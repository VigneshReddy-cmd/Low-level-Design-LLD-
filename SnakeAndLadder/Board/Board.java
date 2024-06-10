package Board;

public class Board {
    private int size;
    private Cell[][] board;
    public Board(int size)
    {
            this.size=size;
            this.board=new Cell[size][size];
    }
}
