package contest1592;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GamerHemose {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt(), h = sc.nextInt();
            int top1 = 0, top2 = 0;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (num > top1) {
                    top2 = top1;
                    top1 = num;
                } else if (num > top2) {
                    top2 = num;
                }
            }
            int count = 0;
            if(h >= top1 + top2){
                int times = h / (top1 + top2);
                count += 2 * times;
                h -= times * (top1 + top2);
            }
            int top = 0;
            while (h > 0) {
                h -= top == 0 ? top1 : top2;
                top ^= 1;
                count++;
            }
            System.out.println(count);
        }
    }
}
