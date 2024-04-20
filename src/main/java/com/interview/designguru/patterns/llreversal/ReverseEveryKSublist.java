package com.interview.designguru.patterns.llreversal;

/**
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting
 * from the head.
 *
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 *
 * Example:
 * [1,2,3,4,5,6]
 * 2
 * Output: [2,1,4,3,6,5]
 *
 * Example:
 * [1,2,3,4,5,6,7]
 * 4
 * Output: [4,3,2,1,7,6,5]
 */
public class ReverseEveryKSublist {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.display();
        head = reverse(head, 2);
        head.display();
    }

    public static ListNode reverse(ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while(true){
            ListNode lastNodePreviousPart = previous;
            ListNode lastNodeSubList = current;
            int i = 1;
            while(i != k+1 && current != null){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                i++;
            }

            ListNode firstNodeSubList = previous;
            ListNode firstNodeNextPart = current;

            if(lastNodePreviousPart != null){
                lastNodePreviousPart.next = firstNodeSubList;
            }
            else{
                head = firstNodeSubList;
            }
            lastNodeSubList.next = firstNodeNextPart;

            if(current == null){
                break;
            }

            previous = lastNodeSubList;
        }

        return head;
    }
}
