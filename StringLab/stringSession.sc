import scala.util.Random
import scala.StringBuilder

object stringSession {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def isPal(word: String) = {
    val word2 = word.trim.toLowerCase
    word2 == word2.reverse
  }                                               //> isPal: (word: String)Boolean
  isPal("rotator")                                //> res0: Boolean = true
  isPal("cat")                                    //> res1: Boolean = false
  isPal("Racecar")                                //> res2: Boolean = true

  def isLetter(c: Char) = 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z'
                                                  //> isLetter: (c: Char)Boolean


	def isPal2(phrase: String) = isPal(phrase.filter(isLetter _))
                                                  //> isPal2: (phrase: String)Boolean
  isPal2("A man, a plan, a canal, Panama!")       //> res3: Boolean = true
  
  def mkPal(s: String) = {
  	val word1 = s
  	val word2 = s.reverse
  	(word1 + word2)
  }                                               //> mkPal: (s: String)String
  mkPal("ham")                                    //> res4: String = hammah
  mkPal("mars")                                   //> res5: String = marssram
  
  def mkWord(length: Int = 10) = {
  	val rnd = new Random
		val sb = new StringBuilder
		for(i <- 0 to length-1) {
			val char = ('a' + rnd.nextInt('z' - 'a')).toChar
			sb.append(char)
		}
		sb.toString
  }                                               //> mkWord: (length: Int)String
  
  mkWord()                                        //> res6: String = vjcpmsossn
  mkWord(15)                                      //> res7: String = jpbhwvergpehegq
  
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
  }                                               //> mkSentence: (length: Int)String
  mkSentence()                                    //> res8: String = Hkgfk perkl ccdvgh sulhe ppqxj fexpjjjkb gdpqgaehh edrhr opx
                                                  //| v.
  mkSentence(15)                                  //> res9: String = Oimtfnkqpby wiy vkehjomj nrx sgkutsb baxssq rnlsqjhgg duildi
                                                  //| ve s dvrbrqm pn ifnqcqn phyfunk ua.
                                                  
  def shuffle(str: String) = {
  	val half1 = str.substring(0, str.length/2)
  	val half2 = str.substring(str.length/2, str.length)
  	val result = half2+half1
  	(result)
  }                                               //> shuffle: (str: String)String
  
  shuffle("aabbccddeeffgg")                       //> res10: String = deeffggaabbccd
  
  def countSubstrings(str1:String, str2:String): Int = {
  	def count(pos: Int, c: Int): Int = {
      val idx = str2.indexOf(str1, pos)
      if(idx == -1) c
      else count(idx+str1.size, c+1)
   	}
   	count(0,0)
	}                                         //> countSubstrings: (str1: String, str2: String)Int
	countSubstrings("is", "Mississippi")      //> res11: Int = 2
	
	def first(arr: Array[String]) = {
	var result = ""
		for(i <- 0 until arr.length-1)
			if (arr(i).compareTo(arr(i+1)) > 0) result = arr(i+1)
			else if (arr(i).compareTo(arr(i+1)) < 0) result = arr(i)
			else result = arr(i)
		result
	}                                         //> first: (arr: Array[String])String
	
	first(Array("cat", "rat", "bat"))         //> res12: String = bat
}