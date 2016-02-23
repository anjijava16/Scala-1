package Acorn

/**
 * @author Benton
 */
class Number (val value: Double) extends Expression {
  def execute = value 
  override def toString = value.toString
}

object Number {
  def apply(number: Double) = new Number(number)
}