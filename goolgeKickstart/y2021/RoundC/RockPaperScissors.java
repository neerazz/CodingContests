package y2021.RoundC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Aug 05, 2021
 * Ref : https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435c44/00000000007ec28e
 * https://github.com/kamyu104/GoogleKickStart-2021
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt(), x = sc.nextInt();
        int[][] scores = new int[t][2];
        for (int i = 0; i < t; i++) {
            scores[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }
        int[][] res = getResult(t, x, scores);
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + i + 1 + ": " + convert(res[i]));
        }
    }

    private static String convert(int[] vals) {
        StringBuilder sb = new StringBuilder();
        for (int val : vals) {
            sb.append((char) ('A' + val));
        }
        return sb.toString();
    }

    private static int[][] getResult(int t, int x, int[][] scores) {
        int[][] result = new int[t][60];
        int[][][] dp = new int[t][60][3];
//        dp[i][j][k] -> Your score in ith round, while playing jth turn and by making kth choice.
        for (int round = 1; round <= t; round++) {
            int[] cur = new int[60];

            result[round - 1] = cur;
        }
        return result;
    }
}
