package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

public interface Figure {
    //метод для получения позиции фигуры на поле, возвращает Cell тип перечисления.
    Cell position();

    //Этот метод возвращает массив с клетками, которые должна пройти фигура от клетки position до клетки dest
    Cell[] way(Cell dest) throws ImpossibleMoveException;

    default String icon() {
        return String.format(
                "%s.png", getClass().getSimpleName()
        );
    }
//метод создает объект класса с позицией dest. При переходе из одной клетки в другую,
// будет создаваться новый обьект с новой позицией, а старый удаляться
    Figure copy(Cell dest);
}
