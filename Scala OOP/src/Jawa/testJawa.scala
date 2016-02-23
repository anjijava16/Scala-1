package Jawa

/**
 * @author Benton
 */
object testJawa extends App {
  val and = new And(new Boole(true), new Boole(false))
  println("And test: " + and.execute)
  
  val or = new Or(new Boole(false), new Boole(true))
  println("Or test: " + or.execute)
  
  val product = new Product(new Number(5), new Number(4)) 
  println("Product test 4 * 5: " + product.execute)
  
  val not = new Not(new Boole(false))
  println("Not test (false): " + not.execute)
}