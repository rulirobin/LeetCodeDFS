
public class LeetCode2AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode s1 = l1;
	    	ListNode s2 = l2;
	        ListNode head = new ListNode(0);
	        ListNode prev = head;
	        int sum = 0;
	        while(s1 != null || s2 != null) {
	        	sum /=10;
	        	if(s1 != null) {
	        		sum += s1.val;
	        		s1 = s1.next;
	        	}
	        	if(s2 != null) {
	        		sum += s2.val;
	        		s2 = s2.next;
	        	}
	        	prev.next = new ListNode(sum % 10);
	        	prev = prev.next;
	        }
	        if(sum /10 == 1) {
	        	prev.next = new ListNode(1);
	        }
	        return head.next;
	    }
		// TODO Auto-generated method stub

	}

}
