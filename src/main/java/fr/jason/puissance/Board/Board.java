package fr.jason.puissance.Board;

import fr.jason.puissance.Token.Token;

public class Board {

    private Token[][] grid;

    public Board(Token[][] grid){
        this.grid = grid;
    }

    public Token[][] getGrid() {
        return grid;
    }

    public void setGrid(Token[][] grid) {
        this.grid = grid;
    }

    public void addToken(Token[][] grid, int column, int line, Token token){
        grid[column][line] = token;
    }

    /* public boolean checkOnAddToken(Token token){
        int[][] cosToken = token.getCoordinates();
        Player playerToken = token.getPlayer();

        if (grid[cosToken[0]][cosToken[cosToken[1] -1]])
        return false;
    }*/

    public boolean columnIsFull(Token[] column){
        for (Token token : column){
            if (token == null){
                return false;
            }
        }
        return true;
    }

    public boolean isFull(Token[][] grid){
        for (Token[] column : grid){
            for (Token token : column) {
                if (token == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    public void displayBoard(Token[][] grid){
        List<String> lines = new ArrayList<>();
        for (Token[] column : grid){

        }
    }*/
}
