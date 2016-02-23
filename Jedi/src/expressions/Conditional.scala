package expressions
import values._
import ui._

/*
 *  represents expressions of the form
 *  if(a) b else c
 *  if(a) b
 */
/**
 * @author Benton
 */
case class Conditional(condition: Expression, consequent: Expression, alternative: Expression = null) extends SpecialForm {
  def execute(env: Environment): Value = {
    condition.execute(env) match {
      case Boole(value) =>
        if (value) consequent.execute(env)
        else if (alternative != null) alternative.execute(env) else Notification("Unspecified")
      case _ => throw new TypeException("if condition must be Boole")
    }
  }
}