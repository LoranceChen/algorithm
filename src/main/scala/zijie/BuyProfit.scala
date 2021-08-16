package zijie

/**
  * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
  * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
  */
object BuyProfit {
  def main(args: Array[String]): Unit = {
//    val rst = maxProfit(Array(1,4,2,7,1,9))
    val rst = maxProfit(Array(2,1,4))
//    val rst = maxProfit(Array(2,1))
    println(rst)
  }

  /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    *
    * @param prices int整型一维数组
    * @return int整型
    */
  def maxProfit(prices: Array[Int]): Int = {
    if(prices.length == 1) return 0
    // write code here
    // maxProfitHelper(prices.toList, 0, -1, -1, 0)
    val rstData = maxProfitHelper(prices.toList, 0, 0, 0 , Nil)
    rstData.map(_.profit).getOrElse(0)

  }

  case class RstData(minDay: Int, minCount: Int, profit: Int)

  def maxProfitHelper(prices: List[Int],
                      curDay: Int,
                      formerMinCount: Int,
                      formerMinDay: Int,
                      rst: List[RstData]): Option[RstData] = {
    if(curDay == 0) {
      return maxProfitHelper(prices.tail, curDay + 1, prices.head, curDay + 1, Nil)
    }
    if(prices.isEmpty) {
      rst.sortBy( - _.profit).headOption
    } else {
      if(prices.head > formerMinCount) { // 当前值比最小的大
        if(prices.head < formerMinCount) {
          maxProfitHelper(prices.tail,
            curDay + 1,
            prices.head,
            curDay,
            rst :+ RstData(curDay, prices.head, prices.head - formerMinCount)
          )
        } else {
          maxProfitHelper(prices.tail,
            curDay + 1,
            formerMinCount,
            formerMinDay,
            rst :+ RstData(curDay, prices.head, prices.head - formerMinCount)
          )
        }

      } else { // 当前值比最小的小
        maxProfitHelper(prices.tail,
          curDay + 1,
          prices.head,
          formerMinDay,
          rst
        )
      }

    }
  }
}
