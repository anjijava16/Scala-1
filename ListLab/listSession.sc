import scala.math

object listSession {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  // PROBLEM 1

  // Test List
  val a = List(3, 3, 3, 4, 5)                     //> a  : List[Int] = List(3, 3, 3, 4, 5)

  // helper
  def isOdd(x: Int) = {
    if (x % 2 != 0) true
    else false
  }                                               //> isOdd: (x: Int)Boolean
  def cube(x: Int) = {
    x * x * x
  }                                               //> cube: (x: Int)Int

  // iterative
  def oddCubeSumI(l: List[Int]) = {
    var sum = 0;
    for (x <- l) {
      if (isOdd(x)) sum += x * x * x
    }
    sum
  }                                               //> oddCubeSumI: (l: List[Int])Int
  oddCubeSumI(a)                                  //> res0: Int = 206

  // recursive
  def oddCubeSumR(l: List[Int]): Int = {
    if (l.isEmpty) 0
    else if (isOdd(l.head)) l.head * l.head * l.head + oddCubeSumR(l.tail)
    else oddCubeSumR(l.tail)
  }                                               //> oddCubeSumR: (l: List[Int])Int
  oddCubeSumR(a)                                  //> res1: Int = 206

  // tail-recursive
  def oddCubeSumTR(l: List[Int]): Int = {
    def ocsHelper(l: List[Int], accum: Int): Int = {
      if (l.isEmpty) accum
      else if (isOdd(l.head)) ocsHelper(l.tail, accum + l.head * l.head * l.head)
      else ocsHelper(l.tail, accum)
    }
    ocsHelper(l, 0)
  }                                               //> oddCubeSumTR: (l: List[Int])Int
  oddCubeSumTR(a)                                 //> res2: Int = 206

  // map filter reduce
  a.reduce(_ + _)                                 //> res3: Int = 18
  a.map(cube)                                     //> res4: List[Int] = List(27, 27, 27, 64, 125)
  a.filter(isOdd)                                 //> res5: List[Int] = List(3, 3, 3, 5)

  def oddCubeSumMRF(l: List[Int]): Int = {
    l.filter(isOdd).map(cube).reduce(_ + _)
  }                                               //> oddCubeSumMRF: (l: List[Int])Int
  oddCubeSumMRF(a)                                //> res6: Int = 206

  // defining reduce
  // bop is binary operator (takes 2 elements and turns into 1
  // init is initial value (usually 0)
  def reduce[T](vals: List[T], bop: (T, T) => T, init: T): T = {
    if (vals == Nil) init else bop(vals.head, reduce(vals.tail, bop, init))
  }                                               //> reduce: [T](vals: List[T], bop: (T, T) => T, init: T)T
  
	def spellCheck(doc: List[String], dictionary: List[String]): List[String] = {
    if (doc == Nil) Nil
    else {
      val badWords = spellCheck(doc.tail, dictionary)
      if (dictionary.contains(doc.head)) badWords
      else doc.head :: badWords
    }
  }                                               //> spellCheck: (doc: List[String], dictionary: List[String])List[String]
  // spellcheck MFR
  // lambda: (params) => body
  // doc.filter((w) => !dictionary.contains(w))

  ///////////////////////////////////

  //PROBLEM 2

  // Test List
  val b = List(List(1, 2, 3), List(1, 2, 3))      //> b  : List[List[Int]] = List(List(1, 2, 3), List(1, 2, 3))

  // iterative
  def sumOfSumsI(l: List[List[Int]]) = {
    var sum = 0
    // sub is a sublist
    for (sub <- l) {
      // int is the individual ele in the sublist
      for (int <- sub) {
        sum += int
      }
    }
    sum
  }                                               //> sumOfSumsI: (l: List[List[Int]])Int
  sumOfSumsI(b)                                   //> res7: Int = 12

  // recursive
  def sumOfSumsR(l: List[List[Int]]): Int = {
    var sum = 0;
    def sosHelper(subList: List[Int]): Int = {
      for (x <- subList) {
        sum += x
      }
      sum
    }
    if (l.isEmpty) sum
    else sosHelper(l.head) + sumOfSumsR(l.tail)
  }                                               //> sumOfSumsR: (l: List[List[Int]])Int
  sumOfSumsR(b)                                   //> res8: Int = 12

  // tail-recursive
  def sumOfSumsTR(l: List[List[Int]]): Int = {
    def sosHelper(l: List[List[Int]], accum: Int): Int = {
      var sum = accum
      for (ele <- l.head) sum += ele
      if (l.tail.isEmpty) sum
      else sosHelper(l.tail, sum)
    }
    sosHelper(l, 0)
  }                                               //> sumOfSumsTR: (l: List[List[Int]])Int
  sumOfSumsTR(b)                                  //> res9: Int = 12

  // map-reduce
  def sumOfSumsMFR(l : List[List[Int]]) = {
  	def sum(y: List[Int]) = y.reduce(_ + _)
  	sum(l.map(sum))
  }                                               //> sumOfSumsMFR: (l: List[List[Int]])Int
  sumOfSumsMFR(b)                                 //> res10: Int = 12

  ///////////////////////////////////

  // PROBLEM 3
  // if nil, 0
  // if input is not a list 0
  // map depth function

  // Test List
  val c = List(List(List(1, 2, List(3))))         //> c  : List[List[List[Any]]] = List(List(List(1, 2, List(3))))

  // recursive
  def listDepthR(l: List[Any]): Int = {
  	if (l == Nil) 0
  	else if (!l.isInstanceOf[List[Any]]) 0
  	else {
  		if (l.head.isInstanceOf[List[Any]]) math.max(listDepthR(l.head.asInstanceOf[List[Any]]) + 1, listDepthR(l.tail))
  		else math.max(1, listDepthR(l.tail))
  	}
  }                                               //> listDepthR: (l: List[Any])Int
  listDepthR(c)                                   //> res11: Int = 4

  ///////////////////////////////////

  // PROBLEM 4

  // Test List
  val d = List(1.0, 3.0, 4.0, 5.0)                //> d  : List[Double] = List(1.0, 3.0, 4.0, 5.0)

  // iterative
  def dblAvgI(l: List[Double]) = {
    var sum = 0.0
    for (e <- l) sum += e
    sum / l.size
  }                                               //> dblAvgI: (l: List[Double])Double
  dblAvgI(d)                                      //> res12: Double = 3.25

  // recursive
  def dblAvgR(l: List[Double]): Double = {
    val size = l.size
    def helper(l: List[Double]): Double = {
      if (l.isEmpty) 0
      else l.head + helper(l.tail)
    }
    helper(l) / size
  }                                               //> dblAvgR: (l: List[Double])Double
  dblAvgR(d)                                      //> res13: Double = 3.25

  // tail-recursive
  def dblAvgTR(l: List[Double]): Double = {
    val size = l.size
    def helper(l: List[Double], sum: Double): Double = {
      if (l.isEmpty) sum / size
      else helper(l.tail, sum + l.head)
    }
    helper(l, 0)
  }                                               //> dblAvgTR: (l: List[Double])Double

  dblAvgTR(d)                                     //> res14: Double = 3.25

  // map filter reduce
  def dblAvgMFR(l: List[Double]): Double = {
  	l.reduce(_ + _) / l.size
  }                                               //> dblAvgMFR: (l: List[Double])Double
  dblAvgMFR(d)                                    //> res15: Double = 3.25

  ///////////////////////////////////

  // PROBLEM 5

  ///////////////////////////////////

  // PROBLEM 6

  // predicate
  def boolTest[T](t: (T)) = {
    if (t.isInstanceOf[Boolean]) true
    else false
  }                                               //> boolTest: [T](t: T)Boolean

  // iterative
  var f = List("1", 4421, true, false, "wow", false)
                                                  //> f  : List[Any] = List(1, 4421, true, false, wow, false)

  def boolPredI[T](pred: (T) => Boolean, l: List[T]) = {
    var result = 0
    for (element <- l) {
      if (pred(element)) result += 1
    }
    result
  }                                               //> boolPredI: [T](pred: T => Boolean, l: List[T])Int
  boolPredI(boolTest, f)                          //> res16: Int = 3

  // recursive
  def boolPredR[T](pred: (T) => Boolean, l: List[T]): Int = {
    if (l.isEmpty) 0
    else {
      if (pred(l.head)) 1 + boolPredR(pred, l.tail)
      else boolPredR(pred, l.tail)
    }
  }                                               //> boolPredR: [T](pred: T => Boolean, l: List[T])Int
  boolPredR(boolTest, f)                          //> res17: Int = 3
  
  // tail-recursive
  def boolPredTR[T](pred: (T) => Boolean, l: List[T]): Int = {
  	def helper[T](pred: (T) => Boolean, l: List[T], total: Int): Int = {
  		if (l.isEmpty) total
  		else {
  			if (pred(l.head)) helper(pred, l.tail, total+1)
  			else helper(pred, l.tail, total)
  		}
  	}
  	helper(pred, l, 0)
  }                                               //> boolPredTR: [T](pred: T => Boolean, l: List[T])Int
  boolPredTR(boolTest, f)                         //> res18: Int = 3
  
  // map filter reduce
  def boolPredMFR[T](pred: (T) => Boolean, l: List[T]): Int = {
  	l.filter(boolTest).size
  }                                               //> boolPredMFR: [T](pred: T => Boolean, l: List[T])Int
  boolPredMFR(boolTest, f)                        //> res19: Int = 3
  
  ///////////////////////////////////
  
  // PROBLEM 7
  
  // List
  val g = List(1, 2, 3, 4, 5)                     //> g  : List[Int] = List(1, 2, 3, 4, 5)
  val h = List(true, false, "hello", 1)           //> h  : List[Any] = List(true, false, hello, 1)
  
  // predicate
  def isInt[T](element : (T)) = {
  	 if (element.isInstanceOf[Int]) true
  	 else false
  }                                               //> isInt: [T](element: T)Boolean
  
  // iterative
  def allPredCheck[T](pred: (T) => Boolean, l: List[T]) = {
  	var result = true;
  	for (x <- l) if (!pred(x)) result = false
  	result
  }                                               //> allPredCheck: [T](pred: T => Boolean, l: List[T])Boolean
  allPredCheck(isInt, g)                          //> res20: Boolean = true
  allPredCheck(isInt, h)                          //> res21: Boolean = false
  
  // recursive
  def allPredCheckR[T](pred: (T) => Boolean, l: List[T]): Boolean = {
  	var res = true
  	def helper(pred: (T) => Boolean, l: List[T]): Boolean = {
  		if (l.isEmpty) res
  		else {
  			if (pred(l.head)) helper(pred, l.tail)
  			else
  				false
  		}
  	}
  	helper(pred, l)
  }                                               //> allPredCheckR: [T](pred: T => Boolean, l: List[T])Boolean
  allPredCheckR(isInt, g)                         //> res22: Boolean = true
  allPredCheckR(isInt, h)                         //> res23: Boolean = false
  
  // tail-recursive
  def allPredCheckTR[T](pred: (T) => Boolean, l: List[T]): Boolean = {
  	var res = true;
  	def helper(pred: (T) => Boolean, l: List[T], res: Boolean): Boolean = {
  		if (l.isEmpty) res
  		else if (!res) res
  		else {
  			if (pred(l.head)) helper(pred, l.tail, res)
  			else false
  		}
  			
  	}
  	helper(pred, l, res)
  }                                               //> allPredCheckTR: [T](pred: T => Boolean, l: List[T])Boolean
  allPredCheckTR(isInt, g)                        //> res24: Boolean = true
  allPredCheckTR(isInt, h)                        //> res25: Boolean = false
  
  // map filter reduce
  def allPredCheckMFR[T](pred: (T) => Boolean, l: List[T]): Boolean = {
  	if(l.filter(pred).size == l.size) true
  	else false
  }                                               //> allPredCheckMFR: [T](pred: T => Boolean, l: List[T])Boolean
  
  allPredCheckMFR(isInt, g)                       //> res26: Boolean = true
  allPredCheckMFR(isInt, h)                       //> res27: Boolean = false
  
  ///////////////////////////////////
  
  // PROBLEM 8
  val i = List("cow", "fish", "bear", "sheep")    //> i  : List[String] = List(cow, fish, bear, sheep)
  
  // iterative
  def anyElementI[T](pred: (T) => Boolean, l: List[T]): Boolean = {
  	var res = false;
  	for (x <- l) {
  		if (pred(x)) res = true
  	}
  	res
  }                                               //> anyElementI: [T](pred: T => Boolean, l: List[T])Boolean
  anyElementI(isInt, g)                           //> res28: Boolean = true
  anyElementI(isInt, i)                           //> res29: Boolean = false
  
  // map reduce
  def anyElementMFR[T](pred: (T) => Boolean, l: List[T]): Boolean = {
  	if (l.filter(pred) != Nil) true
  	else false
  }                                               //> anyElementMFR: [T](pred: T => Boolean, l: List[T])Boolean
  anyElementMFR(isInt, g)                         //> res30: Boolean = true
  anyElementMFR(isInt, i)                         //> res31: Boolean = false
}