package org.example;

import org.example.model.Board;
import org.example.model.Player;

public class Game {

    public static void main(String[] args) {
        Player player1 = new Player("Player1", "white");
        Player player2 = new Player("Player2", "black");
        Board board = new Board(10, 10);

        while (board.getIsGameOver()) {
            while (board.isPlayerMadeMove()) {
                int[] player1Location = player1.move();
                board.updateBoard(player1.getColor(), player1Location);
            }
            while (board.isPlayerMadeMove()) {
                int[] player2Location = player1.move();
                board.updateBoard(player1.getColor(), player2Location);
            }

        }
    }


}
