/**
 * @author Benton
 */
object repl {
  
  def repl(): Unit = {
    try {
      println("Enter: number operator number")
      val in = readLine().split("\\s+")
      if (in(0).equals("quit")) {
        println("bye")
        System.exit(1)
      } else if (in.length != 3) throw new Exception("wrong syntax: number operator number")
      else {
        var op1 = in(0).toDouble
        var op2 = in(2).toDouble
        if (in(1).equals("+")) println(op1 + op2)
        else if (in(1).equals("-")) println(op1 - op2)
        else if (in(1).equals("*")) println(op1 * op2)
        else if (in(1).equals("/")) println(op1 / op2)
        else throw new Exception("unrecognized operator" + in(1))
      }
    } catch { case e: Exception => println(e) }
    repl()
  }
  
  def main(args:Array[String]): Unit = { repl() }
}