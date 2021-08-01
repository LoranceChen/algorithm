package niuke

import scala.annotation.tailrec

object ReverseList {
  def main(args: Array[String]): Unit = {
    val a = ListNode(1)
    val b = ListNode(2)
    val c = ListNode(3)
    a.next = b
    b.next = c

    println(a)
    val rst = reverseList(a)
    println(rst)
  }

  case class ListNode(var `val`: Int, var next: ListNode = null) {
  }


  def reverseList(head: ListNode): ListNode = {
    reverseListHelper(head, null)
  }

  @tailrec
  def reverseListHelper(head: ListNode, former: ListNode): ListNode = {
    // write code here
    if(head == null) {
      former
    } else if(head.next == null) {
      head.next = former
      head
    } else {
      val next = head.next
      head.next = former
      reverseListHelper(next, head)
    }
  }

}
