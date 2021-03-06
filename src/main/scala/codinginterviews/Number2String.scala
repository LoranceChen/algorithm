package codinginterviews

/**
  给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成“a”，1翻译成“b”，……，11翻译成“l”，
  ……，25翻译成“z”。一个数字可能有多个翻译。例如，12258有5种翻译，分别是“bccfi”、“bwfi”、
  “bczi”、“mcfi”和“mzi”。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
  */
object Number2String extends App {

  /**
    * todo: print every case
    * every src Int item is [0, 9]
    */
  def count(src: Seq[Int]): Int = {
    src match {
      case Nil =>
        0
      case _ :: Nil =>
        1
      case first :: (group @ second :: other) =>
        val one = {
          1 * count(group)
        }

        val two = if (first * 10 + second <= 25) {
          1 * {
            other match {
              case Nil =>
                1
              case _ =>
                count(other)
            }
          }
        } else {
          0
        }

        one + two
    }
  }

  assert(count(List(1,2,2,5,8)) == 5)
  assert(count(List(1)) == 1)
  assert(count(List(1,2)) == 2)
  assert(count(List(1,2,9)) == 2)
  assert(count(List(1,2,3)) == 3)
  assert(count(List()) == 0)

}
