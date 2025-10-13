package DSA_with_kunal.LinkedList;

public class Questions {
    // Q1. Remove duplicates from sorted list
    /* Definition for singly-linked list.*/
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode temp=head;
        //int preVal=head.val;
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return head;
    }

    // Q2. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head;
        if(list1.val<=list2.val){
            head=new ListNode(list1.val,null);
            list1=list1.next;
        }else{
            head=new ListNode(list2.val,null);
            list2=list2.next;
        }
        ListNode temp=head;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next=new ListNode(list1.val,null);
                list1=list1.next;
            }else{
                temp.next=new ListNode(list2.val,null);
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1!=null){
            temp.next=list1;
        }else{
            temp.next=list2;
        }
        return head;
    }

    // Q3. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fp=head;
        ListNode sp=head;
        while(fp!=null && fp.next!=null){
            fp=fp.next.next;
            sp=sp.next;
            if(fp==sp){
                return true;
            }
        }
        return false;
    }

    // Q4.  Length of Linked List Cycle
    public int cycleLength(ListNode head){
        if (head==null){
            return 0;
        }
        ListNode fp=head;
        ListNode sp=head;
        while(fp!=null && fp.next!=null){
            fp=fp.next.next;
            sp=sp.next;
            if(fp==sp){
                int len=0;
                do{
                    len++;
                    sp=sp.next;
                }while (sp!=fp);
                return len;
            }
        }
        return 0;
    }
}
