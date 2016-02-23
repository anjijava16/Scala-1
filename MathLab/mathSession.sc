import scala.math._
import scala.util.control._
import scala.util.Random

object mathSession {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def solve(a: Double, b: Double, c: Double) = {
  	val disc = b * b - 4 * a * c
  	if (disc < 0) {
  		Double.NaN
  	} else if (disc == 0) {
  		-b / (2*a)
  	} else {
  		val sol1 = (-b + math.sqrt(disc) / (2 * a))
  		val sol2 = (-b - math.sqrt(disc) / (2 * a))
  		(sol1, sol2)
  	}
  }                                               //> solve: (a: Double, b: Double, c: Double)Any
  solve(1, 6, 8)                                  //> res0: Any = (-5.0,-7.0)
  
  def dist(a: (Double, Double), b: (Double, Double)) = {
  	val xDiff = b._1 - a._1
  	val yDiff = b._2 - a._2
  	
  	math.abs(math.sqrt((math.pow(xDiff, 2)) + (math.pow(yDiff, 2))))
  }                                               //> dist: (a: (Double, Double), b: (Double, Double))Double
  
  dist((1, 1), (0, 0))                            //> res1: Double = 1.4142135623730951
  
  def dot(a: (Double, Double, Double), b: (Double, Double, Double)) = {
  	((a._1 * b._1) + (a._2 * b._2) + (a._3 * b._3))
  }                                               //> dot: (a: (Double, Double, Double), b: (Double, Double, Double))Double
  
  dot((2.0, 3, 4), (2, 2.0, 2))                   //> res2: Double = 18.0
  
  def force(m1: Double, m2: Double, d: Double) = {
  	((m1 * m2) / math.pow(d, 2))
  }                                               //> force: (m1: Double, m2: Double, d: Double)Double
  
  def mean(arr: Array[Double]) = {
  var total = 0.0
  	for (x <- arr) {
  		total += x
  	}
  	total / arr.size
  }                                               //> mean: (arr: Array[Double])Double
  mean(Array(4, 4, 7))                            //> res3: Double = 5.0
  mean(Array(2.0, 3, 4, 5))                       //> res4: Double = 3.5
  
  def stdev(arr: Array[Double]) = {
  	var totalTemp = 0.0
  	var mean = 0.0
  	for (x <- arr) {
  		totalTemp += x
  		mean = totalTemp / arr.size
  	}
  	totalTemp = 0.0
  	for (x <- arr) {
  		totalTemp += math.pow(x - mean, 2)
  	}
  	(math.sqrt(totalTemp/arr.size))
  }                                               //> stdev: (arr: Array[Double])Double
  
  def isPrime(n: Int) = {
  	val loop = new Breaks;
  	var result = true
  	loop.breakable {
  		if (n < 0) throw new IllegalArgumentException("Negative number!")
  		else if (n % 2 == 0) result = false
  		else
  			for (x <- 3 until n by 2)
  				if (n % x == 0) {
  					result = false
  					loop.break
  				}
  	}
  	(result)
  }                                               //> isPrime: (n: Int)Boolean
  
  isPrime(4)                                      //> res5: Boolean = false
  isPrime(17)                                     //> res6: Boolean = true
  isPrime(23)                                     //> res7: Boolean = true
  //isPrime(-5)
                                                  
  
  def eulerPhi(n: Int) = {
  	def gcd(a: Int, b:Int): Int = (a, b) match {
    	case (a, 0) => a
    	case (a, b) => gcd(b, a % b)
  	}
  	var count = 0
  	for(x <- 1 to n) {
  		if(gcd(n, x) == 1) count += 1
  	}
  	(count)
  }                                               //> eulerPhi: (n: Int)Int
  
	eulerPhi(9)                               //> res8: Int = 6
	eulerPhi(21)                              //> res9: Int = 12
	
	def rollDice = {
		var rnd = new Random()
		(rnd.nextInt(6)+1, rnd.nextInt(6)+1)
	}                                         //> rollDice: => (Int, Int)
	
	rollDice                                  //> res10: (Int, Int) = (1,5)
	rollDice                                  //> res11: (Int, Int) = (1,4)
	rollDice                                  //> res12: (Int, Int) = (6,6)
	
}