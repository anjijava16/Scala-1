object patternSession {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  // URLs
  val urlPattern = "(http://)?www\\.[a-zA-Z0-9]+\\.(edu|gov|com|org)((/[a-zA-Z0-9]+)+\\.html?)?"
                                                  //> urlPattern  : String = (http://)?www\.[a-zA-Z0-9]+\.(edu|gov|com|org)((/[a-z
                                                  //| A-Z0-9]+)+\.html?)?

  "http://www.sjsu.edu/cs/faculty/pearce/index.htm".matches(urlPattern)
                                                  //> res0: Boolean = true

  "www.sjsu.edu/cs/faculty/pearce/index.htm".matches(urlPattern)
                                                  //> res1: Boolean = true

  "http://www.sjsu.edu".matches(urlPattern)       //> res2: Boolean = true

  // US Phones
  val usPhonePattern = "(001|1)?(\\([1-9][0-9]{2}\\))?([1-9][0-9]{2}-[0-9]{4})"
                                                  //> usPhonePattern  : String = (001|1)?(\([1-9][0-9]{2}\))?([1-9][0-9]{2}-[0-9]{
                                                  //| 4})

  "(408)924-5060".matches(usPhonePattern)         //> res3: Boolean = true
  "1(408)924-5060".matches(usPhonePattern)        //> res4: Boolean = true
  "924-5060".matches(usPhonePattern)              //> res5: Boolean = true

  // C Identifier
  val cIdPattern = "[_a-zA-Z][_a-zA-Z0-9]*"       //> cIdPattern  : String = [_a-zA-Z][_a-zA-Z0-9]*
  "_hello_World13".matches(cIdPattern)            //> res6: Boolean = true

  // Social Security
  val ssPattern = "(?!000)(?!666)(?!9)\\d{3}([-]?)(?!00)\\d{2}([-]?)(?!0000)\\d{4}"
                                                  //> ssPattern  : String = (?!000)(?!666)(?!9)\d{3}([-]?)(?!00)\d{2}([-]?)(?!0000
                                                  //| )\d{4}
  "123-45-6789".matches(ssPattern)                //> res7: Boolean = true
  "666-00-0000".matches(ssPattern)                //> res8: Boolean = false

  // Hexadecimal
  val hexPattern = "0[xX][0-9a-fA-F]+"            //> hexPattern  : String = 0[xX][0-9a-fA-F]+
  "0xAFFF".matches(hexPattern)                    //> res9: Boolean = true
  "1xASDI)D)@".matches(hexPattern)                //> res10: Boolean = false

  // Sentences
  val sentencePattern = "[A-Z][a-z]+(\\s[A-Za-z]+)+."
                                                  //> sentencePattern  : String = [A-Z][a-z]+(\s[A-Za-z]+)+.
  "Hi my name is sheep.".matches(sentencePattern) //> res11: Boolean = true
  "woboboalalalal".matches(sentencePattern)       //> res12: Boolean = false
}