package temp

import communication._ 
import common._

object Main {
  def main(args: Array[String]): Unit = {
    
    val send: Sender = SendMsg
    val usr: User = User(1,"mike",None)
    val rec: User = User(2,"steve",None)
    val meta: Metadata = Metadata(usr,rec)
    val msg: Message = Message("Hi there",meta)

    send.sendMsg(msg)
  }
}
