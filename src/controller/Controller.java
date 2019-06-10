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
}
