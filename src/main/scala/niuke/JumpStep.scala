package niuke

object JumpStep {
  /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    *
    * @param number int整型
    * @return int整型
    */
  def jumpFloor(number: Int): Int = {
    // write code here
    jumpFloorHelper(number)
  }

  def jumpFloorHelper(number: Int): Int = {
    if(number == 0) 0
    else if(number == 1) 1
    else if(number == 2) 2
    // write code here
    else jumpFloorHelper(number - 1) + jumpFloorHelper(number - 2)
  }
}