package biweekly.biweekly62;

/**
 * Created on:  Oct 02, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-62/problems/maximize-the-confusion-of-an-exam/
 */

public class MaximizeTheConfusionOfAnExam {

    public static void main(String[] args) {

    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int p1 =0, p2 =0, len = answerKey.length();
        int tcount = 0, fcount =0, max =0;
        while(p2 < len){
            char cur = answerKey.charAt(p2);
            if(cur == 'T') tcount++;
            if(cur == 'F') fcount++;
            if(tcount <= k || fcount <= k){
                max = Math.max(max, p2-p1+1);
            }
            if(tcount > k && fcount>k){
//                Reduce the slide size, when both the chars count have the allowed length.
                cur = answerKey.charAt(p1++);
                if(cur == 'T') tcount--;
                else if(cur == 'F') fcount--;
            }
            p2++;
        }
        return max;
    }
}
