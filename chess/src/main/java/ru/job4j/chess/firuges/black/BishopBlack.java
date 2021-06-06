package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Objects;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BishopBlack)) return false;
        BishopBlack that = (BishopBlack) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    //метод для получения позиции фигуры на поле, возвращает Cell тип перечисления.
    public Cell position() {
        return this.position;
    }


    @Override
    //Этот метод возвращает массив с клетками, которые должна пройти фигура от клетки position до клетки dest
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        //Если слон идет не по диагонали, выбрасывается исключение "Could not way by diagonal from %s to %s"
        if (!isDiagonal(position(), dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = position.getX() < dest.getX() ? 1 : -1;
        int deltaY = position.getY() < dest.getY() ? 1 : -1;

        int x = position.getX();
        int y = position.getY();

        for (int index = 0; index < size; index++) {
             x += deltaX;
             y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        //Метод проверяет, ходит ли Слон по диагонали
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    //метод создает объект класса с позицией dest. При переходе из одной клетки в другую,
// будет создаваться новый обьект с новой позицией, а старый удаляться
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
