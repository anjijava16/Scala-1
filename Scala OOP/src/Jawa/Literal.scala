package Jawa

trait Literal extends Value with Expression {
  def execute = this
}