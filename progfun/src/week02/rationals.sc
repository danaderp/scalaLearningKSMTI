package week02

object rationals {
  val x = new Rational(1,3)                       //> x  : week02.Rational = 1/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  
  val y = new Rational(5,7)                       //> y  : week02.Rational = 5/7
  x.add(y)                                        //> res2: week02.Rational = 22/21
  x.sub(y)                                        //> res3: week02.Rational = 8/-21
  x.subElegant(y)                                 //> res4: week02.Rational = 8/-21
  x.neg                                           //> res5: week02.Rational = 1/-3
	val z = new Rational(3,2)                 //> z  : week02.Rational = 3/2
	x.sub(y).sub(z)                           //> res6: week02.Rational = -79/42
	y.sub(y)                                  //> res7: week02.Rational = 0/1
	x.less(y)                                 //> res8: Boolean = true
	x.max(y)                                  //> res9: Boolean = false
	x.maxElegant(y)                           //> res10: week02.Rational = 5/7
	val strange = new Rational(1,0)           //> java.lang.IllegalArgumentException: requirement failed: denominator ough to 
                                                  //| be nonzero
                                                  //| 	at scala.Predef$.require(Predef.scala:219)
                                                  //| 	at week02.Rational.<init>(week02.rationals.scala:24)
                                                  //| 	at week02.rationals$$anonfun$main$1.apply$mcV$sp(week02.rationals.scala:
                                                  //| 19)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week02.rationals$.main(week02.rationals.scala:3)
                                                  //| 	at week02.rationals.main(week02.rationals.scala)
}

class Rational(x: Int, y: Int){
	//Dealing with exception divison by zero
	require(y != 0, "denominator ough to be nonzero")
	//Grater Common Denominator definiton
	private def gcd(a:Int, b:Int):Int = if(b==0) a else gcd(b,a%b)
	//private val g = gcd(x,y)
	//def numer = x/g
	//def denom = y/g
	val numer = x / gcd(x,y)
	val denom = y / gcd(x,y)
	
	def less(that: Rational) = numer * that.denom < that.numer * denom
	def max(that: Rational) = ! less(that)
	def maxElegant(that: Rational) = if (this.less(that)) that else this
	
	def add(that: Rational) =
		new Rational(
		numer * that.denom + that.numer * denom,
		denom * that.denom)
	
	def neg : Rational = new Rational (-numer , denom)
	
	def sub(that: Rational) =
		new Rational (
		numer * that.denom - that.numer * denom,
		denom * that.denom)
	
	def subElegant(that:Rational) = add(that.neg)
	
	override def toString = numer + "/" + denom
}