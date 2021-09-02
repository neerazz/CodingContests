package weekly.weekly256;

import java.util.*;

/**
 * Created on:  Aug 28, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-256/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
 */
public class MinimumNumberOfWorkSessionsToFinishTheTasks {
    public static void main(String[] args) {
        System.out.println(minSessions(new int[]{1,2,3}, 3) + " = 2");
    }

    public static int minSessions(int[] tasks, int sessionTime) {
        int len = tasks.length;
        boolean[] taken = new boolean[len];
        Map<String, Integer> dp = new HashMap<>();
        return helper(sessionTime,sessionTime, tasks, taken, 0, dp);
    }
    static int helper(int rem, int power, int[] tasks, boolean[] taken, int total, Map<String, Integer> dp){
        if(total == tasks.length) return 1;
        String key = Arrays.toString(taken) + rem;
        if(dp.containsKey(key)) return dp.get(key);
        if(rem == 0) return 1 + helper(power, power, tasks, taken, total, dp);
        int cur = Integer.MAX_VALUE, len = tasks.length;
        for(int i=0; i<len; i++){
            if(taken[i]) continue;
            if(tasks[i] > rem) continue;
            taken[i] = true;
            int next = helper(rem-tasks[i], power, tasks, taken, total+1, dp);
            if(next != Integer.MAX_VALUE) cur = Math.min(cur, next);
            taken[i] = false;
        }
        if(cur == Integer.MAX_VALUE){
//             You could not process any task, then end your power time and start new;
            cur = 1 + helper(power, power, tasks, taken, total, dp);
        }
        dp.put(key, cur);
        return cur;
    }
}
