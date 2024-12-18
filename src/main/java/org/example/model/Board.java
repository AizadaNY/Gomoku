package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Board {

    //1.so board itself will be stored as a 2D Array
    //2.but point locations will be stored in Map<int[]> is this the correct way to implement?
    // and also hw can i store intersection of 4 cells , i have array of 4 cells only on my mind.

    private int row;
    private int column;
    private String[][] board;
    private boolean isBoardUpdated = false;
    private boolean winningMatch = false;
    private boolean isGameOver = false;
    private int rowNumber;
    private int columnNumber;

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        board = new String[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String[][] getBoard() {
        return board;
    }

    public Boolean getIsBoardUpdated() {
        return isBoardUpdated;
    }

    public boolean getIsGameOver() {
        return isGameOver;
    }

    public void setIsGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }


    public void setBoard(String location, String color) {
        int rowNumber = Integer.parseInt(location.substring(0, 1));
        int columnNumber = Integer.parseInt(location.substring(1));
        board[rowNumber ][columnNumber] = color;
    }

    public boolean isLocationValid(int location) {
        return true;
    }

    Map<Integer, String> allPointLocation = new HashMap<>();

    public void updateBoard(Player player, int location) {
        if (allPointLocation.containsKey(location)) {
            System.out.println("Please select other location");
            isBoardUpdated = false;
        } else if (!isLocationValid(location)) {
            System.out.println("Please select other location");
            isBoardUpdated = false;
        } else {
            setBoard(String.valueOf(location), player.getColor());
            allPointLocation.put(location, player.getColor());
            isBoardUpdated = true;
        }
    }

    int matchedPointCount = 0;

    public boolean checkLine(int[] pointLocation, int matchingCount, int counter) {
        for (int i = 0; i < matchingCount; i++) {
            int[] nextPointLocation = new int[pointLocation.length];
            for (int j = 0; j < pointLocation.length; j++) {
                nextPointLocation[j] = pointLocation[j + counter];
            }
            if (allPointLocation.get(pointLocation).equals(allPointLocation.get(nextPointLocation))) {
                matchedPointCount++;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean checkBoard(int[] pointLocation, int[] counter) {
        for (int i = 0; i < counter.length; i++) {
            if (checkLine(pointLocation, counter[i], Constants.ROW_COUNTER)) {
                winningMatch = true;
            } else if (checkLine(pointLocation, (counter[i] - matchedPointCount), (-Constants.ROW_COUNTER))) {
                winningMatch = true;
            }
        }
        return winningMatch;
    }

    public boolean isBoardFull() {
        if ((row * column) > allPointLocation.size()) {
            return true;
        }
        return false;
    }

    public void gameResult(int[] pointLocation, int[] counter) {
        checkBoard(pointLocation, counter);
        if (winningMatch || isBoardFull()) {
            setIsGameOver(true);
        }
    }


}
