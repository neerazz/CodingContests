package weekly.weekly269;

import java.util.*;

/**
 * Created on:  Nov 27, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-269/problems/find-all-people-with-secret/
 */

public class FindAllPeopleWithSecret {

    public static void main(String[] args) {
        System.out.println(findAllPeople_wrong(6, new int[][]{{0, 2, 1}, {1, 3, 1}, {4, 5, 1}}, 1));
        System.out.println(findAllPeople_wrong(5, new int[][]{{3, 4, 2}, {1, 2, 1}, {2, 3, 1}}, 1));
    }

    public static List<Integer> findAllPeople_wrong(int n, int[][] meetings, int firstPerson) {
        Set<Integer> known = new HashSet<>(Arrays.asList(0, firstPerson));
        TreeMap<Integer, Map<Integer, Set<Integer>>> times = new TreeMap<>();
        for (int[] meeting : meetings) {
            int a = meeting[0], b = meeting[1], time = meeting[2];
            times.putIfAbsent(time, new HashMap<>());
            Map<Integer, Set<Integer>> current = times.get(time);
            current.putIfAbsent(a, new HashSet<>());
            current.putIfAbsent(b, new HashSet<>());
            current.get(a).add(b);
            current.get(b).add(a);
        }
        for (Map<Integer, Set<Integer>> peoples : times.values()) {
//            Loop through all the people who know the secret.
            Set<Integer> currentKnown = new HashSet<>();
            for (int p : known) {
                currentKnown.addAll(peoples.getOrDefault(p, new HashSet<>()));
            }
            for (int p : currentKnown) {
                known.addAll(peoples.getOrDefault(p, new HashSet<>()));
            }
            known.addAll(currentKnown);
            if (peoples.size() == n) break;
        }
        return new ArrayList<>(known);
    }

}
