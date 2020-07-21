package main.java.GreenVsRed;

import main.java.GreenVsRed.Exceptions.ArrayIndexOutOfBoundsException;
import main.java.GreenVsRed.Exceptions.InvalidNumberException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GreenVsRed simulate = null;
        int xWidth = 0;
        int yHeight = 0;

        try {
            int[] dimension = mapInput(scanner, ",", 2);

            xWidth = dimension[0];
            yHeight = dimension[1];

            isInScope(xWidth, yHeight, 1, 9, yHeight > 9);

            simulate = new GreenVsRed(xWidth, yHeight);
        } catch (NumberFormatException ex) {
            System.out.println("Input must contain only numbers separated by coma.");
            System.out.println("Exception is caused " + ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException | InvalidNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            for (int i = 0; i < xWidth; i++) {
                int[] stringLine = mapInput(scanner, "", xWidth);

                for (int j = 0; j < yHeight; j++) {
                    if (stringLine[i] < 0 || stringLine[i] > 1) {
                        throw new IOException("Cells can contain only numbers 1 or 0.");
                    }

                    if (simulate != null) {
                        if (stringLine[i] == 1) {
                            simulate.setGreen(i, j);
                        } else {
                            simulate.setRed(i, j);
                        }
                    }
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Input must contain only numbers.");
            System.out.println("Exception is caused " + ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            int[] coordNumbStr = mapInput(scanner, ",", 3);

            isInScope(coordNumbStr[0], coordNumbStr[1], 0, xWidth, coordNumbStr[1] > yHeight);

            assert simulate != null;
            simulate.wantedX = coordNumbStr[0];
            simulate.wantedY = coordNumbStr[1];
            int turns = coordNumbStr[2];

            simulate.turnExact(turns);
            simulate.printNumberTimesCellBeenGreen();
        } catch (NumberFormatException ex) {
            System.out.println("Input must contain only numbers separated by coma.");
            System.out.println("Exception is caused " + ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException | InvalidNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void isInScope(int param1, int param2, int underScopeVal, int overScopeVal, boolean customBoolean) throws InvalidNumberException {
        if (param1 < underScopeVal || param1 > overScopeVal) {
            throw new InvalidNumberException("Each cell can be surrounded by up to 8 cells 4 on the sides and 4 on the comers.\nExceptions are the corners and the side of the grid.");
        }
        if (param2 < underScopeVal || customBoolean) {
            throw new InvalidNumberException("Each cell can be surrounded by up to 8 cells 4 on the sides and 4 on the comers.\nExceptions are the corners and the side of the grid.");
        }
    }

    private static int[] mapInput(Scanner scanner, String separator, int arrayLength) throws ArrayIndexOutOfBoundsException {
        int[] coordNumbStr = Arrays.stream(scanner.nextLine().split(separator))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (coordNumbStr.length != arrayLength) {
            throw new ArrayIndexOutOfBoundsException(String.format("Please provide %s numbers separated by coma.\nPress Enter to exit.", arrayLength));
        }
        return coordNumbStr;
    }
}