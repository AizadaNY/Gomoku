package org.example.controller;

import org.example.model.Board;
import org.example.model.Player;
import org.example.view.BoardView;

public class BoardController {

    private Board board;
    private BoardView view;

    public BoardController(Board board, BoardView view) {
        this.board = board;
        this.view = view;
    }

    public void startGame(Player player1, Player player2) {
        while (!board.getIsGameOver()) {
            int input;
            input = player1.getInput(player1.getName());
            board.updateBoard(player1, input);
            if (player1.isMoved(board.getIsBoardUpdated())) {
                input = player2.getInput(player2.getName());
                board.updateBoard(player2, input);
            } else if (player2.isMoved(board.getIsBoardUpdated())) {
                input = player1.getInput(player1.getName());
                board.updateBoard(player1, input);
            }
        }
        view.getGameBoard(board);
        board.gameResult();
    }


}
