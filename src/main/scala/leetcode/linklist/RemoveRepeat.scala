//package leetcode.linklist
//
//
//// 改题目在循环遍历中使用中间变量标记，并处理好初始化状态。
//// 可以把初始化状态单独写在一个函数中，避免变量的干扰，主循环流程不用处理边界
//// 条件了。
///**
//  * Definition for singly-linked list.
//  * class ListNode(var _x: Int = 0) {
//  *   var next: ListNode = null
//  *   var x: Int = _x
//  * }
//  */
//object DeleteRepeat extends  App {
//  // Definition for singly-linked list.
//  class ListNode(var _x: Int = 0) {
//    var next: ListNode = null
//    var x: Int = _x
//  }
//
//  def f(src: ListNode): ListNode = {
//    f1(src, None, None).orNull
//  }
//  private val node0 = new ListNode(1)
//  private val node1 = new ListNode(4)
//  private val node3 = new ListNode(2)
//  private val node4 = new ListNode(3)
//  node0.next = node1
//  node1.next = node3
////  node2.next = node3
//  node3.next = node4
//
//  private val rst: ListNode = f(node0)
//  if(rst == null) {
//    println("null")
//  } else {
//    //  println(f(node0))
//    var listNode: ListNode = rst
//    do {
//      println(listNode.x)
//      listNode = listNode.next
//    } while (listNode.next != null)
//  }
//
//  def f1(src: ListNode, headOpt: Option[ListNode], formerNoRepeatOpt: Option[ListNode], formerOpt: Option[ListNode]): Option[ListNode]= {
//    if(src.next == null) {
//      formerOpt match {
//        case None =>
//          return Some(src.next)
//        case Some(former) =>
//          if(former.x == src.x) {
//            former.next = null
//            return headOpt
//          } else {
//            return headOpt
//          }
//      }
//      return headOpt
//    }
//    // _: head
//    //      _ <- src
//    // 1 -> 2 -> 2 -> 3
//    //           _ <- src.next
//    formerOpt match {
//      case None => // 未发现第一个元素
//
//        if(src.next.x == src.x) { // 相同元素
//          // None: head
//          // _ <- src
//          // 1 -> 1 -> 2 -> 3
//          //      _ <- src.next
//          if(src.next.next == null) return None
//          else {
//            return f1(src.next.next, headOpt, formerOpt)
//          }
//        } else {
//          // None: head
//          // _ <- src
//          // 1 -> 2 -> 3 -> 3
//          //      _ <- src.next
//          return f1(src.next, Some(src), Some(src))
//        }
//      case Some(former) =>
//        // _: head
//        // _: former
//        //      _: src
//        // 1 -> 2 -> 2 -> 3
//        //           _: src.next
//        // cur: 1
//        if(src.x == for) { // 相同元素
//          former.next = null
//          return f1(src.next, headOpt, formerOpt, src.x)
//        } else { // 不同元素
//          former.next = src
//          return f1(src.next, Some(headOpt.getOrElse(src)), formerOpt)
//        }
//    }
//
//  }
//
//
//
//}
