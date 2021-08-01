package niuke

object TreeThreeOrders {
  def main(args: Array[String]): Unit = {
    val rst = threeOrders(TreeNode(1,
                        TreeNode(2,
                            TreeNode(3),
                            TreeNode(4)),
                        TreeNode(5)
      ))
    println(rst)
  }

  case class TreeNode(var `val`: Int, var left: TreeNode = null, var right: TreeNode = null) {
  }

  def threeOrders(root: TreeNode): Array[Array[Int]] = {
    // write code here
    var a = List(order1(root), order2(root), order3(root))
    println(a)
    List(order1(root), order2(root), order3(root)).map(_.toArray).toArray
  }

  // 先序遍历
  def order1(src: TreeNode): List[Int] = {
    val rst = if(src == null) {
      Nil
    } else if(src.left == null) {
      src.`val` :: order1(src.right)
    } else if(src.right == null) {
      src.`val` :: order1(src.left)
    } else {
      (src.`val` :: order1(src.left)) ::: order1(src.right)
    }

    rst
  }


  // 中序遍历
  def order2(src: TreeNode): List[Int] = {
    if(src == null) {
      Nil
    } else if(src.left == null) {
      src.`val` :: order2(src.right)
    } else if(src.right == null) {
      order2(src.left) :+ src.`val`
    } else {
      (order2(src.left) :+ src.`val`) ::: order2(src.right)
    }
  }

  // 后序遍历
  def order3(src: TreeNode): List[Int] = {
    if(src == null) {
      Nil
    } else if(src.left == null) {
      order3(src.right) :+ src.`val`
    } else if(src.right == null) {
      order3(src.left) :+ src.`val`
    } else {
      (order3(src.left) ::: order3(src.right)) :+ src.`val`
    }
  }

}
