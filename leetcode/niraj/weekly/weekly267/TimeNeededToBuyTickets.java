package weekly.weekly267;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Sep 25, 2021
 * Ref:
 */

public class TimeNeededToBuyTickets {
    public static void main(String[] args) {

    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.add(new int[]{i, tickets[i]});
        }
        int cur = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[1] == 1) {
//                Is end of this person.
                if (poll[0] == k) return cur;
            } else {
                poll[1]--;
                queue.add(poll);
            }
            cur++;
        }
        return cur;
    }
}
