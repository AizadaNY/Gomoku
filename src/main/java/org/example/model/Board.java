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
    private boolean isUserMadeMove = false;
    private boolean winningMatch = false;
    private boolean isGameOver = false;
    private boolean isBoardFull = false;

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

    public Boolean isPlayerMadeMove() {
        return isUserMadeMove;
    }

    public boolean getIsGameOver() {
        return isGameOver;
    }

    public void setIsGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    Map<int[], String> allPointLocation = new HashMap<>();

    public void updateBoard(String color, int[] location) {
        if (allPointLocation.containsKey(location)) {
            System.out.println("Please select other location");
            isUserMadeMove = false;
        } else if () {
            System.out.println("Please select other location");
            isUserMadeMove = false;
        } else {
            allPointLocation.put(location, color);
            isUserMadeMove = true;
        }
    }

    public boolean isLocationValid(int[] location) {
        if((location[1]-location[0])==1 &&(location[3]-location[2])==1&&
                (location[2]-location[0])==10 &&(location[3]-location[1])==10){
            return true;
        }else if(location[0]>){
            return true;
        }else{
            return false;
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

    public boolean checkBoard(int[] pointLocation, int matchingCount) {
        if (checkLine(pointLocation, matchingCount, Constants.ROW_COUNTER)) {
            winningMatch = true;
        } else if (checkLine(pointLocation, (matchingCount - matchedPointCount), (-Constants.ROW_COUNTER)) == true) {
            winningMatch = true;
        }
        if (checkLine(pointLocation, matchingCount, Constants.COLUMN_COUNTER)) {
            winningMatch = true;
        } else if (checkLine(pointLocation, (matchingCount - matchedPointCount), (-Constants.COLUMN_COUNTER)) == true) {
            winningMatch = true;
        }
        if (checkLine(pointLocation, matchingCount, Constants.FIRST_DIAGONAL_COUNTER)) {
            winningMatch = true;
        } else if (checkLine(pointLocation, (matchingCount - matchedPointCount), (-Constants.FIRST_DIAGONAL_COUNTER)) == true) {
            winningMatch = true;
        }
        if (checkLine(pointLocation, matchingCount, Constants.SECOND_DIAGONAL_COUNTER)) {
            winningMatch = true;
        } else if (checkLine(pointLocation, (matchingCount - matchedPointCount), (-Constants.SECOND_DIAGONAL_COUNTER)) == true) {
            winningMatch = true;
        }
        return winningMatch;
    }

    public void isBoardFull() {
        int allBoardPointCount = (getRow() + 1) * (getColumn() + 1);
        if (allPointLocation.size() > allBoardPointCount) {
            isBoardFull = true;
        }
    }

    public void gameResult() {
        if (winningMatch || isBoardFull) {
            setIsGameOver(true);
        }
    }


}
