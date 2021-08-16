package weekly.weekly254;

/**
 * Created on:  Aug 15, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-254/problems/minimum-non-zero-product-of-the-array-elements/
 */
public class MinimumNonZeroProductOfTheArrayElements {
    public static void main(String[] args) {

    }

    /*
    f(0) = 0
    f(1) = [1,0] - [0]
    f(2) = 1 * [1,0], 0 * [1,0] = [11,10,01,00] - [00] = [11,10,01]
    f(3) = 1 * [11,10,01,00], 0 * [11,10,01,00] = [111,110,101,100,011,010,001] =>
            [111,110,101,100,011,010,001]
            [111,110,110,100,011,001,001] => (101,010) -> (110,001)
            [111,110,110,110,001,001,001] => (100,011) -> (110,001)
            [111,3*110,3*001]

    f(4) = 1 * [111,110,110,110,001,001,001,000] + 0 * [111,110,110,110,001,001,001,000] - [0000]
         = [1111, 1110,1110,1110,1001, 1001,1001,1000, 0111, 0110,0110,0110,0001,0001,0001]
         [1111, 3 * 1110, 3 * 1001, 1000, 3 * 0111, 3 * 0110,0001] => 3 * (1001, 0110) -> (1000,0111)
         [1111, 3 * 1110, 3 * 1000, 1000, 3 * 0111, 3 * 0111,0001]
         [1111, 3 * 1110, 4 * 1000, 6 * 0111 ,0001]

    If you have n = 4. It means 2^4 = 32.
    The largest mx value is 31.
    The left numbers sm value is 30 (1110).
    Since you can swap bits between the numbers and in total get fifteen 1 and fifteen 30 numbers multiplied by mx 31.

    f(n) = 1*10 + f(n-1) + f(n-1)
        1* 10^j + f(n-j) - 0*n , where j = 0,n-1

Sol: https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/discuss/1404496/Detailed-Explanation-of-the-Greedy-Approach
https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/discuss/1404022/Java-Clean-and-Concise.-Recursive-multiplication
*/
    static long mod = 1_000_000_007;

    public static int minNonZeroProduct(int p) {
        if (p == 1) return 1;

        long mx = (long) (Math.pow(2, p)) - 1;
        long sm = mx - 1;
        long n = sm / 2;
        long sum = rec(sm, n);
        return (int) (sum * (mx % mod) % mod);
    }

    public static long rec(long val, long n) {
        if (n == 0) return 1;
        if (n == 1) return (val % mod);
        long newVal = ((val % mod) * (val % mod)) % mod;
        if (n % 2 != 0) {
            return ((rec(newVal, n / 2) % mod) * (val % mod)) % mod;
        }
        return rec(newVal, n / 2) % mod;
    }
}
