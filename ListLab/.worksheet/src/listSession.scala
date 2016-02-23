import scala.math

object listSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 
  println("Welcome to the Scala worksheet");$skip(62); 

  // PROBLEM 1

  // Test List
  val a = List(3, 3, 3, 4, 5);System.out.println("""a  : List[Int] = """ + $show(a ));$skip(81); 

  // helper
  def isOdd(x: Int) = {
    if (x % 2 != 0) true
    else false
  };System.out.println("""isOdd: (x: Int)Boolean""");$skip(41); 
  def cube(x: Int) = {
    x * x * x
  };System.out.println("""cube: (x: Int)Int""");$skip(143); 

  // iterative
  def oddCubeSumI(l: List[Int]) = {
    var sum = 0;
    for (x <- l) {
      if (isOdd(x)) sum += x * x * x
    }
    sum
  };System.out.println("""oddCubeSumI: (l: List[Int])Int""");$skip(17); val res$0 = 
  oddCubeSumI(a);System.out.println("""res0: Int = """ + $show(res$0));$skip(186); 

  // recursive
  def oddCubeSumR(l: List[Int]): Int = {
    if (l.isEmpty) 0
    else if (isOdd(l.head)) l.head * l.head * l.head + oddCubeSumR(l.tail)
    else oddCubeSumR(l.tail)
  };System.out.println("""oddCubeSumR: (l: List[Int])Int""");$skip(17); val res$1 = 
  oddCubeSumR(a);System.out.println("""res1: Int = """ + $show(res$1));$skip(291); 

  // tail-recursive
  def oddCubeSumTR(l: List[Int]): Int = {
    def ocsHelper(l: List[Int], accum: Int): Int = {
      if (l.isEmpty) accum
      else if (isOdd(l.head)) ocsHelper(l.tail, accum + l.head * l.head * l.head)
      else ocsHelper(l.tail, accum)
    }
    ocsHelper(l, 0)
  };System.out.println("""oddCubeSumTR: (l: List[Int])Int""");$skip(18); val res$2 = 
  oddCubeSumTR(a);System.out.println("""res2: Int = """ + $show(res$2));$skip(42); val res$3 = 

  // map filter reduce
  a.reduce(_ + _);System.out.println("""res3: Int = """ + $show(res$3));$skip(14); val res$4 = 
  a.map(cube);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(18); val res$5 = 
  a.filter(isOdd);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(92); 

  def oddCubeSumMRF(l: List[Int]): Int = {
    l.filter(isOdd).map(cube).reduce(_ + _)
  };System.out.println("""oddCubeSumMRF: (l: List[Int])Int""");$skip(19); val res$6 = 
  oddCubeSumMRF(a);System.out.println("""res6: Int = """ + $show(res$6));$skip(269); 

  // defining reduce
  // bop is binary operator (takes 2 elements and turns into 1
  // init is initial value (usually 0)
  def reduce[T](vals: List[T], bop: (T, T) => T, init: T): T = {
    if (vals == Nil) init else bop(vals.head, reduce(vals.tail, bop, init))
  };System.out.println("""reduce: [T](vals: List[T], bop: (T, T) => T, init: T)T""");$skip(263); 
  
	def spellCheck(doc: List[String], dictionary: List[String]): List[String] = {
    if (doc == Nil) Nil
    else {
      val badWords = spellCheck(doc.tail, dictionary)
      if (dictionary.contains(doc.head)) badWords
      else doc.head :: badWords
    }
  };System.out.println("""spellCheck: (doc: List[String], dictionary: List[String])List[String]""");$skip(213); 
  // spellcheck MFR
  // lambda: (params) => body
  // doc.filter((w) => !dictionary.contains(w))

  ///////////////////////////////////

  //PROBLEM 2

  // Test List
  val b = List(List(1, 2, 3), List(1, 2, 3));System.out.println("""b  : List[List[Int]] = """ + $show(b ));$skip(238); 

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
  };System.out.println("""sumOfSumsI: (l: List[List[Int]])Int""");$skip(16); val res$7 = 
  sumOfSumsI(b);System.out.println("""res7: Int = """ + $show(res$7));$skip(269); 

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
  };System.out.println("""sumOfSumsR: (l: List[List[Int]])Int""");$skip(16); val res$8 = 
  sumOfSumsR(b);System.out.println("""res8: Int = """ + $show(res$8));$skip(280); 

  // tail-recursive
  def sumOfSumsTR(l: List[List[Int]]): Int = {
    def sosHelper(l: List[List[Int]], accum: Int): Int = {
      var sum = accum
      for (ele <- l.head) sum += ele
      if (l.tail.isEmpty) sum
      else sosHelper(l.tail, sum)
    }
    sosHelper(l, 0)
  };System.out.println("""sumOfSumsTR: (l: List[List[Int]])Int""");$skip(17); val res$9 = 
  sumOfSumsTR(b);System.out.println("""res9: Int = """ + $show(res$9));$skip(127); 

  // map-reduce
  def sumOfSumsMFR(l : List[List[Int]]) = {
  	def sum(y: List[Int]) = y.reduce(_ + _)
  	sum(l.map(sum))
  };System.out.println("""sumOfSumsMFR: (l: List[List[Int]])Int""");$skip(18); val res$10 = 
  sumOfSumsMFR(b);System.out.println("""res10: Int = """ + $show(res$10));$skip(182); 

  ///////////////////////////////////

  // PROBLEM 3
  // if nil, 0
  // if input is not a list 0
  // map depth function

  // Test List
  val c = List(List(List(1, 2, List(3))));System.out.println("""c  : List[List[List[Any]]] = """ + $show(c ));$skip(294); 

  // recursive
  def listDepthR(l: List[Any]): Int = {
  	if (l == Nil) 0
  	else if (!l.isInstanceOf[List[Any]]) 0
  	else {
  		if (l.head.isInstanceOf[List[Any]]) math.max(listDepthR(l.head.asInstanceOf[List[Any]]) + 1, listDepthR(l.tail))
  		else math.max(1, listDepthR(l.tail))
  	}
  };System.out.println("""listDepthR: (l: List[Any])Int""");$skip(16); val res$11 = 
  listDepthR(c);System.out.println("""res11: Int = """ + $show(res$11));$skip(106); 

  ///////////////////////////////////

  // PROBLEM 4

  // Test List
  val d = List(1.0, 3.0, 4.0, 5.0);System.out.println("""d  : List[Double] = """ + $show(d ));$skip(116); 

  // iterative
  def dblAvgI(l: List[Double]) = {
    var sum = 0.0
    for (e <- l) sum += e
    sum / l.size
  };System.out.println("""dblAvgI: (l: List[Double])Double""");$skip(13); val res$12 = 
  dblAvgI(d);System.out.println("""res12: Double = """ + $show(res$12));$skip(214); 

  // recursive
  def dblAvgR(l: List[Double]): Double = {
    val size = l.size
    def helper(l: List[Double]): Double = {
      if (l.isEmpty) 0
      else l.head + helper(l.tail)
    }
    helper(l) / size
  };System.out.println("""dblAvgR: (l: List[Double])Double""");$skip(13); val res$13 = 
  dblAvgR(d);System.out.println("""res13: Double = """ + $show(res$13));$skip(243); 

  // tail-recursive
  def dblAvgTR(l: List[Double]): Double = {
    val size = l.size
    def helper(l: List[Double], sum: Double): Double = {
      if (l.isEmpty) sum / size
      else helper(l.tail, sum + l.head)
    }
    helper(l, 0)
  };System.out.println("""dblAvgTR: (l: List[Double])Double""");$skip(15); val res$14 = 

  dblAvgTR(d);System.out.println("""res14: Double = """ + $show(res$14));$skip(101); 

  // map filter reduce
  def dblAvgMFR(l: List[Double]): Double = {
  	l.reduce(_ + _) / l.size
  };System.out.println("""dblAvgMFR: (l: List[Double])Double""");$skip(15); val res$15 = 
  dblAvgMFR(d);System.out.println("""res15: Double = """ + $show(res$15));$skip(213); 

  ///////////////////////////////////

  // PROBLEM 5

  ///////////////////////////////////

  // PROBLEM 6

  // predicate
  def boolTest[T](t: (T)) = {
    if (t.isInstanceOf[Boolean]) true
    else false
  };System.out.println("""boolTest: [T](t: T)Boolean""");$skip(69); 

  // iterative
  var f = List("1", 4421, true, false, "wow", false);System.out.println("""f  : List[Any] = """ + $show(f ));$skip(160); 

  def boolPredI[T](pred: (T) => Boolean, l: List[T]) = {
    var result = 0
    for (element <- l) {
      if (pred(element)) result += 1
    }
    result
  };System.out.println("""boolPredI: [T](pred: T => Boolean, l: List[T])Int""");$skip(25); val res$16 = 
  boolPredI(boolTest, f);System.out.println("""res16: Int = """ + $show(res$16));$skip(207); 

  // recursive
  def boolPredR[T](pred: (T) => Boolean, l: List[T]): Int = {
    if (l.isEmpty) 0
    else {
      if (pred(l.head)) 1 + boolPredR(pred, l.tail)
      else boolPredR(pred, l.tail)
    }
  };System.out.println("""boolPredR: [T](pred: T => Boolean, l: List[T])Int""");$skip(25); val res$17 = 
  boolPredR(boolTest, f);System.out.println("""res17: Int = """ + $show(res$17));$skip(322); 
  
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
  };System.out.println("""boolPredTR: [T](pred: T => Boolean, l: List[T])Int""");$skip(26); val res$18 = 
  boolPredTR(boolTest, f);System.out.println("""res18: Int = """ + $show(res$18));$skip(121); 
  
  // map filter reduce
  def boolPredMFR[T](pred: (T) => Boolean, l: List[T]): Int = {
  	l.filter(boolTest).size
  };System.out.println("""boolPredMFR: [T](pred: T => Boolean, l: List[T])Int""");$skip(27); val res$19 = 
  boolPredMFR(boolTest, f);System.out.println("""res19: Int = """ + $show(res$19));$skip(102); 
  
  ///////////////////////////////////
  
  // PROBLEM 7
  
  // List
  val g = List(1, 2, 3, 4, 5);System.out.println("""g  : List[Int] = """ + $show(g ));$skip(40); 
  val h = List(true, false, "hello", 1);System.out.println("""h  : List[Any] = """ + $show(h ));$skip(111); 
  
  // predicate
  def isInt[T](element : (T)) = {
  	 if (element.isInstanceOf[Int]) true
  	 else false
  };System.out.println("""isInt: [T](element: T)Boolean""");$skip(159); 
  
  // iterative
  def allPredCheck[T](pred: (T) => Boolean, l: List[T]) = {
  	var result = true;
  	for (x <- l) if (!pred(x)) result = false
  	result
  };System.out.println("""allPredCheck: [T](pred: T => Boolean, l: List[T])Boolean""");$skip(25); val res$20 = 
  allPredCheck(isInt, g);System.out.println("""res20: Boolean = """ + $show(res$20));$skip(25); val res$21 = 
  allPredCheck(isInt, h);System.out.println("""res21: Boolean = """ + $show(res$21));$skip(301); 
  
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
  };System.out.println("""allPredCheckR: [T](pred: T => Boolean, l: List[T])Boolean""");$skip(26); val res$22 = 
  allPredCheckR(isInt, g);System.out.println("""res22: Boolean = """ + $show(res$22));$skip(26); val res$23 = 
  allPredCheckR(isInt, h);System.out.println("""res23: Boolean = """ + $show(res$23));$skip(355); 
  
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
  };System.out.println("""allPredCheckTR: [T](pred: T => Boolean, l: List[T])Boolean""");$skip(27); val res$24 = 
  allPredCheckTR(isInt, g);System.out.println("""res24: Boolean = """ + $show(res$24));$skip(27); val res$25 = 
  allPredCheckTR(isInt, h);System.out.println("""res25: Boolean = """ + $show(res$25));$skip(158); 
  
  // map filter reduce
  def allPredCheckMFR[T](pred: (T) => Boolean, l: List[T]): Boolean = {
  	if(l.filter(pred).size == l.size) true
  	else false
  };System.out.println("""allPredCheckMFR: [T](pred: T => Boolean, l: List[T])Boolean""");$skip(31); val res$26 = 
  
  allPredCheckMFR(isInt, g);System.out.println("""res26: Boolean = """ + $show(res$26));$skip(28); val res$27 = 
  allPredCheckMFR(isInt, h);System.out.println("""res27: Boolean = """ + $show(res$27));$skip(106); 
  
  ///////////////////////////////////
  
  // PROBLEM 8
  val i = List("cow", "fish", "bear", "sheep");System.out.println("""i  : List[String] = """ + $show(i ));$skip(168); 
  
  // iterative
  def anyElementI[T](pred: (T) => Boolean, l: List[T]): Boolean = {
  	var res = false;
  	for (x <- l) {
  		if (pred(x)) res = true
  	}
  	res
  };System.out.println("""anyElementI: [T](pred: T => Boolean, l: List[T])Boolean""");$skip(24); val res$28 = 
  anyElementI(isInt, g);System.out.println("""res28: Boolean = """ + $show(res$28));$skip(24); val res$29 = 
  anyElementI(isInt, i);System.out.println("""res29: Boolean = """ + $show(res$29));$skip(142); 
  
  // map reduce
  def anyElementMFR[T](pred: (T) => Boolean, l: List[T]): Boolean = {
  	if (l.filter(pred) != Nil) true
  	else false
  };System.out.println("""anyElementMFR: [T](pred: T => Boolean, l: List[T])Boolean""");$skip(26); val res$30 = 
  anyElementMFR(isInt, g);System.out.println("""res30: Boolean = """ + $show(res$30));$skip(26); val res$31 = 
  anyElementMFR(isInt, i);System.out.println("""res31: Boolean = """ + $show(res$31))}
}
