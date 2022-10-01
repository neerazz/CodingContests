package weekly.weekly291;

import java.util.*;
import java.io.*;

/**
 * Created on:  August 29, 2022, 5:07 PM
 * Ref: https://leetcode.com/contest/weekly-contest-291
 */

public class RemoveDigitFromNumberToMaximizeResult {

    public static void main(String[] args) {

    }

    public static String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        int i = number.length() - 1;
        while (i >= 0) {
            char c = number.charAt(i--);
            if (!found && c == digit) {
                found = true;
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

}
