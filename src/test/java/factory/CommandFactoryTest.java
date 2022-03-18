package factory;

import command.*;
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
    public void whenCommandUnknownReturnNull() {
        String rawCommand = "J 13 14";
        Command create = CommandFactory.create(rawCommand);
        assert create == null;
    }

    @Test
    public void whenCreateCommandValidReturnsCreate() {
        String rawCommand = "C 8 8";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Create.class);
    }

    @Test
    public void whenDrawLineCommandValidReturnsDrawLine() {
        String rawCommand = "L 1 1 2 2";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Draw.class);
    }

    @Test
    public void whenDrawShapeCommandValidReturnsDrawShape() {
        String rawCommand = "R 1 1 2 2";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Draw.class);
    }

    @Test
    public void whenPaintCommandValidReturnsPaint() {
        String rawCommand = "B 1 1";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Paint.class);
    }

    @Test
    public void whenQuitCommandValidReturnsQuit() {
        String rawCommand = "Q";
        Command create = CommandFactory.create(rawCommand);
        assert create != null;
        assertEquals(create.getClass(), Quit.class);
    }
}
