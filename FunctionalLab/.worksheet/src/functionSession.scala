object functionSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  println("Welcome to the Scala worksheet");$skip(96); 

  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    def r(x: A) = f(g(x))
    r _
  };System.out.println("""compose: [A, B, C](f: B => C, g: A => B)A => C""");$skip(30); 

  def square(x: Int) = x * x;System.out.println("""square: (x: Int)Int""");$skip(33); 

  def len(s: String) = s.length;System.out.println("""len: (s: String)Int""");$skip(34); 

  def h = compose(square, len _);System.out.println("""h: => String => Int""");$skip(32); 
  
  def inc(x: Double) = x + 1;System.out.println("""inc: (x: Double)Double""");$skip(32); 
  def double(x: Double) = 2 * x;System.out.println("""double: (x: Double)Double""");$skip(17); val res$0 = 

  h("12345678");System.out.println("""res0: Int = """ + $show(res$0));$skip(49); 

  def selfCompose[A](f: A => A) = compose(f, f);System.out.println("""selfCompose: [A](f: A => A)A => A""");$skip(33); 
  val g = selfCompose(Math.sqrt);System.out.println("""g  : Double => Double = """ + $show(g ));$skip(10); val res$1 = 
  g(81.0);System.out.println("""res1: Double = """ + $show(res$1));$skip(155); 
  
  def selfIter[T](f: T=>T, n: Int): T=>T = {
  	def id(x: T) = x;
  	if (n == 0) id _
  	else {
  		def x = selfIter(f, n-1)
  		compose(f, x)
  	}
  };System.out.println("""selfIter: [T](f: T => T, n: Int)T => T""");$skip(91); 
  
  def add(n: Int, m: Int) = {
  	def add_m  = selfIter(inc, m)
  	add_m(n) // n + m
  };System.out.println("""add: (n: Int, m: Int)Double""");$skip(136); 
  
  def countPass[T] (f: T => Boolean, arr: Array[T]) = {
  	var count = 0
  	for (x <- arr) {
  		if(f(x)) count+=1
  	}
  	count
  };System.out.println("""countPass: [T](f: T => Boolean, arr: Array[T])Int""");$skip(75); 
  
  val isBool = (x: Any) => if (x.isInstanceOf[Boolean]) true else false;System.out.println("""isBool  : Any => Boolean = """ + $show(isBool ));$skip(48); 
  val testArr = Array("1", 1, true, false, 234);System.out.println("""testArr  : Array[Any] = """ + $show(testArr ));$skip(80); val res$2 = 
                                                  
  countPass(isBool, testArr);System.out.println("""res2: Int = """ + $show(res$2));$skip(254); 
  
  //////////////////////
  
  // 5. Control Loop
  def controlLoop[S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S): S = {
  	if (halt(state, cycle)) state
  	else controlLoop(update(state, cycle), cycle+1, halt, update)
  };System.out.println("""controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S)S""");$skip(173); 
  
  // 6
  def population(): Int = {
  	def halt(pop: Int, cycle: Int) = pop >= 100000
  	def update(pop: Int, cycle: Int) = 2 * pop
  	controlLoop(1, 0, halt, update)
  };System.out.println("""population: ()Int""");$skip(272); 
  
  // 7
  // improve guess uses newton's method
  // solve(f) = r where |f(r)| < 10^-5
  def solve(f: Double => Double) = {
  	def halt(num: Int, cycle: Int) = math.abs(f(num)) <= .00010
  	def update(num: Int, cycle: Int) = num+1
  	controlLoop(1, 0, halt, update)
  };System.out.println("""solve: (f: Double => Double)Int""");$skip(84); 
  
  // 8
  def sqrt(a: Double) = {
  	def f(x: Double) = x * x - a
  	solve(f)
  };System.out.println("""sqrt: (a: Double)Int""");$skip(14); val res$3 = 
  
  sqrt(16);System.out.println("""res3: Int = """ + $show(res$3));$skip(90); 
  
  // 9
  def cubeRt(a: Double) = {
  	def f(x: Double) = x * x * x - a
  	solve(f)
  };System.out.println("""cubeRt: (a: Double)Int""");$skip(12); val res$4 = 
  cubeRt(8);System.out.println("""res4: Int = """ + $show(res$4));$skip(105); 
  
  // 10
  def nthRoot(a: Double, n: Int) = {
  	def f(x: Double) = math.pow(x, n) - a
  	solve(f)
  };System.out.println("""nthRoot: (a: Double, n: Int)Int""");$skip(20); val res$5 = 
  
  nthRoot(27, 3);System.out.println("""res5: Int = """ + $show(res$5))}
}
