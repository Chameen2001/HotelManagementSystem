package controller.admin;

import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

public class DashBoardFormController {

    public ImageView logOutBtn;
    public ImageView homeBtn;
    public ImageView settingBtn;
    public AnchorPane dashBoardFormRootContext;
    public AnchorPane dashBoardContext;
    public AnchorPane homeFormContext;
    public Pane roomOption;
    public ImageView backBtn;
    public Pane incomeOption;
    public Pane mealOption;
    String whichForm;
    Object controller;

    public void scaleTransZoomIn(ImageView Node){
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(200));
        scaleTransition.setNode(Node);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.play();
    }
    public void scaleTransZoomOut(ImageView Node){
        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(200),Node);
        scaleTransition2.setToX(1);
        scaleTransition2.setToY(1);
        scaleTransition2.play();
    }
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

    public void initialize(){
        backBtn.setVisible(false);
    }

    public void clickedAnimation(ImageView Node){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(100));
        transition.setNode(Node);
        transition.setToY(-10);
        transition.setAutoReverse(true);
        transition.setCycleCount(2);
        transition.play();
    }public void clickedAnimation(Pane Node){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(100));
        transition.setNode(Node);
        transition.setToY(-10);
        transition.setAutoReverse(true);
        transition.setCycleCount(2);
        transition.play();
    }

    private void backBtnComes(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(500));
        transition.setNode(backBtn);
        transition.setFromX(100);
        transition.setFromY(-100);
        transition.setToX(0);
        transition.setToY(0);
        transition.play();
    }

    public void logOutMeth(MouseEvent mouseEvent) throws IOException {
        clickedAnimation(logOutBtn);
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure want to logout?",yes,no);
        alert.setTitle("Confirmation Alert");
        /*1.8-->(windows null pointer exception)-->java-1.8*/
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../../view/LogInForm.fxml")));
            Stage stage = (Stage) dashBoardFormRootContext.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
    public void homeClickedMeth(MouseEvent mouseEvent) {
        backBtn.setVisible(false);
        clickedAnimation(homeBtn);
        dashBoardContext.getChildren().clear();
        dashBoardContext.getChildren().add(homeFormContext);
        homeFormContext.translateXProperty().set(dashBoardContext.getWidth());
        KeyValue keyValue = new KeyValue(homeFormContext.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event -> {

        });
        timeline.play();


    }

    public void homeMouseEnteredMeth(MouseEvent mouseEvent) {
        scaleTransZoomIn(homeBtn);

    }

    public void homeMouseExitedMeth(MouseEvent mouseEvent) {
        scaleTransZoomOut(homeBtn);

    }

    public void settingMouseClickedMeth(MouseEvent mouseEvent) {
        clickedAnimation(settingBtn);
    }

    public void settingMouseEnteredMeth(MouseEvent mouseEvent) {
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(500));
        rotateTransition.setNode(settingBtn);
        rotateTransition.setToAngle(180);
        rotateTransition.play();
    }

    public void settingMouseExitedMeth(MouseEvent mouseEvent) {
        RotateTransition transition = new RotateTransition();
        transition.setToAngle(0);
        transition.setNode(settingBtn);
        transition.play();
    }


    public void roomOptionClickedMeth(MouseEvent mouseEvent) throws IOException {
        backBtnComes();
        //////////////////////////////////
        backBtn.setVisible(true);
        whichForm="room";
        dashBoardContext.getChildren().clear();
        FXMLLoader fxml= new FXMLLoader(getClass().getResource("../../view/admin/RoomForm.fxml"));
        Parent load = fxml.load();
        controller = fxml.getController();
        Scene scene = dashBoardContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        dashBoardContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event -> {

        });
        timeline.play();
    }


    public void mealPackageOptionClickedMeth(MouseEvent mouseEvent) throws IOException {
        backBtnComes();
        backBtn.setVisible(true);
        whichForm="meal";
        dashBoardContext.getChildren().clear();
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("../../view/admin/MealPackageForm.fxml"));
        Parent load = fxml.load();
        controller = fxml.getController();
        Scene scene = dashBoardContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        dashBoardContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event -> {

        });
        timeline.play();
    }

    public void incomeReportsOptionClickedMeth(MouseEvent mouseEvent) throws IOException {
        backBtnComes();
        backBtn.setVisible(true);
        whichForm="income";
        dashBoardContext.getChildren().clear();
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("../../view/admin/IncomeReportForm.fxml"));
        Parent load = fxml.load();
        controller = fxml.getController();
        Scene scene =  dashBoardContext.getScene();

        load.translateXProperty().set(scene.getWidth());
        dashBoardContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event -> {

        });
        timeline.play();
    }

    public void backClickedMeth(MouseEvent mouseEvent) throws IOException {
        if(whichForm.equals("room")){
            clickedAnimation(backBtn);
            RoomFormController controller = (RoomFormController) this.controller;
            if(controller.backClicked()){
                backBtn.setVisible(false);
                dashBoardContext.getChildren().clear();
                dashBoardContext.getChildren().add(homeFormContext);
                homeFormContext.translateXProperty().set(dashBoardContext.getWidth());
                KeyValue keyValue = new KeyValue(homeFormContext.translateXProperty(),0,Interpolator.EASE_IN);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.setOnFinished(event -> {

                });
                timeline.play();
            }else{

            }


        }else if(whichForm.equals("meal")){

            MealPackageFormController controller = (MealPackageFormController) this.controller;
            if(controller.backClicked()){
                backBtn.setVisible(false);
                dashBoardContext.getChildren().clear();
               dashBoardContext.getChildren().add(homeFormContext);
               homeFormContext.translateXProperty().set(dashBoardContext.getWidth());
               KeyValue keyValue = new KeyValue(homeFormContext.translateXProperty(),0,Interpolator.EASE_IN);
               KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
               Timeline timeline = new Timeline();
               timeline.getKeyFrames().add(keyFrame);
               timeline.setOnFinished(event -> {

               });
               timeline.play();

            }else {

            }

        }else{
            backBtn.setVisible(false);
            dashBoardContext.getChildren().clear();
            homeFormContext.translateXProperty().set(dashBoardContext.getWidth());

            dashBoardContext.getChildren().add(homeFormContext);
            KeyValue keyValue = new KeyValue(homeFormContext.translateXProperty(),0,Interpolator.EASE_IN);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.setOnFinished(event -> {

            });
            timeline.play();

        }

    }

    public void backMouseEnteredMeth(MouseEvent mouseEvent) {
        scaleTransZoomIn(backBtn);
    }

    public void backMouseExitedMeth(MouseEvent mouseEvent) {
        scaleTransZoomOut(backBtn);
    }

    public void logoutMouseEnteredMeth(MouseEvent mouseEvent) {
        scaleTransZoomIn(logOutBtn);
    }

    public void logoutMouseExitedMeth(MouseEvent mouseEvent) {
        scaleTransZoomOut(logOutBtn);
    }

    public void roomEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(roomOption);
    }

    public void roomExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(roomOption);
    }

    public void mealEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(mealOption);
    }

    public void mealExidet(MouseEvent mouseEvent) {
        scaleTransZoomOut(mealOption);
    }

    public void incomeEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(incomeOption);
    }

    public void incomeExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(incomeOption);
    }
}
