package weekly.weekly255;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Aug 21, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-255/problems/find-unique-binary-string/
 */
public class FindUniqueBinaryString {
    public static void main(String[] args) {

    }

    static String result;
    public String findDifferentBinaryString(String[] nums) {
        result = null;
        int len = 0;
        Set<String> set = new HashSet<>();
        for(String str: nums){
            set.add(str);
            len = str.length();
        }
        dfs("", 0 , len, set);
        return result;
    }

    void dfs(String sofar, int i, int len, Set<String> set){
        if(result != null) return;
        if(i == len){
            if(set.contains(sofar)) return;
            result = sofar;
        }else{
            dfs(sofar+"0", i+1, len, set);
            dfs(sofar+"1", i+1, len, set);
        }
    }
}
