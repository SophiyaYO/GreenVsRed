package GreenVsRed;

public class Game {
    public Board board;

    public Game(int w,int h){
        this.board = new Board(w,h);

    }

    public void printInitialBoard(){
        this.board.printBoard();
    }

    protected void  initialFill(int x, int y, int color){
        this.board.setColor(x,y,color);
    }

    public void play(int wantedX, int wantedY, int turns){
        board.setWantedX(wantedX);
        board.setWantedY(wantedY);
        board.turnExact(turns);

        System.out.println(this.board.getBeenGreen());
    }
}
