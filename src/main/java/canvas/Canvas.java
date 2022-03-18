package canvas;

import java.util.Arrays;

public class Canvas {

    private final String[][] board;

    private String topBorder = "-";
    private String bottomBorder = "-";
    private String leftBorder = "|";
    private String rightBorder = "|";

    private final int rows;
    private final int columns;

    public Canvas(int rows, int columns) {
        if (rows < 0 || columns < 0) throw new IllegalArgumentException("Rows and columns must be positive");
        this.rows = rows;
        this.columns = columns;

        this.topBorder = this.topBorder.repeat(columns + 2);
        this.bottomBorder = this.bottomBorder.repeat(columns + 2);

        this.board = new String[rows][columns];
        for (String[] row: this.board) Arrays.fill(row, " ");
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public String getPoint(Point point) {
        validatePoint(point);
        int x = point.getX();
        int y = point.getY();
        return this.board[x][y];
    }

    public void setPoint(Point point, String value) {
        validatePoint(point);
        int x = point.getX();
        int y = point.getY();
        this.board[x][y] = value;
    }

    void validatePoint(Point point) {
        int x = point.getX();
        int y = point.getY();

        if (x < 0) throw new IllegalArgumentException("x should be positive");
        if (x >= rows) throw new IllegalArgumentException("x should be less than " + rows);

        if (y < 0) throw new IllegalArgumentException("y should be positive");
        if (y >= columns) throw new IllegalArgumentException("y should be less than " + columns);
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
