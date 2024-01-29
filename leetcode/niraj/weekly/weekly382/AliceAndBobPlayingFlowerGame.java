package weekly.weekly382;

/**
 * Created on:  January 27, 2024, 9:30 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-382">AliceAndBobPlayingFlowerGame</a>
 */

public class AliceAndBobPlayingFlowerGame {

    public static void main(String[] args) {
        System.out.println(flowerGame(3, 2) + " = 3");
        System.out.println(flowerGame(1, 1) + " = 0");
        System.out.println(flowerGame(1, 5) + " = 2");
        System.out.println(flowerGame(5, 5) + " = 12");
    }

    public static long flowerGame(int n, int m) {
        if (n == 1 && m == 1) return 0;
//        long count = 0;
//        for (int x = 1; x <= n; x++) {
//            for (int y = 1; y <= m; y++) {
//                if ((x + y) % 2 == 1) {
//                    count++;
//                }
//            }
//        }
//        return count;
        long count = 0;
        for (int x = 1; x <= n; x++) {
            count += (x % 2 == 0) ? (m + 1) / 2 : m / 2;
        }
        return count;
    }

}
