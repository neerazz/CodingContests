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
        int[] max = new int[n];
        int j = n - 1;
        for (int i = maxWord.length() - 1; i >= 0 && j < n; i--) {
            max[j--] = maxWord.charAt(i) - 'a';
        }
        int p1 = (n - 1) / 2, p2 = n / 2;
        int[] cur = new int[n];
        long total = 0;
        for (int l = 0; l < n / 2; l++) {
            for (int i = 0; i < k; i++) {
                Arrays.fill(cur, p1, p2 + 1, i);
                int p11 = (n - 1) / 2, p21 = n / 2, curChar =0;
                while (p11 >= p1 && p21 <= p2 && Arrays.compare(cur, max) < 0 && curChar <= i) {
                    total++;
                    cur[p11--] = cur[p21++] = ++curChar;
                    System.out.println(Arrays.toString(cur));
                }
            }
            p1--;
            p2++;
        }
        return total;
    }
}
