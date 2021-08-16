package baidu

import scala.collection.mutable._

object TongHuaShun {

  def main(args: Array[String]): Unit = {
    // test
    assert(tonghuashui("AAABA3A4A5"))
    assert(!tonghuashui("AAABA3A4A4A5"))

//    assert(tonghuashui(""))
//    assert(!tonghuashui("A1A2A3A4A5"))
  }

  def tonghuashui(src: String): Boolean = {
    if(src.length < 5) return false

    val listData = new ArrayBuffer[(Char, Int)]
    var color: Char = '1'
    (1 to src.length) foreach( idx => {
      if(idx % 2 == 0) { // 偶数（数字）
        listData.+=((color, getCardCount(src(idx - 1))))
      } else {
        color = src(idx - 1)
      }
    })

    thsHelper(listData.toList, Nil)
  }

  /**
    *
    * @param data list item: key - 花色（A/B/C/D), value - 1-13 哪一张牌
    * @param rst 当前积累的同花顺
    * @return 是否包含
    */
  def thsHelper(data: List[(Char, Int)], rst: List[(Char, Int)]): Boolean = {
    // 边界
    if(rst.size >= 5) true
    else if(data.isEmpty) {
      if(rst.size >= 5) true
      else false
    } else {// 逻辑
      if(rst.isEmpty) {
        thsHelper(data.tail, data.head :: Nil)
      } else if(data.head._1 == rst.last._1 && rst.last._2 + 1 == data.head._2) {
        thsHelper(data.tail, rst :+ data.head)
      } else {
        thsHelper(data.tail, data.head :: Nil)
      }
    }
  }

  private def getCardCount(card: Char): Int = {
    // A -> 1, K -> 13
    card match {
      case 'A' => 1
      case 'B' => 2
      case '3' => 3
      case '4' => 4
      case '5' => 5
      case '6' => 6
      case '7' => 7
      case '8' => 8
      case '9' => 9
      case '0' => 10 // todo
      case 'J' => 11
      case 'Q' => 12
      case 'K' => 13

    }
  }


}
