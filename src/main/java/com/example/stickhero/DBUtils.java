package com.example.stickhero;

import com.almasb.fxgl.entity.action.Action;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;

public class DBUtils {

    private static String curr_user;

    public static String getCurr_user() {
        return curr_user;
    }

    public static void changeScene(ActionEvent event, String fxmlfile, String title, String username, String email, String cherries, String high_score){
        System.out.println("scene changed with username - "+username+" credits = "+cherries);
        Parent root = null;

        if(username!=null&&email!=null){

            try{
                if(fxmlfile.equals("logged-in.fxml")){

                    HelloApplication ha = new HelloApplication();
                    HelloApplication.initialize_game_details(Integer.parseInt(cherries),Integer.parseInt(high_score));
//                    ha.start_game(sta);
                    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    ha.start_game(stage,username,Integer.parseInt(cherries),Integer.parseInt(high_score));
                    HelloApplication.initialize_game_details(Integer.parseInt(cherries),Integer.parseInt(high_score));
                    return;
                }
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlfile));
                root = loader.load();
                System.out.println(fxmlfile);
                LoggedInController loggedInController = new LoggedInController();
                loggedInController = loader.getController();
                loggedInController.setUserInformation(username,email,cherries,high_score);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            try{
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlfile));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root,420,700));
//        HelloApplication helloApplication= new HelloApplication();
//        helloApplication.start(stage);
        stage.show();
    }

    public static void signUpUser(ActionEvent event , String username, String password,String email){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-video","root","123456");
            psCheckUserExists = ((java.sql.Connection) connection).prepareStatement("SELECT * FROM game_users WHERE username = ?");
            psCheckUserExists.setString(1,username);
            resultSet = psCheckUserExists.executeQuery();
            if(resultSet.isBeforeFirst()){
                //username is in use
                System.out.println("user already exits in-game");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cant use this username");
                alert.show();
            }else{
                psInsert = ((java.sql.Connection) connection).prepareStatement("INSERT INTO game_users (username,password,email,cherries,high_score) VALUES (?, ?, ?, ?, ? )");
                psInsert.setString(1,username);
                psInsert.setString(2,password);
                psInsert.setString(3,email);
                psInsert.setString(4,String.valueOf(0));
                psInsert.setString(5,String.valueOf(0));
                psInsert.executeUpdate();
                curr_user = username;
                System.out.println(curr_user);
                changeScene(event,"logged-in.fxml","Welcome!",username,email,String.valueOf(0),String.valueOf(0));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try{
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(psCheckUserExists!=null){
                try{
                psCheckUserExists.close();}catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if ((psInsert!=null)){
                try{
                    psInsert.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }

    public static void logInUser(ActionEvent event,String username,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-video","root","123456");
            preparedStatement = connection.prepareStatement("SELECT password, email,cherries,high_score FROM game_users WHERE username = ?");
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("user not found in db");
                Alert alert  = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided id-pass is incorrect");
                alert.show();
            }else{
                while (resultSet.next()){
                    String retrievedPassword = resultSet.getString("password");
                    String retrievedEmail = resultSet.getString("email");
                    String retrievedCherries = resultSet.getString("cherries");
                    String retrievedScore = resultSet.getString("high_score");
                    if(retrievedPassword.equals(password)){
                        curr_user = username;
                        System.out.println(curr_user);
                        changeScene(event,"logged-in.fxml","Welcome",username,retrievedEmail,retrievedCherries,retrievedScore);
                    }else{
                        System.out.println("Password did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Passcode did not match");
                        alert.show();
                    }
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try{
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try{
                    preparedStatement.close();}catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(connection!=null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }
    }

    public static void update_user_details(String cherries, String score) {
        String username = getCurr_user();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-video", "root", "123456");
            preparedStatement = connection.prepareStatement("UPDATE game_users SET cherries = ?, high_score = ? WHERE username = ?");
            preparedStatement.setString(1, cherries);
            preparedStatement.setString(2, score);
            preparedStatement.setString(3, username);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User details updated successfully");
            } else {
                System.out.println("Failed to update user details");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
