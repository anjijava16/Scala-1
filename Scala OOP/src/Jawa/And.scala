package Jawa

class And(op1: Expression, op2: Expression) extends Expression {
  def execute = {
    val arg1 = op1.execute
    val arg2 = op2.execute
    if (!arg1.isInstanceOf[Boole] || !arg2.isInstanceOf[Boole]) {
      throw new Exception("and inputs must be booleans")
    }
    val num1 = arg1.asInstanceOf[Boole]
    val num2 = arg2.asInstanceOf[Boole]
    new Boole(num1.value && num2.value)
  }
}