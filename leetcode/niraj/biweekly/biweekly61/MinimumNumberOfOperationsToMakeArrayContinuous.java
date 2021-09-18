package biweekly.biweekly61;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  Sep 18, 2021
 * Ref:
 */
public class MinimumNumberOfOperationsToMakeArrayContinuous {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{8, 5, 9, 9, 8, 4}));
    }

    public static int minOperations(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().distinct().sorted().collect(Collectors.toList());
        int len = collect.size();
        int min = len, last = 0;
        for (int i = 0; i < len; i++) {
//            If nums[i], is the starting number then find the last number that in the array.
            while (last < len && collect.get(last) == len + collect.get(i) - 1) last++;
//            The length of this subarray is `last - i`. We need to replace `len - last + i` elements to make it continuous.
            min = Math.min(min, len - (last - i));
        }
        return min;
    }
}
