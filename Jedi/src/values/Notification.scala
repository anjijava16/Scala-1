package values

case class Notification(msg: String) extends Value {
  def getMsg(): String = msg
  override def toString = msg
}

object Notification extends Value {
  val undef = new Notification("Undefined Error...")
  val update = new Notification("Identifier Updated")
  val decl = new Notification("Declaration Successful")
  var err = new Notification("Error, please re-enter command")
  var accepted = Notification("Accepted")
  var finish = Notification("Command finished")
}