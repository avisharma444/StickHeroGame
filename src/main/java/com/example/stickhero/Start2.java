package com.example.stickhero;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.*;


public class Start2 extends Application {

    private Set<KeyCode> pressedKeys = new HashSet<>();
    private ScaleTransition scale;

    private boolean cherrylock = true;

    private boolean isFlipped = true;

    private storage gameData;

    private PauseTransition pause3 ;
    public double d;

    private RotateTransition rotate;
    private TranslateTransition stickmanTransition;

    private Rectangle pillar3;
    private TranslateTransition pillar3Transition;

    private Rectangle getPillar3() {
        return pillar3;
    }

    private TranslateTransition t;

    private static boolean flag;

    private TranslateTransition stickmanTransitionQuick;

    private TranslateTransition stickTransition;
    private TranslateTransition pillar1Transition;
    private TranslateTransition pillar2Transition;

    private boolean flag1 = false;
    private boolean flag2 = false;
    private boolean flag3 = false;
    private boolean flag4 = false;

    private int reloadFlag = 0;

    public int getReloadFlag() {
        return reloadFlag;
    }

    public void setReloadFlag(int reloadFlag) {
        this.reloadFlag = reloadFlag;
    }

    private saveDetails progress;


    public static saveDetails getSaveCurrState() {
        return saveCurrState;
    }

    public static void setSaveCurrState(saveDetails saveCurrState) {
        Start2.saveCurrState = saveCurrState;
    }

    private static saveDetails saveCurrState;

    private Rectangle stickRct;
    private Rectangle tempRct;

    private boolean flip_allow = false;


    private Rectangle pillar1;

    private pillar pillar1obj;
    private Rectangle pillar2;
    private pillar pillar2obj;

    private ArrayList<pillar> pillarArrayList;

    private static double minPillarWidth = 50;

    private Timeline collisionCheckTimeline;

    private static double maxPillarWidth = 100;

    private static boolean validStick;
    private static boolean stickFell;

    private static boolean stickmanIsFlipped;

    public static boolean isStickmanIsFlipped() {
        return stickmanIsFlipped;
    }

    public static boolean isValidStick() {
        return validStick;
    }


    public static boolean isStickFell() {
        return stickFell;
    }


    public static boolean isCherryIncremented() {
        return cherryIncremented;
    }


    public static boolean isStickmanIntersects() {
        return stickmanIntersects;
    }


    private static boolean cherryIncremented;

    private static boolean stickmanIntersects;

    private static Pane scenePane;
    private int start_x = 75;

    private Image stickmanImage = new Image(getClass().getResourceAsStream("Idle.png"));
    public ImageView stickmanImageView = new ImageView(stickmanImage);

    private Timeline timeline1;
    private Text counter;

    private static int score = 0;


    private Timeline timeline2;
    private Timeline timeline3;

    private Timeline timeline4;

    private Image cherryImage = new Image(getClass().getResourceAsStream("590774.png"));
    private ImageView cherryImageView = new ImageView(cherryImage);

    private Image pause_img = new Image(getClass().getResourceAsStream("PauseB.png"));
    private ImageView pause_iv = new ImageView(pause_img);


    private cherry cherryObj = new cherry(cherryImageView);

    private ImageView tempCherry = new ImageView(cherryImage);


    private static ArrayList<Double> cherryLocations = new ArrayList<Double>();

    private int pillar2HasCherry = 0;

    private int collectedCherryCount = 0;

    private Stage myStage;
    private double rotationPivotY = 0;

    private boolean canRotate = true;

    private boolean increaseFlag = true;

    private boolean game_lock = true;


    private ImageView cherryView = new ImageView(cherryImage);


    public ImageView stickmanImageview;


    private Text cherryText;


    public void setCherryOpacity(){
        double x = generateRandomNumber(0,2);
        if(x>1){
            cherryImageView.setOpacity(0);
        }else{
            cherryImageView.setOpacity(1);
        }
    }


    public void try_rotate(){
        if(canRotate){
            canRotate = false;
            Rotate rotateTransform = new Rotate();
            rotateTransform.setPivotX(stickRct.getX());
            rotateTransform.setPivotY(stickRct.getY()+stickRct.getHeight()+stickRct.getWidth()/2);
            stickRct.getTransforms().add(rotateTransform);
            timeline1 = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(rotateTransform.angleProperty(), 0)),
                    new KeyFrame(Duration.seconds(1.4), new KeyValue(rotateTransform.angleProperty(), 90)));

            timeline1.setOnFinished(event5 -> {
                timeline1.stop();
            });

            timeline1.play();

        }else {

        }

    }


    public void tryFlip(){
        System.out.println("here");
        if(stickmanImageView.getBoundsInParent().intersects(pillar2.getBoundsInParent())){
            System.out.println("over");
        }
        if(!(stickmanImageView.getBoundsInParent().getMinX()<pillar1.getBoundsInParent().getMaxX() || stickmanImageView.getBoundsInParent().getMaxX()>pillar2.getBoundsInParent().getMinX())&&!pause_flag&&!select_flag){
            isFlipped = !isFlipped;
            if (isFlipped) {
                stickmanImageView.setY(stickmanImageView.getBoundsInParent().getHeight()+stickRct.getWidth());
                stickmanImageView.setRotate(180);
                stickmanImageView.setScaleX(-1);
                flip_flag = false;
            } else {
                stickmanImageView.setY(0);
                stickmanImageView.setRotate(0);
                stickmanImageView.setScaleX(1);
                flip_flag = true;
            }
        }else{
            System.out.println("CANT FLIP");
        }

    }

    boolean isFlip(){
        if(stickmanImageView.getBoundsInParent().getMaxY()>pillar1.getBoundsInParent().getMinY()){

            stickmanImageView.setY(0);
            stickmanImageView.setRotate(0);
            stickmanImageView.setScaleX(1);
            return true;
        }
        return false;
    }
    public ImageView c1;
    public ImageView c2;
    public ImageView c3;
    public ImageView c4;
    public ImageView c5;
    public ImageView c6;

    public ImageView forward;
    public ImageView backward;

    public static int choice =1;
    public void setCheckNull(){
        c1.setOpacity(0);
        c2.setOpacity(0);
        c3.setOpacity(0);
        c4.setOpacity(0);
        c5.setOpacity(0);
        c6.setOpacity(0);
    }

    public ImageView get_C(int choice) throws FileNotFoundException {
        ArrayList<Integer>chars = HelloApplication.getChar_arr_list();
        ArrayList<Integer>temp1 = new ArrayList<>();
        for (Integer i :chars
             ) {
            if(!temp1.contains(i)){
                temp1.add(i);
            }
        }
        int idx = temp1.get(choice-1);
        if(idx == 1){
            return c1;
        } else if (idx==2) {
            return c2;
        }
        else if (idx==3) {
            return c3;
        }
        else if (idx==4) {
            return c4;
        }
        else if (idx==5) {
            return c5;
        }
        else if (idx==6) {
            return c6;
        }
        return null;
    }


    public void select_char() throws FileNotFoundException {
        ArrayList<Integer>chars = HelloApplication.getChar_arr_list();
        HashSet<Integer> char_unique = new HashSet<>(chars);
        Image i2 = new Image(getClass().getResourceAsStream("UI_Flat_Frame_01_Standard.png"));
        ImageView im2 = new ImageView(i2);
        im2.setLayoutY(240);
        im2.setLayoutX(168);
        im2.setScaleX(3.5);
        im2.setScaleY(3.5);
        Image i3 = new Image(getClass().getResourceAsStream("UI_Flat_Frame_02_Horizontal.png"));
        ImageView im3 = new ImageView(i3);
        im3.setLayoutY(390);
        im3.setLayoutX(168);
        im3.setScaleX(2);
        im3.setScaleY(1.6);
        scenePane.getChildren().addAll(im2,im3);
        Text goText = new Text("character");
        goText.setLayoutX(30);
        goText.setLayoutY(185);
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 48);
        goText.setFont(customFont);
        goText.setScaleX(0.7);
        goText.setScaleY(0.7);
        goText.toFront();
        goText.setFill(Color.BLACK);
        Text goText2 = new Text("start");
        goText2.setLayoutX(136);
        goText2.setLayoutY(420);
        Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 36);
        goText2.setFont(customFont2);
        goText2.setScaleX(0.7);
        goText2.setScaleY(0.7);
        goText2.toFront();
        goText2.setFill(Color.BLACK);
        scenePane.getChildren().addAll(goText2,goText);

        c1 = new ImageView(new Image(getClass().getResourceAsStream("archer.png")));
        c2 = new ImageView(new Image(getClass().getResourceAsStream("wizard.png")));
        c3 = new ImageView(new Image(getClass().getResourceAsStream("shaman.png")));
        c4 = new ImageView(new Image(getClass().getResourceAsStream("berserk.png")));
        c5 = new ImageView(new Image(getClass().getResourceAsStream("kitsune.png")));
        c6 = new ImageView(new Image(getClass().getResourceAsStream("yamabushi.png")));
        forward  =new ImageView(new Image(getClass().getResourceAsStream("Play.png")));
        backward  =new ImageView(new Image(getClass().getResourceAsStream("Play.png")));

        forward.setScaleX(3);
        forward.setScaleY(3);
        backward.setScaleX(-3);
        backward.setScaleY(3);
        forward.setLayoutY(280);
        backward.setLayoutY(280);
        backward.setLayoutX(im2.getBoundsInParent().getMinX()+backward.getFitWidth()+20);
        forward.setLayoutX(im2.getBoundsInParent().getMaxX()-forward.getFitWidth()-35);
        c1.setScaleX(1.8);
        c1.setScaleY(1.8);
        c2.setScaleX(1.8);
        c2.setScaleY(1.8);
        c3.setScaleX(1.8);
        c3.setScaleY(1.8);
        c4.setScaleX(1.8);
        c4.setScaleY(1.8);
        c5.setScaleX(1.8);
        c5.setScaleY(1.8);
        c6.setScaleX(1.5);
        c6.setScaleY(1.5);
        c1.setLayoutY(185);
        c1.setLayoutX(160);
        c2.setLayoutY(185);
        c2.setLayoutX(160);
        c3.setLayoutY(185);
        c3.setLayoutX(160);
        c4.setLayoutY(185);
        c4.setLayoutX(170);
        c5.setLayoutY(185);
        c5.setLayoutX(160);
        c6.setLayoutY(185);
        c6.setLayoutX(150);
        setCheckNull();
        ImageView t1 = get_C(1);
        t1.setOpacity(1);
        scenePane.getChildren().addAll(c1,c2,c3,c4,c5,c6,forward,backward);

        im3.setOnMouseClicked(done->{
            System.out.println("HI");
            try {
                ImageView t = get_C(choice);
                stickmanImageView.setImage(t.getImage());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            scenePane.getChildren().removeAll(im3,im2,c1,c2,c3,c4,c5,c6,forward,backward,goText2,goText);
            select_flag = false;

        });
        goText2.setOnMouseClicked(done->{
            System.out.println("HI");
            try {
                ImageView t = get_C(choice);
                stickmanImageView.setImage(t.getImage());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            scenePane.getChildren().removeAll(im3,im2,c1,c2,c3,c4,c5,c6,forward,backward,goText2,goText);
            select_flag = false;

        });


        forward.setOnMouseClicked(f->{
            if(choice<char_unique.size()){
            choice++;}
            System.out.println("FORWARD - "+choice);

            setCheckNull();
            try {
                ImageView tempimv = get_C(choice);
                tempimv.setOpacity(1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        backward.setOnMouseClicked(b->{
            if(choice>1){
            choice--;}
            System.out.println("BACKWARD - "+choice);

            setCheckNull();
            try {
                ImageView tempimv = get_C(choice);
                tempimv.setOpacity(1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });



    }


    public void initializer(Pane scenePane, saveDetails s1) throws FileNotFoundException {
        pause_iv.setFitHeight(40);
        pause_iv.setFitWidth(40);
        pause_iv.setLayoutX(6);
        pause_iv.setLayoutY(6);
        scenePane.getChildren().add(pause_iv);
        if(reloadFlag == 1){
            select_flag = false;

            double p1_width = s1.standingPillarWidth;
            double p2_width = s1.nextPillarWidth;
            double x1 = s1.standingPillarX;
            double x2 = s1.nextPillarX;
            score = s1.score;
            int cherries = s1.cherryCount;
            collectedCherryCount = cherries;
            pillar1 = new Rectangle(p1_width, 200, Color.BLACK);
            pillar1.setX(0);
            pillar1.setLayoutY(500);
            pillar1obj = new pillar(pillar1);

            //Pair<Double, Double> pillar2Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar2 = new Rectangle(p2_width, 200, Color.BLACK);
            pillar2.setLayoutX(x2);
            pillar2.setLayoutY(500);
            pillar2obj = new pillar(pillar2);

            SaveCurrState.f = false;
            reloadFlag = 0;
        }

        else {
            select_char();
            pillar1 = new Rectangle(generateRandomNumber(75, 100), 200, Color.BLACK);
            pillar1.setX(0);
            pillar1.setLayoutY(500);
            score = 0;
            pillar2 = new Rectangle(generateRandomNumber(50, 70), 200, Color.BLACK);
            pillar2.setLayoutX(generateRandomNumber(150, 320));
            pillar2.setLayoutY(500);
        }
        cherryText = new Text();
        cherryText.setText(String.valueOf(collectedCherryCount));
        cherryText.setLayoutX(330);
        cherryText.setLayoutY(50);
        cherryText.setScaleX(0.7);
        cherryText.setScaleY(0.7);

        Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/kamikaze.3d-gradient-italic.ttf"), 48);

        cherryText.setFont(customFont);


        counter = new Text();
        counter.setText(String.valueOf(score));
        counter.setLayoutY(100);
        counter.setLayoutX(200);

        scenePane.getChildren().add(cherryText);
        Font customFont1 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 36);


        counter.setFont(customFont);
        cherryText.setFont(customFont1);
//        cherryText.s

        scenePane.getChildren().add(counter);

        scale = new ScaleTransition(Duration.millis(4000), stickRct);
        scale.setFromY(1.0);
        scale.setToY(2.0);

        stickmanImageView.setFitHeight(50);
        stickmanImageView.setFitWidth(60);
        stickmanImageView.setLayoutX(pillar1.getBoundsInParent().getMaxX()-stickmanImageView.getFitWidth());
        start_x = 75;
        stickmanImageView.setLayoutY(500-stickmanImageView.getFitHeight());

        stickRct = new Rectangle(5, 1, Color.BLACK);
        stickRct.setLayoutX(stickmanImageView.getLayoutX()+stickmanImageView.getFitWidth()-5);

        stickRct.setLayoutY(stickmanImageView.getLayoutY()+stickmanImageView.getFitHeight());

        scenePane.getChildren().add(stickRct);
        scenePane.getChildren().add(pillar1);
        scenePane.getChildren().add(pillar2);
        scenePane.getChildren().add(stickmanImageView);


        pillarArrayList = new ArrayList<>();
        pillarArrayList.add(pillar1obj);
        pillarArrayList.add(pillar2obj);
        gameData = new storage(pillarArrayList);
    }

    public void show_pause_menu(){
        Image i2 = new Image(getClass().getResourceAsStream("UI_Flat_Frame_01_Horizontal.png"));
        ImageView im2 = new ImageView(i2);
        im2.setLayoutY(196);
        im2.setLayoutX(168);
        im2.setScaleX(3.5);
        im2.setScaleY(3.5);
        scenePane.getChildren().add(im2);
        Text goText = new Text("Paused");
        goText.setLayoutX(95);
        goText.setLayoutY(228);
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 48);
        goText.setFont(customFont);
        goText.setScaleX(0.7);
        goText.setScaleY(0.7);

        goText.toFront();
        goText.setFill(Color.BLACK);

        scenePane.getChildren().add(goText);
        Image i3 = new Image(getClass().getResourceAsStream("FloppyDisk.png"));
        ImageView iv2 = new ImageView(i3);
        iv2.setLayoutY(300);
        iv2.setLayoutX(50);
        iv2.setFitHeight(47.0);
        iv2.setFitWidth(47.0);
        scenePane.getChildren().add(iv2);
        Image i4 = new Image(getClass().getResourceAsStream("Home.png"));
        ImageView iv4 = new ImageView(i4);
        iv4.setLayoutY(300);
        iv4.setLayoutX(200);
        iv4.setFitHeight(47.0);
        iv4.setFitWidth(47.0);
        scenePane.getChildren().add(iv4);
        Image irev = new Image(getClass().getResourceAsStream("Play.png"));
        ImageView iv5 = new ImageView(irev);
        iv5.setLayoutY(300);
        iv5.setLayoutX(350);
        iv5.setFitHeight(47.0);
        iv5.setFitWidth(47.0);
        scenePane.getChildren().add(iv5);
        iv2.setOnMouseClicked(savegame ->{

            saveDetails progress = new saveDetails(collectedCherryCount, score, pillar1.getWidth(), pillar1.getLayoutX(), pillar2.getWidth(), pillar2.getLayoutX());
            try {
                serialize(progress);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Text save_t = new Text("Saved !");
            save_t.setLayoutX(170);
            save_t.setLayoutY(150);
            Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 24);
            save_t.setFont(customFont2);
            save_t.setFill(Color.BLACK);
            FadeTransition save_fade = new FadeTransition(Duration.seconds(1));
            save_fade.setFromValue(1);
            save_fade.setToValue(0);
            save_fade.setNode(save_t);
            scenePane.getChildren().add(save_t);
            save_fade.play();

        });


        iv4.setOnMouseClicked(goHomeEvent ->{
            HelloController hc = new HelloController();
            try {
                hc.toHomeScreen(goHomeEvent);
            } catch (IOException | gameNotFoundError e) {
                throw new RuntimeException(e);
            }
        });

        iv5.setOnMouseClicked(endpause -> {
            scenePane.getChildren().removeAll(iv2,iv4,iv5,im2,goText);
            pause_flag = false;
        });

    }

    private boolean pause_flag = false;
    private boolean select_flag ;


    @Override
    public void start(Stage stage) {
        try {
            select_flag = true;
            pause_iv.setOnMouseClicked(e->{
                if(select_flag == false) {
                    pause_flag = true;
                    show_pause_menu();
                }
            });
            stickHero sh = stickHero.getInstance();
            stickmanImageview = sh.getImv();


            //used the singleton stickman instance "sh"
            System.out.println("-----STARTING--------");

            cherrylock = true;
            isFlipped = false;
            increaseFlag = true;
            game_lock = true;
            canRotate = true;

            Parent root = FXMLLoader.load(getClass().getResource("play_menu3.fxml"));
            scenePane = new Pane(root);
            cherryView.setLayoutX(370);
            cherryView.setLayoutY(10);
            cherryView.setFitHeight(35);
            cherryView.setFitWidth(35);
            scenePane.getChildren().add(cherryView);

            initializer(scenePane,saveCurrState);
            System.out.println("avlue - "+isFlip());




            stickmanTransition = new TranslateTransition(Duration.seconds(2), stickmanImageView);
            stickTransition = new TranslateTransition(Duration.seconds(2), stickRct);
            stickmanTransitionQuick = new TranslateTransition(Duration.seconds(0), stickmanImageView);
            pillar1Transition = new TranslateTransition(Duration.seconds(2), pillar1);
            pillar2Transition = new TranslateTransition(Duration.seconds(2), pillar2);
            cherryImageView = generateCherry2();


            Scene scene = new Scene(scenePane);
            scene.setOnKeyPressed(this::handleKeyPressed);
            scene.setOnKeyReleased(this::handleKeyReleased);

            stage.setScene(scene);
            myStage = stage;
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double generateRandomNumber(double a, double b) {
        Random random = new Random();
        return random.nextDouble(b - a + 1) + a;
    }


    public void tryIncrease(){
        if(increaseFlag&&!pause_flag&&!select_flag){
            double newHeight = stickRct.getHeight() + 10;
            double newY = stickRct.getY() - 10;
            stickRct.setHeight(newHeight);
            stickRct.setY(newY);
        }
    }

    public boolean flip_flag = true;



    private boolean aKeyPressed = false;

    private void handleKeyPressed(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        pressedKeys.add(keyEvent.getCode());

        if (code.equals(KeyCode.A)) {
            tryIncrease();
        }
        else if (code.equals(KeyCode.SPACE)) {
            tryFlip();
        }

//        if(code.equals(KeyCode.S)){
//            saveDetails progress = new saveDetails(collectedCherryCount, score, pillar1.getWidth(), pillar1.getLayoutX(), pillar2.getWidth(), pillar2.getLayoutX());
//            try {
//                serialize(progress);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            Text save_t = new Text("Saved !");
//            save_t.setLayoutX(170);
//            save_t.setLayoutY(180);
//            Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/kamikaze.3d-gradient-italic.ttf"), 24);
//            save_t.setFont(customFont2);
//            save_t.setFill(Color.BLACK);
//            scenePane.getChildren().add(save_t);
//
//            HelloController hc = new HelloController();
//
//
//        }
    }

    public boolean collided = false;


    private void handleKeyReleased(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        pressedKeys.remove(code);
        if (code == KeyCode.A && game_lock&&!pause_flag&&!select_flag) {
            cherrylock = true;

            scale.stop();
            flag = false;
            increaseFlag = false;
            game_lock = false;

            try_rotate();
            System.out.println("oye");
            PauseTransition pause = new PauseTransition(Duration.seconds(1.4));
            pause.setOnFinished(event -> {

                if (stickRct.getHeight() + stickRct.getLayoutX() >= pillar2.getLayoutX()-5 && stickRct.getHeight() + stickRct.getLayoutX() <= pillar2.getLayoutX() + pillar2.getWidth()) {
                    score++;
                    stickFell = true;
                    validStick = stickRct.getHeight() + stickRct.getLayoutX() >= pillar2.getLayoutX() && stickRct.getHeight() + stickRct.getLayoutX() <= pillar2.getLayoutX() + pillar2.getWidth();

                    counter.setText(String.valueOf(score));


                    timeline2 = new Timeline();
                    pillar3 = generateNewPillar3();
                    tempCherry  = generateCherry();
                    System.out.println("Cherry opacity - "+cherryImageView.getOpacity());
//
//                    System.out.println("before1 - "+stickmanImageView.getLayoutX());
//                    System.out.println("before2 - "+pillar1.getLayoutX());
//                    System.out.println("before3 - "+pillar2.getLayoutX());
//                    System.out.println("before4 - "+pillar3.getLayoutX());

//                    KeyFrame k1  = new KeyFrame(Duration.ZERO, new KeyValue(stickmanImageView.layoutXProperty(), stickmanImageView.getX()));
                    double p1 = pillar1.getLayoutX();
                    double p2 = pillar2.getBoundsInParent().getMinX();
                    double p3 = pillar3.getLayoutX();
                    double stm = stickmanImageView.getLayoutX();
                    double shm = stickmanImageview.getLayoutX();

                    double inc = cherryImageView.getLayoutX();


//                    KeyFrame k61  = new KeyFrame(Duration.seconds(1.2), new KeyValue(tempCherry.layoutXProperty(), tempCherry.getLayoutX()));
                    KeyFrame k62  = new KeyFrame(Duration.seconds(2), new KeyValue(tempCherry.layoutXProperty(), generateRandomNumber(pillar1.getBoundsInParent().getMaxX()+cherryImageView.getFitWidth(),pillar2.getBoundsInParent().getMinX()-cherryImageView.getFitWidth())));
//                    KeyFrame k63  = new KeyFrame(Duration.seconds(1.2), new KeyValue(cherryImageView.layoutXProperty(), cherryImageView.getLayoutX()));
                    KeyFrame k64  = new KeyFrame(Duration.seconds(2), new KeyValue(cherryImageView.layoutXProperty(),-200));



                    KeyFrame k6 =  new KeyFrame(Duration.seconds(1.2), new KeyValue(stickmanImageView.layoutXProperty(), pillar2.getBoundsInParent().getMaxX() - stickmanImageView.getFitWidth()));
                    KeyFrame k10  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutXProperty(), pillar2.getWidth()-stickmanImageView.getFitWidth()-5));

                    KeyFrame k06 =  new KeyFrame(Duration.seconds(1.2), new KeyValue(stickmanImageview.layoutXProperty(), pillar2.getBoundsInParent().getMaxX() - stickmanImageview.getFitWidth()));
                    KeyFrame k100  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageview.layoutXProperty(), pillar2.getWidth()-stickmanImageview.getFitWidth()-5));

                    Timeline tt = new Timeline();
                    tt.getKeyFrames().addAll(k06,k100);
                    KeyFrame k11  = new KeyFrame(Duration.seconds(2), new KeyValue(stickRct.layoutXProperty(), p1-stickRct.getHeight()));

                    KeyFrame k7  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar1.layoutXProperty(),-200));
                    KeyFrame k8  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar2.layoutXProperty(), 0));
                    KeyFrame k9  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar3.layoutXProperty(), p2 ));
                    if (pillar2HasCherry == 1) {
                        KeyFrame kCherry = new KeyFrame(Duration.seconds(1.2), new KeyValue(cherryImageView.layoutXProperty(), cherryImageView.getLayoutX()));
                        KeyFrame kCherry2 = new KeyFrame(Duration.seconds(2), new KeyValue(cherryImageView.layoutXProperty(),generateRandomNumber(pillar1.getBoundsInParent().getMaxX(),pillar2.getBoundsInParent().getMinX())));
                        timeline2.getKeyFrames().add(kCherry);
                        timeline2.getKeyFrames().add(kCherry2);


//                        timeline2.getKeyFrames().add(chkCollision);
                    }
//                    timeline2.getKeyFrames().add(k61);
//                    timeline2.getKeyFrames().add(k63);
                    timeline2.getKeyFrames().add(k64);
                    timeline2.getKeyFrames().add(k62);

                    timeline2.getKeyFrames().add(k7);
                    timeline2.getKeyFrames().add(k8);
                    timeline2.getKeyFrames().add(k9);
                    timeline2.getKeyFrames().add(k10);
                    timeline2.getKeyFrames().add(k11);
                    timeline2.setOnFinished(op->{
                        flip_allow = false;
                        cherryImageView = tempCherry;
                        pillar1 = pillar2;
                        pillar2 = pillar3;
                        canRotate = true;
                        stickRct = generate_stick();
                        increaseFlag = true;
                        game_lock = true;


                    });




                    collisionCheckTimeline = new Timeline(
                            new KeyFrame(Duration.millis(8), wi -> {
//                                System.out.println("Checking for collision");
//                                System.out.println("is flipped -  "+ isFlipped);
                                Bounds cherryBounds = cherryImageView.getBoundsInParent();
                                Bounds p2b= pillar2.getBoundsInParent();

                                if (stickmanImageView.getBoundsInParent().getMaxX()>= p2b.getMinX() && !flip_flag){

                                    timeline3.stop();
                                    timeline2.stop();
//                                    stickmanImageView.setLayoutX(pillar2.getBoundsInParent().getMinX()-stickmanImageView.getFitWidth());

                                    double xx = stickmanImageView.getLayoutX();
                                    System.out.println("x2 layout - "+pillar2.getLayoutX());
                                    Timeline endl = new Timeline();
                                    KeyFrame kk2 = new KeyFrame(Duration.ZERO,new KeyValue(stickmanImageView.xProperty(),stickmanImageView.getLayoutX()));
                                    KeyFrame kk3 = new KeyFrame(Duration.seconds(2),new KeyValue(stickmanImageView.yProperty(),800));
                                    endl.getKeyFrames().addAll(kk2,kk3);


                                    TranslateTransition fall = new TranslateTransition(Duration.seconds(0.5),stickmanImageView);
                                    stickmanImageView.setLayoutX(xx);
                                    stickmanImageView.setX(pillar2.getBoundsInParent().getMinX()-pillar2.getWidth());
                                    fall.setToY(800);

                                    fall.play();
                                    fall.setOnFinished(oi->{
                                        try {
                                            end();
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    });


//                                    ended.play();
                                    collisionCheckTimeline.stop();


                                }
                                if (stickmanImageView.getLayoutX() <= cherryBounds.getMaxX() && stickmanImageView.getLayoutX() >= cherryBounds.getMinX()&& isFlipped) {
                                    System.out.println("Collision out");
                                    if(cherrylock){
                                        System.out.println("Collision in");
                                        collectedCherryCount++;
                                        cherrylock = false;
                                        cherryIncremented = true;
                                        stickmanIsFlipped = isFlipped;
                                        stickmanIntersects = stickmanImageView.getLayoutX() <= cherryBounds.getMaxX() && stickmanImageView.getLayoutX() >= cherryBounds.getMinX()&& isFlipped;
                                        boolean stickfigintersects = stickmanImageview.getLayoutX() <= cherryBounds.getMaxX() && stickmanImageview.getLayoutX() >= cherryBounds.getMinX()&& isFlipped;

                                        cherryText.setText(String.valueOf(collectedCherryCount));
                                        scenePane.getChildren().remove(cherryImageView);
                                    }
                                    System.out.println("after - "+collectedCherryCount);

                                }
                            })
                    );

                    collisionCheckTimeline.setCycleCount(Timeline.INDEFINITE);
                    collisionCheckTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(8)));
                    collisionCheckTimeline.play();
                    timeline3 = new Timeline();


                    timeline3.getKeyFrames().add(k6);
                    flip_allow = true;
                    timeline3.play();

                    timeline3.setOnFinished(opi->{
                        collisionCheckTimeline.stop();
                        flip_allow = false;
                        timeline2.play();
                    });
                }

                else
                {
                    try {
                        end();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
            pause.play();

        }

    }


    private static void serialize(saveDetails info) throws IOException{
        ObjectOutputStream out = null;
        try{
            System.out.println(info);
            out = new ObjectOutputStream(new FileOutputStream("saveProgressNew.txt"));
            out.writeObject(info);
        }finally {
            out.close();
        }
    }

    public static void deserialize(String progressFile) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();
            System.out.println(s1);
        } finally {
            in.close();
        }
    }




    private static int cherryOccurs() {
        Random random = new Random();
        return random.nextInt(2);
    }



    private static Map<Double,Rectangle> pillarr_arrlist = new HashMap<>();

    private Rectangle generateNewPillar3() {
        double width = generateRandomNumber(50, 70);
        if(!pillarr_arrlist.containsKey(width)){
            Rectangle pp = new Rectangle(generateRandomNumber(50, 70), 200, Color.BLACK);
            pp.setLayoutX(440 + pp.getWidth());
            pp.setLayoutY(500);
            pillarr_arrlist.put(width,pp);

        }
        Rectangle rectangle = pillarr_arrlist.get(width);
        rectangle.setLayoutX(440 + rectangle.getWidth());
        rectangle.setLayoutY(500);

        scenePane.getChildren().add(rectangle);

        return rectangle;

    }


    ImageView generateCherry(){
        Image ci = new Image(getClass().getResourceAsStream("590774.png"));
        ImageView temp = new ImageView(ci);
        double x = generateRandomNumber(0,2);
        if(x>1){
            temp.setOpacity(1);
        }else{
            temp.setOpacity(1);
        }

        temp.setFitHeight(30);
        temp.setFitWidth(30);
        temp.setLayoutX(500);
        temp.setLayoutY(pillar2.getLayoutY()+10);
        scenePane.getChildren().add(temp);

        cherryLocations.add(temp.getLayoutX());
        return temp;

    }

    ImageView generateCherry2(){
        Image ci = new Image(getClass().getResourceAsStream("590774.png"));
        ImageView temp = new ImageView(ci);


        temp.setFitHeight(30);
        temp.setFitWidth(30);
        temp.setLayoutX(generateRandomNumber(pillar1.getBoundsInParent().getMaxX()+10, pillar2.getBoundsInParent().getMinX()-20));
        temp.setLayoutY(pillar2.getLayoutY()+10);
        scenePane.getChildren().add(temp);

        cherryLocations.add(temp.getLayoutX());
        return temp;

    }

    private Rectangle generate_stick(){
        stickRct = new Rectangle(5, 1, Color.BLACK);
        stickRct.setLayoutX(stickmanImageView.getLayoutX()+stickmanImageView.getFitWidth());

        stickRct.setLayoutY(stickmanImageView.getLayoutY()+stickmanImageView.getFitHeight());

        scale = new ScaleTransition(Duration.millis(4000), stickRct);
        scale.setFromY(1.0);
        scale.setToY(2.0);
        Rotate rotateTransform = new Rotate();
        rotateTransform.setPivotX(stickRct.getX());
        rotateTransform.setPivotY(stickRct.getY()+stickRct.getHeight()+stickRct.getWidth()/2);
        stickRct.getTransforms().add(rotateTransform);
        scenePane.getChildren().add(stickRct);
        return stickRct;
    }

    public static void writeScore(int x) throws IOException {

        PrintWriter fww = new PrintWriter((new FileWriter("highscore.txt")));
        String s = String.valueOf(x);
        fww.write(s +" ");
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

    public static void main(String[] args) throws IOException {
        readHighScore(5);
        readHighScore(7);
        MusicPlayer player = new MusicPlayer();
//        Song1Player song1Player = new Song1Player(player);
//
        Thread music_t = new Thread(player);
        music_t.start();
        launch(args);
    }

    public void end() throws IOException {
        int curr_c = HelloApplication.getUserCredits();
        HelloApplication.setUserCredits(curr_c+collectedCherryCount);
        int x = readHighScore(5);
        {
            if(score>readHighScore(1)){
                writeScore(score);
            }
            SaveCurrState.r1 = pillar1;
            SaveCurrState.r2 = pillar2;
            SaveCurrState.score = score;

            timeline4 = new Timeline();
            KeyFrame k2  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutXProperty(), stickmanImageView.getX()+stickRct.getBoundsInParent().getMaxX()-10));
            KeyFrame k3  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutYProperty(), stickmanImageView.getLayoutY()));
            KeyFrame k4  = new KeyFrame(Duration.seconds(4), new KeyValue(stickmanImageView.layoutYProperty(), stickmanImageView.getLayoutY()+500));

//                    timeline4.getKeyFrames().add(k1);
            timeline4.getKeyFrames().add(k2);
            timeline4.getKeyFrames().add(k3);
            timeline4.getKeyFrames().add(k4);
            timeline4.play();

            PauseTransition pp = new PauseTransition(Duration.seconds(4));
            pp.play();
            timeline4.setOnFinished(oo->
            {

                Image i2 = new Image(getClass().getResourceAsStream("UI_Flat_Frame_01_Horizontal.png"));
                ImageView im2 = new ImageView(i2);
                im2.setLayoutY(196);
                im2.setLayoutX(168);
                im2.setScaleX(3.5);
                im2.setScaleY(3.5);

                scenePane.getChildren().add(im2);
                Text goText = new Text("Game Over!");
                goText.setLayoutX(30);
                goText.setLayoutY(210);

                // Load the font
                Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 48);
                goText.setFont(customFont);
                goText.setScaleX(0.7);
                goText.setScaleY(0.7);

                goText.toFront();
                goText.setFill(Color.BLACK);

                scenePane.getChildren().add(goText);

                Text hs = new Text("Highest Score: "+x);
                hs.setLayoutX(80);
                hs.setLayoutY(239);
                Font customFont5 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 24);
                hs.setFont(customFont5);
                hs.setFill(Color.BLACK);
                scenePane.getChildren().add(hs);


                Image i3 = new Image(getClass().getResourceAsStream("FloppyDisk.png"));
                ImageView iv2 = new ImageView(i3);
                iv2.setLayoutY(300);
                iv2.setLayoutX(50);
                iv2.setFitHeight(47.0);
                iv2.setFitWidth(47.0);
                scenePane.getChildren().add(iv2);
                Image i4 = new Image(getClass().getResourceAsStream("Home.png"));
                ImageView iv4 = new ImageView(i4);
                iv4.setLayoutY(300);
                iv4.setLayoutX(200);
                iv4.setFitHeight(47.0);
                iv4.setFitWidth(47.0);
                scenePane.getChildren().add(iv4);
                Image irev = new Image(getClass().getResourceAsStream("Restart.png"));
                ImageView iv5 = new ImageView(irev);
                iv5.setLayoutY(300);
                iv5.setLayoutX(350);
                iv5.setFitHeight(47.0);
                iv5.setFitWidth(47.0);
                scenePane.getChildren().add(iv5);



                iv2.setOnMouseClicked(savegame ->{

                    saveDetails progress = new saveDetails(collectedCherryCount, score, pillar1.getWidth(), pillar1.getLayoutX(), pillar2.getWidth(), pillar2.getLayoutX());
                    try {
                        serialize(progress);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Text save_t = new Text("Saved !");
                    save_t.setLayoutX(170);
                    save_t.setLayoutY(150);
                    Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 24);
                    save_t.setFont(customFont2);
                    save_t.setFill(Color.BLACK);
                    FadeTransition save_fade = new FadeTransition(Duration.seconds(1));
                    save_fade.setFromValue(1);
                    save_fade.setToValue(0);
                    save_fade.setNode(save_t);
                    scenePane.getChildren().add(save_t);
                    save_fade.play();

                });


                iv4.setOnMouseClicked(goHomeEvent ->{
                    HelloController hc = new HelloController();
                    try {
                        hc.toHomeScreen(goHomeEvent);
                    } catch (IOException | gameNotFoundError e) {
                        throw new RuntimeException(e);
                    }
                });

                iv5.setOnMouseClicked(revival -> {
                    if(collectedCherryCount >= 3){
                        collectedCherryCount = collectedCherryCount -3;
                        try {
                            HelloApplication.setUserCredits(HelloApplication.getUserCredits()-3);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        progress = new saveDetails(collectedCherryCount, score, pillar1.getWidth(), pillar1.getLayoutX(), pillar2.getWidth(), pillar2.getLayoutX());
                        try {
                            serialize(progress);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        ObjectInputStream in = null;

                        try {
                            in = new ObjectInputStream (
                                    new FileInputStream("saveProgressNew.txt"));
                            saveDetails s1 = (saveDetails) in.readObject();

                            reloadFlag = 1;
                            saveCurrState = s1;
                            start(myStage);


                            System.out.println(s1);
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        } finally {
                            try {
                                assert in != null;
                                in.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }else {
                        Text revf = new Text("Insufficient cherries !");
                        revf.setLayoutX(65);
                        revf.setLayoutY(140);
                        Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/ROGFonts-Regular.otf"), 20);
                        revf.setFont(customFont2);
                        revf.setFill(Color.BLACK);
                        FadeTransition rev_fade = new FadeTransition(Duration.seconds(1));
                        rev_fade.setFromValue(1);
                        rev_fade.setToValue(0);
                        rev_fade.setNode(revf);
                        scenePane.getChildren().add(revf);
                        rev_fade.play();
                    }
                });
        });}
    }
}




class saveDetails implements Serializable {
    public int cherryCount;
    public int score;
    public double standingPillarWidth;
    public double standingPillarX;
    public double nextPillarWidth;
    public double nextPillarX;

    @Override
    public String toString() {
        return "\nsaveDetails{" +
                "cherryCount=" + cherryCount +
                ", score=" + score +
                ", standingPillarWidth=" + standingPillarWidth +
                ", standingPillarX=" + standingPillarX +
                ", nextPillarWidth=" + nextPillarWidth +
                ", nextPillarX=" + nextPillarX +
                "\n}";
    }

    public saveDetails(int cherryCount, int score, double standingPillarWidth, double standingPillarX, double nextPillarWidth, double nextPillarX) {
        this.cherryCount = cherryCount;
        this.score = score;
        this.standingPillarWidth = standingPillarWidth;
        this.standingPillarX = standingPillarX;
        this.nextPillarWidth = nextPillarWidth;
        this.nextPillarX = nextPillarX;
    }
}


class SaveCurrState {

    public static boolean isF() {
        return f;
    }

    public static boolean f;

    static Rectangle r1;
    static Rectangle r2;
    static int score;

    public static void setF(boolean f) {
        SaveCurrState.f = f;
    }

    static int cherries;

}