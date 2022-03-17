package command;

import exception.InvalidParameterException;

import java.util.List;

public class Create implements Command {

    public Create(List<String> parameters) {
        if (parameters.size() < 2) throw new InvalidParameterException("Both x and y is required");
    }
}
