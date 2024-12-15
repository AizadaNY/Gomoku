package org.example;

import org.example.model.Board;
import org.example.model.Player;

public class Game {

    public static void main(String[] args) {
        Player player1 = new Player("Player1", "white");
        Player player2 = new Player("Player2", "black");
        Board board = new Board(10, 10);

        while (!board.getIsGameOver()) {
            if (player1.isMoved()) {
                player2.move();
            } else {
                player1.move();
            }
        }
    }


}
