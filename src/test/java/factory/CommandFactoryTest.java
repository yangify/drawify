package factory;

import command.Command;
import command.Create;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    @Test
    public void whenCommandEmptyReturnNull() {
        String rawCommand = "";
        Command create = CommandFactory.create(rawCommand);
        assert create == null;
    }

    @Test
    public void whenCreateCommandValidReturnsCreate() {
        String rawCommand = "C 5 5";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Create.class);
    }
}
