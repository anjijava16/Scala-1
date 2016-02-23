object s1 {
  println("Welcome to the Scala worksheet")
  
  val pi = 3.14
  
  var balance = 100.0
  
  balance = balance + 1
  
  def deposit(amt: Double) { balance += amt }
  
  def square(x: Double) = x * x
  
  def area(r: Double) = pi * square(r)
  
  area(20)
  
  deposit(50)
  
  balance
  
}