package controller.admin;


import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class RoomFormController {
    public AnchorPane roomFormContext;
    public boolean whichForm=false;
    public AnchorPane roomFormRootContext;
    public Pane modifyRoomOption;
    public Pane newRoomOption;
    public Pane deleteRoomOption;
    RoomFormController controller;

    public void scaleTransZoomIn(Pane Node){
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(200));
        scaleTransition.setNode(Node);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
    }
    public void scaleTransZoomOut(Pane Node){
        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(200),Node);
        scaleTransition2.setToX(1);
        scaleTransition2.setToY(1);
        scaleTransition2.play();
    }



    public void addNewRoomClicked(MouseEvent mouseEvent) throws IOException {
        whichForm=true;
        roomFormRootContext.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("../../view/admin/AddNewRoomForm.fxml"));
        Scene scene = roomFormRootContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        roomFormRootContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public void modifyRoomClicked(MouseEvent mouseEvent) throws IOException {

        whichForm=true;

        roomFormRootContext.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("../../view/admin/ModifyRoomForm.fxml"));
        Scene scene = roomFormRootContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        roomFormRootContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void deleteRoomClicked(MouseEvent mouseEvent) throws IOException {
        whichForm=true;
        roomFormRootContext.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("../../view/admin/DeleteRoomForm.fxml"));
        Scene scene = roomFormRootContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        roomFormRootContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public boolean backClicked() throws IOException {

        if(whichForm){
            whichForm=false;
            roomFormRootContext.getChildren().clear();
            roomFormRootContext.getChildren().add(roomFormContext);
            roomFormContext.translateXProperty().set(roomFormRootContext.getWidth());
            KeyValue keyValue = new KeyValue(roomFormContext.translateXProperty(),0,Interpolator.EASE_IN);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();



            return false;
        }else {
            return true;
        }
    }

    public void modifyRoomEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(modifyRoomOption);
    }

    public void modifyRoomExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(modifyRoomOption);
    }

    public void newRoomEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(newRoomOption);
    }

    public void newRoomExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(newRoomOption);
    }

    public void deleteRoomEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(deleteRoomOption);
    }

    public void deleteRoomExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(deleteRoomOption);
    }
}
