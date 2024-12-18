package org.example.controller;

import org.example.model.Player;
import org.example.view.PlayerView;

public class PlayerController {

    private Player player1;
    private Player player2;
    private PlayerView playerView;

    public PlayerController(Player player1, Player player2, PlayerView playerView) {
        this.player1 = player1;
        this.player2 = player2;
        this.playerView = playerView;
    }


}
