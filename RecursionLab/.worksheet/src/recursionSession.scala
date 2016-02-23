object recursionSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(69); 
  println("Welcome to the Scala worksheet");$skip(27); 

  def inc(n: Int) = n + 1;System.out.println("""inc: (n: Int)Int""");$skip(27); 

  def dec(n: Int) = n - 1;System.out.println("""dec: (n: Int)Int""");$skip(86); 

  def fib1(n: Int): Int = {
    if (n <= 1) 1
    else fib1(n - 1) + fib1(n - 2)
  };System.out.println("""fib1: (n: Int)Int""");$skip(169); 

  def fib2(n: Int) = {
    var fib2 = 1
    var fib1 = 1
    for (i <- 1 until n) {
      var temp = fib2 + fib1
      fib1 = fib2
      fib2 = temp
    }
    fib2
  };System.out.println("""fib2: (n: Int)Int""");$skip(164); 

  def fib3(n: Int) = {
    def helper(i: Int, f1: Int, f2: Int): Int = {
      if (i == n) f2
      else helper(i + 1, f2, f1 + f2)
    }

    helper(0, 1, 1)
  };System.out.println("""fib3: (n: Int)Int""");$skip(45); 

  for (i <- 0 to 10) {
    println(fib3(i))
  };$skip(49); 

  for (i <- 0 to 10) {
    println(fib2(i))
  };$skip(49); 

  for (i <- 0 to 10) {
    println(fib1(i))
  };$skip(97); 

  def recAdd(n: Int, m: Int): Int = {
    if (m == 0) n
    else recAdd(inc(n), dec(m))
  };System.out.println("""recAdd: (n: Int, m: Int)Int""");$skip(16); val res$0 = 

  recAdd(3, 3);System.out.println("""res0: Int = """ + $show(res$0));$skip(225); 

  def recMul(n: Int, m: Int): Int = {
    def mulHelper(n: Int, m: Int, res: Int): Int = {
      if (n == 0 || m == 0) 0
      if (m == 1) res
      else mulHelper(n, dec(m), recAdd(res, n))
    }
    mulHelper(n, m, n)
  };System.out.println("""recMul: (n: Int, m: Int)Int""");$skip(17); val res$1 = 

  recMul(10, 2);System.out.println("""res1: Int = """ + $show(res$1));$skip(166); 

  def recExp(n: Int): Int = {
  	def expHelper(n: Int, res: Int): Int = {
  		if (n == 0) res
  		else expHelper(dec(n), recMul(2, res))
  	}
  	expHelper(n, 1)
  };System.out.println("""recExp: (n: Int)Int""");$skip(13); val res$2 = 

  recExp(4);System.out.println("""res2: Int = """ + $show(res$2));$skip(178); 

  def hyperExp(m: Int): Int = {
    def hyperHelper(m: Int, res: Int): Int = {
      if (m == 0) res
      else hyperHelper(dec(m), recExp(res))
    }
    hyperHelper(m, 1)
  };System.out.println("""hyperExp: (m: Int)Int""");$skip(17); val res$3 = 
  
  hyperExp(4);System.out.println("""res3: Int = """ + $show(res$3));$skip(121); 


  def choose(n: Int, m: Int): Int = {
    if (m == 0 || m == n) 1
    else choose(n - 1, m - 1) + choose(n - 1, m)
  };System.out.println("""choose: (n: Int, m: Int)Int""");$skip(16); val res$4 = 

  choose(6, 2);System.out.println("""res4: Int = """ + $show(res$4));$skip(728); 
  
  def repl(): Unit = {
    try {
      println("Enter: number operator number")
      val in = readLine().split("\\s+")
      if (in(0).equals("quit")) {
        println("bye")
        System.exit(1)
      } else if (in.length != 3) throw new Exception("wrong syntax: number operator number")
      else {2
        var op1 = in(0).toDouble
        var op2 = in(2).toDouble
        if (in(1).equals("+")) println(op1 + op2)
        else if (in(1).equals("-")) println(op1 - op2)
        else if (in(1).equals("*")) println(op1 * op2)
        else if (in(1).equals("/")) println(op1 / op2)
        else throw new Exception("unrecognized operator" + in(1))
      }
    } catch { case e: Exception => println(e) }
    repl()
  };System.out.println("""repl: ()Unit""");$skip(53); 
  
  def main(args:Array[String]): Unit = { repl() };System.out.println("""main: (args: Array[String])Unit""")}

}
