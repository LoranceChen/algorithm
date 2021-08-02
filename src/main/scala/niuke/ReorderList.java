package niuke;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) return;
        if(head.next == null) return;

        reorderListHelper2(head, head.next, false);
    }

    // 返回参数head对应的头
    public void reorderListHelper(ListNode lastNode, // 已经处理好的链表的最后一个节点
                                  ListNode head, // 剩下需要处理的节点
                                  Boolean useFirst // 下一个头是first还是last
    ) {
        if(head == null) return;
        if(head.next == null) {
            lastNode.next = head;
            return;
        }
        // 计算头
        ListNode nextHead = getNextHead(head, useFirst);

        ListNode newHead;
        if(useFirst) {
            newHead = head.next;
        } else {
            newHead = head;
        }
        lastNode.next = nextHead;

        reorderListHelper(nextHead, newHead, !useFirst);

    }

    // 返回参数head对应的头
    public void reorderListHelper2(ListNode lastNode1, // 已经处理好的链表的最后一个节点
                                   ListNode head1, // 剩下需要处理的节点
                                   Boolean useFirst1 // 下一个头是first还是last
    ) {
        ListNode lastNode = lastNode1; // 已经处理好的链表的最后一个节点
        ListNode head = head1; // 剩下需要处理的节点
        Boolean useFirst = useFirst1; // 下一个头是first还是last
        while(true) {
            if(head == null) return;
            if(head.next == null) {
                lastNode.next = head;
                return;
            }
            // 计算头
            ListNode nextHead = getNextHead(head, useFirst);

            ListNode newHead;
            if(useFirst) {
                newHead = head.next;
            } else {
                newHead = head;
            }
            lastNode.next = nextHead;

            lastNode = nextHead;
            head = newHead;
            useFirst = !useFirst;
            // reorderListHelper(nextHead, newHead, !useFirst);
        }

    }

    // 获取到下一个head，并处理好指针
    private ListNode getNextHead(ListNode head, // 剩下需要处理的节点
                                 Boolean useFirst) {
        if(head == null) return null;
        if(useFirst) {
            // todo 应该不需要更改
            return head;
        } else {// 需要获取链表的最后一个node，并且把最后一个node的上一个node的指针值为null
            ListNode last = head;
            ListNode last2 = null; // 倒数第二个指针
            while(last.next != null) {
                last2 = last; // 记录倒数第二个指针
                last = last.next;
            }
            // 清理倒数第二个指针
            if(last2 != null) {
                last2.next = null;
            }
            return last;
        }
    }

    // 交换链表指针
}