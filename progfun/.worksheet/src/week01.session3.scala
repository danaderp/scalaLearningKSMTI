package week01

object session3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(234); 
  //sum is a function that returns another function
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(29); 

  def sumInts = sum(x => x);System.out.println("""sumInts: => (Int, Int) => Int""");$skip(37); 
  def sumCubes = sum(x => x * x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(193); 
  //def sumFactorials = sum(fact)

  //Writting products
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 //offset just multiply by one
    else f(a) * product(f)(a + 1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(29); val res$0 = 

  product(x => x * x)(3, 7);System.out.println("""res0: Int = """ + $show(res$0));$skip(43); 
	
	def fact(n: Int) = product(x => x)(1,n);System.out.println("""fact: (n: Int)Int""");$skip(9); val res$1 = 
	fact(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(205); 
	
	//Generalized sum and product
	def mapReduce(f: Int => Int, combine:(Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
		if(a > b) zero
		else combine( f(a), mapReduce(f, combine, zero)( a + 1 , b) );System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(95); 
	
	def productMap (f: Int => Int)(a: Int, b: Int): Int = mapReduce( f, (x,y) => (x*y), 1)(a,b);System.out.println("""productMap: (f: Int => Int)(a: Int, b: Int)Int""");$skip(25); val res$2 = 
	productMap(x=>x*x)(3,7);System.out.println("""res2: Int = """ + $show(res$2))}
}
