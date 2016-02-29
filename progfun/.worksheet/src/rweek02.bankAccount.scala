package rweek02

object bankAccount {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
  println("Welcome to the Scala worksheet");$skip(29); 
  val acct = new BankAccount;System.out.println("""acct  : rweek02.BankAccount = """ + $show(acct ));$skip(18); 
  acct deposit 50;$skip(19); val res$0 = 
  acct withdraw 20;System.out.println("""res0: Int = """ + $show(res$0));$skip(28); 
	
	val a = new BankAccountP;System.out.println("""a  : rweek02.BankAccountP = """ + $show(a ));$skip(26); 
	val b = new BankAccountP;System.out.println("""b  : rweek02.BankAccountP = """ + $show(b ));$skip(37); 
	val c = new Consolidator(List(a,b));System.out.println("""c  : rweek02.Consolidator = """ + $show(c ));$skip(16); val res$1 = 
	c.totalBalance;System.out.println("""res1: Int = """ + $show(res$1));$skip(14); 
	a deposit 20;$skip(16); val res$2 = 
	c.totalBalance;System.out.println("""res2: Int = """ + $show(res$2));$skip(14); 
	b deposit 30;$skip(16); val res$3 = 
	c.totalBalance;System.out.println("""res3: Int = """ + $show(res$3))}
}
