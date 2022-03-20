package canvas;

import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isBefore(Point that) {
        if (this.y == that.y && this.x < that.x) return true;
        if (this.x == that.x && this.y < that.y) return true;
        return this.x < that.x && this.y < that.y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Point)) return false;

        Point that = (Point) o;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
