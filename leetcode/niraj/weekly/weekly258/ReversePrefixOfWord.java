package weekly.weekly258;

import java.util.*;

/**
 * Created on:  Sep 11, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-258/problems/reverse-prefix-of-word/
 */
public class ReversePrefixOfWord {
    public static void main(String[] args) {

    }
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(index == -1) return word;
        StringBuilder sb = new StringBuilder();
        int i = index+1;
        while(index>=0){
            sb.append(word.charAt(index--));
        }
        while(i <word.length()){
            sb.append(word.charAt(i++));
        }
        return sb.toString();
    }
}
