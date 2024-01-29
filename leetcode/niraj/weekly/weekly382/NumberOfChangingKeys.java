package weekly.weekly382;

/**
 * Created on:  January 27, 2024, 9:30 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-382">NumberOfChangingKeys</a>
 */

public class NumberOfChangingKeys {

    public static void main(String[] args) {
        System.out.println(countKeyChanges("AaAaAaaA"));
    }

    public static int countKeyChanges(String s) {
        int change = 0;
        char preKey = ' ';
        for (char c : s.toCharArray()) {
            char current = Character.toLowerCase(c);
            if (preKey != ' ' && preKey != current) {
                change++;
            }
            preKey = current;
        }
        return change;
    }

}
