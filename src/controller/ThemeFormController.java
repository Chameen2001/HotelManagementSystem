package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class ThemeFormController {

    public AnchorPane themeFormContext;
    public StackPane rootContext;
    public JFXButton startBtn;
    public Label hotelBlueLbl;
    public Label OceanLbl;
    public ImageView symbol;

    public void initialize(){
        labelTransition();

    }

    public void labelTransition() {
        //        try{Thread.sleep(5000);}catch(Exception ex){}
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1.5));
        transition.setNode(OceanLbl);
        transition.setToY(-320);
        transition.play();

        TranslateTransition transition1 = new TranslateTransition();
        transition1.setDuration(Duration.seconds(1.5));
        transition1.setNode(hotelBlueLbl);
        transition1.setToY(-320);
        transition1.play();

        TranslateTransition transition2 = new TranslateTransition();
        transition2.setDuration(Duration.seconds(1.5));
        transition2.setNode(symbol);
        transition2.setToY(210);
        transition2.setOnFinished(event -> {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000),startBtn);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
        });
        transition2.play();

//        TranslateTransition transition3 = new TranslateTransition();
//        transition3.setDuration(Duration.seconds(1.5));
//        transition3.setNode(startBtn);
//        transition3.setToY(-70);
//        transition3.play();



    }

    public void startBtn(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../view/LogInForm.fxml"));
        Scene scene = rootContext.getScene();

        root.translateXProperty().set(scene.getWidth());
        rootContext.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_OUT);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event -> {
            rootContext.getChildren().remove(themeFormContext);
        });
        timeline.play();

    }
}

//fx:controller="controller.ThemeFormController"