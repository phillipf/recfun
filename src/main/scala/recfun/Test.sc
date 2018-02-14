
var string = "(if (zero? x) max (/ 1 x))"
var string2 = "())("
var chars2 = string2.toList

var chars = List('(',')')

chars.head == '('
chars.tail.head == ')'
/*chars.tail.tail.head
chars.tail.tail.tail.head
chars.tail.tail.tail.tail.head
chars.tail.tail.tail.tail.tail.head*/

chars.length
chars2.length

/*def step(current: Char, counter: Int): Int = current match {
  case x if x == '(' => counter + 1
  case x if x == ')' => counter - 1
  case _ => counter
}*/

def step(current: Char): Int = current match {
  case x if x == '(' => 1
  case x if x == ')' => -1
  case _ => 0
}

chars2.tail
chars2.tail.head
chars2.tail.tail.head

/*step(chars2.head)
step(chars2.tail.head)
step(chars2.tail.tail.head)*/

/*def balance(chars: List[Char], counter: Int, n:Int): Int = {

  if(n == 0) counter
  else if(counter == 0 && chars.head == ')') -1
  //if(n ==  & chars.head == '(') -1
  else balance(chars.tail, step(chars.head) + counter, n - 1)

}*/

def balance(chars: List[Char], counter: Int): Int = chars match {

  case Nil => counter
  case x if x.head == ')' && counter == 0 => -1
  case x::xtail => balance(xtail, counter + step(x))

}

balance(chars, 0)

balance(chars2, 0)