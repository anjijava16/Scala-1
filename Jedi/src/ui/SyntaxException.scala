package ui
import scala.util.parsing.combinator._

/**
 * @author Benton
 */
class SyntaxException(val result: Parsers#Failure) extends JediException("Syntax error")
