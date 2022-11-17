package classes.algorithm;

import java.util.Objects;

class Cello {
    int row;
    int col;

    public Cello(int rowIndex, int colIndex) {
        super();
        this.row = rowIndex;
        this.col = colIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cello cell = (Cello) o;
        return row == cell.row &&
                col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

}
