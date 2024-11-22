package org.example.model;

public class Board {

    private int row;
    private int column;
    private String [][] board;

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        board=new String[row][column];
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public void updateBoard(String color, int[] cell) {

    }

    public void checkRight(int matchingNumber){
        for (int i = 0; i < matchingNumber; i++) {

        }
    }

    public void checkLeft(int matchingNumber){
        for (int i = 0; i < matchingNumber; i++) {

        }
    }

    public void checkUp(int matchingNumber){
        for (int i = 0; i < matchingNumber; i++) {

        }
    }

    public void checkDown(int matchingNumber){
        for (int i = 0; i < matchingNumber; i++) {

        }
    }

    public void checkDiagonal1(int matchingNumber){
        for (int i = 0; i < matchingNumber; i++) {

        }
    }

    public void checkDiagonal2(int matchingNumber){
        for (int i = 0; i < matchingNumber; i++) {

        }
    }


















    int rowAmt = 1;
    int columnAmt = 10;
    int diagonalAmt = 11;
    int diagonalAmt2 = 9;

    public void checkTheBoard(String color, int[] cell) {
        checkMatchingCells(color,cell,rowAmt);
        checkMatchingCells(color,cell,columnAmt);
        checkMatchingCells(color,cell,diagonalAmt);
        checkMatchingCells(color,cell,diagonalAmt2);
    }

    boolean fiveMatching = false;

    public void checkMatchingCells(String color, int[] cell, int number) {
        int[] cell2 = leftCell(cell, number);
        if (getCellValue(cell2).equals(color)&&getCellValue(cell2)!=null) {
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
