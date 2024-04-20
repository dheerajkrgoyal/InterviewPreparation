package com.interview.designguru.patterns.llreversal;

class ListNode {
    int val;
    ListNode next;

    public  ListNode(int val){
        this.val = val;
    }

    public void display(){
        ListNode node = this;
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }

    public String toString(){
        return String.valueOf(this.val);
    }
}
