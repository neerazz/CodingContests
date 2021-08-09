package weekly.weekly253;

/**
 * Created on:  Aug 08, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-253/problems/check-if-string-is-a-prefix-of-array/
 */
public class CheckIfStringIsAPrefixOfArray {
    public static void main(String[] args) {

    }

    public static boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for(String word: words){
            sb.append(word);
            if(sb.toString().equals(s)) return true;
            if(sb.toString().length() > s.length()) break;
        }
        return false;
    }
}
