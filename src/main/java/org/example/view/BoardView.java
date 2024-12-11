package org.example.view;


import org.example.model.Board;

import java.util.Arrays;

public class BoardView {

    public void getGameBoard(Board board) {
        String[][] gameBoard = board.getBoard();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == null) {
                    gameBoard[i][j] = "";
                }
            }
            System.out.println(Arrays.toString(gameBoard[i]));
        }
        System.out.print("\n");
    }
}
