package weekly.weekly254;

/**
 * Created on:  Aug 15, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-254/problems/number-of-strings-that-appear-as-substrings-in-word/
 */
public class NumberOfStringsThatAppearAsSubstringsInWord {
    public static void main(String[] args) {

    }
    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String pat: patterns){
            if(word.contains(pat)) count++;
        }
        return count;
    }
}
