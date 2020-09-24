package storage.slick

import slick.jdbc.PostgresProfile.api._
import slick.jdbc.PostgresProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object DBAccess {
  private val config: String = "standard"
  private val dbCon: Database = Database.forConfig(config)
  private val driver: String = "org.postgresql.Driver"

  def init(uri: String, outputFolder: String): Unit = {
    slick.codegen.SourceCodeGenerator.main(
      Array(uri, outputFolder)
    )
  }

  def createDB: Unit = {

  }

  def shutdown: Unit =
    dbCon.close
  
}
