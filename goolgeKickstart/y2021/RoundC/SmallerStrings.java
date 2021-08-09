package y2021.RoundC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on:  Aug 05, 2021
 * Ref : https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435c44/00000000007ebe5e
 */
public class SmallerStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt(), k = sc.nextInt();
            result[i] = getCount(k, n, sc.next());
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static long getCount(int k, int n, String maxWord) {
        long total = 0, mod = 1_000_000_007;
        int mid = (n + 1) / 2;
        char[] maxChars = maxWord.toCharArray();
        for (int i = 0; i < mid; i++) {
            int allowedChars = Math.min(maxChars[i] - 'a', k);
//            Possibility at each index is the number of chars you are away from center to the power k.
            double poss = Math.pow(k, mid - i - 1);
            long cur = (long) (poss * allowedChars) % mod;
            total += cur;
            total %= mod;
//            Override the other side of the string;
            maxChars[n - i - 1] = maxChars[i];
        }
//        If after overriding all the on the left with the chars with right and the changedChars is still small then
        if (Arrays.compare(maxChars, maxWord.toCharArray()) < 0) total++;
        return total % mod;
    }
}
