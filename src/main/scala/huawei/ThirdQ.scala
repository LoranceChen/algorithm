package huawei

import java.io._
import scala.io._

object ThirdQ {
  def main(args :Array[String]): Unit= {
    val outCapture = new ByteArrayOutputStream
    val stdout = System.out
    try {
      val letterLimit = StdIn.readInt()
      val src = StdIn.readLine()

      val length = src.length
      if(src == null || src.length == 1) println("NO")
      else {
        val rst = nonHuiwenHelper(src, letterLimit, 0)
        println(rst)
      }


    } catch {
      case e: Exception => {
        System.setOut(stdout)
        e.printStackTrace
      }
    }
  }

  // 计算一个字符串是否包含回文
  def calcHasHuiwen(src: String): Boolean = {
    if(src.length == 1) false
    else if(src == src.reverse) {
      true
    } else {
      val init = calcHasHuiwen(src.init)
      val tail = calcHasHuiwen(src.tail)
      init || tail
    }
  }

  /**
    *
    * @param src
    * @param letterLimit
    * @param curLastIndex
    * @return boolean true: calc complete 当前的curLastIndex是否匹配完成
    */
  // 计算下一个非回文
  def nextString(src: String,
                 letterLimit: Int,
                 curLastIndex: Int = 0// 倒数第几个
                  ): (String, Boolean) = {
    // 计算下一个字符串
    if(curLastIndex == 0) {
      val lastChar = 'a'.toInt + letterLimit - 1
      if(src.last.toInt < lastChar) {
        (src.init :+ (src.last.toInt + 1).toChar, false)
      } else {
        ("", true)
      }
    } else {
      ("", true)
    }
  }

  def nonHuiwenHelper(src: String, letterLimit: Int, curLastIndex: Int): String = {
    if(curLastIndex + 1 > src.length) "NO"
    else {
      nextString(src, letterLimit) match {
        case (newStr, false) =>
          if(!calcHasHuiwen(newStr))
            newStr
          else
            nonHuiwenHelper(newStr, letterLimit, curLastIndex)
        case (_, true) =>
          if(curLastIndex == src.length - 1) {"NO"}
          else {
            val (init, tail) = src.splitAt(src.length - curLastIndex)
            if(init.last.toInt + 1 > letterLimit.toInt) nonHuiwenHelper(src, letterLimit, curLastIndex + 1)
            else nonHuiwenHelper((init :+ (init.last.toInt + 1).toChar) + tail, letterLimit, curLastIndex)
          }


      }
    }

  }




}
