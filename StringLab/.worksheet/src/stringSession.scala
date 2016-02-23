import scala.util.Random
import scala.StringBuilder

object stringSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(119); 
  println("Welcome to the Scala worksheet");$skip(100); 

  def isPal(word: String) = {
    val word2 = word.trim.toLowerCase
    word2 == word2.reverse
  };System.out.println("""isPal: (word: String)Boolean""");$skip(19); val res$0 = 
  isPal("rotator");System.out.println("""res0: Boolean = """ + $show(res$0));$skip(15); val res$1 = 
  isPal("cat");System.out.println("""res1: Boolean = """ + $show(res$1));$skip(19); val res$2 = 
  isPal("Racecar");System.out.println("""res2: Boolean = """ + $show(res$2));$skip(72); 

  def isLetter(c: Char) = 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z';System.out.println("""isLetter: (c: Char)Boolean""");$skip(65); 


	def isPal2(phrase: String) = isPal(phrase.filter(isLetter _));System.out.println("""isPal2: (phrase: String)Boolean""");$skip(44); val res$3 = 
  isPal2("A man, a plan, a canal, Panama!");System.out.println("""res3: Boolean = """ + $show(res$3));$skip(95); 
  
  def mkPal(s: String) = {
  	val word1 = s
  	val word2 = s.reverse
  	(word1 + word2)
  };System.out.println("""mkPal: (s: String)String""");$skip(15); val res$4 = 
  mkPal("ham");System.out.println("""res4: String = """ + $show(res$4));$skip(16); val res$5 = 
  mkPal("mars");System.out.println("""res5: String = """ + $show(res$5));$skip(212); 
  
  def mkWord(length: Int = 10) = {
  	val rnd = new Random
		val sb = new StringBuilder
		for(i <- 0 to length-1) {
			val char = ('a' + rnd.nextInt('z' - 'a')).toChar
			sb.append(char)
		}
		sb.toString
  };System.out.println("""mkWord: (length: Int)String""");$skip(14); val res$6 = 
  
  mkWord();System.out.println("""res6: String = """ + $show(res$6));$skip(13); val res$7 = 
  mkWord(15);System.out.println("""res7: String = """ + $show(res$7));$skip(366); 
  
  def mkSentence(length: Int = 10) = {
  	val rnd = new Random
  	val sb = new StringBuilder
  		for(i <- 0 to length-1)
  			if (i == length-1)
  				sb.append(mkWord(rnd.nextInt(10) + 1) + ".")
  			else if (i == 0)
  				sb.append((mkWord(rnd.nextInt(10) + 1) + ".").charAt(0).toUpper)
  			else sb.append(mkWord(rnd.nextInt(10) + 1) + " ")
  	sb.toString
  };System.out.println("""mkSentence: (length: Int)String""");$skip(15); val res$8 = 
  mkSentence();System.out.println("""res8: String = """ + $show(res$8));$skip(17); val res$9 = 
  mkSentence(15);System.out.println("""res9: String = """ + $show(res$9));$skip(227); 
                                                  
  def shuffle(str: String) = {
  	val half1 = str.substring(0, str.length/2)
  	val half2 = str.substring(str.length/2, str.length)
  	val result = half2+half1
  	(result)
  };System.out.println("""shuffle: (str: String)String""");$skip(31); val res$10 = 
  
  shuffle("aabbccddeeffgg");System.out.println("""res10: String = """ + $show(res$10));$skip(223); 
  
  def countSubstrings(str1:String, str2:String): Int = {
  	def count(pos: Int, c: Int): Int = {
      val idx = str2.indexOf(str1, pos)
      if(idx == -1) c
      else count(idx+str1.size, c+1)
   	}
   	count(0,0)
	};System.out.println("""countSubstrings: (str1: String, str2: String)Int""");$skip(38); val res$11 = 
	countSubstrings("is", "Mississippi");System.out.println("""res11: Int = """ + $show(res$11));$skip(240); 
	
	def first(arr: Array[String]) = {
	var result = ""
		for(i <- 0 until arr.length-1)
			if (arr(i).compareTo(arr(i+1)) > 0) result = arr(i+1)
			else if (arr(i).compareTo(arr(i+1)) < 0) result = arr(i)
			else result = arr(i)
		result
	};System.out.println("""first: (arr: Array[String])String""");$skip(37); val res$12 = 
	
	first(Array("cat", "rat", "bat"));System.out.println("""res12: String = """ + $show(res$12))}
}
