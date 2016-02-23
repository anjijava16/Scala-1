package expressions
import values._
import ui._
import expressions._
/**
 * @author Benton
 */
case class Assignment(x: Identifier, update: Expression) extends SpecialForm {
  def execute(env: Environment): Value = {
    val e = x.execute(env)
    if (e.isInstanceOf[Variable]) {
      e.asInstanceOf[Variable].vals = update.execute(env)
      Notification.accepted
    } else throw new TypeException("Assignment must be Variable")
  }
}