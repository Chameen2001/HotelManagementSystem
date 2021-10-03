package controller.receptionist;

import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class ReserveRoomFormController {
    public AnchorPane roomFormContext;
    public Pane checkRoomOption;
    public Pane selectMealOption;
    public Pane addGuestOption;
    private DashBoardFormController controller;
    public boolean whichForm;

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

    public void setController(DashBoardFormController controller){

        this.controller= controller;

    }

    public void checkRoomAvailabilityClicked(MouseEvent mouseEvent) throws IOException {
        whichForm=true;
        controller.dashBoardContext.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("../../view/receptionist/CheckRoomAvailabilityForm.fxml"));
        Scene scene = controller.dashBoardContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        controller.dashBoardContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void addGuestDetailsClicked(MouseEvent mouseEvent) throws IOException {
        whichForm=true;
        controller.dashBoardContext.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("../../view/receptionist/AddGuestDetailsForm.fxml"));
        Scene scene = controller.dashBoardContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        controller.dashBoardContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public void selectMealPlanClicked(MouseEvent mouseEvent) throws IOException {
        whichForm=true;
        controller.dashBoardContext.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("../../view/receptionist/SelectMealPlaneForm.fxml"));
        Scene scene = controller.dashBoardContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        controller.dashBoardContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public boolean backClicked(){
        if(whichForm){
            whichForm=false;
            controller.dashBoardContext.getChildren().clear();
            controller.dashBoardContext.getChildren().add(roomFormContext);
            controller.dashBoardContext.translateXProperty().set(controller.dashBoardContext.getWidth());

            KeyValue keyValue = new KeyValue(controller.dashBoardContext.translateXProperty(),0,Interpolator.EASE_IN);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
            return false;
        }else{
            return true;
        }
    }

    public void checkRoomEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(checkRoomOption);
    }

    public void checkRoomExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(checkRoomOption);
    }

    public void addGuestEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(addGuestOption);
    }

    public void addGuestExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(addGuestOption);
    }

    public void selectMealEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(selectMealOption);
    }

    public void selectMealExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(selectMealOption);
    }
}
