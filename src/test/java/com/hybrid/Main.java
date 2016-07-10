package com.hybrid;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javafx.application.Platform;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Text text = new Text("!");
        text.setFont(new Font(40));
        VBox box = new VBox();
        box.getChildren().add(text);
        final Scene scene = new Scene(box,300, 250);
        scene.setFill(null);
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              System.out.println("Stage is closing");
          }
        });        
//        stage.close();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
