package leetcode

/**
  * Given an array of integers nums and an integer target,
  * return indices of the two numbers such that they add up to target.
  *
  * You may assume that each input would have exactly one solution,
  * and you may not use the same element twice.
  *
  * You can return the answer in any order.
  */
object TwoSum {

  def main(args: Array[String]): Unit = {
    val ints = twoSum(Array(0, 1, 2, 4), 3)
    println(ints.toList)
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    // 排序
    var sortedNums = sort(nums)

    // 从小到到选择合适的num，标记为small, large 变量，如果两者之和大于其中target，
    // 则移动small的index+1，否则移动large的index+1.
    var smallIndex = 0
    var largeIndex = 1

    val rst = findTarget(nums, smallIndex, largeIndex, target)

    Array(rst._1, rst._2)

  }

  def sort(nums: Array[Int]): Array[Int] = {
    nums.toList.sorted.toArray
  }

  def findTarget(nums: Array[Int], smallIndex: Int, largeIndex: Int, target: Int): (Int, Int) = {
    if(nums(smallIndex) + nums(largeIndex) == target) {
      return (smallIndex, largeIndex)
    } else if(nums(smallIndex) + nums(largeIndex) < target) {
      return findTarget(nums, smallIndex, largeIndex + 1, target)
    } else {
      return findTarget(nums, smallIndex + 1, largeIndex, target)
    }
  }

}
