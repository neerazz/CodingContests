package weekly.weekly273;

import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 25, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-273/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
 */

public class ExecutionOfAllSuffixInstructionsStayingInAGrid {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(executeInstructions(3, new int[]{0, 1}, "RRDDLU")));
        System.out.println(Arrays.toString(executeInstructions(2, new int[]{1, 1}, "LURD")));
        System.out.println(Arrays.toString(executeInstructions(1, new int[]{0, 0}, "LRUD")));
        System.out.println(Arrays.toString(executeInstructions(10, new int[]{9, 6}, "UDDDUDDURRLLDRDDRRUU")));
        System.out.println(Arrays.toString(executeInstructions(476, new int[]{351,63}, "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL")));
        System.out.println("**************************************** Array DP Solution ****************************************");
        System.out.println(Arrays.toString(executeInstructions_array_dp(3, new int[]{0, 1}, "RRDDLU")));
        System.out.println(Arrays.toString(executeInstructions_array_dp(2, new int[]{1, 1}, "LURD")));
        System.out.println(Arrays.toString(executeInstructions_array_dp(1, new int[]{0, 0}, "LRUD")));
        System.out.println(Arrays.toString(executeInstructions_array_dp(10, new int[]{9, 6}, "UDDDUDDURRLLDRDDRRUU")));
        System.out.println(Arrays.toString(executeInstructions_array_dp(476, new int[]{351,63}, "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL")));
        System.out.println("**************************************** Map DP Solution ****************************************");
        System.out.println(Arrays.toString(executeInstructions_map_dp(3, new int[]{0, 1}, "RRDDLU")));
        System.out.println(Arrays.toString(executeInstructions_map_dp(2, new int[]{1, 1}, "LURD")));
        System.out.println(Arrays.toString(executeInstructions_map_dp(1, new int[]{0, 0}, "LRUD")));
        System.out.println(Arrays.toString(executeInstructions_map_dp(10, new int[]{9, 6}, "UDDDUDDURRLLDRDDRRUU")));
        System.out.println(Arrays.toString(executeInstructions_map_dp(476, new int[]{351,63}, "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL")));
        System.out.println("**************************************** Trie Solution ****************************************");
        System.out.println(Arrays.toString(executeInstructions_trie(3, new int[]{0, 1}, "RRDDLU")));
        System.out.println(Arrays.toString(executeInstructions_trie(2, new int[]{1, 1}, "LURD")));
        System.out.println(Arrays.toString(executeInstructions_trie(1, new int[]{0, 0}, "LRUD")));
//        System.out.println(Arrays.toString(executeInstructions_trie(10, new int[]{9, 6}, "UDDDUDDURRLLDRDDRRUU")));
//        System.out.println(Arrays.toString(executeInstructions_trie(476, new int[]{351,63}, "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL")));
    }

    public static int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int dist = getLastIdx(n, startPos[0], startPos[1], s, i);
            result[i] = dist - i;
        }
        return result;
    }

    private static int getLastIdx(int n, int row, int col, String str, int idx) {
        if (idx == str.length()) return idx;
        int dir = getDir(str.charAt(idx));
        int nr = row + dirs[dir][0], nc = col + dirs[dir][1];
        if (inRange(n, nr, nc)) return getLastIdx(n, nr, nc, str, idx+1);
        return idx;
    }

    public static int[] executeInstructions_trie(int n, int[] startPos, String s) {
        Node node = new Node();
        buildTrie(node, startPos, n, s, 0);
        int len = s.length();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int steps = checkPath(s, i, node);
            result[i] = steps;
        }
        return result;
    }

    private static int checkPath(String s, int i, Node node) {
        if (s.length() == i) return 0;
        int dir = getDir(s.charAt(i));
        if (node.dirs[dir] == null) return 0;
        return 1 + checkPath(s, i + 1, node.dirs[dir]);
    }

    private static void buildTrie(Node node, int[] pos, int n, String s, int idx) {
        if (idx == s.length()) return;
        for (int dir = 0; dir < 4; dir++) {
            int nr = pos[0] + dirs[dir][0], nc = pos[1] + dirs[dir][1];
            if (inRange(n, nr, nc)) {
                node.dirs[dir] = node.dirs[dir] == null ? new Node() : node.dirs[dir];
                buildTrie(node.dirs[dir], new int[]{nr, nc}, n, s, idx + 1);
            }
        }
    }

    static class Node {
        Node[] dirs = new Node[4];
    }

    public static int[] executeInstructions_map_dp(int n, int[] startPos, String s) {
        int len = s.length();
        Integer[][][] dp = new Integer[n][n][len + 1];
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int steps = helper(n, startPos, s, i, dp);
            result[i] = steps;
        }
        return result;
    }

    private static String key(int[] pos, int idx) {
        return String.format("[%d,%d] %d", pos[0], pos[1], idx);
    }

    private static int helper(int n, int[] pos, String dir, int idx, Map<String, Integer> dp) {
        if (idx == dir.length() || !inRange(n, pos[0], pos[1])) {
            return 0;
        }
        String key = key(pos, idx);
        if (dp.containsKey(key)) {
            return dp.get(key);
        } else {
            int cur = 0;
            int[] next = canMove(n, pos, dir.charAt(idx));
            if (next != null) {
                cur = 1 + helper(n, next, dir, idx + 1, dp);
            }
            dp.put(key, cur);
            return cur;
        }
    }

    public static int[] executeInstructions_array_dp(int n, int[] startPos, String s) {
        int len = s.length();
        Integer[][][] dp = new Integer[n][n][len + 1];
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int steps = helper(n, startPos, s, i, dp);
            result[i] = steps;
        }
        return result;
    }

    private static int helper(int n, int[] pos, String dir, int idx, Integer[][][] dp) {
        if (idx == dir.length() || !inRange(n, pos[0], pos[1])) {
            return 0;
        } else if (dp[pos[0]][pos[1]][idx] != null) {
            return dp[pos[0]][pos[1]][idx];
        } else {
            int cur = 0;
            int[] next = canMove(n, pos, dir.charAt(idx));
            if (next != null) {
                cur = 1 + helper(n, next, dir, idx + 1, dp);
            }
            return dp[pos[0]][pos[1]][idx] = cur;
        }
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int getDir(char dir) {
        if (dir == 'U') return 0;
        else if (dir == 'D') return 1;
        else if (dir == 'L') return 2;
        else return 3;
    }

    private static boolean inRange(int n, int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }

    private static int[] canMove(int n, int[] pos, char dirChar) {
        int[] dir = dirs[getDir(dirChar)];
        int nr = pos[0] + dir[0], nc = pos[1] + dir[1];
        int[] newPos = {nr, nc};
        return inRange(n, nr, nc) ? newPos : null;
    }

}
