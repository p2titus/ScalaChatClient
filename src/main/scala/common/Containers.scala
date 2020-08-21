// package for data structures that are common between all parts of the program

case class User(val username: String, val password: Option[String])
case class Message(val usr: User, val msg: String, val metadata: Metadata)
case class Metadata(val 
