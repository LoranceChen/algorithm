package niuke

import niuke.TreeThreeOrders.TreeNode

/**
  * class TreeNode(var val: Int) {
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */

/**
  * 问题复盘：
  *   1. [边界条件处理] 生成parentRst: Array[TreeNode]时候，没有把自己也算上
  *     - 解决过程：先把失败的case画出来（如果没自动生成树的工具，可能要花一些时间画一下），看清楚这中特殊情况，结合代码定位到响应的逻辑
  */
object TreeCommonParent {
  def main(args: Array[String]): Unit = {
    val tree = TreeNode(1,
                  TreeNode(2,
                    TreeNode(3),
                    TreeNode(4)),
                  TreeNode(5)
                )

  }
  /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    *
    * @param root TreeNode类
    * @param o1 int整型
    * @param o2 int整型
    * @return int整型
    */
  def lowestCommonAncestor(root: TreeNode,o1: Int,o2: Int): Int = {
    // write code here
    // 1. 遍历树，找到两个数字对应的treenode引用
    val (_, rst1) = findValParent(root, o1, Array()) // O(n)
    val (_, rst2) = findValParent(root, o2, Array()) // O(n)
    // 2. 使用树层数比较小的parent节点开始遍历出另外一个treenode
    val rst = if(rst1.parents.length <= rst2.parents.length) {
      // 使用o1的父节点找o2
      findAncestorHelper(rst1.t, rst1.parents, rst2.t, rst2.parents) // O(logN)
    } else {
      findAncestorHelper(rst2.t, rst2.parents, rst1.t, rst1.parents)
    }

    rst.`val`

  }
  case class AimNodeInfo(t: TreeNode, o: Int, parents: Array[TreeNode])
  // 找到对应节点的所有父节点
  def findValParent(root: TreeNode, o: Int, parentRst: Array[TreeNode]): (Boolean, AimNodeInfo) = {
    if(root == null) {
      (false, null)
    } else if(root.`val` == o) {
      (true, AimNodeInfo(root, o, parentRst :+ root))
    } else {
      val rst @ (success, _) = findValParent(root.left, o, parentRst :+ root)
      if(success) rst
      else findValParent(root.right, o, parentRst :+ root)
    }
  }

  // 找出最前面的两个节点的重合的地方
  def findAncestorHelper(t1: TreeNode,
                         t1ps: Array[TreeNode],
                         t2: TreeNode,
                         t2ps: Array[TreeNode]): TreeNode = {
    if(t1ps.length == 0) null
    else {
      val t1Last = t1ps.last
      if(t2ps.contains(t1Last)) t1Last
      else {
        findAncestorHelper(t1, t1ps.init, t2, t2ps)
      }
    }
  }

}


