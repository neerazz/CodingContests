package weekly.weekly261;

/**
 * Created on:  Oct 03, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-261/problems/minimum-moves-to-convert-string/
 */

public class MinimumMovesToConvertString {

    public static void main(String[] args) {

    }

    public static int minimumMoves(String s) {
        int p1 =0, xs =0, total =0, len = s.length();
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(c == 'X'){
                if(xs == 0) p1 =i;
                xs++;
            }
            if(i-p1+1 == 3){
                if(xs > 0) total++;
                xs = 0;
                p1=i+1;
            }
        }
        if(xs > 0) total++;
        return total;
    }
}
