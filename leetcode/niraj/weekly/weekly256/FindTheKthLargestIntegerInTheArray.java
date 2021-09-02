package weekly.weekly256;

import java.math.BigInteger;
import java.util.*;

/**
 * Created on:  Aug 28, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-256/problems/find-the-kth-largest-integer-in-the-array/
 */
public class FindTheKthLargestIntegerInTheArray {
    public static void main(String[] args) {
        compare("423","521");
        System.out.println(kthLargestNumber(new String[]{"3", "6", "7", "10"}, 4) + " = 3");
        System.out.println(kthLargestNumber(new String[]{"2","21","12","1"}, 3) + " = 2");
        System.out.println(kthLargestNumber(new String[]{"423","521","2","42"}, 2) + " = 423");
    }

    public static String kthLargestNumber(String[] nums, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : nums) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        LinkedList<String> pq = new LinkedList<>();
        for (String key : map.keySet()) {
            pq.add(key);
        }
        Collections.sort(pq, (s1, s2) -> compare(s1, s2));
        String top = pq.poll();
        k -= map.get(top);
        while (k > 0 && !pq.isEmpty()) {
            top = pq.poll();
            k -= map.get(top);
        }
        return top;
    }

    private static int compare(String s1, String s2) {
        int i1 = 0, i2 = 0, l1 = s1.length(), l2 = s2.length();
        if(l1 < l2) return 1;
        if(l1 >  l2) return -1;
        while(i1 < l1 && i2 < l2){
            char c1 = s1.charAt(i1++), c2 = s2.charAt(i2++);
            if(c1 > c2) return -1;
            else if(c1 < c2) return 1;
        }
//        Only one string will have the value.
        if(i1 < l1) return -1;
        return 1;
    }
}
