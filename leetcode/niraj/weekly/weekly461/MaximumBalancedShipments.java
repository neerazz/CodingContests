package weekly.weekly461;


/**
 * @author :  bnira
 * Created :  8/2/2025
 * Problem : https://leetcode.com/contest/weekly-contest-461/problems/maximum-balanced-shipments/description/
 */

public class MaximumBalancedShipments {


    public static void main(String[] args) {
        MaximumBalancedShipments sol = new MaximumBalancedShipments();
        sol.maxBalancedShipments(new int[]{750, 148});
    }

    public int maxBalancedShipments(int[] weight) {
        int max = Integer.MIN_VALUE;
        int count = 0, len = weight.length;
        for (int i = 0; i < len; i++) {
            int cur = weight[i];
            if (max == Integer.MIN_VALUE) {
                max = cur;
            } else if (cur < max) {
//                This can be the end of a shipment
                max = Integer.MIN_VALUE;
                count++;
            } else {
                max = Math.max(max, cur);
            }
        }
        return count;
    }

}
