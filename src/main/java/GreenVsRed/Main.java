package main.java.GreenVsRed;

import main.java.GreenVsRed.Exceptions.ArrayIndexOutOfBoundsException;
import main.java.GreenVsRed.Exceptions.InputMismatchException;
import main.java.GreenVsRed.Exceptions.InvalidNumberException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        GreenVsRed simulate = null;
        int xWidth = 0;
        int yHeight = 0;

        try {
            int[] dimension = mapInput(scanner, ",", 2);

            xWidth = dimension[0];
            yHeight = dimension[1];

            if (xWidth < 1 || xWidth > 9) {
                throw new InvalidNumberException("Each cell can be surrounded by up to 8 cells 4 on the sides and 4 on the comers.\nExceptions are the corners and the side of the grid.");
            }
            if (yHeight < 1 || yHeight > 9) {
                throw new InvalidNumberException("Each cell can be surrounded by up to 8 cells 4 on the sides and 4 on the comers.\nExceptions are the corners and the side of the grid.");
            }

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
        } catch (ArrayIndexOutOfBoundsException | IOException e){
            System.out.println(e.getMessage());
        }

        try {

            int[] coordNumbStr = mapInput(scanner, ",", 3);

            if (coordNumbStr[0] < 0 || coordNumbStr[0] > xWidth) {
                throw new InvalidNumberException("Each cell can be surrounded by up to 8 cells 4 on the sides and 4 on the comers.\nExceptions are the corners and the side of the grid.");
            }

            if (coordNumbStr[1] < 0 || coordNumbStr[1] > yHeight) {
                throw new InvalidNumberException("Each cell can be surrounded by up to 8 cells 4 on the sides and 4 on the comers.\nExceptions are the corners and the side of the grid.");
            }

            assert simulate != null;
            simulate.wantedX = coordNumbStr[0];
            simulate.wantedY = coordNumbStr[1];
            int turns = coordNumbStr[2];

            simulate.turnExact(turns);
            System.out.println(simulate.getBeenGreen());
        } catch (NumberFormatException ex) {
            System.out.println("Input must contain only numbers separated by coma.");
            System.out.println("Exception is caused " + ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException | InvalidNumberException e) {
            System.out.println(e.getMessage());
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