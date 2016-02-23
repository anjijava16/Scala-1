package expressions

import values._
import ui._
import expressions._

case class Iteration(condition: Expression, body: Expression) extends SpecialForm {
  def execute(env: Environment): Value = {
    var result: Value = Notification("Unspecified! Please go back and check.")
    val con = condition.execute(env)
    if (!con.isInstanceOf[Boole]) throw new TypeException("Condition must be Boole!")
    var conInst = con.asInstanceOf[Boole]
    while (conInst.value) {
      result = body.execute(env)
      conInst = condition.execute(env).asInstanceOf[Boole]
    }
    result
  }
}