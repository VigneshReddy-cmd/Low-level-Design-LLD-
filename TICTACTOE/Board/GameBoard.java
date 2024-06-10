package TICTACTOE;
public class GameBoard {
    public Piece[][] board;
    public GameBoard(int size){
        this.board=new Piece[size][size];
    }
    public boolean check_Avaliability(int row,int Column,Piece piece){
        if(board[row][Column]==null)
        {
            board[row][Column]=piece;
            return true;
        }
        else{
            return false;
        }
    }
  public boolean check_Cell(){
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==null)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isWinner(Piece piece){
        boolean rowmatch=false;
        boolean colmatch=false;
        boolean rightDiagonal=false;
        boolean leftDiagonal=false;
        for(int i=0;i<3;i++)
        {
            if(board[i][0]==piece && board[i][1]==piece && board[i][2]==piece){
                rowmatch=true;
                break;
            }
            if(board[0][i]==piece && board[1][i]==piece && board[2][i]==piece){
                colmatch=true;
                break;
            }
        }

        if(board[1][1]==piece && board[0][0]==piece && board[2][2]==piece){
            rightDiagonal=true;
        }
         
        if(board[1][1]==piece && board[0][2]==piece && board[2][0]==piece)
        {
            leftDiagonal=true;
        }
        return rowmatch || colmatch || rightDiagonal || leftDiagonal;
    }
    public void printBoard(){
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j].toString()+"  "+"|");
            }
            System.out.print("\n");
        }
    }
}
