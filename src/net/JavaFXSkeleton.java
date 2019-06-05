package net;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class JavaFXSkeleton extends Application {
    private Random random = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        System.out.println("Тело метода init()");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Skeleton");
        Pane rootNode = new Pane();
        Scene myScene = new Scene(rootNode, 500, 350);
        primaryStage.setScene(myScene);
        Label myLabel = new Label("Try to click on second button!");
        myLabel.setLayoutX(180);
        myLabel.setLayoutY(50);
        Button buttonFirst = new Button("Alpha");
        buttonFirst.setLayoutX(150);
        buttonFirst.setLayoutY(80);
        Button buttonSecond = new Button(" Beta");
        buttonSecond.setLayoutX(300);
        buttonSecond.setLayoutY(80);
        buttonFirst.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("First button message");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("I have a great message - You have clicked on button Alpha!");
            alert.showAndWait();
        });
        buttonSecond.setOnMouseEntered(event -> {
            int newX = (int) (random.nextInt((int) myScene.getWidth()) - buttonSecond.getWidth());
            int newY = (int) (random.nextInt((int) myScene.getHeight()) - buttonSecond.getHeight());
            System.out.println("Size is" + myScene.getWidth() + " " + myScene.getHeight());
            System.out.println("new X is " + newX);
            System.out.println("new Y is " + newY);
            buttonSecond.setLayoutX(newX);
            buttonSecond.setLayoutY(newY);
        });
        buttonSecond.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Second button message");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("I have a great message - You have clicked on button Betta!");
            alert.showAndWait();
        });
        rootNode.getChildren().addAll(myLabel, buttonFirst, buttonSecond);
        primaryStage.show();
    }

    @Override
    public void stop() {
        System.out.println("Тело метода stop()");
    }
}