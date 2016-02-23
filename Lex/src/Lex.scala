

/**
 * @author Benton
 */

trait Expression {
  //def execute(e: Expression)
}

case class Number(value: Double) extends Expression
case class FunCall(op1: Expression, opr: String, op2: Expression) extends Expression


object Lex extends App {
  val plus = "+"
  val times = "*"
  // use unapply
  def execute(e: Expression): Double =
     e match {
    case e: Number => e.value
    case e: FunCall => {
      val FunCall(op1, opr, op2) = e
      opr match {
        case "+" => execute(op1) + execute(op2)
        case "*" => execute(op1) * execute(op2)
        case _ => throw new Exception("Error")
      }
    }
    case _ => throw new Exception("Unknown expression type")
  }

  val exp0 = Number(42.0)
  println(execute(exp0))
  val exp1 = FunCall(Number(3.14), plus, Number(2.71)) // 3.14 + 2.71
  println(execute(exp1)) // prints 5.85
  val exp2 = FunCall(Number(5.0), times, exp1) // 5.0 * (3.14 + 2.71)
  println(execute(exp2)) // prints 29.25 
}