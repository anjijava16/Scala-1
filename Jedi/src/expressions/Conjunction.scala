package expressions
import values._
import ui._

/**
 * @author Benton
 */
case class Conjunction(exp: List[Expression]) extends SpecialForm {

  def execute(env: Environment) = {
    val len = exp.length
    var i = 0
    var moreCon = true
    while (moreCon && i < len) {
      val result = exp(i).execute(env)
      if (!result.isInstanceOf[Boole]) throw new TypeException("Only Booles allowed! Fault @ : " + result)
      moreCon = (result.asInstanceOf[Boole]).value
      i = i + 1
    }
    new Boole(moreCon)
  }
}