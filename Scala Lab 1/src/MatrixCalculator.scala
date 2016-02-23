import Array._
import util.Random

object MatrixCalculator {

  // converts matrix to a string
  def toString(matrix: Array[Array[Int]]) = {
    matrix.deep.mkString("\n")
  }

  // returns the sum of the diagonal entries of a matrix
  def trace(m: Array[Array[Int]]) = {
    var result = 0
    for (i <- 0 until m.length) {
      for (j <- i to i) {
        result += m(i)(j)
      }
    }
    result
  }

  // returns a dim x dim matrix with i/j entry = 3 * i + 2 * j % cap
  def makeArray(dim: Int, cap: Int = 100) = {
    var matrix = ofDim[Int](dim, dim)
    for (i <- 0 until dim) {
      for (j <- 0 until dim) {
        matrix(i)(j) = 3 * i + 2 * j % cap
      }
    }
    matrix
  }

  def main(args: Array[String]): Unit = {
    print("Enter a positive integer: ")
    var n = readInt
    var m = makeArray(n)
    println(toString(m))
    println("trace = " + trace(m))
  }
}