package Acorn

/**
 * @author Benton
 */
class Product (operand1: Expression, operand2: Expression) extends Expression {
  def execute = operand1.execute * operand2.execute
  override def toString = "(* " + operand1 + " " + operand2 + ")"
}

object Product {
  def apply(operand1: Expression, operand2: Expression) = 
      new Product(operand1, operand2)
}