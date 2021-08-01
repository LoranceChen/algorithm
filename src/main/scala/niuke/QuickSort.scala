//package niuke
//
//object QuickSort {
//
//  def main(args: Array[String]): Unit = {
////    val rst = sort(1 :: 3 :: 2 :: Nil)
////    println(rst)
//    val rst = mySort(Array(1,3,2,4))
//    println(rst.toList)
//  }
//
//  /**
//    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//    * 将给定数组排序
//    * @param arr int整型一维数组 待排序的数组
//    * @return int整型一维数组
//    */
//  def mySort(arr: Array[Int]): Array[Int] = {
//    val lst = arr.toList
//    val rst = sort(lst).toArray
//    println(rst)
//    rst
//  }
//
//  def sort(arr: List[Int]): List[Int] = {
//    arr match {
//      case Nil => Nil
//      case head :: tail =>
//        val (left, right) = tail.partition(x => x < head)
//        sort(left) ::: head :: sort(right)
//    }
//  }
//
//}



object Solution {
  def main(args: Array[String]): Unit = {
    println(MySort(Array(1,2,4,3)).toList)
  }
  /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    * 将给定数组排序
    * @param arr int整型一维数组 待排序的数组
    * @return int整型一维数组
    */
  def MySort(arr: Array[Int]): Array[Int] = {
    // to list
    val list = arr.toList
    val a = sortHelper(list).toArray
    // println(a)

    a

  }

  def sortHelper(src: List[Int]): List[Int] = {
    src match {
      case Nil => Nil
      case head :: tail =>
        val (left, right) = tail.partition(x => x < head)
        sortHelper(left) ::: head :: sortHelper(right)
    }
  }
}