package Jawa

class Sum(operand1: Expression, operand2: Expression) extends Expression {
  def execute = {
    val arg1 = operand1.execute
    val arg2 = operand2.execute
    if (!arg1.isInstanceOf[Number] || !arg2.isInstanceOf[Number]) {
      throw new Exception("sum inputs must be numbers")
    }
    val num1 = arg1.asInstanceOf[Number]
    val num2 = arg2.asInstanceOf[Number]
    new Number(num1.value + num2.value)
  }
}