object listSession2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // 1
 	var cs152 = List(List(93.0, 89.0, 90.0), List(75.0, 76.0, 68.0), List(88.0, 82.0, 78.0))
                                                  //> cs152  : List[List[Double]] = List(List(93.0, 89.0, 90.0), List(75.0, 76.0, 
                                                  //| 68.0), List(88.0, 82.0, 78.0))
 	
 	def avg(scores: List[Double]): Double = {
 		scores.reduce(_ + _) / scores.size
 	}                                         //> avg: (scores: List[Double])Double
 	
 	def avgAvg(scores: List[List[Double]]): List[Double] = {
 		if (scores == Nil) Nil
 		else scores.head.reduce(_ + _) / scores.head.size :: avgAvg(scores.tail)
 	}                                         //> avgAvg: (scores: List[List[Double]])List[Double]
 	
 	avgAvg(cs152)                             //> res0: List[Double] = List(90.66666666666667, 73.0, 82.66666666666667)
 	
 	def passing(scores: List[List[Double]]): List[Int] = {
 		def helper(scores: List[List[Double]], pos: Int): List[Int] = {
 			if (scores == Nil) Nil
 			else {
 				if (avg(scores.head) >= 70) pos :: helper(scores.tail, pos+1)
 				else helper(scores.tail, pos+1)
 			}
 		}
 		helper(scores, 0)
 	}                                         //> passing: (scores: List[List[Double]])List[Int]
 	passing(cs152)                            //> res1: List[Int] = List(0, 1, 2)
  
  def sumSums(scores: List[List[Double]]): Double = {
  	var sum = 0.0
    // sub is a sublist
    for (sub <- scores) {
      // int is the individual ele in the sublist
      for (s <- sub) {
        sum += s
      }
    }
    sum
  }                                               //> sumSums: (scores: List[List[Double]])Double
  sumSums(cs152)                                  //> res2: Double = 739.0
  
  
  // 3
  def spellCheckMFR(doc: List[String], dictionary: List[String]): List[String] = {
  	doc.filter((w) => !dictionary.contains(w))
  }                                               //> spellCheckMFR: (doc: List[String], dictionary: List[String])List[String]
  
  // 4
  val list = List((3.0, 2.0), (-5.0, 0.0))        //> list  : List[(Double, Double)] = List((3.0,2.0), (-5.0,0.0))
  def evalMono(mono: (Double, Double), x: Double) = mono._1 * (math.pow(mono._2, x))
                                                  //> evalMono: (mono: (Double, Double), x: Double)Double
  evalMono(list.head, 4)                          //> res3: Double = 48.0
  
  def evalPoly(poly: List[(Double, Double)], x: Double): Double = {
  	poly.head._1 * (math.pow(poly.head._2, x))
  }                                               //> evalPoly: (poly: List[(Double, Double)], x: Double)Double
  evalPoly(list, 2)                               //> res4: Double = 12.0
}