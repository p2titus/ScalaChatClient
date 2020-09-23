package storage

// idea of this is to use implicits to fill in queries for each object as req.

import common._

import scala.collection

trait Storage {
  def init: Storage // used to initialise storage solution
  def retrieve[A,B](id: A)(implicit acc: Access[A,B]): B
  def store[A](x: A)(implicit acc: Access[A,A]): Storage
  def retrieveAll[B](implicit acc: Access[B,B]): Iterator[B]
}

trait Access[A,B] {
  def get(id: A): B
  def set(st: B): Unit
}


object GetCon {
  def getCon: Storage = DBCon
}
