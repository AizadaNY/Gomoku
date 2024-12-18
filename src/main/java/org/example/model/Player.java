package org.example.model;

import java.util.Scanner;

public class Player {

    private String name;
    private String color;
    Scanner scanner = new Scanner(System.in);

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getInput(String playerName) {
        System.out.println(playerName + "  provide your location:");
        return scanner.nextInt();
    }

    public boolean isMoved(boolean isBoardUpdated) {
        if (isBoardUpdated) {
            return true;
        } else {
            return false;
        }
    }
}
