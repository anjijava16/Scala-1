object midterm {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def function(x: Double): Double = math.pow(x, 2) - 1
                                                  //> function: (x: Double)Double
  val in = List(1.0, 2.0, 3.0, 1.0)               //> in  : List[Double] = List(1.0, 2.0, 3.0, 1.0)
  
  def countRoots[T](f: T=>Double, inputs: List[T]): Int = {
  	def helper(f: T=>Double, inputs: List[T], accum: Int): Int = {
  		if (inputs.isEmpty) accum
  		else {
  			if (f(inputs.head) == 0) helper(f, inputs.tail, accum + 1)
  			else helper(f, inputs.tail, accum)
  		}
  	}
  	helper(f, inputs, 0)
  }                                               //> countRoots: [T](f: T => Double, inputs: List[T])Int
  countRoots(function, in)                        //> res0: Int = 2
  
  // MAP REDUCE!
  def notZero(x: Double) = x != 0                 //> notZero: (x: Double)Boolean
  def crMFR[T](f: Double=>Double, inputs: List[Double]): Int = {
  	inputs.map(f).filter(notZero).size
  }                                               //> crMFR: [T](f: Double => Double, inputs: List[Double])Int
  crMFR(function, in)                             //> res1: Int = 2
  
  /////////////////////////////
  
  // PROBLEM 3
  def fact(n: Int): Int = if (n == 0) 1 else n * fact(n-1)
                                                  //> fact: (n: Int)Int
  
  def recur(baseValue: Int, combiner: Int=>Int) = {
  	
  }                                               //> recur: (baseValue: Int, combiner: Int => Int)Unit
  
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
  }                                               //> some: [T](vals: List[T], test: T => Boolean)Boolean
  
  some(List(1, 3, 5, 7), (n: Int)=> n % 2 == 0)   //> res2: Boolean = false
  some(List(1, 3, 5, 8), (n: Int)=> n % 2 == 0)   //> res3: Boolean = true
  
  /////////////////////////////
  
  // PROBLEM 4B
  def some2[T](vals: List[T], test: T=>Boolean): Boolean = {
  	if(vals.filter(test) != Nil) true
  	else false
  }                                               //> some2: [T](vals: List[T], test: T => Boolean)Boolean
  some2(List(1, 3, 5, 7), (n: Int)=> n % 2 == 0)  //> res4: Boolean = false
  some2(List(1, 3, 5, 8), (n: Int)=> n % 2 == 0)  //> res5: Boolean = true
}