package niuke
import scala.io._

object CharCount {

  def main(args: Array[String]): Unit = {
    val src = StdIn.readLine()
    val aim = StdIn.readLine()

    calc(src.toLowerCase, aim.toLowerCase()(0), 0)
  }

  def calc(src: String, aim: Char, count: Int): Int = {
    if(src.isEmpty) {
      count
    } else {
      val first = src.head
      if(first == aim) {
        calc(src.tail, aim, count + 1)
      } else {
        calc(src.tail, aim, count)
      }
    }
  }


}
