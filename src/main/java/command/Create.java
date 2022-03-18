package command;

import exception.InvalidParameterException;

import java.util.List;

public class Create implements Command {

    private final int rows;
    private final int columns;

    public Create(List<String> parameters) {
        if (parameters == null || parameters.size() < 2)
            throw new InvalidParameterException("Both row and column is required");

        try {
            this.rows = Integer.parseInt(parameters.get(0));
            this.columns = Integer.parseInt(parameters.get(1));
        } catch (NumberFormatException e) {
            throw new InvalidParameterException("Both row and column must be positive digit");
        }

        if (this.rows < 0 || this.columns < 0)
            throw new InvalidParameterException("Both row and column must be positive digit");
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
