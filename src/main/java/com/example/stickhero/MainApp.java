package com.example.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            stage.setTitle("hewl");
            stage.setScene(new Scene(root, 420, 700));
            stage.show();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
