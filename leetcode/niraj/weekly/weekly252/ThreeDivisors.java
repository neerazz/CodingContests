package weekly.weekly252;

/**
 * Created on:  Jul 31, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-252/problems/three-divisors/
 */
public class ThreeDivisors {
    public static void main(String[] args) {

    }
    public boolean isThree(int n) {
        int count = 0;
        for(int i=1; i<=n; i++){
            count += (n%i ==0) ? 1 : 0;
            if(count >3) break;
        }
        return count == 3;
    }
}
