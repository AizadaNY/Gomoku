package org.example.controller;

import org.example.model.Board;
import org.example.model.Player;

public class BoardController {

    Board board=new Board(10, 10);
    Player player=new Player("Player1", "white");
    Player player2=new Player("Player2", "black");

    public void updateBoard(){

    }
    
    boolean fiveMatchings=false;
    public void checkMatchingCells(String color,int[] cell){
        int[] cell2 = leftCell(cell, 1);
        if(getCellValue(cell2).equals(color)){
            int [] cell3=leftCell(cell2,1 );
            if(getCellValue(cell3).equals(color)){
                int [] cell4=leftCell(cell3,1 );
                if(getCellValue(cell4).equals(color)){
                    int [] cell5=leftCell(cell4,1 );
                    if(getCellValue(cell5).equals(color)){
                        fiveMatchings=true;
                    }else{
                         cell5=rightCell(cell,1 );
                        if(getCellValue(cell5).equals(color)){
                            fiveMatchings=true;
                        }
                    }
                }else{
                   cell4=rightCell(cell3, 1);
                   if(getCellValue(cell4).equals(color)){
                       int [] cell5=leftCell(cell4,1 );
                       if(getCellValue(cell5).equals(color)){
                           fiveMatchings=true;
                       }else{
                           //what need to return
                       }
                   }

                }
            }else{
                cell3=rightCell(cell, 1);

            }
        }else{
            cell2=rightCell(cell, 1);
        }
    }

    private String getCellValue(int[] cell2) {
        return ""; 
    }

    public int[] leftCell(int[] cell,int count){
        int[] nextCell = new int[4];
        for (int i = 0; i < 4; i++) {
            nextCell[i]=cell[i]+count;
        }
        return nextCell;
    }

    public int[] rightCell(int[] cell,int count){
        int[] nextCell = new int[4];
        for (int i = 0; i < 4; i++) {
            nextCell[i]=cell[i]-count;
        }
        return nextCell;
    }





}
