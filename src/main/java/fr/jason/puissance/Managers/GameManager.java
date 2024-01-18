package fr.jason.puissance.Managers;

import fr.jason.puissance.Board.Board;
import fr.jason.puissance.Player.Player;
import fr.jason.puissance.State;
import fr.jason.puissance.Token.Token;

import java.util.Scanner;

public class GameManager {

    private Player[] players = new Player[2];

    private State state;

    public void setState(State state){
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public boolean isState(State state){
        return this.state == state;
    }

    public void startGame(){
            inizializeGame();
            gameLoop();
    }

    public void inizializeGame(){

        setState(State.STARTING);

        System.out.println("Nom du joueur 1 :");
        String playerName1 = new Scanner(System.in).nextLine();
        Player player1 = new Player(playerName1, "X");
        players[0] = player1;

        System.out.println("Nom du joueur 2 :");
        String playerName2 = new Scanner(System.in).nextLine();
        Player player2 = new Player(playerName2, "O");
        players[1] = player2;
    }

    public void gameLoop(){
        if (isState(State.STARTING)){
            setState(State.PLAYING);

            Token[][] grid = new Token[7][6];

            Board board = new Board(grid);

            int round = 1;

            while (!board.isFull(grid)){

                Player currentPlayer;

                if (round%2 != 0){
                    currentPlayer = players[0];
                } else {
                    currentPlayer = players[1];
                }

                System.out.println(currentPlayer.getName() + " - Colonne : ");
                int column = new Scanner(System.in).nextInt();

                Token[][] boardGrid = board.getGrid();

                for (int index = 0; index < boardGrid.length; index++){
                    if (!board.columnIsFull(boardGrid[column])){
                        try {
                            if (boardGrid[column][index] == null){
                                Token token = new Token(currentPlayer, new int[column][index]);
                                board.addToken(boardGrid, column, index, token);
                                round++;
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("Colonne invalide. Incris une colonne entre 1 et 7");
                            break;
                        }
                    } else {
                        System.out.println("Colonne pleine !");
                        break;
                    }
                }
            }
        }
        setState(State.ENDING);
    }

    /*public void finishGame() {
    }*/
}
