  object TaxCalculator {

  def tax(income: Double): Double = {
    var rate = 0.0
    if (income < 0) {
      throw new IllegalArgumentException("Income can't be negative")
    } else {

      if (income < 20000.00) { rate = 0.0 }
      else if (income < 30000.00) { rate = 0.05 }
      else if (income < 40000.00) { rate = 0.11 }
      else if (income < 60000.00) { rate = 0.23 }
      else if (income < 100000.00) { rate = 0.32 }
      else if (income >= 100000.00) { rate = 0.50 }

    }
    rate * income
  }

  def main(args: Array[String]): Unit = {
    try {
      println("enter 3 incomes x, y, and z on separate lines:")
      var x = readDouble()
      var y = readDouble
      var z = readDouble
      println("tax(x) = $" + tax(x))
      println("tax(y) = $" + tax(y))
      println("tax(z) = $" + tax(z))
    } catch {
      case e: Exception => { println(e) }
    }
  }
}
