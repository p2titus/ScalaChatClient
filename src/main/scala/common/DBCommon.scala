package common

import slick.jdbc.PostgresProfile.api._

object DBCommon {
  class User(tag: Tag) extends Table[(Int, String)](tag, "users") {
    def user_id: Rep[Int] = column[Int]("user_id", O.PrimaryKey)
    def username: Rep[String] = column[String]("username")
  
    def * = (user_id, username)
  }
  val user: TableQuery[User] = TableQuery[User]

  class Chat(tag: Tag) extends Table[(Int)](tag, "chat") {
    def chat_id: Rep[Int] = column[Int]("chat_id", O.PrimaryKey)
    
    def * = (chat_id)
  }
  val chat: TableQuery[Chat] = TableQuery[Chat]

  class Participant(tag: Tag) extends Table[(Int,Int)](tag, "participants") {
    def chat_id: Rep[Int] = column("chat_id", O.PrimaryKey)
    def user_id: Rep[Int] = column("user_id", O.PrimaryKey)

    def * = (chat_id, user_id)
    def part_user = foreignKey("fk_part_user", user_id, user)(_.user_id)
    def part_chat = foreignKey("fk_part_chat", chat_id, chat)(_.chat_id)
  }
  val participant: TableQuery[Participant] = TableQuery[Participant]

  class Message(tag: Tag) extends Table[(Int, Int, String)](tag, "messages") {
    def msg_id: Rep[Int] = column[Int]("msg_id", O.PrimaryKey)
    def chat_id: Rep[Int] = column[Int]("chat_id", O.PrimaryKey)
    def contents: Rep[String] = column[String]("contents")

    def * = (msg_id, chat_id, contents)
    def msg_user = foreignKey("fk_msg", chat_id, chat)(_.chat_id)
  }
  val message: TableQuery[Message] = TableQuery[Message]
}
