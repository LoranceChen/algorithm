package niuke

import collection.mutable.ArrayBuffer

class TreeNode(var `val`: Int) {
   var left: TreeNode = null
   var right: TreeNode = null
}


object TreeNodeOutput {
  def main(args: Array[String]): Unit = {
    // write code here
    val a = Array[Int]()
    val b = a :+ 10

    println(a.toList)
    println(b.toList)
  }
  /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    *
    * @param root TreeNode类
    * @return int整型二维数组
    */
  def levelOrder(root: TreeNode): Array[Array[Int]] = {
    // write code here
    val rst: Array[Array[Int]] = levelOrderHelper(root, 0, ArrayBuffer())
    rst
  }

  def levelOrderHelper(root: TreeNode, levelIndex: Int, rst: ArrayBuffer[ArrayBuffer[Int]]): Array[Array[Int]] = {
    if(root == null) {
      rst.map(item => item.toArray).toArray
    } else {
      if(rst.length < levelIndex + 1) {
        rst.append(ArrayBuffer(root.`val`))
        levelOrderHelper(root.left, levelIndex + 1, rst)
        levelOrderHelper(root.right, levelIndex + 1, rst)
      } else {
        rst(levelIndex).append(root.`val`)
        levelOrderHelper(root.left, levelIndex + 1, rst)
        levelOrderHelper(root.right, levelIndex + 1, rst)
      }
    }
  }
}
