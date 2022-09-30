package de.szut;

public class TicTacToe {

    private char[][] board = new char[3][3];

    public void play(int x, int y) {
        checkBounds(x, y);
    }

    public char nextPlayer(int counter) {
        if(counter % 2 == 0) return 'X';
        else return 'O';
    }

    public char checkWin(char[][] board, char player) {
        if(board[0][0] == player && board[0][1] == player && board[0][2] == player)

            for(int i = 0; i < 3; i++) {

            }

        return ' ' ;
    }

    private char checkRow(int r, char player) {
        return ' ' ;
    }

    private void checkBounds(int x, int y) {
        if (x < 0 || x > 2) {
            throw new RuntimeException("X Außerhalb des Feldes");
        }
        if (y < 0 || y > 2) {
            throw new RuntimeException("Y Außerhalb des Feldes");
        }
    }

    public void checkIfEmpty(char board[][], int x, int y) {
        if (board[x][y] != ' ') {
            throw new RuntimeException("Feld ist belegt");
        }
    }

}
