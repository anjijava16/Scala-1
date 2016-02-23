package expressions
import values._
import values.Closure

case class Lambda(params: List[Identifier], body: Expression) extends SpecialForm {
  def execute(env: Environment): Value = {
    new Closure(params, body, env)
  }
}