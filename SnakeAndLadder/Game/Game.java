package Game;

import java.util.ArrayList;
import java.util.List;

import Board.Board;
import Dice.Dice;
import Player.Player;

public class Game {
    private int nop;
    private Board board;
    private Dice dice;
    private List<Player> players;
    public Game(int n)
    {
       this.nop=n;
       this.players=new ArrayList<>();
    }
    public Game(Player player)
    {
        players.add(player);
    }
    public void startGame(){
        
    }
}
