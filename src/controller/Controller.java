package controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Logic;

public class Controller {

    private Logic logic = new Logic();

    public int[][] getBoard() {
        return logic.generateBoard();
    }

    private int[][] choosenBoard;

    public int[][] getChoosenBoard() {
        return choosenBoard;
    }

    public void createBoard(GraphicsContext graphicsContext) {

        graphicsContext.clearRect(0, 0, 450, 450);
        graphicsContext.setFill(Color.WHITE);
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {

                int cellSide = 45;
                int coordinateX = column * 50;
                int coordinateY = row * 50;

                graphicsContext.fillRect(coordinateX, coordinateY, cellSide, cellSide);
            }
        }

        graphicsContext.strokeLine(0, 149, 445, 149);
        graphicsContext.strokeLine(0, 297, 445, 297);
        graphicsContext.strokeLine(149, 0, 149, 445);
        graphicsContext.strokeLine(297, 0, 297, 445);

        int[][] board = getBoard();
        choosenBoard = board;
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {

                int coordinateX = column * 53 + 3;
                int coordinateY = row * 52 + 19;
                graphicsContext.setFill(Color.BLACK);
                Font cellsFont = new Font("Gigi", 25);
                graphicsContext.setFont(cellsFont);
                int cellValue = board[row][column];
                if (cellValue != 0) {
                    graphicsContext.fillText(String.valueOf(cellValue), coordinateX, coordinateY);
                }

            }

        }
    }

    public void enter(int x, int y, int number){
        if (choosenBoard[y][x] == 0 && number >= 1 && number <= 9) {
            int[][] playersArray = logic.getPlayersArray();
            playersArray[y][x] = number;
        }
    }

    public void clearPlayersArray(){
        logic.setPlayersArray(new int[9][9]);
    }

    public void deleteNumber(int x, int y){
        if(choosenBoard[y][x] == 0) {
            int[][] playersArray = logic.getPlayersArray();
            playersArray[y][x] = 0;
        }
    }

    public boolean check() {
        int[][] playersArray = logic.getPlayersArray();

        int[][] global = new int[9][9];
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (choosenBoard[row][column] == 0)
                    global[row][column] = playersArray[row][column];
                else global[row][column] = choosenBoard[row][column];
            }
        }
        for (int row = 0; row < 9; row++) {
            int counter = 0;
            for (int column = 0; column < 9; column++) {
                counter += global[row][column];
            }
            if (counter != 45) {
                return false;
            }
        }
        for (int column = 0; column < 9; column++) {
            int counter = 0;
            for (int row = 0; row < 9; row++) {
                counter += global[row][column];
            }
            if (counter != 45) {
                return false;
            }
        }
        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                int counter = 0;
                for (int clusterRow = 0; clusterRow < 3; clusterRow++) {
                    for (int clusterColumn = 0; clusterColumn < 3; clusterColumn++) {
                        counter += global[row + clusterRow][column + clusterColumn];
                    }
                }
                if (counter != 45) {
                    return false;
                }
            }
        }
        return true;
    }
}
