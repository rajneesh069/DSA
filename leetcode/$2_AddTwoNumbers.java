package leetcode;

public class $2_AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = new ListNode();
        int carry = 0;

        while (temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val + carry;
            carry = 0;
            if (sum > 9) {
                ListNode newNode = new ListNode(sum % 10);
                carry = sum / 10;
                if (head == null) {
                    head = newNode;
                } else {
                    ListNode tail = head;
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    tail.next = newNode;
                }
            } else {
                ListNode newNode = new ListNode(sum % 10);
                carry = 0;
                if (head == null) {
                    head = newNode;
                } else {
                    ListNode tail = head;
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    tail.next = newNode;
                }
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {
            int sum = temp1.val + carry;
            carry = 0;

            if (sum > 9) {
                ListNode newNode = new ListNode(sum % 10);
                carry = sum / 10;
                if (head == null) {
                    head = newNode;
                } else {
                    ListNode tail = head;
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    tail.next = newNode;
                }
            } else {
                ListNode newNode = new ListNode(sum % 10);
                carry = 0;
                if (head == null) {
                    head = newNode;
                } else {
                    ListNode tail = head;
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    tail.next = newNode;
                }
            }
            temp1 = temp1.next;

        }

        while (temp2 != null) {
            int sum = temp2.val + carry;
            carry = 0;

            if (sum > 9) {
                ListNode newNode = new ListNode(sum % 10);
                carry = sum / 10;
                if (head == null) {
                    head = newNode;
                } else {
                    ListNode tail = head;
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    tail.next = newNode;
                }

            } else {
                ListNode newNode = new ListNode(sum % 10);
                carry = 0;
                if (head == null) {
                    head = newNode;

                } else {
                    ListNode tail = head;
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    tail.next = newNode;
                }
            }
            temp2 = temp2.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            carry = 0;
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
        }

        return head.next;
    }
}
