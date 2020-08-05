package GreenVsRed;

public class Board {
    private int width;
    private int height;
    private int wantedX;
    private int wantedY;
    private int beenGreen;
    private Cell[][] board;

    protected Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.beenGreen = 0;
        this.board = new Cell[height][width];
    }

    public void setWantedX(int wantedX) {
        this.wantedX = wantedX;
    }

    public void setWantedY(int wantedY) {
        this.wantedY = wantedY;
    }

    protected void setColor(int x, int y, int c) {//using it you can initialize cell
        if (c == 1) {
            this.board[x][y] = new GreenCell(x, y);
        } else {
            this.board[x][y] = new RedCell(x, y);
        }
    }

    protected int countGreenNeighbours(int x, int y) {
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

    private int getState(int x, int y) {
        if (x < 0 || x >= width) {//out of horizontal board scope- adding Zero
            return 0;
        }

        if (y < 0 || y >= height) {//out of vertical board scope- adding Zero
            return 0;
        }

        return this.board[x][y].getColor();//getting the value of the cell
    }

    private void timesBeenGreen() {
        this.beenGreen++;
    }

    protected int getBeenGreen() {
        return this.beenGreen;
    }

    //Loop for exact turns of the board
    //turns are the last input data
    protected void turnExact(int turns) {
        for (int i = 0; i < turns; i++) {
            turn();
        }
    }

    private void turn() {
        Cell[][] newBoard = new Cell[height][width];

        if (this.board[wantedX][wantedY].getColor() == 1) {
            timesBeenGreen();
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int greenNeighbours = countGreenNeighbours(i, j);

                if (getState(i, j) == 1) {
                    if (greenNeighbours < 2) {
                        newBoard[i][j] = new RedCell(i, j);
                    } else if (greenNeighbours > 3 && greenNeighbours < 6) {
                        newBoard[i][j] = new RedCell(i, j);
                    } else if (greenNeighbours > 6 && greenNeighbours <= 8) {
                        newBoard[i][j] = new RedCell(i, j);
                    } else {
                        newBoard[i][j] = new GreenCell(i, j);
                    }

                } else {
                    if (greenNeighbours == 3 || greenNeighbours == 6) {
                        newBoard[i][j] = new GreenCell(i, j);
                    } else {
                        newBoard[i][j] = new RedCell(i, j);
                    }
                }
            }
        }
        this.board = newBoard;
    }

    protected void printBoard() {
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j].getColor() + " ");
            }
            System.out.println();
        }
    }
}
