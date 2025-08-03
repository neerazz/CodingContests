package weekly.weekly461;


import java.util.ArrayList;
import java.util.List;

/**
 * @author :  bnira
 * Created :  8/2/2025
 * Problem : https://leetcode.com/contest/weekly-contest-461/problems/trionic-array-i/description/
 */

public class TrionicArrayI {


    public static void main(String[] args) {
        TrionicArrayI sol = new TrionicArrayI();
    }

    public boolean isTrionic(int[] nums) {
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>();
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > pre) {
                if (a.isEmpty() || b.isEmpty()) {
                    a.add(cur);
                }
                if (!b.isEmpty()) {
                    c.add(cur);
                }
            } else if (pre == cur) {
                return false;
            } else {
                if (a.isEmpty()) return false;
//                This will be the forth sequence
                if (!c.isEmpty()) return false;
                b.add(cur);
            }
            pre = cur;
        }
        return !a.isEmpty() && !b.isEmpty() && !c.isEmpty();
    }

}
