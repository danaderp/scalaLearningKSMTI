package week02

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  val x = new Rational(1,3);System.out.println("""x  : week02.Rational = """ + $show(x ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(31); 
  
  val y = new Rational(5,7);System.out.println("""y  : week02.Rational = """ + $show(y ));$skip(11); val res$2 = 
  x.add(y);System.out.println("""res2: week02.Rational = """ + $show(res$2));$skip(11); val res$3 = 
  x.sub(y);System.out.println("""res3: week02.Rational = """ + $show(res$3));$skip(18); val res$4 = 
  x.subElegant(y);System.out.println("""res4: week02.Rational = """ + $show(res$4));$skip(8); val res$5 = 
  x.neg;System.out.println("""res5: week02.Rational = """ + $show(res$5));$skip(27); 
	val z = new Rational(3,2);System.out.println("""z  : week02.Rational = """ + $show(z ));$skip(17); val res$6 = 
	x.sub(y).sub(z);System.out.println("""res6: week02.Rational = """ + $show(res$6));$skip(10); val res$7 = 
	y.sub(y);System.out.println("""res7: week02.Rational = """ + $show(res$7));$skip(11); val res$8 = 
	x.less(y);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(10); val res$9 = 
	x.max(y);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(9); val res$10 = 
	x max y;System.out.println("""res10: Boolean = """ + $show(res$10));$skip(17); val res$11 = 
	x.maxElegant(y);System.out.println("""res11: week02.Rational = """ + $show(res$11));$skip(33); 
	val strange = new Rational(1,0);System.out.println("""strange  : week02.Rational = """ + $show(strange ))}
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
