package weekly.weekly262;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Oct 03, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-262/problems/two-out-of-three/
 */
public class TwoOutOfThree {
    public static void main(String[] args) {

    }
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int num: nums1){
            map.computeIfAbsent(num, val -> new HashSet<>()).add(1);
        }
        for(int num: nums2){
            map.computeIfAbsent(num, val -> new HashSet<>()).add(2);
        }
        for(int num: nums3){
            map.computeIfAbsent(num, val -> new HashSet<>()).add(3);
        }
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() >= 2)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}
