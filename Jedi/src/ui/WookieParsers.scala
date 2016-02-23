/**
 * @author Benton
 */
package ui

import scala.util.parsing.combinator._
import expressions._
import values._

class WookieParsers extends RegexParsers {

  def block: Parser[Expression] = "{" ~ expression ~ rep(";" ~> expression) ~ "}" ^^ {
    case "{" ~ exp ~ Nil ~ "}"  => Block(List(exp))
    case "{" ~ exp ~ exps ~ "}" => Block(exp :: exps)
  }

  def params: Parser[List[Identifier]] = "(" ~> opt(identifier ~ rep("," ~> identifier)) <~ ")" ^^ {
    case None           => Nil
    case Some(e ~ Nil)  => List(e)
    case Some(e ~ exps) => e :: exps
    case _              => Nil
  }

  def lambda: Parser[Expression] = "lambda" ~ params ~ expression ^^ {
    case "lambda" ~ parameters ~ body => Lambda(parameters, body)
  }

  def expression: Parser[Expression] = declaration | conditional | disjunction | failure("Invalid expression")

  def declaration: Parser[Declaration] = "def" ~ identifier ~ "=" ~ expression ^^ {
    case "def" ~ id ~ "=" ~ exp => Declaration(id, exp)
  }

  def conditional: Parser[Conditional] = "if" ~ "(" ~ expression ~ ")" ~ expression ~ opt("else" ~> expression) ^^ {
    case "if" ~ "(" ~ cond ~ ")" ~ cons ~ None      => Conditional(cond, cons)
    case "if" ~ "(" ~ cond ~ ")" ~ cons ~ Some(alt) => Conditional(cond, cons, alt)
  }

  def disjunction: Parser[Expression] = conjunction ~ rep("||" ~> conjunction) ^^ {
    case e ~ Nil  => e
    case e ~ more => Disjunction(e :: more)
  }

  def conjunction: Parser[Expression] = equality ~ rep("&&" ~> equality) ^^ {
    case e ~ Nil  => e
    case e ~ more => Conjunction(e :: more)
  }

  def equality: Parser[Expression] = inequality ~ rep("==" ~> inequality) ^^ {
    case e ~ Nil  => e
    case e ~ exps => FunCall(Identifier("same"), e :: exps)
  }

  def inequality: Parser[Expression] = sum ~ rep("<" ~> sum) ^^ {
    case e ~ Nil  => e
    case e ~ exps => FunCall(Identifier("less"), e :: exps)
  }

  def sum: Parser[Expression] = product ~ rep(("+" | "-") ~ product ^^ { case "+" ~ s => s case "-" ~ s => negate(s) }) ^^ {
    case p ~ Nil  => p
    case p ~ rest => FunCall(Identifier("sum"), p :: rest)
  }

  def negate(exp: Expression): Expression = {
    val sub = Identifier("sub")
    val zero = Number(0)
    FunCall(sub, List(zero, exp))
  }

  def product: Parser[Expression] = funcall ~ rep(("*" | "/") ~ funcall ^^ { case "*" ~ s => s case "/" ~ s => invert(s) }) ^^ {
    case p ~ Nil  => p
    case p ~ rest => FunCall(Identifier("mul"), p :: rest)
  }

  def invert(exp: Expression): Expression = {
    val div = Identifier("div")
    val one = Number(1)
    FunCall(div, List(one, exp))
  }

  def funcall: Parser[Expression] = term ~ opt(operands) ^^ {
    case t ~ None      => t
    case t ~ Some(Nil) => FunCall(t.asInstanceOf[Identifier], Nil)
    case t ~ Some(ops) => FunCall(t.asInstanceOf[Identifier], ops)
  }

  def operands: Parser[List[Expression]] = "(" ~> opt(expression ~ rep("," ~> expression)) <~ ")" ^^ {
    case None           => Nil
    case Some(e ~ Nil)  => List(e)
    case Some(e ~ exps) => e :: exps
    case _              => Nil
  }

  def term: Parser[Expression] = lambda | block | literal | identifier | "(" ~> expression <~ ")"

  def literal: Parser[Literal] = boole | numeral

  def numeral: Parser[Number] = """(\+|-)?[0-9]+(\.[0-9]+)?""".r ^^
    {
      case e => Number(e.toDouble)
    }

  def boole: Parser[Boole] = """true|false""".r ^^
    {
      case e => Boole(e.toBoolean)
    }

  def identifier: Parser[Identifier] = """[a-zA-Z][a-zA-Z0-9]*""".r ^^
    {
      case e => Identifier(e)
    }

}