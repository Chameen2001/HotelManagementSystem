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

public class MealPackageFormController {
    public AnchorPane mealPackageFormContext;
    public AnchorPane mealPackageFormRootContext;
    public Pane modifyMealOption;
    public Pane deleteMealOption;
    public Pane newMealOption;
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



    public void addNewMealPackageClicked(MouseEvent mouseEvent) throws IOException {
        whichForm=true;
        mealPackageFormRootContext.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("../../view/admin/AddNewMealPackageForm.fxml"));
        Scene scene = mealPackageFormRootContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        mealPackageFormRootContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public void modifyMealPackageClicked(MouseEvent mouseEvent) throws IOException {
        whichForm=true;
        mealPackageFormRootContext.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("../../view/admin/ModifyMealPackageForm.fxml"));
        Scene scene = mealPackageFormRootContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        mealPackageFormRootContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public void deleteMealPackageClicked(MouseEvent mouseEvent) throws IOException {
        whichForm=true;
        mealPackageFormRootContext.getChildren().clear();
        Parent load = FXMLLoader.load(getClass().getResource("../../view/admin/DeleteMealPackageForm.fxml"));
        Scene scene = mealPackageFormRootContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        mealPackageFormRootContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public boolean backClicked(){
        if(whichForm){
            whichForm=false;
            mealPackageFormRootContext.getChildren().clear();
            mealPackageFormRootContext.getChildren().add(mealPackageFormContext);
            mealPackageFormContext.translateXProperty().set(mealPackageFormRootContext.getWidth());
            KeyValue keyValue = new KeyValue(mealPackageFormContext.translateXProperty(),0,Interpolator.EASE_IN);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.setOnFinished(event -> {

            });
            timeline.play();
            return false;
        }else {
            return true;
        }

    }

    public void modifyMealEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(modifyMealOption);
    }

    public void modifyMealExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(modifyMealOption);
    }

    public void newMealEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(newMealOption);
    }

    public void newMealExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(newMealOption);
    }

    public void deleteMealEnterd(MouseEvent mouseEvent) {
        scaleTransZoomIn(deleteMealOption);
    }

    public void deleteMealExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(deleteMealOption);
    }
}
