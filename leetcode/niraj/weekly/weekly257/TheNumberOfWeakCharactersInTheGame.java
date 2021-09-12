package weekly.weekly257;

import java.util.*;

/**
 * Created on:  Sep 12, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-257/problems/the-number-of-weak-characters-in-the-game/
 */
public class TheNumberOfWeakCharactersInTheGame {
    public static void main(String[] args) {

    }
    public int numberOfWeakCharacters(int[][] properties) {
//         Sort base on the attack first and when they are same then sort based on the decending order of defence
        Arrays.sort(properties, (p1,p2) -> p1[0] == p2[0] ? Integer.compare(p2[1], p1[1]) : Integer.compare(p1[0],p2[0]));
        int count =0, len = properties.length;
//         Now compare the last before element defence.
        int max = properties[len-1][1];
        for(int i=len-2; i>=0; i--){
//             Since array is sorted based on the attack, you know what the attack of the ith element is less then the max element
//             So just compare the defence
            if(max > properties[i][1]){
                count++;
//                 Then this is a valid condition.
            }else{
//                 Update the max, you have found a new devence that is heigher then max.
                max = properties[i][1];
            }
        }
        return count;
    }
}
