object listSession2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 
  println("Welcome to the Scala worksheet");$skip(101); 
  
  // 1
 	var cs152 = List(List(93.0, 89.0, 90.0), List(75.0, 76.0, 68.0), List(88.0, 82.0, 78.0));System.out.println("""cs152  : List[List[Double]] = """ + $show(cs152 ));$skip(89); 
 	
 	def avg(scores: List[Double]): Double = {
 		scores.reduce(_ + _) / scores.size
 	};System.out.println("""avg: (scores: List[Double])Double""");$skip(168); 
 	
 	def avgAvg(scores: List[List[Double]]): List[Double] = {
 		if (scores == Nil) Nil
 		else scores.head.reduce(_ + _) / scores.head.size :: avgAvg(scores.tail)
 	};System.out.println("""avgAvg: (scores: List[List[Double]])List[Double]""");$skip(19); val res$0 = 
 	
 	avgAvg(cs152);System.out.println("""res0: List[Double] = """ + $show(res$0));$skip(305); 
 	
 	def passing(scores: List[List[Double]]): List[Int] = {
 		def helper(scores: List[List[Double]], pos: Int): List[Int] = {
 			if (scores == Nil) Nil
 			else {
 				if (avg(scores.head) >= 70) pos :: helper(scores.tail, pos+1)
 				else helper(scores.tail, pos+1)
 			}
 		}
 		helper(scores, 0)
 	};System.out.println("""passing: (scores: List[List[Double]])List[Int]""");$skip(17); val res$1 = 
 	passing(cs152);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(240); 
  
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
  };System.out.println("""sumSums: (scores: List[List[Double]])Double""");$skip(17); val res$2 = 
  sumSums(cs152);System.out.println("""res2: Double = """ + $show(res$2));$skip(146); 
  
  
  // 3
  def spellCheckMFR(doc: List[String], dictionary: List[String]): List[String] = {
  	doc.filter((w) => !dictionary.contains(w))
  };System.out.println("""spellCheckMFR: (doc: List[String], dictionary: List[String])List[String]""");$skip(53); 
  
  // 4
  val list = List((3.0, 2.0), (-5.0, 0.0));System.out.println("""list  : List[(Double, Double)] = """ + $show(list ));$skip(85); 
  def evalMono(mono: (Double, Double), x: Double) = mono._1 * (math.pow(mono._2, x));System.out.println("""evalMono: (mono: (Double, Double), x: Double)Double""");$skip(25); val res$3 = 
  evalMono(list.head, 4);System.out.println("""res3: Double = """ + $show(res$3));$skip(121); 
  
  def evalPoly(poly: List[(Double, Double)], x: Double): Double = {
  	poly.head._1 * (math.pow(poly.head._2, x))
  };System.out.println("""evalPoly: (poly: List[(Double, Double)], x: Double)Double""");$skip(20); val res$4 = 
  evalPoly(list, 2);System.out.println("""res4: Double = """ + $show(res$4))}
}
