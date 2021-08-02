package niuke

import scala.util.control.Breaks

object TopK {

  def main(args: Array[String]): Unit = {
    val a = GetLeastNumbers_Solution(Array(3,8,5,4,9), 3)
    println(a.toList)
  }

  /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    * 找出最大的k个数（构造小顶堆，但不需要排序）
    * @param input int整型一维数组
    * @param k int整型
    * @return int整型一维数组
    */
  def GetLeastNumbers_Solution(input: Array[Int],k: Int): Array[Int] = {
    if(input == null || input.size <= k) {
      input
    } else {
      val heap = new Array[Int](k)
      (0 until k).foreach(i => heap(i) = input(i))
      createHeap(heap, k)
      println(heap.toList)

      (k until input.size).foreach(i => {
        if (input(i) > heap(0)) {
          heap(0) = input(i)
          adjust(heap, k, 0)
        }
      })

      heap
    }
  }

  def createHeap(arr: Array[Int], size: Int): Unit = {
    var i = (size - 2) / 2 // 最后一个非叶子节点的index
    while (i >= 0) {
      adjust(arr, size, i)
      i-=1
    }
  }

  // 对当前指定的index所在的非叶子节点做下沉替换。保证该节点及所有子节点是小顶堆
  def adjust(arr: Array[Int], len: Int, index: Int): Unit = {
    val left = 2 * index + 1
    val right = 2 * index + 2
    var minIndex = index
    if(left < len && arr(left) < arr(minIndex)) minIndex = left
    if(right < len && arr(right) < arr(minIndex)) minIndex = right
    if(minIndex != index) {
      val t = arr(index)
      arr(index) = arr(minIndex)
      arr(minIndex) = t

      adjust(arr, len, minIndex)
    }

  }

  def adjustDown1(arr: Array[Int], size: Int, root: Int): Unit = {
    var theRoot = root
    val loop = new Breaks
    loop.breakable(
      while(true) {
        val left: Int = 2 * theRoot + 1
        if(left >= size) {
          loop.break()
        }

        val right = 2 * theRoot + 2
        var min: Int = left
        if(right < size && arr(right) > arr(left)) {
          min = right
        }
        if(arr(theRoot) >= arr(min)) {
          loop.break()
        }

        var t = arr(theRoot)
        arr(theRoot) = arr(min)
        arr(min) = t
        theRoot = min
      }
    )

  }

  // log2
  def log2(x: Int): Double = {
    Math.log(x) / Math.log(2)
  }

}
