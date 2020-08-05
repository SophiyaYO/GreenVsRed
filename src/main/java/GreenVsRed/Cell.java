package GreenVsRed;

abstract class Cell {
    private int wantedX;
    private int wantedY;
    private int color;

    public Cell() {
    }

    public Cell(int x, int y) {
        this.wantedX = x;
        this.wantedY = y;
        this.getColor();
    }

    public int getColor() {

        return this.color;
    }

}
