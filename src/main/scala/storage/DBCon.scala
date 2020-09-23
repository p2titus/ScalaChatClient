package storage

import common._
import storage.slick._

object DBCon extends Storage {
  override def init: Storage = {
    // TODO - ensure the database has been initialised
    val uri: String = "test"
    val out: String = "test.db"
    DBAccess.init(uri,out)
    DBCon
  }

  override def retrieve[A,B](id: A)(implicit acc: Access[A,B]): B =
    acc.get(id)

  override def store[A](st: A)(implicit acc: Access[A,A]) = { // TODO - what is this return type?
    acc.set(st)
    this
  }
    
  override def retrieveAll[B](implicit acc: Access[B,B]): Iterator[B] = {
    var xs: List[B] = Nil

    xs.iterator
  }
}

object DBConInst {
  implicit val usr: Access[String,User] = 
    new Access[String,User] {
      def get(id: String): User = ???
      def set(st: User): Unit = ???
    }
}
