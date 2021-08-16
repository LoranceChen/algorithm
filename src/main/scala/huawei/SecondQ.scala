package huawei

import java.io._

import scala.io._

object SecondQ {
  def main(args :Array[String]): Unit= {
    val outCapture = new ByteArrayOutputStream
    val stdout = System.out
    try {
      val (member, letter) = StdIn.readf2("{0} {1}")
      val memberCount = member.toString.toLong
      val letterCount = letter.toString.toLong
      val rst0 = Math.log10(memberCount / Math.pow(26, letterCount))
      val rst = Math.ceil(rst0)
      println(if(rst.toInt == 0) 1 else rst.toInt)

    } catch {
      case e: Exception => {
        System.setOut(stdout)
        e.printStackTrace
      }
    }
  }


}
