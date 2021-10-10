package weekly.weekly262;

import java.util.*;

/**
 * Created on:  Oct 03, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-262/problems/stock-price-fluctuation/
 */

public class StockPriceFluctuation {

    static class StockPrice {

        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> stack = new TreeSet<>();
        TreeMap<Integer, Integer> values = new TreeMap<>();

        public void update(int timestamp, int price) {
            boolean update = map.containsKey(timestamp);
            if (update) {
                //update existing, so remove it from the
                int preval = map.get(timestamp);
                remove(preval);
            }
            // add the new value
            map.put(timestamp, price);
            add(price);
            if (!update) stack.add(timestamp);
        }

        void add(int val) {
            values.put(val, values.getOrDefault(val, 0) + 1);
        }

        void remove(int val) {
            int occ = values.remove(val);
            if (occ > 1) {
                values.put(val, occ - 1);
            }
        }

        public int current() {
            int preTime = stack.last();
            return map.get(preTime);
        }

        public int maximum() {
            return values.lastKey();
        }

        public int minimum() {
            return values.firstKey();
        }
    }
}
