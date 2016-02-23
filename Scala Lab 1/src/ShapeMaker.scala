object ShapeMaker {

  def makeRectangle(rows: Int, cols: Int) = {
    var result = ""
    for (x <- 1 to rows) {
      for (y <- 1 to cols) {
        result = result + "*"
      }
      result += '\n'
    }
    result
  }

  def makeRightTriangle(rows: Int) = {
    var result = ""
    for (x <- 1 to rows) {
      (1 to x) foreach (x => result += "*")
      result += '\n'
    }
    result
  }

  def makeIsoTriangle(rows: Int) = {
    var result = ""
    var mid = rows / 2
    var sp = 5

    for (x <- 1 to rows + 1 by 2) {
      for (x <- sp to 1 by -1) {
        result += " "
      }
      (1 to x) foreach (x => result += "*")
      result += "\n"
      sp -= 1
    }
    result
  }

  // helper function
  def times(n: Int)(code: => Unit) {
    for (i <- 1 to n) code
  }

  def makeInvertedTriangle(rows: Int) = {
    var result = ""
    var mid = rows / 2
    var sp = 0

    for (x <- 1 to rows + 1 by 2) {
      times(sp) { result += " " }
      (10 to x - 1 by -1) foreach (x => result += "*")

      result += "\n"
      sp += 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    print("Enter a positive integer: ")
    var n = readInt
    println(makeRectangle(n, n))
    println(makeRightTriangle(n))
    println(makeIsoTriangle(n))
    println(makeInvertedTriangle(n))
  }

}