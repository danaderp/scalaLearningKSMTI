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
}

class Rational(x: Int, y: Int){
	//Grater Common Denominator definiton
	private def gcd(a:Int, b:Int):Int = if(b==0) a else gcd(b,a%b)
	private val g = gcd(x,y)
	//def numer = x/g
	//def denom = y/g
	val numer = x / gcd(x,y)
	val denom = y / gcd(x,y)
	
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