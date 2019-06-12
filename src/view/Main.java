package view;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

        box.setPadding(new Insets(25, 35, 20, 20));

        Font inputButtonsFont = new Font("Gigi", 20);

        Button checkButton = new Button("Check!");
        checkButton.setFont(inputButtonsFont);
        checkButton.setStyle(buttonsStyle);

        Text winMessage = new Text("Congratulations! You won!");
        winMessage.setFont(buttonsFont);
        FlowPane winPane = new FlowPane();
        winPane.getChildren().addAll(winMessage);
        winPane.setAlignment(Pos.CENTER);
        winPane.setBackground(new Background(new BackgroundFill
                (Color.LAVENDERBLUSH, CornerRadii.EMPTY, new Insets(10, 10, 10, 10))));
        Stage winStage = new Stage();
        Scene winScene = new Scene(winPane);
        winStage.setScene(winScene);
        winStage.setWidth(350);
        winStage.setHeight(200);

        Text lossMessage = new Text("Check your answer!");
        lossMessage.setFont(buttonsFont);
        FlowPane lossPane = new FlowPane();
        lossPane.getChildren().addAll(lossMessage);
        lossPane.setAlignment(Pos.CENTER);
        lossPane.setBackground(new Background(new BackgroundFill
                (Color.LAVENDERBLUSH, CornerRadii.EMPTY, new Insets(10, 10, 10, 10))));
        Stage lossStage = new Stage();
        Scene lossScene = new Scene(lossPane);
        lossStage.setScene(lossScene);
        winStage.setWidth(350);
        winStage.setHeight(200);

        checkButton.setOnAction(event -> {
                boolean result = controller.check();
                if (result) winStage.show();
                else lossStage.show();
        });

        VBox controlPanel = new VBox();
        controlPanel.setSpacing(5);
        controlPanel.getChildren().addAll(startButton, checkButton);
        box.setRight(controlPanel);

        List<Button> inputButtons = new ArrayList<>();

        Button buttonOne = new Button("1");
        inputButtons.add(buttonOne);

        Button buttonTwo = new Button("2");
        inputButtons.add(buttonTwo);

        Button buttonThree = new Button("3");
        inputButtons.add(buttonThree);

        Button buttonFour = new Button("4");
        inputButtons.add(buttonFour);

        Button buttonFive = new Button("5");
        inputButtons.add(buttonFive);

        Button buttonSix = new Button("6");
        inputButtons.add(buttonSix);

        Button buttonSeven = new Button("7");
        inputButtons.add(buttonSeven);

        Button buttonEight = new Button("8");
        inputButtons.add(buttonEight);

        Button buttonNine = new Button("9");
        inputButtons.add(buttonNine);

        Button deleteButton = new Button("Del");
        inputButtons.add(deleteButton);

        for (Button button : inputButtons){
            button.setFont(inputButtonsFont);
            button.setStyle(buttonsStyle);
        }

        VBox inputPanel = new VBox();
        inputPanel.setSpacing(5);
        inputPanel.setPadding(new Insets(0, 10 , 35, 0));
        inputPanel.getChildren().addAll(buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
        buttonSeven, buttonEight, buttonNine, deleteButton);
        box.setLeft(inputPanel);

        Canvas field = new Canvas(450, 450);
        GraphicsContext graphicsContext = field.getGraphicsContext2D();

        box.setCenter(field);

        startButton.setOnAction(event ->{
                controller.clearPlayersArray();
                controller.createBoard(graphicsContext);});

                field.setOnMouseClicked(event -> {
                    int column = (int) event.getX() / 50;
                    int row = (int) event.getY() / 50;

                    int coordinateX = column * 53 + 3;
                    int coordinateY = row * 52 + 19;

                    graphicsContext.setFill(Color.DEEPPINK);
                    Font cellsFont = new Font("Gigi", 25);
                    graphicsContext.setFont(cellsFont);

                    buttonOne.setOnAction(event1 -> {
                        if(controller.getChoosenBoard()[row][column] == 0) {
                            controller.enter(column, row, 1);
                            graphicsContext.fillText("1", coordinateX, coordinateY);
                        }
                    });
                    buttonTwo.setOnAction(event1 -> {
                        if(controller.getChoosenBoard()[row][column] == 0) {
                            controller.enter(column, row, 2);
                            graphicsContext.fillText("2", coordinateX, coordinateY);
                        }
                    });
                    buttonThree.setOnAction(event1 -> {
                        if(controller.getChoosenBoard()[row][column] == 0) {
                            controller.enter(column, row, 3);
                            graphicsContext.fillText("3", coordinateX, coordinateY);
                        }
                    });
                    buttonFour.setOnAction(event1 -> {
                        if(controller.getChoosenBoard()[row][column] == 0) {
                            controller.enter(column, row, 4);
                            graphicsContext.fillText("4", coordinateX, coordinateY);
                        }
                    });
                    buttonFive.setOnAction(event1 -> {
                        if(controller.getChoosenBoard()[row][column] == 0) {
                            controller.enter(column, row, 5);
                            graphicsContext.fillText("5", coordinateX, coordinateY);
                        }
                    });
                    buttonSix.setOnAction(event1 -> {
                        if(controller.getChoosenBoard()[row][column] == 0) {
                            controller.enter(column, row, 6);
                            graphicsContext.fillText("6", coordinateX, coordinateY);
                        }
                    });
                    buttonSeven.setOnAction(event1 -> {
                        if(controller.getChoosenBoard()[row][column] == 0) {
                            controller.enter(column, row, 7);
                            graphicsContext.fillText("7", coordinateX, coordinateY);
                        }
                    });
                    buttonEight.setOnAction(event1 -> {
                        if(controller.getChoosenBoard()[row][column] == 0) {
                            controller.enter(column, row, 8);
                            graphicsContext.fillText("8", coordinateX, coordinateY);
                        }
                    });
                    buttonNine.setOnAction(event1 -> {
                        if(controller.getChoosenBoard()[row][column] == 0) {
                            controller.enter(column, row, 9);
                            graphicsContext.fillText("9", coordinateX, coordinateY);
                        }
                    });
                    deleteButton.setOnAction(event1 -> {
                        controller.deleteNumber(column, row);
                        if (controller.getChoosenBoard()[row][column] == 0) {
                            graphicsContext.setFill(Color.WHITE);
                            graphicsContext.fillRect(column * 50, row * 50, 40, 40);
                        }
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
