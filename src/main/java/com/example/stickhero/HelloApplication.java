package com.example.stickhero;

import com.almasb.fxgl.notification.Notification;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloApplication {
    private ArrayList<Integer> char_arr_list;
    private int curr_char;
    private static int userCreds;
    public static int getUserCreds() {
        return userCreds;
    }

    public static void setUserCreds(int userCreds) {
        HelloApplication.userCreds = userCreds;
    }

    public static Stage stage_primary;
    public static Parent root;



    public static void initialize_game_details(int cherries,int high_score) throws IOException {
        setUserCredits(cherries);
        writeScore(high_score);
    }
    public static void writeScore(int x) throws IOException {

        PrintWriter fww = new PrintWriter((new FileWriter("src/main/java/com/example/stickhero/highscore.txt")));
        String s = String.valueOf(x);
        fww.write(s);
        fww.close();
    }
    public static int readHighScore(int score) throws FileNotFoundException {
        Scanner in2 = new Scanner(new BufferedInputStream(new FileInputStream("src/main/java/com/example/stickhero/highscore.txt")));
        ArrayList<Integer> int_arr2 = new ArrayList<>();
        while(in2.hasNext()){
            int y = Integer.parseInt(in2.next());
            int_arr2.add(y);
        }
        System.out.println(int_arr2);

        return int_arr2.get(0);
    }

//    @Override
    public void start_game(Stage stage,String username,int userCreds,int score) {

        try {
                try {
                    root = FXMLLoader.load(HelloApplication.class.getResource("start_menu.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            Alert entered = new Alert(Alert.AlertType.CONFIRMATION);
                entered.setContentText(username+" Logged In Successfully!");
                entered.show();


//                    HelloController hc = new HelloController();
//                hc.setUserInformation(username);
//                HelloController.setUserInformation(username);
            System.out.println("heloojiiiiiiii");
            System.out.println(DBUtils.getCurr_user());
            curr_char = getCurr_char();
            char_arr_list = getChar_arr_list();
            int credits = userCreds;
            System.out.println("curr char - "+curr_char);
            System.out.println(char_arr_list);
            setUserCreds(credits);
            System.out.println("user credits are - "+userCreds);
            stage_primary=stage;
            Scene scene = new Scene(root);
            stage_primary.setScene(scene);
            stage_primary.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static int getCurr_char() throws FileNotFoundException {
        Scanner in2 = new Scanner(new BufferedInputStream(new FileInputStream("src/main/java/com/example/stickhero/currchar")));
        ArrayList<Integer> int_arr2 = new ArrayList<>();
        while(in2.hasNext()){
            int y = Integer.parseInt(in2.next());
            int_arr2.add(y);
        }
        return int_arr2.get(0);
    }

    public static boolean read_flag = false;


    public static ArrayList<Integer> getChar_arr_list() throws FileNotFoundException {
        Scanner in2 = new Scanner(new BufferedInputStream(new FileInputStream("src/main/java/com/example/stickhero/charlist")));

        ArrayList<Integer> int_arr2 = new ArrayList<>();
        while(in2.hasNext()){

            int y = Integer.parseInt(in2.next());
            System.out.println("reading- "+y);
            int_arr2.add(y);
        }
        return int_arr2;
    }

    public static void add_char(ArrayList<Integer> temp,int c) throws IOException {
        PrintWriter fww = new PrintWriter((new FileWriter("src/main/java/com/example/stickhero/charlist")));
        System.out.println("temp = "+temp);
        temp.add(c);
        System.out.println("temp = "+temp);
            for(int j=0;j<temp.size();j++){
                String s = String.valueOf(temp.get(j));
                fww.write(s +" ");
                System.out.println("writtern - "+s);
            }
        fww.close();
    }


    static int getUserCredits() throws FileNotFoundException {
        Scanner in2 = new Scanner(new BufferedInputStream(new FileInputStream("src/main/java/com/example/stickhero/credits")));
        ArrayList<Integer> int_arr2 = new ArrayList<>();
        while(in2.hasNext()){
            int y = Integer.parseInt(in2.next());
            int_arr2.add(y);
        }
        return int_arr2.get(0);
    }

    static void setUserCredits(int creds) throws IOException {
        PrintWriter fww2 = new PrintWriter((new FileWriter("src/main/java/com/example/stickhero/credits")));
        String s = String.valueOf(creds);
        fww2.write(s);
        fww2.close();
    }

}