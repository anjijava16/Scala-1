package values

import ui._
import values._
import expressions._

/**
 * @author Benton
 */
class Closure(params: List[Identifier], body: Expression, defEnv: Environment) extends Value {
  def apply(args: List[Value]): Value = {
    var tempEnv = new Environment(defEnv)
    if (params.length == args.length) {
      for (i <- 0 until args.length) {
        tempEnv.put(params(i), args(i))
      }
      body.execute(tempEnv)
    } else throw new TypeException
  }
  override def toString = "lambda" + " " + params + " " + body
}