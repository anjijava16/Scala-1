package Jawa

class Not(op1: Expression) extends Expression {
  def execute = {
    val arg1 = op1.execute
    if (!arg1.isInstanceOf[Boole]) {
      throw new Exception("not input must be booleans")
    }
    val num1 = arg1.asInstanceOf[Boole]
    new Boole(!num1.value)
  }
}