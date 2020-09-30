// file for data structures that are common between all parts of the program
package common

// sent Users should not be sent with a password
// serverside code should enforce this as a precondition, and refuse any message that has passwords
// obviously this leaves the whole thing a bit susceptible to mitm attacks with modified code
case class User(val userID: Int, val username: String, val password: Option[String]) 
case class Message(val msg: String, val metadata: Metadata)
case class Metadata(val sender: User, val receiver: User) {
  def respond: Metadata = Metadata(receiver,sender)
}


object Conv {
  implicit val userConv: User => (Int,String) = dbUser(_)
  private def dbUser(x: User): (Int,String) =
    (x.userID, x.username)
}
