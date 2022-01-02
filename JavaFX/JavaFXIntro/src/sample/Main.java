package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); // ui using xml file
        //Parent root = FXMLLoader.load(getClass().getResource("hbox.fxml"));     // hbox example screen load
        Parent root = FXMLLoader.load(getClass().getResource("vbox.fxml"));     // hbox example screen load

        // UI without xml file
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//
//        Label greet = new Label("Welcome to FX!");
//        greet.setTextFill(Color.GREEN);
//        greet.setFont(Font.font("Calibri", FontWeight.BOLD, 70));
//        root.getChildren().add(greet);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 375));
        primaryStage.show();
    }

    // we can also define start() and init() method but they are not mandatory.


    public static void main(String[] args) {
        launch(args);
    }
}
