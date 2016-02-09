package week03

object nth {
  def nth[T](n:Int, xs: List[T]):T =
  	if (xs.isEmpty ) throw new IndexOutOfBoundsException
  	else if(n == 0) xs.head
  	else nth(n-1, xs.tail)                    //> nth: [T](n: Int, xs: week03.List[T])T
  	
  	val list = new Cons(1, new Cons (2, new Cons (3, new Nil)))
                                                  //> list  : week03.Cons[Int] = week03.Cons@6e8dacdf
  	nth(2, list)                              //> res0: Int = 3
  	nth(0, list)                              //> res1: Int = 1
  	nth(4, list)                              //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week03.nth$$anonfun$main$1.nth$1(week03.nth.scala:5)
                                                  //| 	at week03.nth$$anonfun$main$1.apply$mcV$sp(week03.nth.scala:12)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week03.nth$.main(week03.nth.scala:3)
                                                  //| 	at week03.nth.main(week03.nth.scala)
}