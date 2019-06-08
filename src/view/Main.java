package view;

import javafx.application.Application;
import javafx.geometry.Insets;
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

        Button startButton = new Button("Start new game", imageView);
        Font startButtonFont = new Font("Gigi", 25);
        startButton.setFont(startButtonFont);
        startButton.setStyle("-fx-focus-color: firebrick; -fx-base: WHITE;");

        box.setRight(startButton);
        box.setPadding(new Insets(35, 50, 20, 20));


        stage.setResizable(false);


        stage.setScene(scene);
        stage.setTitle("Sudoku");
        stage.setWidth(1000);
        stage.setHeight(580);
        stage.show();

        // ввод цифр - TextField; GridPane (поле)

    }
}
