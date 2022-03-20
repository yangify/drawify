package canvas;

import java.util.Arrays;

public class Canvas {

    private final String[][] board;

    private String topBorder = "-";
    private String bottomBorder = "-";
    private String leftBorder = "|";
    private String rightBorder = "|";

    private final int width;
    private final int height;

    public Canvas(int width, int height) {
        if (width < 0 || height < 0) throw new IllegalArgumentException("Rows and columns must be positive");
        this.width = width;
        this.height = height;

        this.topBorder = this.topBorder.repeat(width + 2);
        this.bottomBorder = this.bottomBorder.repeat(width + 2);

        this.board = new String[height][width];
        for (String[] row: this.board) Arrays.fill(row, " ");
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPoint(Point point) {
        validatePoint(point);
        int x = point.getX();
        int y = point.getY();
        return this.board[y][x];
    }

    public void setPoint(Point point, String value) {
        validatePoint(point);
        int x = point.getX();
        int y = point.getY();
        this.board[y][x] = value;
    }

    void validatePoint(Point point) {
        int x = point.getX() - 1;
        int y = point.getY() - 1;

        if (x < 0) throw new IllegalArgumentException("x should be positive");
        if (x >= width) throw new IllegalArgumentException("x should be less than " + width);

        if (y < 0) throw new IllegalArgumentException("y should be positive");
        if (y >= height) throw new IllegalArgumentException("y should be less than " + height);
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder canvasString = new StringBuilder();

        canvasString.append(this.topBorder).append("\n");
        for (String[] row : this.board) {
            canvasString.append(this.leftBorder);
            for (String character: row) canvasString.append(character);
            canvasString.append(this.rightBorder).append("\n");
        }
        canvasString.append(this.bottomBorder).append("\n");

        return canvasString.toString();
    }
}
