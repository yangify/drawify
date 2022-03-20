package command;

import canvas.Point;

import java.util.List;

public class Paint implements Command {

    private final Point point;
    private final String value;

    public Paint(List<String> parameters) {
        if (parameters == null || parameters.size() < 3)
            throw new IllegalArgumentException("Both point and value is required");

        try {
            int x = Integer.parseInt(parameters.get(0));
            int y = Integer.parseInt(parameters.get(1));
            if (x < 0 || y < 0) throw new NumberFormatException();
            this.point = new Point(x, y);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Both x and y must be positive digit");
        }

        this.value = parameters.get(2);
    }

    public Point getPoint() {
        return this.point;
    }

    public String getValue() {
        return this.value;
    }
}
