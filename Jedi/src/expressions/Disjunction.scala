package expressions
import values._
import ui._

/**
 * @author Benton
 */
case class Disjunction(exp: List[Expression]) extends SpecialForm {

  def execute(env: Environment) = {
    val length = exp.length
    var i = 0
    var finish = false
    while (!finish && i < length) {
      val res = exp(i).execute(env)
      println("" + exp(i) + " = " + res)
      if (!res.isInstanceOf[Boole]) throw new TypeException("Only Booles allowed in Disjunction! Fault @ : " + res)
      finish = (res.asInstanceOf[Boole]).value
      i = i + 1
    }
    new Boole(finish)
  }
}