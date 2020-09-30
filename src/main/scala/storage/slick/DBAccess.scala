package storage.slick

import common._
import common.Conv

import slick.jdbc.PostgresProfile.api._
import slick.jdbc.PostgresProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import java.sql.Date
import scala.reflect.ClassTag
import scala.concurrent.{Future, Await}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

// some type declarations will be *gasp* non-explicit due to complexity
object DBAccess {
  type DBUser = DBCommon.User

  private val config: String = "standard"
  private val db: Database = Database.forConfig(config)
  private val driver: String = "org.postgresql.Driver"
  private val stdDur: Duration = Duration(10, "seconds")

  def init(uri: String, outputFolder: String): Unit = {
    Await.result(createDB, stdDur)
  }

  def addUser(user: User)(implicit f: User => (Int,String)): Unit = {
    val tq: TableQuery[DBUser] = DBCommon.user
    tq += user // TODO - investigate implicit usage for this
  }

  // TODO - reimplement this with Future
  def getAllUsers(implicit f: DBUser => User): Future[Seq[User]] = {
    val tq: TableQuery[DBUser] = DBCommon.user
    var usrs: List[DBUser] = Nil

    // i don't like this, but it appears to work
    db.run(tq.result).map(_.foreach { 
      case (id,name) => User(id,name,None)::usrs
      case _ => usrs = usrs
    })

    /*val q = for(u <- tq)
      yield u
    val res: Future[Seq[DBUser]] = db.run(q.result)*/
    usrs.map(f)
  }

  def createDB: Future[Unit] = {
    val schema: PostgresProfile.DDL = DBCommon.user.schema ++ DBCommon.chat.schema ++ DBCommon.participant.schema ++ DBCommon.message.schema
    db.run(schema.createIfNotExists)
  }

  def shutdown: Unit =
    db.close
  
}
