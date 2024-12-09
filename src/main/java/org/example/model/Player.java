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

    public String getColor(){
        return color;
    }

    public String getName(){
        return name;
    }

    public int[] move() {
        int[] pointLocation = new int[4];
        System.out.println("Please provide your location");
        for (int i = 0; i < 4; i++) {
            pointLocation[i] = getInput();
        }
        return pointLocation;
    }

    public int getInput() {

        System.out.println("-");
        return scanner.nextInt();
    }
}
