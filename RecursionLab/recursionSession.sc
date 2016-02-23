object recursionSession {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def inc(n: Int) = n + 1                         //> inc: (n: Int)Int

  def dec(n: Int) = n - 1                         //> dec: (n: Int)Int

  def fib1(n: Int): Int = {
    if (n <= 1) 1
    else fib1(n - 1) + fib1(n - 2)
  }                                               //> fib1: (n: Int)Int

  def fib2(n: Int) = {
    var fib2 = 1
    var fib1 = 1
    for (i <- 1 until n) {
      var temp = fib2 + fib1
      fib1 = fib2
      fib2 = temp
    }
    fib2
  }                                               //> fib2: (n: Int)Int

  def fib3(n: Int) = {
    def helper(i: Int, f1: Int, f2: Int): Int = {
      if (i == n) f2
      else helper(i + 1, f2, f1 + f2)
    }

    helper(0, 1, 1)
  }                                               //> fib3: (n: Int)Int

  for (i <- 0 to 10) {
    println(fib3(i))                              //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 5
                                                  //| 8
                                                  //| 13
                                                  //| 21
                                                  //| 34
                                                  //| 55
                                                  //| 89
                                                  //| 144
  }

  for (i <- 0 to 10) {
    println(fib2(i))                              //> 1
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 5
                                                  //| 8
                                                  //| 13
                                                  //| 21
                                                  //| 34
                                                  //| 55
                                                  //| 89
  }

  for (i <- 0 to 10) {
    println(fib1(i))                              //> 1
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 5
                                                  //| 8
                                                  //| 13
                                                  //| 21
                                                  //| 34
                                                  //| 55
                                                  //| 89
  }

  def recAdd(n: Int, m: Int): Int = {
    if (m == 0) n
    else recAdd(inc(n), dec(m))
  }                                               //> recAdd: (n: Int, m: Int)Int

  recAdd(3, 3)                                    //> res0: Int = 6

  def recMul(n: Int, m: Int): Int = {
    def mulHelper(n: Int, m: Int, res: Int): Int = {
      if (n == 0 || m == 0) 0
      if (m == 1) res
      else mulHelper(n, dec(m), recAdd(res, n))
    }
    mulHelper(n, m, n)
  }                                               //> recMul: (n: Int, m: Int)Int

  recMul(10, 2)                                   //> res1: Int = 20

  def recExp(n: Int): Int = {
  	def expHelper(n: Int, res: Int): Int = {
  		if (n == 0) res
  		else expHelper(dec(n), recMul(2, res))
  	}
  	expHelper(n, 1)
  }                                               //> recExp: (n: Int)Int

  recExp(4)                                       //> res2: Int = 16

  def hyperExp(m: Int): Int = {
    def hyperHelper(m: Int, res: Int): Int = {
      if (m == 0) res
      else hyperHelper(dec(m), recExp(res))
    }
    hyperHelper(m, 1)
  }                                               //> hyperExp: (m: Int)Int
  
  hyperExp(4)                                     //> res3: Int = 65536


  def choose(n: Int, m: Int): Int = {
    if (m == 0 || m == n) 1
    else choose(n - 1, m - 1) + choose(n - 1, m)
  }                                               //> choose: (n: Int, m: Int)Int

  choose(6, 2)                                    //> res4: Int = 15
  
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
  }                                               //> repl: ()Unit
  
  def main(args:Array[String]): Unit = { repl() } //> main: (args: Array[String])Unit

}