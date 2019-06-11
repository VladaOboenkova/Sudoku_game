package view;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main extends Application{

    private Controller controller = new Controller();

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        BorderPane box = new BorderPane();
        box.setBackground(new Background(new BackgroundFill
                (Color.LAVENDERBLUSH, CornerRadii.EMPTY, new Insets(10, 10, 10, 10))));
        Scene scene = new Scene(box);

        FileInputStream input = new FileInputStream("13_1.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        String buttonsStyle = "-fx-focus-color: firebrick; -fx-base: WHITE;";
        Button startButton = new Button("Start new game", imageView);
        Font buttonsFont = new Font("Gigi", 25);
        startButton.setFont(buttonsFont);
        startButton.setStyle(buttonsStyle);

        box.setRight(startButton);
        box.setPadding(new Insets(45, 45, 20, 20));

        Font inputButtonsFont = new Font("Gigi", 20);

        Button buttonOne = new Button("1");
        buttonOne.setFont(inputButtonsFont);
        buttonOne.setStyle(buttonsStyle);

        Button buttonTwo = new Button("2");
        buttonTwo.setFont(inputButtonsFont);
        buttonTwo.setStyle(buttonsStyle);

        Button buttonThree = new Button("3");
        buttonThree.setFont(inputButtonsFont);
        buttonThree.setStyle(buttonsStyle);

        Button buttonFour = new Button("4");
        buttonFour.setFont(inputButtonsFont);
        buttonFour.setStyle(buttonsStyle);

        Button buttonFive = new Button("5");
        buttonFive.setFont(inputButtonsFont);
        buttonFive.setStyle(buttonsStyle);

        Button buttonSix = new Button("6");
        buttonSix.setFont(inputButtonsFont);
        buttonSix.setStyle(buttonsStyle);

        Button buttonSeven = new Button("7");
        buttonSeven.setFont(inputButtonsFont);
        buttonSeven.setStyle(buttonsStyle);

        Button buttonEight = new Button("8");
        buttonEight.setFont(inputButtonsFont);
        buttonEight.setStyle(buttonsStyle);

        Button buttonNine = new Button("9");
        buttonNine.setFont(inputButtonsFont);
        buttonNine.setStyle(buttonsStyle);

        VBox inputPanel = new VBox();
        inputPanel.setSpacing(5);
        inputPanel.setPadding(new Insets(7, 20 , 35, 0));
        inputPanel.getChildren().addAll(buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
        buttonSeven, buttonEight, buttonNine);
        box.setLeft(inputPanel);

        Canvas field = new Canvas(450, 450);
        GraphicsContext graphicsContext = field.getGraphicsContext2D();

        box.setCenter(field);

        startButton.setOnAction(event -> controller.createBoard(graphicsContext));

                field.setOnMouseClicked(event -> {
                    int column = (int) event.getX() / 50;
                    int row = (int) event.getY() / 50;

                    int coordinateX = column * 53 + 3;
                    int coordinateY = row * 52 + 19;

                    graphicsContext.setFill(Color.DEEPPINK);
                    Font cellsFont = new Font("Gigi", 25);
                    graphicsContext.setFont(cellsFont);

                    buttonOne.setOnAction(event1 -> {
                        controller.enterOne(column, row);
                        graphicsContext.fillText("1", coordinateX, coordinateY);
                    });
                    buttonTwo.setOnAction(event1 -> {
                        controller.enterTwo(column, row);
                        graphicsContext.fillText("2", coordinateX, coordinateY);
                    });
                    buttonThree.setOnAction(event1 -> {
                        controller.enterThree(column, row);
                        graphicsContext.fillText("3", coordinateX, coordinateY);
                    });
                    buttonFour.setOnAction(event1 -> {
                        controller.enterFour(column, row);
                        graphicsContext.fillText("4", coordinateX, coordinateY);
                    });
                    buttonFive.setOnAction(event1 -> {
                        controller.enterFive(column, row);
                        graphicsContext.fillText("5", coordinateX, coordinateY);
                    });
                    buttonSix.setOnAction(event1 -> {
                        controller.enterSix(column, row);
                        graphicsContext.fillText("6", coordinateX, coordinateY);
                    });
                    buttonSeven.setOnAction(event1 -> {
                        controller.enterSeven(column, row);
                        graphicsContext.fillText("7", coordinateX, coordinateY);
                    });
                    buttonEight.setOnAction(event1 -> {
                        controller.enterEight(column, row);
                        graphicsContext.fillText("8", coordinateX, coordinateY);
                    });
                    buttonNine.setOnAction(event1 -> {
                        controller.enterNine(column, row);
                        graphicsContext.fillText("9", coordinateX, coordinateY);
                    });
            });

        stage.setResizable(false);

        stage.setScene(scene);
        stage.setTitle("Sudoku");
        stage.setWidth(870);
        stage.setHeight(580);
        stage.show();
    }

}
