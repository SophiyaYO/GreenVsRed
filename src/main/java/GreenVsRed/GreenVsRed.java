package main.java.GreenVsRed;

public class GreenVsRed {

    private int width;
    private int height;
    protected int wantedX;
    protected int wantedY;
    private int beenGreen;
    private int[][] board;

    protected GreenVsRed(int width, int height) {
        this.width = width;
        this.height = height;
        this.beenGreen = 0;
        this.board = new int[width][height];
    }

    private int getWantedX() {
        return this.wantedX;
    }

    private int getWantedY() {
        return this.wantedY;
    }

    /**
     * the board can be printed with  this method by removing the comments
     * protected void printBoard() {
     * for (int i = 0; i < height; i++) {
     * for (int j = 0; j < width; j++) {
     * System.out.print(board[i][j] + " ");
     * }
     * System.out.println();
     * }
     * }
     **/

    protected void setGreen(int x, int y) {//using it you can initialize cell to green (green='1')
        this.board[x][y] = 1;
    }

    protected void setRed(int x, int y) {//using it you can initialize cell to red (green='0')
        this.board[x][y] = 0;
    }

    /**
     * checking surrounding cells for green (1) and returning the sum
     * getState will make sure it does not go out of the board
     */
    private int countGreenNeighbours(int x, int y) {
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

    //checking every surrounding cell value (if it is on the board)
    private int getState(int x, int y) {
        if (x < 0 || x >= width) {//out of horizontal board scope- adding Zero
            return 0;
        }

        if (y < 0 || y >= height) {//out of vertical board scope- adding Zero
            return 0;
        }

        return this.board[x][y];//getting the value of the cell
    }

    private void timesBeenGreen() {
        this.beenGreen++;
    }

    private int getBeenGreen() {
        return this.beenGreen;
    }

    //Loop for exact turns of the board
    //turns are the last input data
    protected void turnExact(int turns) {
        for (int i = 0; i < turns; i++) {
            turn();
        }
    }

    //method and action of turning
    private void turn() {
        int[][] newBoard = new int[width][height];

        if (this.board[getWantedX()][getWantedY()] == 1) {
            timesBeenGreen();
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int greenNeighbours = countGreenNeighbours(i, j);

                if (getState(i, j) == 1) {
                    if (greenNeighbours < 2) {
                        newBoard[i][j] = 0;
                    } else if (greenNeighbours > 3 && greenNeighbours < 6) {
                        newBoard[i][j] = 0;
                    } else if (greenNeighbours > 6 && greenNeighbours <= 8) {
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }

                } else {
                    if (greenNeighbours == 3 || greenNeighbours == 6) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        this.board = newBoard;
    }

    protected void printNumberTimesCellBeenGreen(){
        System.out.println(this.getBeenGreen());
//        System.out.println("Picked cell has been green for exact: " + this.getBeenGreen() + " turns.");
    }
}
