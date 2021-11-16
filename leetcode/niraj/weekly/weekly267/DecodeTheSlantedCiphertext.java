package weekly.weekly267;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created on:  Sep 25, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-267/problems/decode-the-slanted-ciphertext/
 */

public class DecodeTheSlantedCiphertext {
    public static void main(String[] args) {
        System.out.println(decodeCiphertext("ch   ie   pr", 3));
        System.out.println(decodeCiphertext(" b  ac", 2));
        System.out.println(decodeCiphertext("iveo    eed   l te   olc", 4));
    }

    public static String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length(), cols = len / rows;
        char[][] chars = new char[rows][cols];
        int row = 0, col = 0, lastRow = 0, lastCol =0;
        for (int i = 0; i < len; i++) {
            chars[row][col] = encodedText.charAt(i);
            col++;
            if (col == cols) {
                col = 0;
                row++;
            }
        }
        LinkedList<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int startCol = 0;
        while (startCol < cols) {
            col = startCol++;
            row = 0;
            for (int i = 0; i < rows && col < cols; i++) {
                queue.add(chars[row++][col++]);
            }
        }
        while(!queue.isEmpty() && queue.getLast() == ' ') queue.removeLast();
        while(!queue.isEmpty()) sb.append(queue.removeFirst());
        return sb.toString();
    }
}
