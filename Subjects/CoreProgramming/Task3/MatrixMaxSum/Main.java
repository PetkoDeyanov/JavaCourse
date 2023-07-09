package Task3.MatrixMaxSum;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //MatrixMaxSum
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        int cols = input.length;
        int[][] matrix = new int[rows][];
        int maxSum = Integer.MIN_VALUE, currentSum = 0;


        for (int i = 0; i < rows; i++) {
           matrix[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
            input = sc.nextLine().split(" ");
        }

        //input = sc.nextLine().split(" ");
        ArrayList<Integer> coordinates = new ArrayList<>();
        for (String s : input) {
            coordinates.add(Integer.parseInt(s));
        }

        int step;
        int colIndex;
        int col;
        int rowIndex;
        int row;
        while (!coordinates.isEmpty()) {
            colIndex = Math.abs(coordinates.get(1)) - 1;
            col = Math.abs(coordinates.get(1))-1;
            rowIndex = Math.abs(coordinates.get(0)) - 1;
            row = Math.abs(coordinates.get(0)) - 1;
            if (coordinates.get(0) < 0) step = 1;
            else step = -1;
            while (colIndex < cols && colIndex >= 0) {
                currentSum += matrix[row][colIndex];
                colIndex += step;
            }

            if (coordinates.get(1) < 0) step = 1;
            else step = -1;

            rowIndex += step;
            while (rowIndex < rows && rowIndex >= 0) {
                currentSum += matrix[rowIndex][col];
                rowIndex += step;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            currentSum = 0;

            coordinates.remove(0);
            coordinates.remove(0);
        }
        System.out.println(maxSum);
    }

}
