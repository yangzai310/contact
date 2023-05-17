package algorithm.example.linked.basic;

import algorithm.example.linked.ListNode;
import algorithm.example.linked.SimpleNode;

public class SimpleNodeTest {

//    public static void main(String[] args) {
//        SimpleNode node1 = new SimpleNode();
//
//        SimpleNode node2 = new SimpleNode();
//        SimpleNode node3 = new SimpleNode();
//        SimpleNode node4 = new SimpleNode();
//        node1.setObject(1);
//        node1.setNext(node2);
//        node2.setObject(2);
//        node2.setNext(node3);
//
//        node3.setObject(3);
//        node3.setNext(node4);
//        node4.setObject(4);
////        node4.setNext(node1);
////        SimpleNode simpleNode = reverseList(node1);
//
////        boolean b = hasCycle(node1);
//        removeTargetNode(node1, 4);
//
//    }


    public static SimpleNode reverseList(SimpleNode head) {
        // 1 2 3 4

        SimpleNode pre = null;
        SimpleNode cur = head;

        while (cur != null) {
            SimpleNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return  pre;
    }


    public static boolean hasCycle(SimpleNode head) {
        if (head == null) {
            return false;
        }
        SimpleNode fast = head.next;
        SimpleNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void removeTargetNode(SimpleNode head, int n) {
        SimpleNode targetNode = head;
        SimpleNode fast = head;
        while (n > 0) {
            n--;
            fast = fast.next;
        }
        if (fast == null || fast.next == null) {
            head = head.next;
            return ;
        }
        while (fast.next != null) {
            fast = fast.next;
            targetNode = targetNode.next;
        }

        targetNode.next = targetNode.next.next;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }


}
