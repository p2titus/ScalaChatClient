package communication

import common._

// java imports
import java.net._
import java.io._

trait Sender {
  def sendMsg(msg: Message): Unit
}

// gets server socket
object getServer {
  def getIP: String = "127.0.0.1"
  def getPort: Int = 43225
  def getSocket: Socket = {
    new Socket(getIP,getPort)
  }
}

// used generically for sending messages
object SendMsg extends Sender {
  override def sendMsg(msg: Message): Unit = {
    val skt: Socket = getServer.getSocket
    val outStream: OutputStream = skt.getOutputStream
    val out: ObjectOutputStream = new ObjectOutputStream(outStream)
    
    out.writeObject(msg)
    
    out.close
    outStream.close
    skt.close
  }
}

// used when sending a number of messages to a specific recipient
// fixes metadata using the data supplied then ignores 
class FixUsrMsg(private val meta: Metadata) extends Sender {
  override def sendMsg(msg: Message): Unit = ??? 
}
