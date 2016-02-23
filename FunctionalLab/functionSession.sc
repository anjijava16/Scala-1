object functionSession {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    def r(x: A) = f(g(x))
    r _
  }                                               //> compose: [A, B, C](f: B => C, g: A => B)A => C

  def square(x: Int) = x * x                      //> square: (x: Int)Int

  def len(s: String) = s.length                   //> len: (s: String)Int

  def h = compose(square, len _)                  //> h: => String => Int
  
  def inc(x: Double) = x + 1                      //> inc: (x: Double)Double
  def double(x: Double) = 2 * x                   //> double: (x: Double)Double

  h("12345678")                                   //> res0: Int = 64

  def selfCompose[A](f: A => A) = compose(f, f)   //> selfCompose: [A](f: A => A)A => A
  val g = selfCompose(Math.sqrt)                  //> g  : Double => Double = <function1>
  g(81.0)                                         //> res1: Double = 3.0
  
  def selfIter[T](f: T=>T, n: Int): T=>T = {
  	def id(x: T) = x;
  	if (n == 0) id _
  	else {
  		def x = selfIter(f, n-1)
  		compose(f, x)
  	}
  }                                               //> selfIter: [T](f: T => T, n: Int)T => T
  
  def add(n: Int, m: Int) = {
  	def add_m  = selfIter(inc, m)
  	add_m(n) // n + m
  }                                               //> add: (n: Int, m: Int)Double
  
  def countPass[T] (f: T => Boolean, arr: Array[T]) = {
  	var count = 0
  	for (x <- arr) {
  		if(f(x)) count+=1
  	}
  	count
  }                                               //> countPass: [T](f: T => Boolean, arr: Array[T])Int
  
  val isBool = (x: Any) => if (x.isInstanceOf[Boolean]) true else false
                                                  //> isBool  : Any => Boolean = <function1>
  val testArr = Array("1", 1, true, false, 234)   //> testArr  : Array[Any] = Array(1, 1, true, false, 234)
                                                  
  countPass(isBool, testArr)                      //> res2: Int = 2
  
  //////////////////////
  
  // 5. Control Loop
  def controlLoop[S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S): S = {
  	if (halt(state, cycle)) state
  	else controlLoop(update(state, cycle), cycle+1, halt, update)
  }                                               //> controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (
                                                  //| S, Int) => S)S
  
  // 6
  def population(): Int = {
  	def halt(pop: Int, cycle: Int) = pop >= 100000
  	def update(pop: Int, cycle: Int) = 2 * pop
  	controlLoop(1, 0, halt, update)
  }                                               //> population: ()Int
  
  // 7
  // improve guess uses newton's method
  // solve(f) = r where |f(r)| < 10^-5
  def solve(f: Double => Double) = {
  	def halt(num: Int, cycle: Int) = math.abs(f(num)) <= .00010
  	def update(num: Int, cycle: Int) = num+1
  	controlLoop(1, 0, halt, update)
  }                                               //> solve: (f: Double => Double)Int
  
  // 8
  def sqrt(a: Double) = {
  	def f(x: Double) = x * x - a
  	solve(f)
  }                                               //> sqrt: (a: Double)Int
  
  sqrt(16)                                        //> res3: Int = 4
  
  // 9
  def cubeRt(a: Double) = {
  	def f(x: Double) = x * x * x - a
  	solve(f)
  }                                               //> cubeRt: (a: Double)Int
  cubeRt(8)                                       //> res4: Int = 2
  
  // 10
  def nthRoot(a: Double, n: Int) = {
  	def f(x: Double) = math.pow(x, n) - a
  	solve(f)
  }                                               //> nthRoot: (a: Double, n: Int)Int
  
  nthRoot(27, 3)                                  //> res5: Int = 3
}