package Task3.SpiralMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        matrix[0][0] = 1;

        for (int i = 0; i < 1; i++) {

            for (int j = 1; j < size; j++) {
                matrix[i][j] = matrix[i][j - 1] + 1;
            }

        }

        printMatrix(matrix, size);
    }

    private static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
