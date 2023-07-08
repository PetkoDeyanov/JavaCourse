package Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //LongestBlockInString 100/100
        Scanner sc = new Scanner(System.in);
        String argument = sc.nextLine();
        char[] array = argument.toCharArray();


        if (array.length > 1) {
            char result = array[0];
            int countMax = 0;
            int sequenceLength = 1;
            int previous = array[0];
            for (int i = 1; i < array.length; i++) {
                if (previous == array[i]) {
                    sequenceLength++;
                    if (countMax < sequenceLength) {
                        countMax = sequenceLength;
                        result = array[i];
                    }
                }
                if (previous != array[i]) {
                    sequenceLength = 1;
                }
                previous = array[i];
            }
            if (countMax < 1) {
                System.out.print(result);
            }
            else {
                for (int i = 0; i < countMax; i++) {
                    System.out.print(result);
                }
            }
        } else if (array.length == 1) System.out.println(array[0]);

    }
}
