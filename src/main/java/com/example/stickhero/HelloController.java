package com.example.stickhero;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController{
    private Stage stage;
    private Scene scene;


    @FXML
    private Button button_logout;





    @FXML
    private Label fav_yt;


    public void toLogout(ActionEvent event) throws FileNotFoundException {
        DBUtils.update_user_details(String.valueOf(HelloApplication.getUserCredits()),String.valueOf(HelloApplication.readHighScore(0)));
        DBUtils.changeScene(event,"sample.fxml","Log in!",null,null,null,null);
    }

    public void setUserInformation(String username){
        welcome.setText("welcome "+username+" !!");
        FadeTransition ff = new FadeTransition(Duration.seconds(1));
        ff.setNode(welcome);
        ff.setFromValue(1);
        ff.setToValue(0);
        ff.play();
    }

    public Button front;
    public Button back;
    public Button load_game;
    public Button play;

    public Button item1;
    public Button item2;
    public Button item3;
    public Button item4;
    public Button item5;
    public Button item6;

    public ImageView i1;
    public ImageView i2;
    public ImageView i3;
    public ImageView i4;
    public ImageView i5;
    public ImageView i6;

    public Text t1;
    public Text t2;
    public Text t3;
    public Text t4;
    public Text t5;
    public Text t6;

    public ImageView c1;
    public ImageView c2;
    public ImageView c3;
    public ImageView c4;
    public ImageView c5;
    public ImageView c6;



    public void setCheckNull(){
        c1.setOpacity(0);
        c2.setOpacity(0);
        c3.setOpacity(0);
        c4.setOpacity(0);
        c5.setOpacity(0);
        c6.setOpacity(0);
    }
//
//    public ImageView curr_char;
//
//    public int curr_char_int;



    public void initialize_market() throws FileNotFoundException {
        ArrayList<Integer> char_arr_list = HelloApplication.getChar_arr_list();
        int curr_char_int = HelloApplication.getCurr_char();
        setCheckNull();
        if(curr_char_int ==1){
            c1.setOpacity(1);
        } else if (curr_char_int==2) {
            c2.setOpacity(1);
        }
        else if (curr_char_int==3) {
            c3.setOpacity(1);
        }
        else if (curr_char_int==4) {
            c4.setOpacity(1);
        }
        else if (curr_char_int==5) {
            c5.setOpacity(1);
        }
        else if (curr_char_int==6) {
            c6.setOpacity(1);
        }
        if(char_arr_list.contains(1)){
            i1.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t1.setOpacity(0);

        } else if (char_arr_list.contains(2)) {
            i2.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t2.setOpacity(0);

        } else if (char_arr_list.contains(3)) {
            i3.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t3.setOpacity(0);

        } else if (char_arr_list.contains(4)) {
            i4.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t4.setOpacity(0);

        } else if (char_arr_list.contains(5)) {
            i5.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t5.setOpacity(0);

        } else if (char_arr_list.contains(6)) {
            i6.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t6.setOpacity(0);
        }
    }


    public void handle_shopping1(ActionEvent event) throws IOException, gameNotFoundError {

            try {
                if(HelloApplication.getUserCredits()>Integer.parseInt(t1.getText())){
                    System.out.println("done");
                    i1.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
                    t1.setOpacity(0);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
    }

    public void handle_shopping2(ActionEvent event) throws IOException, gameNotFoundError {

        try {
            if(HelloApplication.getUserCredits()>Integer.parseInt(t2.getText())){
                System.out.println("done");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void handle_shopping3(ActionEvent event) throws IOException, gameNotFoundError {

        try {
            if(HelloApplication.getUserCredits()>Integer.parseInt(t3.getText())){
                System.out.println("done");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void handle_shopping4(ActionEvent event) throws IOException, gameNotFoundError {

        try {
            if(HelloApplication.getUserCredits()>Integer.parseInt(t4.getText())){
                System.out.println("done");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void handle_shopping5(ActionEvent event) throws IOException, gameNotFoundError {

        try {
            if(HelloApplication.getUserCredits()>Integer.parseInt(t5.getText())){
                System.out.println("done");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void handle_shopping6(ActionEvent event) throws IOException, gameNotFoundError {

        try {
            if(HelloApplication.getUserCredits()>Integer.parseInt(t6.getText())){
                System.out.println("done");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public Text uc;

    public void toHomeScreen(MouseEvent event) throws IOException, gameNotFoundError {
        Parent root = FXMLLoader.load(getClass().getResource("start_menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toStart(ActionEvent event) throws IOException, gameNotFoundError {
        Parent root = FXMLLoader.load(getClass().getResource("start_menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toLoadGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loadGame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public Text buttontext;


    public static int choice= 1;

    public void ChooseFinal(ActionEvent event) throws IOException {
        System.out.println(choice);
        switch (choice){
            case 1:
                toGameplay(event);
                break;
            case 2:
                toLoadGame(event);
                break;
        }
    }

    public void TextChanger(int choice){
        if(choice==2){
            buttontext.setText("Load game");
        }else if(choice==1){
            buttontext.setText("New game");
        }
    }

    public void ChooseActionForward(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        if(choice!=2){
            choice++;
            TextChanger(choice);
            System.out.println("hiiii");
        }
    }

    @FXML
    public void ChooseActionBackward(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        if (choice!=1){
            choice--;
            TextChanger(choice);
        }

    }

    public static Text creds = new Text();



    public void toGameplay(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Start2 gcontroller = new Start2();
        gcontroller.start(stage);
    }

    public void toMarket(ActionEvent event) throws Exception {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Start3 mcontroller = new Start3();
        try {
            mcontroller.start(stage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deserialize1(ActionEvent event) throws IOException, ClassNotFoundException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String progressFile = "saveProgress.txt";
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();

            Start2 p1 = new Start2();
            p1.setReloadFlag(1);
            p1.setSaveCurrState(s1);
            p1.start(stage);
        } finally {
            in.close();
        }
    }


    public void deserialize2(ActionEvent event) throws IOException, ClassNotFoundException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String progressFile = "saveProgress2.txt";
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();

            Start2 p1 = new Start2();
            p1.setReloadFlag(1);
            p1.setSaveCurrState(s1);
            p1.start(stage);
        } finally {
            in.close();
        }
    }
    public void deserialize3(ActionEvent event) throws IOException, ClassNotFoundException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String progressFile = "saveProgress1.txt";
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();

            Start2 p1 = new Start2();
            p1.setReloadFlag(1);
            p1.setSaveCurrState(s1);
            p1.start(stage);
        } finally {
            in.close();
        }
    }

    public void deserializeLast(ActionEvent event) throws IOException, ClassNotFoundException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String progressFile = "saveProgressNew.txt";
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();

            Start2 p1 = new Start2();
            p1.setReloadFlag(1);
            p1.setSaveCurrState(s1);
            p1.start(stage);
        } finally {
            in.close();
        }
    }
    @FXML
    private Text welcome;

}

class setC implements Runnable{
    @Override
    public void run() {
        Platform.runLater(() -> {
            HelloController.creds.setText(String.valueOf(HelloApplication.getUserCreds()));
        });
    }
}
