package values
import expressions.Literal

case class Number(value: Double) extends Literal {
  override def toString = value.toString
}
