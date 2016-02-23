package Acorn

/**
 * @author Benton
 */
class FunCall(f: Double=>Double, exp1 : Expression) extends Expression {
  def execute = f.apply(exp1.execute)
  override def toString = ""
}

object FunCall {
  def apply(f: Double=>Double, exp1 : Expression) = new FunCall(f, exp1)
}