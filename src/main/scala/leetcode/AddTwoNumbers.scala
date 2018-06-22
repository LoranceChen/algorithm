package leetcode

import scala.annotation.tailrec

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
object AddTwoNumbers extends App {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x

    override def toString: String = {
      s"$x -> $next"
    }
  }

  /**
    * 思路：这是一个类似于BigInteger的实现，第一个node为最小位。边界需要考虑进一的情况
    */
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    addTwoNumbersHelper(
      l1,
      l2,
      null,
      0,
      null
    )

  }

  @tailrec
  def addTwoNumbersHelper(l1: ListNode,
                                   l2: ListNode,
                                   acc: ListNode,
                                   overflow1: Int,
                                   accLastPoint: ListNode
                         ): ListNode = {
    val firstAdd = l1.x + l2.x + overflow1
    val mod = firstAdd % 10
    val newOverflow = firstAdd / 10
    val newListNode = new ListNode(mod)

    if(l1.next == null && l2.next == null) { // game over condition
      if(acc == null) {
        if(newOverflow == 1) {
          newListNode.next = new ListNode(1)
        }
        newListNode
      } else {
        accLastPoint.next = newListNode
        if(newOverflow == 1) {
          newListNode.next = new ListNode(1)
        }

        acc
      }
    } else {
      if(l1.next != null && l2.next == null) {
        addTwoNumbersHelper(
          l1.next,
          new ListNode(0),
          {
            if(accLastPoint == null) newListNode
            else {
              accLastPoint.next = newListNode
              acc
            }
          },
          newOverflow,
          newListNode
        )
      } else if(l2.next != null && l1.next == null) {
        addTwoNumbersHelper(
          new ListNode(0),
          l2.next,
          {
            if(accLastPoint == null) newListNode
            else {
              accLastPoint.next = newListNode
              acc
            }
          },
          newOverflow,
          newListNode
        )
      } else {//l2.next != null && l1.next != null
        addTwoNumbersHelper(
          l1.next,
          l2.next,
          {
            if(accLastPoint == null) newListNode
            else {
              accLastPoint.next = newListNode
              acc
            }
          },
          newOverflow,
          newListNode
        )
      }
    }

  }

  def test1: Unit = {
    val p1 = new ListNode(9)
    p1.next = new ListNode(8)

    val p2 = new ListNode(1)

    val rst = addTwoNumbers(p1, p2)

    println(rst)
  }

  def test2: Unit = {
    val p11 = new ListNode(2)
    val p12 = new ListNode(4)
    val p13 = new ListNode(3)
    p11.next = p12
    p12.next = p13

    val p21 = new ListNode(5)
    val p22 = new ListNode(6)
    val p23 = new ListNode(4)
    p21.next = p22
    p22.next = p23

    val rst = addTwoNumbers(p11, p21)

    println(rst)
  }

  test1
  test2

}

