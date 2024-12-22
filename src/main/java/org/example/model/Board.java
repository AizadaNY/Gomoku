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
    private int playerMove;

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        board = new String[row][column];
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


    public void setBoard(String userInput, String color) {
        playerMove = Integer.parseInt(userInput);
        board[Integer.parseInt(userInput.substring(0, 1))][Integer.parseInt(userInput.substring(1))] = color;
    }

    Map<Integer, String> allPointLocation = new HashMap<>();

    public void updateBoard(Player player, String userInput) {
        int location = Integer.parseInt(userInput);
        if (allPointLocation.containsKey(location)) {
            System.out.println("Please select other location");
            isBoardUpdated = false;
        } else if (!isLocationValid(userInput)) {
            System.out.println("Please select other location");
            isBoardUpdated = false;
        } else {
            setBoard(String.valueOf(location), player.getColor());
            allPointLocation.put(location, player.getColor());
            isBoardUpdated = true;
            gameResult(playerMove);
        }
    }

    int matchedPointCount = 0;

    public boolean checkLine(int pointLocation, int matchingCount, int counter) {
        try {
            int nextPointLocation = pointLocation + counter;
            for (int i = 1; i < matchingCount; i++) {
                if (allPointLocation.get(pointLocation).equals(allPointLocation.get(nextPointLocation))) {
                    matchedPointCount++;
                } else {
                    return false;
                }
                nextPointLocation += counter;
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkBoard(int pointLocation, int matchingCount) {
        for (int i = 0; i < Constants.COUNTER.length; i++) {
            if (checkLine(pointLocation, matchingCount, Constants.COUNTER[i])) {
                winningMatch = true;
            } else if (checkLine(pointLocation, (matchingCount - matchedPointCount), (-Constants.COUNTER[i]))) {
                winningMatch = true;
            } else {
                winningMatch = false;
            }
        }
        return winningMatch;
    }

    public boolean isBoardFull() {
        if (allPointLocation.size() >= (row * column)) {
            return true;
        } else {
            return false;
        }
    }

    public void gameResult(int pointLocation) {
        checkBoard(pointLocation, Constants.MATCHING_COUNT);
        if (winningMatch || isBoardFull()) {
            setIsGameOver(true);
        }
    }


    public boolean isLocationValid(String location) {
        if (location.length() == 2) {
            return true;
        } else {
            return false;
        }
    }


}
