package week01

object session3 {
  //sum is a function that returns another function
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int

  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  def sumCubes = sum(x => x * x * x)              //> sumCubes: => (Int, Int) => Int
  //def sumFactorials = sum(fact)

  //Writting products
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 //offset just multiply by one
    else f(a) * product(f)(a + 1, b)              //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(3, 7)                       //> res0: Int = 6350400
	
	def fact(n: Int) = product(x => x)(1,n)   //> fact: (n: Int)Int
	fact(5)                                   //> res1: Int = 120
	
	//Generalized sum and product
	def mapReduce(f: Int => Int, combine:(Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
		if(a > b) zero
		else combine( f(a), mapReduce(f, combine, zero)( a + 1 , b) )
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
	
	def productMap (f: Int => Int)(a: Int, b: Int): Int = mapReduce( f, (x,y) => (x*y), 1)(a,b)
                                                  //> productMap: (f: Int => Int)(a: Int, b: Int)Int
	productMap(x=>x*x)(3,7)                   //> res2: Int = 6350400
}