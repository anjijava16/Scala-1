import scala.math._
import scala.util.control._
import scala.util.Random

object mathSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(138); 
  println("Welcome to the Scala worksheet");$skip(294); 
  
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
  };System.out.println("""solve: (a: Double, b: Double, c: Double)Any""");$skip(17); val res$0 = 
  solve(1, 6, 8);System.out.println("""res0: Any = """ + $show(res$0));$skip(190); 
  
  def dist(a: (Double, Double), b: (Double, Double)) = {
  	val xDiff = b._1 - a._1
  	val yDiff = b._2 - a._2
  	
  	math.abs(math.sqrt((math.pow(xDiff, 2)) + (math.pow(yDiff, 2))))
  };System.out.println("""dist: (a: (Double, Double), b: (Double, Double))Double""");$skip(26); val res$1 = 
  
  dist((1, 1), (0, 0));System.out.println("""res1: Double = """ + $show(res$1));$skip(130); 
  
  def dot(a: (Double, Double, Double), b: (Double, Double, Double)) = {
  	((a._1 * b._1) + (a._2 * b._2) + (a._3 * b._3))
  };System.out.println("""dot: (a: (Double, Double, Double), b: (Double, Double, Double))Double""");$skip(35); val res$2 = 
  
  dot((2.0, 3, 4), (2, 2.0, 2));System.out.println("""res2: Double = """ + $show(res$2));$skip(90); 
  
  def force(m1: Double, m2: Double, d: Double) = {
  	((m1 * m2) / math.pow(d, 2))
  };System.out.println("""force: (m1: Double, m2: Double, d: Double)Double""");$skip(120); 
  
  def mean(arr: Array[Double]) = {
  var total = 0.0
  	for (x <- arr) {
  		total += x
  	}
  	total / arr.size
  };System.out.println("""mean: (arr: Array[Double])Double""");$skip(23); val res$3 = 
  mean(Array(4, 4, 7));System.out.println("""res3: Double = """ + $show(res$3));$skip(28); val res$4 = 
  mean(Array(2.0, 3, 4, 5));System.out.println("""res4: Double = """ + $show(res$4));$skip(278); 
  
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
  };System.out.println("""stdev: (arr: Array[Double])Double""");$skip(339); 
  
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
  };System.out.println("""isPrime: (n: Int)Boolean""");$skip(16); val res$5 = 
  
  isPrime(4);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(14); val res$6 = 
  isPrime(17);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(14); val res$7 = 
  isPrime(23);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(299); 
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
  };System.out.println("""eulerPhi: (n: Int)Int""");$skip(16); val res$8 = 
  
	eulerPhi(9);System.out.println("""res8: Int = """ + $show(res$8));$skip(14); val res$9 = 
	eulerPhi(21);System.out.println("""res9: Int = """ + $show(res$9));$skip(87); 
	
	def rollDice = {
		var rnd = new Random()
		(rnd.nextInt(6)+1, rnd.nextInt(6)+1)
	};System.out.println("""rollDice: => (Int, Int)""");$skip(12); val res$10 = 
	
	rollDice;System.out.println("""res10: (Int, Int) = """ + $show(res$10));$skip(10); val res$11 = 
	rollDice;System.out.println("""res11: (Int, Int) = """ + $show(res$11));$skip(10); val res$12 = 
	rollDice;System.out.println("""res12: (Int, Int) = """ + $show(res$12))}
	
}
