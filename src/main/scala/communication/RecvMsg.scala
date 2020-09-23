package communication

import common._

trait Receiver {
  def recvMsg: Iterator[Message]
}

object RecvMessage extends Receiver {
  // the code for this will be an adapted version of the serverside code.
  // copy that once it's finished
  override def recvMsg: Iterator[Message] = ???
}
