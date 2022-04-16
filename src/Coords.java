import java.util.Objects;

public class Coords {
    int row;
    int colm;

    Coords(int row, int colm) {
        this.row = row;
        this.colm = colm;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColm() {
        return colm;
    }

    public void setColm(int colm) {
        this.colm = colm;
    }

    Coords(userInfo user) {
        int rows = Integer.parseInt(user.getSeats().replaceAll(FileEdit.regex1, ""));
        String alpa = user.getSeats().replaceAll(FileEdit.regex2, "");
        int colms = FileEdit.TransferAlpa(alpa);
        this.row = rows;
        this.colm = colms;
    }

    public boolean equals(Coords c) {
        if (this.getRow() == c.getRow() && this.getColm() == c.getColm()) {
            return true;
        }
        return false;
    }
}
