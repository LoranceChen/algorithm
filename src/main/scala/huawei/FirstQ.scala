package huawei

import scala.io._
import java.io._
import scala.collection.JavaConversions._

object FirstQ {
  def main(args :Array[String]): Unit= {
    val outCapture = new ByteArrayOutputStream
    val stdout = System.out
    try {
      val line = StdIn.readLine()
      val words = line.split(" ").toList
      val reversedWords = words.map(item => item.toLowerCase().reverse)
      var count = 0
      reversedWords.foreach(item => {
        val hasNonAbc = item.exists(char => {
          !char.isLetter
        })
        if (hasNonAbc) false // 排除非字母word
        else {
          count += calcCount(item, 0)

        }
      })

      println(count)


    } catch {
      case e: Exception => {
        System.setOut(stdout)
        e.printStackTrace
      }
    }
  }

  private def calcCount(raw: String, rst: Int): Int = {
    if(raw.length < 4) rst
    else if(raw.length == 4) four4IsOk(raw) + rst
    else {
      four4IsOk(raw.take(4)) +
        calcCount(raw.tail, rst)
    }
  }

  private def four4IsOk(item: String) : Int = {
    if (item.length == 4 &&
      item(0) != 'r' &&
      item(2) != 'r' &&
      item(3) == 'e' &&
      List('a', 'e', 'i', 'o', 'u').contains(item(1))) {
      1
    } else 0
  }

}
