package neopart2

object neopart2 {
  val xs = 3 :: 6 :: 12 :: Nil
  
  xs match {
  	case List(a,b) => a * b
  	case List(a, b, c) => a + b+ c
  	case _=> 0
  }
  
  val xs2 = 3::6::12::24::Nil
  xs2 match{
  	case List(a,b,_*) =>a * b
  	case _=> 0
  }
  
  def greetWithFirstName(name: String) = name match{
  	case GivenNames(firstName, _*) => "Good Morning,"+ firstName + "!"
  	case _=> "Welcome! Please make sure to fill in your name!"
	}
	
	greetWithFirstName("David Alberto")
}