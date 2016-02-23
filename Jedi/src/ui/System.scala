package ui
import values._
import expressions._

/**
 * @author Benton
 */
object System {
  // the dispatcher
  def execute(operator: String, args: List[Value]): Value = {
    operator match {
      case "add"     => add(args)
      case "mul"     => mul(args)
      case "div"     => div(args)
      case "sub"     => sub(args)
      case "equals"  => equal(args)
      case "less"    => less(args)
      case "not"     => not(args)
      case "content" => content(args)
      case "print"   => print(args)
      case "var"     => makeVar(args)

      case _         => throw new UndefinedException(operator)
    }
  }

  def add(args: List[Value]) = {
    // type check like crazy first
    if (args.isEmpty) throw new TypeException("Needs more than 1 input!")
    val filtered = args.filter(_.isInstanceOf[Number])
    if (filtered.length < args.length) throw new TypeException("All inputs must be numbers!")
    new Number(args.map(_.asInstanceOf[Number]).map(_.value).reduce(_ + _))
  }

  def sub(args: List[Value]) = {
    // type check like crazy first
    if (args.isEmpty) throw new TypeException("Needs more than 1 input!")
    val filtered = args.filter(_.isInstanceOf[Number])
    if (filtered.length < args.length) throw new TypeException("All inputs must be numbers!")
    new Number(args.map(_.asInstanceOf[Number]).map(_.value).reduce(_ - _))
  }

  def mul(args: List[Value]) = {
    // type check like crazy first
    if (args.isEmpty) throw new TypeException("Needs more than 1 input!")
    val filtered = args.filter(_.isInstanceOf[Number])
    if (filtered.length < args.length) throw new TypeException("All inputs must be numbers!")
    new Number(args.map(_.asInstanceOf[Number]).map(_.value).reduce(_ * _))
  }

  def div(args: List[Value]) = {
    // type check like crazy first
    if (args.isEmpty) throw new TypeException("Needs more than 1 input!")
    val filtered = args.filter(_.isInstanceOf[Number])
    if (filtered.length < args.length) throw new TypeException("All inputs must be numbers!")
    new Number(args.map(_.asInstanceOf[Number]).map(_.value).reduce(_ / _))
  }

  def equal(args: List[Value]) = {
    if (args.isEmpty) throw new TypeException("Needs more than 1 input!")
    val filtered = args.filter(_.isInstanceOf[Number])
    if (filtered.length < args.length) throw new TypeException("All inputs must be numbers!")
    val mapped = args.map(_.asInstanceOf[Number])
    var isEqual = true
    for (i <- 1 until mapped.length) {
      if (mapped(0).value != mapped(i).value) isEqual = false
    }
    if (isEqual) new Boole(true) else new Boole(false)
  }

  def less(args: List[Value]) = {
    if (args.isEmpty) throw new TypeException("Needs more than 1 input!")
    val filtered = args.filter(_.isInstanceOf[Number])
    if (filtered.length < args.length) throw new TypeException("All inputs must be numbers!")
    val mapped = args.map(_.asInstanceOf[Number])
    var isLess = true

    for (i <- 1 until mapped.length) {
      if (mapped(i - 1).value >= mapped(i).value) isLess = false
    }
    if (isLess) new Boole(true) else new Boole(false)
  }

  def not(args: List[Value]) = {
    if (args.isEmpty) throw new TypeException("No input provided...")
    val filtered = args.filter(_.isInstanceOf[Boole])
    if (filtered.length < args.length) throw new TypeException("All inputs must be Booles!")
    if (args.length > 1) throw new TypeException("Only 1 input (Boole) allowed")
    val mapped = args.map(_.asInstanceOf[Boole])
    mapped(0)
  }

  private def content(args: List[Value]): Value = {
    if (args.isEmpty) throw new TypeException("error")
    if (args.head.isInstanceOf[Variable]) args.head.asInstanceOf[Variable].vals
    else throw new TypeException
  }
  private def makeVar(args: List[Value]) = {
    if (args.isEmpty) throw new TypeException("error")
    else new Variable(args.head)
  }

  def print(args: List[Value]) = {
    for (arg <- args) println(arg)
    Notification("Done")
  }

}