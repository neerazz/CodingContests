package weekly.weekly252;

import java.util.PriorityQueue;

/**
 * Created on:  Jul 31, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-252/problems/maximum-number-of-weeks-for-which-you-can-work/
 */
public class MaximumNumberOfWeeksForWhichYouCanWork {
    public static void main(String[] args) {
        System.out.println(numberOfWeeks(new int[]{1, 2, 3}) + " = 6");
        System.out.println(numberOfWeeks(new int[]{5, 2, 1}) + " = 7");
        System.out.println(numberOfWeeks(new int[]{9, 3, 6, 8, 2, 1}) + " = 29");
    }

    public static long numberOfWeeks(int[] milestones) {
//        As long as the weeks for the longest project <= all other projects' weeks + 1, we can finish all the projects.
//        If the weeks for the longest project > all other projects' week + 1, we cannot finish the longest project. In this case, return (all other projects) * 2 + 1
        long max = 0, sum = 0;
        for (int week : milestones) {
            max = Math.max(week, max);
            sum += week;
        }
        return sum >= 2 * max ? sum : 2 * (sum - max) + 1;
    }

    public static long numberOfWeeks_naive(int[] milestones) {
        long weeks = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));
        for (int num : milestones) {
            pq.add(num);
        }
        int pre = pq.poll();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (pre > 1) pq.add(pre - 1);
            pre = cur;
            weeks++;
        }
        return weeks;
    }
}
