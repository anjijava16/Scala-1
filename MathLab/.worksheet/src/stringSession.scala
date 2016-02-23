object stringSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
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
  isPal2("A man, a plan, a canal, Panama!");System.out.println("""res3: Boolean = """ + $show(res$3))}
}
