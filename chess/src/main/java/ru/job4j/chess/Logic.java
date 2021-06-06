package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
            free(steps);
        figures[index] = figures[index].copy(dest);
    }

    private boolean free(Cell[] steps) throws OccupiedCellException, FigureNotFoundException {
        //Метод проходится по массиву figures  и проверяет, что фигуры не занимают элементы из массива steps
        for (Figure figure : figures) {
            for (int j = 0; j < steps.length; j++) {
                if (figure.position() != null) {
                    if (figure.position().equals(steps[j])) {
                        throw new OccupiedCellException("Could not way by the way");
                    }
                }
            }
        }
        return true;

    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException("Cant find Figure");
    }
}
