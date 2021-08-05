package weekly.weekly252;

/**
 * Created on:  Jul 31, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-252/problems/minimum-garden-perimeter-to-collect-enough-apples/
 */
public class MinimumGardenPerimeterToCollectEnoughApples {
    public static void main(String[] args) {
        System.out.println(minimumPerimeter(13));
        System.out.println(minimumPerimeter(1000000000));
        System.out.println(minimumPerimeter(Long.parseLong("350551360251708")));
    }

    public static long minimumPerimeter(long neededApples) {
        long size = 1, total = 0;
        while (total < neededApples) {
            long corners = 4 * (size + size);
            long center = 4 * size;
            long mid = 0;
            for (long i = 1; i < size; i++) {
                mid += 8 * (size + i);
            }
            total += corners + center + mid;
            if(total >= neededApples) return 8 * size;
            size++;
        }
        return -1;
    }
}
