package fr.jason.puissance.Managers;

import fr.jason.puissance.Board.Board;
import fr.jason.puissance.Player.Player;
import fr.jason.puissance.State;
import fr.jason.puissance.Token.Token;

import java.util.List;
import java.util.Scanner;

public class GameManager {

    private Player[] players = new Player[2];

    private State state;

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public boolean isState(State state){
        return this.state == state;
    }

    public void startGame(){
        inizializeGame();
        gameLoop();
        finishGame();
    }

    public void inizializeGame(){

        setState(State.STARTING);

        String playerName1 = new Scanner(System.in).nextLine();
        Player player1 = new Player(playerName1, "X");
        players[0] = player1;

        String playerName2 = new Scanner(System.in).nextLine();
        Player player2 = new Player(playerName2, "O");
        players[1] = player2;
    }

    public Player gameLoop(){

        Player winner = null;

        if (isState(State.STARTING)){
            setState(State.PLAYING);

            Token[][] grid = new Token[7][6];

            Board board = new Board(grid);

            while (!board.isFull()){
                System.out.println("Colonne : ");
                int column = new Scanner(System.in).nextInt();

                for (int index = 0; index < board.getGrid().length; index++){
                    if (board.getGrid()[column][index] == null){
                        board.addToken(board.getGrid(), column, index, new Token(players[0], new int[column][index])); //players[0] test
                    }
                }

            }
        }
        return winner;
    }

    public String finishGame(){
        return "test";
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player changePlayer(List<Player> players){
        Player currentPlayer = null;
        if (currentPlayer == players.get(0)){
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }
        return currentPlayer;
    }
}
