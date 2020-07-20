package main.java.GreenVsRed;

import java.util.Arrays;
import java.util.Scanner;

public class GreenVsRed {

    int width;
    int height;
    int wantedX;
    int wantedY;
    int[][] board;

    public GreenVsRed(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public void setWantedX(int x) {
        this.wantedX = x;
    }

    public void setWantedY(int y) {
        this.wantedY = y;
    }

    public void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setGreen(int x, int y) {
        this.board[x][y] = 1;
    }

    public void setRed(int x, int y) {
        this.board[x][y] = 0;
    }

    public int countGreenNeighbours(int x, int y) {
        int count = 0;

        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        return count;
    }

    public int getState(int x, int y) {
        if (x < 0 || x >= width) {
            return 0;
        }

        if (y < 0 || y >= height) {
            return 0;
        }

        return this.board[x][y];
    }


    public int timesBeenGreen(int x, int y) {
        int count = 0;
        count ++;

        return count;
    }

    public void turn() {
        int[][] newBoard = new int[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int greenNeighbours = countGreenNeighbours(i, j);


                if (getState(i, j) == 1) {
                    if (greenNeighbours != 2 && greenNeighbours != 3 && greenNeighbours != 6) {
                        newBoard[i][j] = 0;
                    }
                } else {
                    if (greenNeighbours == 3 || greenNeighbours == 6) {
                        newBoard[i][j] = 1;
                    }
                }
            }

        }
        this.board = newBoard;
    }

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

        int xCoordCheck = coordNumbStr[0];
        int yCoordCheck = coordNumbStr[1];
        int turns = coordNumbStr[2];

        for (int i = 0; i < turns; i++) {

        }

    }
}
