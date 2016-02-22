package rweek02

class BankAccountP extends Publisher {
  private var balance = 0
  //It is not declared public because anyone can read it and write it
  def currentBalance = balance
  
  def deposit(amount: Int):Unit = 
    if(amount > 0){ 
      balance = balance + amount
      publish()
    }
  def withdraw(amount: Int): Int = 
    if(0 < amount && amount <= balance){
      balance = balance - amount
      publish()
      balance
    } else throw new Error("insufficient funds")
}

class Consolidator(observed: List[BankAccountP]) extends Subscriber{
  observed.foreach(_.subscribe(this))
  private var total: Int = _
  compute()
  
  private def compute() =
    total = observed.map(_.currentBalance).sum
    
  def handler(pub: Publisher)=compute()
  
  def totalBalance = total

}