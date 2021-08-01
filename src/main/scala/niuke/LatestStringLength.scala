package niuke

import scala.io.StdIn

object LatestStringLength {
  /**
    * 输入描述：
    * 输入一行，代表要计算的字符串，非空，长度小于5000。
    *
    * 输出描述：
    * 输出一个整数，表示输入字符串最后一个单词的长度。
    */
  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine()
    val rst = findStrCount(line, Nil)
    println(rst)
  }


  def findStrCount(src: String, cur: List[Char]): Int = {
    if(src.isEmpty()) {
      cur.length
    } else {
      val first = src.head
      if(first == ' ') {
        findStrCount(src.tail, Nil)
      } else {
        findStrCount(src.tail, cur :+ first)
      }
    }
  }

}
