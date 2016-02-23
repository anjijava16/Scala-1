import scala.util.control.Breaks._
import util.Random

object Mystery {

  def main(args: Array[String]): Unit = {
    print("enter a positive integer: ")
    var k = readInt()

    for (i <- 0 until 100) {
      print("trial " + i)
      for (j <- 0 until 100) {
        k = (k * k) % 100
        breakable {
          if (k < j / 3) { println("k = " + k) }
          if (k < j / 2) { break }
        }
      }
    }
  }
}