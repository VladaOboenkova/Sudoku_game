package model;


public class Logic {

    private int[][] playersArray = new int[9][9];

    public int[][] getPlayersArray() {
        return playersArray;
    }

    public int[][] generateBoard() {

        int[][] boardOne = new int[][]{
                {0, 0, 0, 9, 0, 5, 0, 0, 0},
                {0, 2, 4, 0, 0, 0, 9, 6, 0},
                {0, 0, 3, 0, 4, 0, 2, 0, 0},
                {0, 5, 1, 8, 7, 2, 3, 9, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 9, 6, 4, 1, 3, 5, 2, 0},
                {0, 0, 9, 0, 8, 0, 7, 0, 0},
                {0, 4, 8, 0, 0, 0, 1, 3, 0},
                {0, 0, 0, 7, 0, 1, 0, 0, 0}};

        int[][] boardTwo = new int[][]{
                {7, 0, 3, 0, 0, 0, 9, 0, 6},
                {0, 8, 0, 0, 5, 0, 0, 1, 0},
                {1, 0, 0, 7, 0, 2, 0, 0, 4},
                {0, 9, 0, 3, 0, 5, 0, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 5, 0, 1, 0, 7, 0, 2, 0},
                {8, 0, 0, 4, 0, 1, 0, 0, 2},
                {0, 1, 0, 0, 3, 0, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 1, 0, 3}};

        int[][] boardThree = new int[][]{
                {1, 0, 0, 6, 3, 0, 2, 0, 0},
                {0, 8, 0, 0, 0, 0, 0, 0, 5},
                {4, 6, 0, 8, 0, 0, 0, 0, 9},
                {0, 0, 7, 2, 8, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 7, 9, 4, 0, 0},
                {3, 0, 0, 0, 0, 1, 0, 2, 6},
                {7, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 0, 4, 0, 5, 8, 0, 0, 7}};

        int boardNumber = (int)(Math.random() * 3) + 1;

        int[][] choosenBoard = new int[0][0];
        if (boardNumber == 1) choosenBoard = boardOne;
        if (boardNumber == 2) choosenBoard = boardTwo;
        if (boardNumber == 3) choosenBoard = boardThree;

        return choosenBoard;
    }

    private int[][] board = generateBoard();

    public int[][] getBoard() {
        return board;
    }



}



