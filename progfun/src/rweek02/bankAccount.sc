package rweek02

object bankAccount {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val acct = new BankAccount                      //> acct  : rweek02.BankAccount = rweek02.BankAccount@6e8dacdf
  acct deposit 50
  acct withdraw 20                                //> res0: Int = 30
	
	val a = new BankAccountP                  //> a  : rweek02.BankAccountP = rweek02.BankAccountP@6fadae5d
	val b = new BankAccountP                  //> b  : rweek02.BankAccountP = rweek02.BankAccountP@17f6480
	val c = new Consolidator(List(a,b))       //> c  : rweek02.Consolidator = rweek02.Consolidator@614c5515
	c.totalBalance                            //> res1: Int = 0
	a deposit 20
	c.totalBalance                            //> res2: Int = 20
	b deposit 30
	c.totalBalance                            //> res3: Int = 50
}