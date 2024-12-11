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

    Player player1 = new Player("1", "white");

    Player player2 = new Player("2", "black");

    Board getBoard() {
        return board;
    }

    public void boardView() {
        view.getGameBoard(board);
    }




}
