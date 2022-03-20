package illustrator;

import canvas.Canvas;
import canvas.Point;

import java.util.*;

public class Painter extends Illustrator {

    private static final String VALUE = "o";

    public static void paint(Canvas canvas, Point point) {
        if (isExceedCanvas(canvas, point)) throw new IllegalArgumentException("Point outside of canvas");

        Set<Point> visited = new HashSet<>();
        Stack<Point> stack = new Stack<>();
        stack.push(point);

        while (!stack.isEmpty()) {
            Point p = stack.pop();
            if (visited.contains(p) || !canvas.getPoint(p).equals(" ")) continue;

            visited.add(p);
            canvas.setPoint(p, VALUE);

            int x = p.getX();
            int y = p.getY();

            List<Point> neighbours = List.of(new Point(x + 1, y), new Point(x - 1, y), new Point(x, y + 1), new Point(x, y - 1));
            for (Point neighbour : neighbours) {
                if (isExceedCanvas(canvas, neighbour) || !canvas.getPoint(neighbour).equals(" ")) continue;
                stack.push(neighbour);
            }
        }
    }
}
