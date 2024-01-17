package fr.jason.puissance.Board;

import fr.jason.puissance.Token.Token;

import java.util.ArrayList;
import java.util.List;

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

    /*
    public void displayBoard(Token[][] grid){
        List<String> lines = new ArrayList<>();
        for (Token[] column : grid){

        }
    }*/
}
