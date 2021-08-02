package niuke

import java.util.Scanner

import scala.io.StdIn

object Test {
  def main(args: Array[String]): Unit = {
    // java scanner
//    var scanner = new Scanner(System.in)
//    val a = scanner.nextInt
//    println(a)
//
//    // scala input
//    val b = StdIn.readChar()
//    println(b)
//
//    val c = StdIn.readDouble()
//    println(c)

//    val d = StdIn.readf("{0},{1}")
//    println(d)

    val line = StdIn.readLine()
//    val regex = "(\\d,\\d,)*\\d".r
//
//    val rst = regex.findAllMatchIn(line)
//    for (elem <- rst.toList) {
//      elem.
//    }
//    println(day)

    regexParse(line)
  }

  def regexParse(src: String): Unit = {
    val p = "[0-9]+".r

    val numbers = p.findAllIn(src).toList // List(2, 12, 21, 23)
    println(numbers)

//    p.findFirstMatchIn("abc123xyz").get // scala.util.matching.Regex.Match = 123


  }
}
