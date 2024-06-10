package TICTACTOE.Game;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import TICTACTOE.Board.GameBoard;
import TICTACTOE.Players.Player;
import TICTACTOE.PlayingPeice.PieceO;
import TICTACTOE.PlayingPeice.PieceType;
import TICTACTOE.PlayingPeice.PieceX;

public class game {
    private static Scanner sc=new Scanner(System.in);
    Deque<Player> players;
    GameBoard gameBoard;
    public  game(String p1,String p2){
        initgame(p1,p2);
    }
    public void initgame(String p1_name,String p2_name){
        players=new LinkedList<>();
        PieceX pieceX=new PieceX(PieceType.X);
        Player p1=new Player(pieceX, p1_name);
        PieceO pieceO=new PieceO(PieceType.O);
        Player p2=new Player(pieceO, p2_name);
        players.add(p1);
        players.add(p2);
       gameBoard=new GameBoard(3);
    }
    public String startGame(){
        boolean noWinner=false;
        while (!noWinner) {
            Player playertrun=players.peekFirst();
            players.removeFirst();
            gameBoard.printBoard();
            // check for free cells avaliable if all are filled then tie
            boolean cell_Chceck=gameBoard.check_Cell();
            if(!cell_Chceck){
              break;
            }
            
            //  get new row and col
               System.out.print("Player "+" "+playertrun.name+" "+"Enter Row and Column:");
               int r=sc.nextInt();
               int c=sc.nextInt();
               boolean is_Avaliable=gameBoard.check_Avaliability(r,c,playertrun.piece);
               if(!is_Avaliable){
                System.out.println("INcorrect position try again");
                   players.addFirst(playertrun);
                   continue;
               }
               else{
                    players.addLast(playertrun);
               }
                   boolean isWinner=gameBoard.isWinner(playertrun.piece);
                   if(isWinner){
                    return playertrun.name;
                  }
               
            
         }
         return "BOTH TIE MATCH";
    }
}
