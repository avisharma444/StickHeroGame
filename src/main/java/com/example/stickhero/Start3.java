package com.example.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Start3 extends Application {
    private static Pane scenePane;
    private Stage myStage;
    public static boolean flag1=true;
    public static boolean flag2=true;
    public static boolean flag3=true;
    public static boolean flag4=true;
    public static boolean flag5=true;
    public static boolean flag6=true;

    private Text cherryText;
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


    public ArrayList<Integer> char_arr_list;

    public void initializer() throws FileNotFoundException {
        i1 = new ImageView();
        i2 = new ImageView();
        i3 = new ImageView();
        i4 = new ImageView();
        i5 = new ImageView();
        i6 = new ImageView();
        i1.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_01_Standard.png")));
        i2.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_01_Standard.png")));
        i3.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_01_Standard.png")));
        i4.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_01_Standard.png")));
        i5.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_01_Standard.png")));
        i6.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_01_Standard.png")));
        i1.setFitWidth(154);
        i1.setFitHeight(154);
        i2.setFitWidth(154);
        i2.setFitHeight(154);
        i3.setFitWidth(154);
        i3.setFitHeight(154);
        i4.setFitWidth(154);
        i4.setFitHeight(154);
        i5.setFitWidth(154);
        i5.setFitHeight(154);
        i6.setFitWidth(154);
        i6.setFitHeight(154);
        i1.setLayoutY(117);
        i1.setLayoutX(23);
        i2.setLayoutY(117);
        i2.setLayoutX(227);
        i3.setLayoutY(314);
        i3.setLayoutX(31);
        i4.setLayoutY(314);
        i4.setLayoutX(235);
        i5.setLayoutY(504);
        i5.setLayoutX(31);
        i6.setLayoutY(504);
        i6.setLayoutX(235);



        scenePane.getChildren().addAll(i1,i2,i3,i4,i5,i6);
        t1 = new Text(String.valueOf(10));
        t2 = new Text(String.valueOf(20));
        t3 = new Text(String.valueOf(40));
        t4 = new Text(String.valueOf(50));
        t5 = new Text(String.valueOf(80));
        t6 = new Text(String.valueOf(100));
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 20);
        t1.setFont(customFont);
        t2.setFont(customFont);
        t3.setFont(customFont);
        t4.setFont(customFont);
        t5.setFont(customFont);
        t6.setFont(customFont);
        scenePane.getChildren().addAll(t1,t2,t3,t4,t5,t6);
        t1.setLayoutX(88);
        t1.setLayoutY(247);
        t2.setLayoutX(289);
        t2.setLayoutY(247);
        t3.setLayoutX(89);
        t3.setLayoutY(453);
        t4.setLayoutX(295);
        t4.setLayoutY(453);
        t5.setLayoutX(90);
        t5.setLayoutY(634);
        t6.setLayoutX(294);
        t6.setLayoutY(634);
        t1.setTextAlignment(TextAlignment.CENTER);
        t2.setTextAlignment(TextAlignment.CENTER);
        t3.setTextAlignment(TextAlignment.CENTER);
        t4.setTextAlignment(TextAlignment.CENTER);
        t5.setTextAlignment(TextAlignment.CENTER);
        t6.setTextAlignment(TextAlignment.CENTER);

        c1 = new ImageView(new Image(getClass().getResourceAsStream("archer.png")));
        c2 = new ImageView(new Image(getClass().getResourceAsStream("wizard.png")));
        c3 = new ImageView(new Image(getClass().getResourceAsStream("shaman.png")));
        c4 = new ImageView(new Image(getClass().getResourceAsStream("berserk.png")));
        c5 = new ImageView(new Image(getClass().getResourceAsStream("kitsune.png")));
        c6 = new ImageView(new Image(getClass().getResourceAsStream("yamabushi.png")));
        scenePane.getChildren().addAll(c1,c2,c3,c4,c5,c6);
        c6.setScaleX(0.8);
        c6.setScaleY(0.8);
        c1.setLayoutY(85);
        c1.setLayoutX(23);
        c2.setLayoutY(90);
        c2.setLayoutX(240);
        c3.setLayoutY(324);
        c3.setLayoutX(50);
        c4.setLayoutY(324);
        c4.setLayoutX(255);
        c5.setLayoutY(480);
        c5.setLayoutX(31);
        c6.setLayoutY(490);
        c6.setLayoutX(235);
    }

    public void modifier() throws FileNotFoundException {
        char_arr_list = HelloApplication.getChar_arr_list();
        System.out.println(char_arr_list);
        if(char_arr_list.contains(1)){
            System.out.println(1);
            i1.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t1.setOpacity(0);

        }  if (char_arr_list.contains(2)) {
            System.out.println("2");

            i2.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t2.setOpacity(0);

        }  if (char_arr_list.contains(3)) {
            i3.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t3.setOpacity(0);

        }  if (char_arr_list.contains(4)) {
            System.out.println("4");
            i4.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t4.setOpacity(0);

        }  if (char_arr_list.contains(5)) {
            System.out.println("5");
            i5.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t5.setOpacity(0);

        }  if (char_arr_list.contains(6)) {
            i6.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
            t6.setOpacity(0);
        }

    }



    @Override
    public void start(Stage stage) throws Exception {

        System.out.println("-----STARTING--------");

        Parent root = FXMLLoader.load(getClass().getResource("store.fxml"));
        scenePane = new Pane(root);
        Scene scene = new Scene(scenePane);
        stage.setScene(scene);
        myStage = stage;
        cherryText = new Text();
        cherryText.setText(String.valueOf(11));
        cherryText.setLayoutX(338);
        cherryText.setLayoutY(42);
        cherryText.setFill(Color.WHITE);
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 24);
        int x = HelloApplication.getUserCredits();

        cherryText.setFont(customFont);
        cherryText.setText(String.valueOf(x));

        scenePane.getChildren().add(cherryText);
        stage.show();
        initializer();
        modifier();

        i1.setOnMouseClicked(it1->{
            try {
                if(HelloApplication.getUserCredits()>Integer.parseInt(t1.getText())&&flag1){
                    flag1=false;
                    System.out.println("done1");
                    i1.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
                    t1.setOpacity(0);
                    HelloApplication.setUserCredits(HelloApplication.getUserCredits()-10);
                    int y1 = HelloApplication.getUserCredits();
                    cherryText.setText(String.valueOf(y1));
                    ArrayList<Integer> integers = HelloApplication.getChar_arr_list();
                    HelloApplication.add_char(integers,1);
                    System.out.println(HelloApplication.getChar_arr_list());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        i2.setOnMouseClicked(it1->{
            try {
                if(HelloApplication.getUserCredits()>Integer.parseInt(t2.getText())&&flag2){
                    flag2=false;
                    System.out.println("done2");
                    i2.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
                    t2.setOpacity(0);
                    HelloApplication.setUserCredits(HelloApplication.getUserCredits()-20);
                    int y2 = HelloApplication.getUserCredits();
                    cherryText.setText(String.valueOf(y2));
                    ArrayList<Integer> integers = HelloApplication.getChar_arr_list();
                    HelloApplication.add_char(integers,2);
                    System.out.println(HelloApplication.getChar_arr_list());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        i3.setOnMouseClicked(it1->{
            try {
                if(HelloApplication.getUserCredits()>Integer.parseInt(t3.getText())&&flag3){
                    flag3 = false;
                    System.out.println("done3");
                    i3.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
                    t3.setOpacity(0);
                    HelloApplication.setUserCredits(HelloApplication.getUserCredits()-40);
                    int y3 = HelloApplication.getUserCredits();
                    cherryText.setText(String.valueOf(y3));
                    ArrayList<Integer> integers = HelloApplication.getChar_arr_list();
                    HelloApplication.add_char(integers,3);
                    System.out.println(HelloApplication.getChar_arr_list());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        i4.setOnMouseClicked(it1->{
            try {
                if(HelloApplication.getUserCredits()>Integer.parseInt(t4.getText())&&flag4){
                    flag4 = false;
                    System.out.println("done4");
                    i4.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
                    t4.setOpacity(0);
                    HelloApplication.setUserCredits(HelloApplication.getUserCredits()-50);
                    int y4 = HelloApplication.getUserCredits();
                    cherryText.setText(String.valueOf(y4));
                    ArrayList<Integer> integers = HelloApplication.getChar_arr_list();
                    HelloApplication.add_char(integers,4);
                    System.out.println(HelloApplication.getChar_arr_list());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        i5.setOnMouseClicked(it1->{
            try {
                if(HelloApplication.getUserCredits()>Integer.parseInt(t5.getText())&&flag5){
                    flag5 = false;
                    System.out.println("done5");
                    i5.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
                    t5.setOpacity(0);
                    HelloApplication.setUserCredits(HelloApplication.getUserCredits()-80);
                    int y5 = HelloApplication.getUserCredits();
                    cherryText.setText(String.valueOf(y5));
                    ArrayList<Integer> integers = HelloApplication.getChar_arr_list();
                    HelloApplication.add_char(integers,5);
                    System.out.println(HelloApplication.getChar_arr_list());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        i6.setOnMouseClicked(it1->{
            try {
                if(HelloApplication.getUserCredits()>Integer.parseInt(t6.getText())&&flag6){
                    flag6 = false;
                    System.out.println("done6");
                    i6.setImage(new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Standard.png")));
                    t6.setOpacity(0);
                    HelloApplication.setUserCredits(HelloApplication.getUserCredits()-100);
                    int y6 = HelloApplication.getUserCredits();
                    cherryText.setText(String.valueOf(y6));
                    ArrayList<Integer> integers = HelloApplication.getChar_arr_list();
                    HelloApplication.add_char(integers,6);
                    System.out.println(HelloApplication.getChar_arr_list());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
