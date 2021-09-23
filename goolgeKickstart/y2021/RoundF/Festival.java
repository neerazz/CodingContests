package y2021.RoundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created on:  Sep 21, 2021
 * Ref: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435bae/0000000000887dba
 */
public class Festival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            int days = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt();
            int[] score = new int[n], start = new int[n], end = new int[n];
            for (int j = 0; j < n; j++) {
                score[j] = sc.nextInt();
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
            }
            long output = getMaxHappiness(days, n, k, score, start, end);
            result[i] = output;
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static long getMaxHappiness(int days, int n, int k, int[] scores, int[] starts, int[] ends) {
        long max = 0;
        Map<Integer, Set<Integer>> add = new HashMap<>();
        Map<Integer, Set<Integer>> remove = new HashMap<>();
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int s = starts[i], e = ends[i];
            start = Math.min(start, s);
            end = Math.max(end, e);
            add.computeIfAbsent(s, val -> new HashSet<>()).add(i);
            remove.computeIfAbsent(e + 1, val -> new HashSet<>()).add(i);
        }
        TreeSet<Integer> pq = new TreeSet<>((i1, i2) -> Integer.compare(scores[i2], scores[i1]));
        for (int i = start; i <= end; i++) {
            pq.addAll(add.getOrDefault(i, new HashSet<>()));
            for (int idx : remove.getOrDefault(i, new HashSet<>())) pq.remove(idx);
            long cur = 0;
            int count = 0;
            for (int idx : pq) {
                cur += scores[idx];
                if (++count == k) break;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
