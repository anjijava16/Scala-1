object midterm {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome to the Scala worksheet");$skip(58); 
  
  def function(x: Double): Double = math.pow(x, 2) - 1;System.out.println("""function: (x: Double)Double""");$skip(36); 
  val in = List(1.0, 2.0, 3.0, 1.0);System.out.println("""in  : List[Double] = """ + $show(in ));$skip(313); 
  
  def countRoots[T](f: T=>Double, inputs: List[T]): Int = {
  	def helper(f: T=>Double, inputs: List[T], accum: Int): Int = {
  		if (inputs.isEmpty) accum
  		else {
  			if (f(inputs.head) == 0) helper(f, inputs.tail, accum + 1)
  			else helper(f, inputs.tail, accum)
  		}
  	}
  	helper(f, inputs, 0)
  };System.out.println("""countRoots: [T](f: T => Double, inputs: List[T])Int""");$skip(27); val res$0 = 
  countRoots(function, in);System.out.println("""res0: Int = """ + $show(res$0));$skip(54); 
  
  // MAP REDUCE!
  def notZero(x: Double) = x != 0;System.out.println("""notZero: (x: Double)Boolean""");$skip(107); 
  def crMFR[T](f: Double=>Double, inputs: List[Double]): Int = {
  	inputs.map(f).filter(notZero).size
  };System.out.println("""crMFR: [T](f: Double => Double, inputs: List[Double])Int""");$skip(22); val res$1 = 
  crMFR(function, in);System.out.println("""res1: Int = """ + $show(res$1));$skip(112); 
  
  /////////////////////////////
  
  // PROBLEM 3
  def fact(n: Int): Int = if (n == 0) 1 else n * fact(n-1);System.out.println("""fact: (n: Int)Int""");$skip(63); 
  
  def recur(baseValue: Int, combiner: Int=>Int) = {
  	
  };System.out.println("""recur: (baseValue: Int, combiner: Int => Int)Unit""");$skip(380); 
  
  /////////////////////////////
  
  // PROBLEM 4A
  def some[T](vals: List[T], test: T=>Boolean): Boolean = {
  	def helper(vals: List[T], test: T=>Boolean, res: Boolean): Boolean = {
  		if (vals.isEmpty) res
  		else if (res) res
  		else {
  			if(test(vals.head)) helper(vals, test, true)
  			else helper(vals.tail, test, res)
  		}
  	}
  	helper(vals, test, false)
  };System.out.println("""some: [T](vals: List[T], test: T => Boolean)Boolean""");$skip(51); val res$2 = 
  
  some(List(1, 3, 5, 7), (n: Int)=> n % 2 == 0);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(48); val res$3 = 
  some(List(1, 3, 5, 8), (n: Int)=> n % 2 == 0);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(170); 
  
  /////////////////////////////
  
  // PROBLEM 4B
  def some2[T](vals: List[T], test: T=>Boolean): Boolean = {
  	if(vals.filter(test) != Nil) true
  	else false
  };System.out.println("""some2: [T](vals: List[T], test: T => Boolean)Boolean""");$skip(49); val res$4 = 
  some2(List(1, 3, 5, 7), (n: Int)=> n % 2 == 0);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(49); val res$5 = 
  some2(List(1, 3, 5, 8), (n: Int)=> n % 2 == 0);System.out.println("""res5: Boolean = """ + $show(res$5))}
}
