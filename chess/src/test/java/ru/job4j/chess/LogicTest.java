package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.*;
public class LogicTest {

    //ImpossibleMoveException - пользователь двигает фигуру не по правилам шахмат.
    //FigureNotFoundException - фигуры нет на клетке.
    //OccupiedCellException - ячейка занята

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }
    @Test(expected = ImpossibleMoveException.class) //фигуры нет на клетке.
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

    @Test(expected = OccupiedCellException.class)  //ячейка занята
    public void whenBishopBlackOccupiedWayException() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        BishopBlack bishopBlack = new BishopBlack(Cell.E7);
        PawnWhite pawnWhite = new PawnWhite(Cell.D6);
        Logic logic = new Logic();
        logic.add(pawnWhite);
        logic.add(bishopBlack);
        logic.move(Cell.E7, Cell.A3);
    }

    @Test(expected = OccupiedCellException.class)  //ячейка занята
    public void whenWhiteKingMoveOnOccupiedCellWhenOccupiedWayException() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        KingWhite kingWhite = new KingWhite(Cell.E6);
        PawnWhite pawnWhite = new PawnWhite(Cell.E5);
        Logic logic = new Logic();
        logic.add(pawnWhite);
        logic.add(kingWhite);
        logic.move(Cell.E6, Cell.E5);
    }

    @Test(expected = OccupiedCellException.class)  //ячейка занята
    public void whenWhiteKnightMoveOnOccupiedCellWhenOccupiedWayException() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        KnightWhite knightWhite = new KnightWhite(Cell.E6);
        PawnWhite pawnWhite = new PawnWhite(Cell.C5);
        Logic logic = new Logic();
        logic.add(pawnWhite);
        logic.add(knightWhite);
        logic.move(Cell.E6, Cell.C5);
    }

    @Test(expected = OccupiedCellException.class)   //ячейка занята
    public void whenWhiteQeenMoveOnOccupiedCellWhenOccupiedWayException() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        BishopBlack knightWhite = new BishopBlack(Cell.E7);
        PawnWhite pawnWhite = new PawnWhite(Cell.B4);
        Logic logic = new Logic();
        logic.add(pawnWhite);
        logic.add(knightWhite);
        logic.move(Cell.E7, Cell.A3);
    }

    @Test(expected = OccupiedCellException.class)  //ячейка занята
    public void whenWhiteRookMoveOnOccupiedCellWhenOccupiedWayException() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        BishopBlack rookWhite = new BishopBlack(Cell.A7);
        PawnWhite pawnWhite = new PawnWhite(Cell.D4);
        Logic logic = new Logic();
        logic.add(pawnWhite);
        logic.add(rookWhite);
        logic.move(Cell.A7, Cell.G1);
    }

}