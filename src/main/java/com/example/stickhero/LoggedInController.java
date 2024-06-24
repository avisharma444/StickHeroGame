package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {
    @FXML
    private Button button_logout;

    @FXML
    private Text welcome;

    @FXML
    private Button start_game;

    @FXML
    private Label fav_yt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"sample.fxml","Log in!",null,null,null,null);
            }
        });
    }

    public void setUserInformation(String username, String favc,String a,String b) throws IOException {
        welcome.setText("welcome "+username+"\n Cherries - "+a+"\n High Score - "+b);
        //set in in the ingame file i/o aswell
        HelloApplication.setUserCredits(Integer.parseInt(a));
        HelloApplication.writeScore(Integer.parseInt(b));
    }


}
