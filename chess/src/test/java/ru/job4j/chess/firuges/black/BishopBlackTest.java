package ru.job4j.chess.firuges.black;

import org.junit.Test;
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
    public void way() {
        BishopBlack bp = new BishopBlack(Cell.C1);
        assertThat(bp.way(Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }
/*

    @Test
    public void isDiagonal() {
        BishopBlack bp = new BishopBlack(Cell.C8);
        Cell[] result = new Cell[0];
        Cell target = Cell.H3;
        result = bp.way(Cell.C8, target);

        assertThat(result[result.length-1].equals(target), is(true));
        assertThat(result[result.length-1].getX(), is(target.getX()));
        assertThat(result[result.length-1].getY(), is(target.getY()));
    }
*/
    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        bishopBlack.copy(Cell.C3);
        assertThat(bishopBlack.position(), is(Cell.C3));

    }


}