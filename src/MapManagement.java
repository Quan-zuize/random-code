public abstract class MapManagement {
    private int col = 4, row = 4;
    int[][] used = new int[col ][row ];
    char[][] map = new char[col ][row];

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
