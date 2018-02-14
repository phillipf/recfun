package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println(balance(test1) == true,
            balance(test2) == true,
            balance(test3) == false,
            balance(test4) == false)
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = c match {
        case 0 => 1
        case x if x == r => 1
        case _ => pascal(c, r - 1) + pascal(c - 1, r - 1)
      }
  
  /**
   * Exercise 2
   */

    val test1 = "(if (zero? x) max (/ 1 x))".toList
    val test2 = "I told him (that it’s not (yet) done). (But he wasn’t listening)".toList
    val test3 = ":-)".toList
    val test4 = "())(".toList

    def balance(chars: List[Char]): Boolean = {

      def step(current: Char): Int = current match {
        case x if x == '(' => 1
        case x if x == ')' => -1
        case _ => 0
      }

      @tailrec
      def iter(chars: List[Char], counter: Int): Boolean = chars match {

        case Nil => counter == 0
        case x if x.head == ')' && counter == 0 => false
        case x::xtail => iter(xtail, counter + step(x))

      }

      iter(chars, 0)

    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
