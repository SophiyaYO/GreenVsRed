package main.java.GreenVsRed;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GreenVsRed simulate = null;
        int xWidth = 0;
        int yHeight = 0;

        try {
            int[] dimension = Arrays.stream(scanner.nextLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (dimension.length != 2) {
                System.out.println("Board must be initialized as 2D grid.");
                throw new ArrayIndexOutOfBoundsException();
            }

            xWidth = dimension[0];
            yHeight = dimension[1];

            simulate = new GreenVsRed(xWidth, yHeight);
        } catch (InputMismatchException exception) {
            System.out.println("Not an integer, please try again. Press enter key to exit");

        } catch (NumberFormatException ex) {
            System.out.println("Input must contain only numbers separated by coma.");
            System.out.println("Exception is caused " + ex.getMessage());
        }

        try {
            for (int i = 0; i < xWidth; i++) {
                int[] stringLine = Arrays.stream(scanner.nextLine().split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                for (int j = 0; j < yHeight; j++) {
                    if (stringLine[i] < 0 || stringLine[i] > 1) {
                        throw new IOException();
                    }

                    if (stringLine[i] == 1) {
                        simulate.setGreen(i, j);
                    } else {
                        simulate.setRed(i, j);
                    }
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Not an integer, please try again. Press enter key to exit");
//
        } catch (NumberFormatException ex) {
            System.out.println("Input must contain only numbers.");
            System.out.println("Exception is caused " + ex.getMessage());
        } catch (IOException e) {
            System.out.println("Cells can contain only numbers 1 or 0.");
            e.printStackTrace();
        }

        try {
            int[] coordNumbStr = Arrays.stream(scanner.nextLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            assert simulate != null;
            simulate.wantedX = coordNumbStr[0];
            simulate.wantedY = coordNumbStr[1];
            int turns = coordNumbStr[2];

            simulate.turnExact(turns);
            System.out.println(simulate.getBeenGreen());
        } catch (InputMismatchException exception) {
            System.out.println("Not an integer, please try again. Press enter key to exit");
        } catch (NumberFormatException ex) {
            System.out.println("Input must contain only numbers separated by coma.");
            System.out.println("Exception is caused " + ex.getMessage());
        }

    }
}