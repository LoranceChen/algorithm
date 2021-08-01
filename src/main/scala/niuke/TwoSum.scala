package niuke

object TwoSum {

  /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    *
    * @param numbers int整型一维数组
    * @param target int整型
    * @return int整型一维数组
    */
  def twoSum(numbers: Array[Int],target: Int): Array[Int] = {
    // write code here
    val appendNo = (1 to numbers.size).map(n => (n, numbers(n - 1)))
    val sorted = appendNo.sortWith((a, b) => a._2 < b._2).toArray
    val (a, b) = find(sorted, 0, sorted.size - 1, target)
    Array(sorted(a)._1, sorted(b)._1).sorted.toArray
  }

  def find(array: Array[(Int, Int)], left: Int, right: Int, target: Int): (Int, Int) = {
    if(array(left)._2 + array(right)._2 == target) {
      (left, right)
    } else if(array(left)._2 + array(right)._2 > target){
      find(array, left, right - 1, target)
    } else {//if(array(left) + array(right) < target) {
      find(array, left + 1, right, target)
    }
  }
}