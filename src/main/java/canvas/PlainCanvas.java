package canvas;

import java.util.Arrays;

public class PlainCanvas implements Canvas {

    private final String[][] board;

    private String topBorder = "-";
    private String bottomBorder = "-";
    private String leftBorder = "|";
    private String rightBorder = "|";

    private final int rows;
    private final int columns;

    public PlainCanvas(int rows, int columns) {
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

    public void setPoint(Point point, String value) throws IndexOutOfBoundsException {
        int x = point.getX();
        int y = point.getY();
        this.board[x][y] = value;
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
