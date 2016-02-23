package expressions

import values._
import expressions._

case class Block(locals: List[Expression]) extends SpecialForm {
  
  def execute(env: Environment): Value = {
    val tempEnv = new Environment(env)
    for (i <- 0 until locals.length - 1) {
      locals(i).execute(tempEnv)
    }
    locals(locals.length - 1).execute(tempEnv)
  }
}