package fr.jason.puissance.Token;

import fr.jason.puissance.Player.Player;

public class Token {

    private Player player;
    private int[][] coordinates;

    public Token(Player player, int[][] coordinates){
        this.player = player;
        this.coordinates = coordinates;
    }

    public Player getPlayer() {
        return player;
    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCoordinates(int[][] coordinates) {
        this.coordinates = coordinates;
    }
}
