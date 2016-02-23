package ui
import values._
import expressions._

/**
 * Author: Benton
 */
object Console {

  val parsers = new SithParsers
  val globalEnv = new Environment

  def execute(cmmd: String): String = {
    val tree = parsers.parseAll(parsers.expression, cmmd)
    tree match {
      case t: parsers.Failure => throw new SyntaxException(t)
      case _                  => "" + tree.get.execute(globalEnv)
    }
  }

  def repl {
    var more = true
    while (more) {
      try {
        print("-> ")
        val cmmd = readLine
        if (cmmd == "quit") {
          println("Death Star Offline")
          more = false
        } else {
          println(execute(cmmd))
        }
      } catch {
        case e: SyntaxException => {
          println(e.msg)
          println(e.result.msg)
          println("line # = " + e.result.next.pos.line)
          println("column # = " + e.result.next.pos.column)
          println("token = " + e.result.next.first)
        }
        case e: TypeException      => println(e)
        case e: UndefinedException => println(e)
        case e: JediException      => println(e)
        case _: Throwable => {
          println("Unfixable Error...")
          more = false
        }
      } finally {
      }
    }
  }
  def main(args: Array[String]): Unit = { repl }
}