package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.*;
public class LogicTest {

    @Test(expected = ImpossibleMoveException.class) //Неправильный ход.
    public void whenImpossibleMove() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.move(Cell.C3, Cell.C4);
    }
    @Test(expected = FigureNotFoundException.class) //фигуры нет на клетке.
    public void whenFigureNotFoundException() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
       BishopBlack bishopBlack = new BishopBlack(Cell.E6);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.move(Cell.E5, Cell.B7);
    }


    @Test(expected = OccupiedCellException.class)  //ячейка занята
    public void whenOccupiedWayException() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        BishopBlack bishopBlack = new BishopBlack(Cell.E7);
        PawnWhite pawnWhite2 = new PawnWhite(Cell.D6);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(pawnWhite2);
        logic.move(Cell.E7, Cell.B4);
    }
}