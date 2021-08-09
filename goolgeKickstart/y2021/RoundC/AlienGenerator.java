package y2021.RoundC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created on:  Aug 05, 2021
 * Ref : https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435c44/00000000007ec1cb
 */
public class AlienGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            result[i] = getPossibility(sc.nextLong());
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

//    Time: n Log n, Space: 1
    private static long getPossibility(long g) {
        long pos = 1;
        for (long i = 1; i < g; i++) {
            if (isPossible(i, g)) {
                pos++;
            }
        }
        return pos;
    }

    private static boolean isPossible(long k, long g) {
        long start = 1, end = g - 1;
        while (start < end) {
            long mid = start + (end - start) / 2;
//            Total golds made if mid-number of days, if K was the value on first day.
            long total = count(k,mid);
            if(total == g) return true;
            if(total < g){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return count(k,start) == g;
    }

    private static long count(long k, long days) {
        return (days * (days-1)) /2 + days * k;
    }
}
