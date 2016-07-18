package doodlebot
package message

sealed abstract class Message extends Product with Serializable
object Message {
  // Messages that indicate the view should change
  sealed abstract class View extends Message
  final case object NotAuthenticated extends View
  final case class Authenticated(name: String, session: String) extends View

  // Messages that indicate an error has occurred
  sealed abstract class Error extends Message
  final case class SignupError(errors: Map[String,List[String]]) extends Error
  final case class LoginError(errors: Map[String,List[String]]) extends Error
  final case class ChatError(errors: Map[String,List[String]]) extends Error

  // Messages that indicate an update to the current model
  sealed abstract class Update extends Message
  final case class Signup(model: doodlebot.model.Model.Signup) extends Update
  final case class Login(model: doodlebot.model.Model.Login) extends Update
  final case class Chat(model: doodlebot.model.Model.Chat) extends Update
}
