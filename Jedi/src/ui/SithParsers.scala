package ui

import scala.util.parsing.combinator._
import expressions._
import values._

/**
 * @author Benton
 */
class SithParsers extends RegexParsers {

  def lambda: Parser[Expression] = "lambda" ~ parameters ~ expression ^^ {
    case "lambda" ~ params ~ exp => Lambda(params, exp)
  }

  def parameters: Parser[List[Identifier]] = "(" ~> opt(identifier ~ rep("," ~> identifier)) <~ ")" ^^
    {
      case None           => Nil
      case Some(e ~ Nil)  => List(e)
      case Some(e ~ exps) => e :: exps
      case _              => Nil
    }

  def block: Parser[Expression] = "{" ~ expression ~ rep(";" ~> expression) ~ "}" ^^ {
    case "{" ~ exp ~ Nil ~ "}"     => Block(List(exp))
    case "{" ~ exp ~ explist ~ "}" => Block(exp :: explist)
  }

  def assignment: Parser[Expression] = identifier ~ "=" ~ expression ^^ {
    case id ~ "=" ~ exp => Assignment(id, exp)
  }

  def iteration: Parser[Expression] = "while" ~ "(" ~ expression ~ ")" ~ expression ^^ {
    case "while" ~ "(" ~ condition ~ ")" ~ body => new Iteration(condition, body)
  }

  def deref: Parser[Expression] = "[" ~ expression ~ "]" ^^ {
    case "[" ~ exp ~ "]" => FunCall(Identifier("content"), List(exp))
  }

  def declaration: Parser[Declaration] = "def" ~ identifier ~ "=" ~ expression ^^
    {
      case "def" ~ id ~ "=" ~ exp => Declaration(id, exp)
    }

  def expression: Parser[Expression] = declaration | conditional | disjunction | failure("Invalid expression")

  def conditional: Parser[Conditional] = "if" ~ "(" ~ expression ~ ")" ~ expression ~ opt("else" ~> expression) ^^ {
    case "if" ~ "(" ~ cond ~ ")" ~ cons ~ None      => Conditional(cond, cons)
    case "if" ~ "(" ~ cond ~ ")" ~ cons ~ Some(alt) => Conditional(cond, cons, alt)
  }

  def operands: Parser[List[Expression]] = "(" ~> opt(expression ~ rep("," ~> expression)) <~ ")" ^^
    {
      case None          => Nil
      case Some(e ~ Nil) => List(e)
      case Some(e ~ exp) => e :: exp
    }

  def funcall: Parser[Expression] = term ~ opt(operands) ^^ {
    case s ~ None       => s
    case s ~ Some(Nil)  => FunCall(s.asInstanceOf[Identifier], Nil)
    case s ~ Some(args) => FunCall(s.asInstanceOf[Identifier], args)
  }

  def inequality: Parser[Expression] = sum ~ rep("<" ~> sum) ^^
    {
      case exp ~ Nil     => exp
      case exp ~ expList => FunCall(Identifier("less"), exp :: expList)
    }

  def sum: Parser[Expression] =
    product ~ rep(("+" | "-") ~ product ^^ { case "+" ~ s => s case "-" ~ s => negate(s) }) ^^ {
      case p ~ Nil  => p
      case p ~ rest => FunCall(Identifier("add"), p :: rest)
    }

  def product: Parser[Expression] =
    funcall ~ rep(("/" | "*") ~ funcall ^^ { case "*" ~ s => s case "/" ~ s => reciprocal(s) }) ^^ {
      case p ~ Nil  => p
      case p ~ rest => FunCall(Identifier("mul"), p :: rest)
    }

  def negate(exp: Expression): Expression = {
    val sub = Identifier("sub")
    val zero = new Number(0)
    FunCall(sub, List(zero, exp))
  }

  def reciprocal(exp: Expression): Expression = {
    val div = Identifier("div")
    val one = new Number(1)
    FunCall(div, List(one, exp))
  }

  def equality: Parser[Expression] = inequality ~ rep("==" ~> inequality) ^^
    {
      case exp ~ Nil     => exp
      case exp ~ expList => FunCall(Identifier("equals"), exp :: expList)
    }

  def conjunction: Parser[Expression] = equality ~ rep("&&" ~> equality) ^^
    {
      case exp ~ Nil     => exp
      case exp ~ expList => Conjunction(exp :: expList)
    }

  def disjunction: Parser[Expression] = conjunction ~ rep("||" ~> conjunction) ^^
    {
      case exp ~ Nil     => exp
      case exp ~ expList => Disjunction(exp :: expList)
    }

  def term: Parser[Expression] = assignment | iteration | deref | lambda | block | literal | identifier | "(" ~> expression <~ ")"

  def identifier: Parser[Identifier] = """[a-zA-Z][a-zA-Z0-9]*""".r ^^
    {
      case e => Identifier(e)
    }

  def literal: Parser[Literal] = boole | numeral

  def boole: Parser[Boole] = """true|false""".r ^^
    {
      case e => new Boole(e.toBoolean)
    }

  def numeral: Parser[Number] = """(/+|-)?[0-9]+(\.[0-9]+)?""".r ^^
    {
      case e => new Number(e.toDouble)
    }
}