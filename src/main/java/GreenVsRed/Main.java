package main.java.GreenVsRed;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dimension = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int xWidth = dimension[0];
        int yHeight = dimension[1];

        GreenVsRed simulate = new GreenVsRed(xWidth, yHeight);

        for (int i = 0; i < xWidth; i++) {
            int[] stringLine = Arrays.stream(scanner.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < yHeight; j++) {
                if (stringLine[i] == 1) {
                    simulate.setGreen(i, j);
                } else {
                    simulate.setRed(i, j);
                }
            }
        }

        int[] coordNumbStr = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        scanner.close();

        simulate.wantedX = coordNumbStr[0];
        simulate.wantedY = coordNumbStr[1];
        int turns = coordNumbStr[2];

        simulate.turnExact(turns);
        System.out.println(simulate.getBeenGreen());

    }
}
