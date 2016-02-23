package expressions
import values._
import ui._

case class Identifier(value: String) extends Expression {
  def execute(env: Environment): Value = {
    if (env.contains(this)) env(this) 
    else throw new UndefinedException("Undefined Identifier: " + value)
  }
}