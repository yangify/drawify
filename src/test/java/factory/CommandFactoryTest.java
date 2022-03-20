package factory;

import command.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CommandFactoryTest {

    @Test
    public void whenCommandEmpty_returnNull() {
        String rawCommand = "";
        Command create = CommandFactory.create(rawCommand);
        assert create == null;
    }

    @Test
    public void whenCommandUnknown_thenThrowException() {
        String rawCommand = "J 13 14";
        Exception exception = assertThrows(RuntimeException.class, () -> CommandFactory.create(rawCommand));

        String expectedMessage = "Unrecognised command";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenCreateCommandValid_returnsCreate() {
        String rawCommand = "C 8 8";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Create.class);
    }

    @Test
    public void whenDrawLineCommandValid_returnsDrawLine() {
        String rawCommand = "L 1 1 1 2";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Draw.class);
    }

    @Test
    public void whenDrawShapeCommandValid_returnsDrawShape() {
        String rawCommand = "R 1 1 2 2";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Draw.class);
    }

    @Test
    public void whenPaintCommandValid_returnsPaint() {
        String rawCommand = "B 1 1";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Paint.class);
    }

    @Test
    public void whenQuitCommandValid_returnsQuit() {
        String rawCommand = "Q";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Quit.class);
    }
}
