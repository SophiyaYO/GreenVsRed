package GreenVsRed;

public class RedCell extends Cell {
    private int color;

    public RedCell(int x, int y) {
        super(x, y);
        this.color = 0;
    }

    public int getColor() {
        return this.color;
    }

    public int setColor(int x, int y) {
        return 0;
    }
}
