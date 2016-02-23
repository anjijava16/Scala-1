object patternSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(67); 
  println("Welcome to the Scala worksheet");$skip(108); 

  // URLs
  val urlPattern = "(http://)?www\\.[a-zA-Z0-9]+\\.(edu|gov|com|org)((/[a-zA-Z0-9]+)+\\.html?)?";System.out.println("""urlPattern  : String = """ + $show(urlPattern ));$skip(73); val res$0 = 

  "http://www.sjsu.edu/cs/faculty/pearce/index.htm".matches(urlPattern);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(66); val res$1 = 

  "www.sjsu.edu/cs/faculty/pearce/index.htm".matches(urlPattern);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(45); val res$2 = 

  "http://www.sjsu.edu".matches(urlPattern);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(96); 

  // US Phones
  val usPhonePattern = "(001|1)?(\\([1-9][0-9]{2}\\))?([1-9][0-9]{2}-[0-9]{4})";System.out.println("""usPhonePattern  : String = """ + $show(usPhonePattern ));$skip(43); val res$3 = 

  "(408)924-5060".matches(usPhonePattern);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(43); val res$4 = 
  "1(408)924-5060".matches(usPhonePattern);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(37); val res$5 = 
  "924-5060".matches(usPhonePattern);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(63); 

  // C Identifier
  val cIdPattern = "[_a-zA-Z][_a-zA-Z0-9]*";System.out.println("""cIdPattern  : String = """ + $show(cIdPattern ));$skip(39); val res$6 = 
  "_hello_World13".matches(cIdPattern);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(106); 

  // Social Security
  val ssPattern = "(?!000)(?!666)(?!9)\\d{3}([-]?)(?!00)\\d{2}([-]?)(?!0000)\\d{4}";System.out.println("""ssPattern  : String = """ + $show(ssPattern ));$skip(35); val res$7 = 
  "123-45-6789".matches(ssPattern);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(35); val res$8 = 
  "666-00-0000".matches(ssPattern);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(57); 

  // Hexadecimal
  val hexPattern = "0[xX][0-9a-fA-F]+";System.out.println("""hexPattern  : String = """ + $show(hexPattern ));$skip(31); val res$9 = 
  "0xAFFF".matches(hexPattern);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(35); val res$10 = 
  "1xASDI)D)@".matches(hexPattern);System.out.println("""res10: Boolean = """ + $show(res$10));$skip(70); 

  // Sentences
  val sentencePattern = "[A-Z][a-z]+(\\s[A-Za-z]+)+.";System.out.println("""sentencePattern  : String = """ + $show(sentencePattern ));$skip(50); val res$11 = 
  "Hi my name is sheep.".matches(sentencePattern);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(44); val res$12 = 
  "woboboalalalal".matches(sentencePattern);System.out.println("""res12: Boolean = """ + $show(res$12))}
}
