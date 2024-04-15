package com.interview.designguru.patterns.fastandslowpointer;

public class IsPalindromeList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHead = reverse(slow, null);
        while(reverseHead != null){
            if(head.val != reverseHead.val){
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }

        return true;
    }


    private static ListNode reverse(ListNode head, ListNode prev){
        if(head == null){
            return prev;
        }
        ListNode headNext = head.next;
        head.next = prev;
        prev = head;
        head = headNext;
        return reverse(head, prev);
    }

}
