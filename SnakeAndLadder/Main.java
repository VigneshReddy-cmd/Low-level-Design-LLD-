import java.util.Scanner;

import Game.Game;
import Player.Player;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Game sandl=new Game(n);
        Player player1=new Player("Vignesh");
        new Game(player1);
        Player player2=new Player("Bubby");
        new Game(player2);
        Player player3=new Player("Subbu");
        new Game(player3);
        sandl.startGame();
    }
}
