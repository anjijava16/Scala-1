object VectorCalculator {

  def add(v1: Array[Int], v2: Array[Int]) = {
    val temp = Array(0, 0, 0)
    for (x <- 0 until v1.length) {
      temp(x) = v1(x) + v2(x)
    }
    temp
  }

  def dot(v1: Array[Int], v2: Array[Int]) = {
    var result = 0
    for (x <- 0 until v1.length) {
      result += v1(x) * v2(x)
    }
    result
  }

  def toString(v: Array[Int]) = {
    var result = "["
    for (e <- v) {
      result = result + "" + e
    }
    result = result + "]"
    result
  }

  def main(args: Array[String]): Unit = {
    try {
      print("Enter 3 integers: ")
      var x = readInt()
      var y = readInt()
      var z = readInt()
      val vec1 = Array(x, y, z)
      val vec2 = Array(1, 2, 3)
      val vec3 = add(vec1, vec2)
      println("sum = " + toString(vec3))
      println("dot = " + dot(vec1, vec2))
    } catch {
      case e: Exception => { println(e) }
    }

  }
}