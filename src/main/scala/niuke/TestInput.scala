package niuke

import java.util.Scanner

object TestInput {
  def main(args: Array[String]): Unit = {
    var scanner = new Scanner(System.in)
    val a = scanner.nextInt
    println(a)
    println("Hello, world")
  }


  def regexParse(src: String): Unit = {
    val p = "[0-9]+".r

    val numbers = p.findAllIn(src).toList // List(2, 12, 21, 23)
    println(numbers)

    //    p.findFirstMatchIn("abc123xyz").get // scala.util.matching.Regex.Match = 123


  }
}
