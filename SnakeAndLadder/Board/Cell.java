package Board;

public class Cell {
    private CELLTYPE celltype;
    private int row;
    private int col;
        public Cell(int row,int col)
        {
           this.row=row;
           this.col=col;
        }
    private CELLTYPE getCellStatus()
    {
          return celltype;
    }
}
