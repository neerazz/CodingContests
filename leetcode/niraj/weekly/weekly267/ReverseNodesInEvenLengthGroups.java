package weekly.weekly267;

import biweekly.biweekly40.MergeInBetweenLinkedLists;

import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Sep 25, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-267/problems/reverse-nodes-in-even-length-groups/
 */

public class ReverseNodesInEvenLengthGroups {
    public static void main(String[] args) {
        System.out.println(reverseEvenLengthGroups(createListNode(Arrays.asList(5, 2, 6, 3, 9, 1, 7, 3, 8, 4))));
        System.out.println(reverseEvenLengthGroups(createListNode(Arrays.asList(1,1,0,6))));
        System.out.println(reverseEvenLengthGroups(createListNode(Arrays.asList(0,4,2,1,3))));
    }

    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode resultRef = head, cur = head.next;
        int groupCount = 1;
        while (cur != null) {
            ListNode start = cur, curGroup = new ListNode(start.val), cgRef = curGroup;
            int count = 1;
            while (cur.next != null && count <= groupCount) {
                ListNode next = cur.next;
                cgRef.next = new ListNode(next.val);
                cgRef = cgRef.next;
                cur = next;
                count++;
            }
            groupCount++;
            if (count % 2 == 0) resultRef.next = reverse(curGroup);
            else resultRef.next = curGroup;
            while (resultRef.next != null) {
                resultRef = resultRef.next;
            }
            cur = cur.next;
        }
        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static ListNode createListNode(List<Integer> list) {
        ListNode output = new ListNode(0), outputRef = output;
        for (int val : list) {
            outputRef.next = new ListNode(val);
            outputRef = outputRef.next;
        }
        return output.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return val +
                    ", " + next;
        }
    }

}
