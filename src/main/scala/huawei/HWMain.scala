package huawei

import scala.io.StdIn

/**
  * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
  *
  * 输出描述:
  * 输出a+b的结果
  *
  * 输入例子1:
  * 1 5
  * 10 20
  *
  * 输出例子1:
  * 6
  * 30
  */
object HWMain extends App {
  var first: Long = _
  var seconds: Long = _
  while({
    val string = StdIn.readLine()
    if(string != null && string.nonEmpty) {
      val rst = string.split(' ')
      first = rst(0).toString.toLong
      seconds = rst(1).toString.toLong
      true
    } else {
      false
    }
  }) {
    println(first + seconds)
  }

}