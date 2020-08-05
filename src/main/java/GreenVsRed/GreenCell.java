package GreenVsRed;

public class GreenCell extends Cell {
    private int color;

    public GreenCell(int x, int y) {
        super(x, y);
        this.color = 1;
    }

    public int getColor() {
        return this.color;
    }

}
