package org.example;

import org.example.controller.BoardController;
import org.example.controller.PlayerController;
import org.example.model.Board;
import org.example.model.Player;
import org.example.view.BoardView;
import org.example.view.PlayerView;

public class Game {

    public static void main(String[] args) {
        Board board = new Board(10, 10);
        BoardView boardView = new BoardView();
        BoardController boardController = new BoardController(board, boardView);
        Player player1 = new Player("Player1", "w");
        Player player2 = new Player("Player2", "b");
        PlayerView playerView = new PlayerView();
        PlayerController playerController = new PlayerController(player1, player2, playerView);
        boardController.startGame(player1, player2);
    }


}
