package contest1592;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class HemoseShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt(), x = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(swapPossible(n, nums, x) ? "YES" : "NO");
        }
    }

    // https://www.youtube.com/watch?v=arGqWuFSRP0
    private static boolean swapPossible(int n, int[] nums, int x) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
//        Swap is not possible between those indices.
        for (int i = n-x; i < x; i++) {
//            Tht numbers should be already in non-increasing order else it is not possible.
            if (clone[i] != nums[i]) return false;
        }
        return true;
    }
}
