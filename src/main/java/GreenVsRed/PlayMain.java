package GreenVsRed;

import java.util.Arrays;
import java.util.Scanner;

public class PlayMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int[] dimension = Arrays.stream(scanner.nextLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int xWidth = dimension[0];
            int yHeight = dimension[1];

            Game game = new Game(xWidth,yHeight);

            for (int i = 0; i < xWidth; i++) {
                int[] stringLine = Arrays.stream(scanner.nextLine().split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                for (int j = 0; j < yHeight; j++) {
                    game.initialFill(i,j,stringLine[i]);
                }
            }

            int[] coordNumbStr = Arrays.stream(scanner.nextLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int turns = coordNumbStr[2];
            game.play(coordNumbStr[0], coordNumbStr[1], turns);

            scanner.close();
        } catch (Exception e){
            System.out.println("Check your input and try again.");
        }



    }
}
