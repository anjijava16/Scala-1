package values
import expressions.Literal

case class Boole(value: Boolean) extends Literal with Value {
  override def toString() = value.toString
}
