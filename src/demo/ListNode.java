package demo;

/**
 * @ClassName : ListNode
 * @Description : ListNode
 * @Author : DukeWei
 * @Date : 2020/9/28 10:53
 * @Version : 1.0
 **/
public class ListNode {

    private int val;
    private ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
