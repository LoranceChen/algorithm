package codinginterviews

/**
  * 有1，2，5元三种面值的硬币，现在需要找零15元，请问有几种找零的方式？
  */
object FindCoinCount extends App {
  /**
    * change 3:
    * 1,1,1
    * 1,2
    * 2,1
    * @param change
    * @return
    */
  def countWithSeq(change: Int): Int = {
    change match {
      case x if x < 0 =>
        0
      case x if x == 0 =>
        1
      case x if x < 2 =>
        countWithSeq(change - 1) //回溯
      case x if x < 5 =>
        countWithSeq(change - 1) + countWithSeq(change - 2) //回溯
      case x if x >= 5 =>
        countWithSeq(change - 1) + countWithSeq(change - 2) + countWithSeq(change - 5) //回溯
    }
  }

  assert(countWithSeq(1) == 1)
  assert(countWithSeq(2) == 2)
  assert(countWithSeq(3) == 3)
  assert(countWithSeq(5) == 9)

}

object AA extends App {
  /**
    * 有1，2，5元三种面值的硬币，现在需要找零15元，请问有几种找零的方式？
    * example:
    * change 3:
    * 2,1
    * 1,1,1
    *
    * @return 2
    */
  def countNoSeq(change: Int,
                 max: Int = 5 //动态规划
                ): Int = {
    if(change < 0) return 0 //不匹配
    if(change == 0) return 1 //匹配
    if(change >= 5 && max == 5) {
      //回溯
      countNoSeq(change - 5, 5)
      + countNoSeq(change - 2, 2)
      + countNoSeq(change - 1, 1)
    } else if(2 <= change && change < 5 && max == 2) {
      countNoSeq(change - 2, 2) + countNoSeq(change - 1, 1)
    } else { //if(change == 1 && max == 2) {
      countNoSeq(change - 1, 1)
    }

  }

  println(countNoSeq(3, 2))

}