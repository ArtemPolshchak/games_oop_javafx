package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bp = new BishopBlack(Cell.A2);
        assertThat(bp.position(), is(Cell.A2));

    }

    @Test
    public void way() throws ImpossibleMoveException {
        BishopBlack bp = new BishopBlack(Cell.C1);
        assertThat(bp.way(Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayDiagonal() throws IllegalAccessException, ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack.way(Cell.A4);
        throw new IllegalAccessException(String.format("Could not way by diagonal from %s to %s", Cell.A1, Cell.A4));
    }


    @Test
    public void isNotDiagonal() {
        BishopBlack bp = new BishopBlack(Cell.C8);
        assertThat(bp.isDiagonal(Cell.C8, Cell.A8), is(false));

    }
    @Test
    public void isDiagonal() {
        BishopBlack bp = new BishopBlack(Cell.C8);
        assertThat(bp.isDiagonal(Cell.C8, Cell.H3), is(true));

    }

    @Test
    public void copy() {
        assertThat(new BishopBlack(Cell.A3).copy(Cell.C6), is(new BishopBlack(Cell.C6)));
    }
}