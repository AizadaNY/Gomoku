package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private int row;
    private int column;
    private String[][] board;
    private boolean moved = false;
    private boolean isMatched = false;

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

    Map<int[], String> map = new HashMap<>();

    public void updateBoard(String color, int[] intersect) {
        if (map.containsKey(cell)) {
            System.out.println("Please select other location");
            moved = false;
        } else {
            map.put(cell, color);
            moved = true;
        }
    }

    int count = 0;

    public boolean checkLine(int[] cell, int matchingNumber, int moveCount) {
        for (int i = 0; i < matchingNumber; i++) {
            int[] cell2 = null;
            for (int j = 0; j < cell.length; j++) {
                cell2[j] = cell[j + moveCount];
            }
            if (map.get(cell).equals(map.get(cell2))) {
                isMatched = true;
                count++;
            } else {
                isMatched = false;
                break;
            }
        }
        return true;
    }

    int rightRow = 1;
    int columnUp = 10;
    int diagonal1 = 11;
    int diagonal2 = 9;

    public boolean checkBoard(int[] cell, int matchingNumber) {
        if (checkLine(cell, matchingNumber, rightRow) == true) {
            System.out.println(matchingNumber + " matching numbers");
        } else {
            checkLine(cell, (matchingNumber - count), -rightRow);
        }
        if (checkLine(cell, matchingNumber, columnUp) == true) {

        } else {
            checkLine(cell, matchingNumber, -columnUp);
        }
        if (checkLine(cell, matchingNumber, diagonal1) == true) {

        } else {
            checkLine(cell, matchingNumber, -diagonal1);
        }
        if (checkLine(cell, matchingNumber, diagonal2) == true) {

        } else {
            checkLine(cell, (matchingNumber - count), (-diagonal2));
        }


    }


    public void checkTheBoard(String color, int[] cell) {
        checkMatchingCells(color, cell, rowAmt);
        checkMatchingCells(color, cell, columnAmt);
        checkMatchingCells(color, cell, diagonalAmt);
        checkMatchingCells(color, cell, diagonalAmt2);
    }

    boolean fiveMatching = false;

    public void checkMatchingCells(String color, int[] cell, int number) {
        int[] cell2 = leftCell(cell, number);
        if (getCellValue(cell2).equals(color) && getCellValue(cell2) != null) {
            int[] cell3 = leftCell(cell2, number);
            if (getCellValue(cell3).equals(color)) {
                int[] cell4 = leftCell(cell3, number);
                if (getCellValue(cell4).equals(color)) {
                    int[] cell5 = leftCell(cell4, number);
                    if (getCellValue(cell5).equals(color)) {
                        fiveMatching = true;
                    } else {
                        cell5 = rightCell(cell, number);
                        if (getCellValue(cell5).equals(color)) {
                            fiveMatching = true;
                        }
                    }
                } else {
                    cell4 = rightCell(cell, number);
                    if (getCellValue(cell4).equals(color)) {
                        int[] cell5 = rightCell(cell4, number);
                        if (getCellValue(cell5).equals(color)) {
                            fiveMatching = true;
                        }
                    }
                }
            } else {
                cell3 = rightCell(cell, number);
                if (getCellValue(cell3).equals(color)) {
                    int[] cell4 = rightCell(cell3, number);
                    if (getCellValue(cell4).equals(color)) {
                        int[] cell5 = rightCell(cell4, number);
                        if (getCellValue(cell5).equals(color)) {
                            fiveMatching = true;
                        }
                    }
                }
            }
        } else {
            cell2 = rightCell(cell, number);
            if (getCellValue(cell2).equals(color)) {
                int[] cell3 = rightCell(cell2, number);
                if (getCellValue(cell3).equals(color)) {
                    int[] cell4 = rightCell(cell3, number);
                    if (getCellValue(cell4).equals(color)) {
                        int[] cell5 = rightCell(cell4, number);
                        if (getCellValue(cell5).equals(color)) {
                            fiveMatching = true;
                        }
                    }
                }
            }
        }
    }

    private String getCellValue(int[] cell2) {
        return "";
    }

    public int[] leftCell(int[] cell, int count) {
        int[] nextCell = new int[4];
        for (int i = 0; i < 4; i++) {
            nextCell[i] = cell[i] + count;

        }
        return nextCell;
    }

    public int[] rightCell(int[] cell, int count) {
        int[] nextCell = new int[4];
        for (int i = 0; i < 4; i++) {
            nextCell[i] = cell[i] - count;
        }
        return nextCell;
    }


}
