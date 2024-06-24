package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;

public class Clickap implements EventHandler<ActionEvent> {
    public Rectangle rct ;
    Clickap(Rectangle rct){
        this.rct = rct;
    }

    @Override
    public void handle(ActionEvent event){
        Scale scale = new Scale();
        scale.setPivotY(100);
        Rotate rt = new Rotate();
        rt.setAngle(90);
        rct.getTransforms().addAll(scale,rt);
    }
}
