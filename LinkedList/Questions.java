package DSA_with_kunal.LinkedList;

public class Questions {
    // Q1. Remove duplicates from sorted list
    /* Definition for singly-linked list.*/
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        //int preVal=head.val;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    // Q2. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val <= list2.val) {
            head = new ListNode(list1.val, null);
            list1 = list1.next;
        } else {
            head = new ListNode(list2.val, null);
            list2 = list2.next;
        }
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = new ListNode(list1.val, null);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val, null);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return head;
    }

    // Q3. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fp = head;
        ListNode sp = head;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            if (fp == sp) {
                return true;
            }
        }
        return false;
    }

    // Q4.  Length of Linked List Cycle
    public int cycleLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode fp = head;
        ListNode sp = head;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            if (fp == sp) {
                int len = 0;
                do {
                    len++;
                    sp = sp.next;
                } while (sp != fp);
                return len;
            }
        }
        return 0;
    }

    // Q5. Linked ListCycle II
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fp = head;
        ListNode sp = head;
        int len = 0;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            if (fp == sp) {
                do {
                    sp = sp.next;
                    len++;
                } while (sp != fp);
                break;
            }
        }
        if (len == 0) {
            return null;
        }
        fp = head;
        sp = head;
        for (int i = 0; i < len; i++) {
            sp = sp.next;
        }
        while (fp != sp) {
            sp = sp.next;
            fp = fp.next;
        }
        return fp;
    }

    // Q6. Happy Number
    public boolean isHappy(int n) {
        int fp = n;
        int sp = n;
        do {
            sp = helper(sp);
            fp = helper(helper(fp));
        } while (fp != sp);
        if (sp == 1) {
            return true;
        }
        return false;
    }

    int helper(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }

    // Q7. Middle of the Linked List
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Q8. Sort List (Merge Sort)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return head;
    }

    public ListNode getMid(ListNode head) {
        ListNode sp = null;
        ListNode fp = head;
        while (fp != null && fp.next != null) {
            sp = sp == null ? head : sp.next;
            fp = fp.next.next;
        }

        ListNode mid = sp.next;
        sp.next = null;
        return mid;
    }

    // Q9. Reverse Linked List
    // i. Recursive approach
    ListNode newHead = null;

    public ListNode reverseListRec(ListNode head) {
        if (head == null) {
            return head;
        }
        reverse(head);
        return newHead;
    }

    public ListNode reverse(ListNode node) {
        if (node.next == null) {
            newHead = node;
            node.next = null;
            return node;
        }
        ListNode prevNode = reverse(node.next);
        prevNode.next = node;
        node.next = null;
        return node;
    }

    // ii. Iterative approach
    public ListNode reverseListItr(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prevNode = null;
        ListNode presNode = head;
        ListNode nextNode = head.next;
        while (presNode != null) {
            presNode.next = prevNode;
            prevNode = presNode;
            presNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        return prevNode;
    }

    // Q 10. Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode prevNode = null;
        for (int i = 1; i < left; i++) {
            prevNode = prevNode == null ? head : prevNode.next;
        }
        ListNode newEnd = prevNode == null ? head : prevNode.next;
        ListNode presNode = newEnd;
        ListNode newPrev = null;
        ListNode nextNode = presNode.next;
        for (int i = 0; i <= right - left; i++) {
            presNode.next = newPrev;
            newPrev = presNode;
            presNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        newEnd.next = presNode;
        if (left == 1) {
            return newPrev;
        }
        prevNode.next = newPrev;
        return head;
    }
}
