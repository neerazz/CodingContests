package weekly.weekly255;

/**
 * Created on:  Aug 21, 2021
 * Ref : n
 */
public class FindGreatestCommonDivisorOfArray {
    public static void main(String[] args) {

    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer. MIN_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return gcd(min, max);
    }
    int gcd(int a, int b){
        if (b == 0) return 1;
        if (a == 0) return 1;
        int rem = a % b;
        if (rem == 0) {
            return b;
        }
        return gcd(b, rem);
    }
}
