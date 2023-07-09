package Task3.ZigZag2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        long sum = 0;
        long value;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i + j) % 2 == 0) {
                    value = ((i + j) * 3L) + 1;
                    sum += value;
                    if (!isCornenr(rows, cols, i, j)) {
                        sum += value;
                    }
                }
            }
        }

        System.out.println(sum);
    }

    private static boolean isCornenr(int rows, int cols, int i, int j) {
        return i == 0 || j == 0 || i == rows - 1 || j == cols - 1;
    }
}