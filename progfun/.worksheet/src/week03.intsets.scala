package week03

object intsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(44); val res$0 = 
 	new Empty;System.out.println("""res0: week03.Empty = """ + $show(res$0));$skip(49); 
 	val t1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""t1  : week03.NonEmpty = """ + $show(t1 ));$skip(21); 
 	val t2 = t1 incl 4;System.out.println("""t2  : week03.IntSet = """ + $show(t2 ))}
}

abstract class IntSet {
  //have no definitions 'cause is abstract
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet) : IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other:IntSet): IntSet = other
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  
  def union (other:IntSet): IntSet =
  	( (left union right) union other ) incl elem
  
  override def toString = "{" + left + elem + right + "}"
}
