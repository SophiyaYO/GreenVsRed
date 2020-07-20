package main.java.GreenVsRed;

import java.util.Arrays;
import java.util.Scanner;

public class GreenVsRed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int width = dimension[0];
        int height = dimension[1];

        int[][] initialBoard = new int[height][width];

        for (int i = 0; i < height ; i++) {
            int[] stringLine = Arrays.stream(scanner.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (width >= 0) {
                System.arraycopy(stringLine, 0, initialBoard[i], 0, width);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(initialBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
