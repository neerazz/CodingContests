package y2021.RoundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created on:  Sep 21, 2021
 * Ref: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435bae/0000000000887c32
 */
public class TrashBins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            int len = sc.nextInt();
            String input = sc.next();
            result[i] = getTotalDistance(len, input);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static long getTotalDistance(int len, String input) {
        long sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == '1') set.add(i);
        }
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == '0') {
                Integer left = set.floor(i), right = set.ceiling(i);
                int min = Math.min(left == null ? Integer.MAX_VALUE : i - left, right == null ? Integer.MAX_VALUE : right - i);
                sum += min;
            }
        }
        return sum;
    }
}
