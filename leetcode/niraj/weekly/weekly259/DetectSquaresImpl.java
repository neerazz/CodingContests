package weekly.weekly259;

/**
 * Created on:  Sep 18, 2021
 * Ref:
 */
public class DetectSquaresImpl {
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}) + " = 1");
        System.out.println(detectSquares.count(new int[]{14, 8}) + " = 0");
        detectSquares.add(new int[]{11, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}) + " = 2");
    }

    static class DetectSquares {
        int[][] data;

        public DetectSquares() {
            data = new int[1001][1001];
        }

        public void add(int[] point) {
            int x = point[0], y = point[1];
            data[x][y]++;
        }


        public int count(int[] point) {
            int a = point[0], b = point[1];
            int count = 0;
            for (int i = 1; i <= 1000; i++) {
//                If the given point is considered as top left point
                if (isValid(a - 1, b) && isValid(a, b + i) && isValid(a - i, b + i)) {
                    count += (data[a - 1][b] * data[a][b + i] * data[a - 1][b + 1]);
                }
//                If the given point is considered as top right point
                if (isValid(a, b - i) && isValid(a - i, b - i) && isValid(a - i, b)) {
                    count += (data[a][b - i] * data[a - i][b - i] * data[a - i][b]);
                }
//                If the given point is considered as bottom left
                if (isValid(a, b + i) && isValid(a + i, b + i) && isValid(a + i, b)) {
                    count += (data[a][b + 1] * data[a + i][b + i] * data[a + i][b]);
                }
//                If the given point is considered as bottom right
                if (isValid(a + i, b) && isValid(a + i, b - i) && isValid(a, b - i)) {
                    count += (data[a + i][b] * data[a + i][b - i] * data[a][b - i]);
                }
            }
            return count;
        }

        boolean isValid(int x, int y) {
            return x >= 0 && x <= 1000 && y >= 0 && y <= 1000;
        }
    }
}
