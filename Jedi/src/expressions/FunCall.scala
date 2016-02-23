package expressions
import values._
import ui._
import values.Closure

case class FunCall(operator: Identifier, operands: List[Expression]) extends Expression {

  def execute(env: Environment) = {
    val mapped: List[Value] = operands.map(_.execute(env))

    if (env.contains(operator)) {
      val func = env(operator)
      if (!func.isInstanceOf[Closure]) throw new TypeException("only functions can be called")
      val res = func.asInstanceOf[Closure]
      res.apply(mapped)
    } else {
      System.execute(operator.value, mapped)
    }
  }
}