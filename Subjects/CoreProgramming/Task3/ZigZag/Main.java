package Task3.ZigZag;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        long[][] matrix = new long[rows][cols];
        matrix[0][0] = 1;
        //creating matrix n= (n-1) + 3
        for (int i = 0; i < rows; i++) {
            if (i > 0) matrix[i][0] = matrix[i - 1][0] + 3;
            for (int j = 1; j < cols; j++) {
                matrix[i][j] = matrix[i][j - 1] + 3;
            }
        }

        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t |");
            }
            System.out.println();
        }
*/
        int colIndex = 0,
                rowIndex = 0,
                stepRow = 1;
        long sum = 0;
        while (rowIndex < rows) {
            if (colIndex < 0) colIndex = 1;
            //if (colIndex >= cols) colIndex = cols - 2;

            while (colIndex < cols) {
                if (rowIndex == rows) break;

                sum += matrix[rowIndex][colIndex];
                colIndex++;
                rowIndex += stepRow;
                stepRow *= -1;
            }
            colIndex -= 2;
            rowIndex += 2;
            stepRow *= -1;
            //  if (rows % 2 == 0 && rowIndex + 2 == rows) break;
            while (colIndex >= 0 && rowIndex < rows) {
                sum += matrix[rowIndex][colIndex];
                colIndex--;
                rowIndex += stepRow;
                stepRow *= -1;
            }


            rowIndex += 2;
            stepRow *= -1;
            //if (rows % 2 == 1 && rowIndex - 1 == rows - 1 && colIndex < 1) break;

        }
        System.out.println(sum);
    }
}