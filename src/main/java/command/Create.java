package command;

import java.util.List;

public class Create implements Command {

    private final int width;
    private final int height;

    public Create(List<String> parameters) {
        if (parameters == null || parameters.size() < 2)
            throw new IllegalArgumentException("Both row and column is required");

        try {
            this.width = Integer.parseInt(parameters.get(0));
            this.height = Integer.parseInt(parameters.get(1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Both row and column must be positive digit");
        }

        if (this.width < 0 || this.height < 0)
            throw new IllegalArgumentException("Both row and column must be positive digit");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
