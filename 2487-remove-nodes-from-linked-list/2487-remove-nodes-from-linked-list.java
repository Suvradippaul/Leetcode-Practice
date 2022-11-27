class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode node = head;
        while (node != null) {
            while (!s.isEmpty() && s.peek() < node.val) {
                s.pop();
            } 
            s.push(node.val);
            node = node.next;
        }
        
        ListNode ans = new ListNode();
        ListNode temp = ans;
        for (int num : s) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        
        return ans.next;
    }
}