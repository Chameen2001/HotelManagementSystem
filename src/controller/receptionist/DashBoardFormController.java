package controller.receptionist;

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
    public AnchorPane dashBoardFormRootContext;
    public AnchorPane dashBoardContext;
    public AnchorPane homeFormContext;
    public Pane roomOption;
    public ImageView backBtn;
    public ImageView logOutBtn;
    public ImageView settingBtn;
    public ImageView homeBtn;
    public Object nextController;
    public String whichForm;
    public Pane markRoomOption;

    public void initialize(){
        backBtn.setVisible(false);
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

    public void clickedAnimation(ImageView Node){
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

    public void reserveRoomClickedMeth(MouseEvent mouseEvent) throws IOException {
        backBtnComes();
        whichForm="reserve";
        backBtn.setVisible(true);
        dashBoardContext.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/receptionist/ReserveRoomForm.fxml"));
        Parent load = fxmlLoader.load();
        Scene scene = dashBoardContext.getScene();
        nextController=fxmlLoader.getController();
        load.translateXProperty().set(scene.getWidth());
        dashBoardContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        ReserveRoomFormController controller = (ReserveRoomFormController) nextController;
        controller.setController(this);

    }

    public void markRoomInMaintenanceClickedMeth(MouseEvent mouseEvent) throws IOException {
        backBtn.setVisible(true);
        backBtnComes();
        whichForm="mark";

        dashBoardContext.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../view/receptionist/MarkRoomInMaintenanceForm.fxml"));
        Parent load = fxmlLoader.load();
        Scene scene = dashBoardContext.getScene();
        load.translateXProperty().set(scene.getWidth());
        dashBoardContext.getChildren().add(load);

        KeyValue keyValue = new KeyValue(load.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    public void homeClickedMeth(MouseEvent mouseEvent) {
        clickedAnimation(homeBtn);
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

    public void backClickedMeth(MouseEvent mouseEvent) {
        clickedAnimation(backBtn);
        if(whichForm.equals("reserve")){
            ReserveRoomFormController controller = (ReserveRoomFormController) nextController;
            if(controller.backClicked()){
                backBtn.setVisible(false);
                dashBoardContext.getChildren().clear();
                dashBoardContext.getChildren().add(homeFormContext);
                dashBoardContext.translateXProperty().set(dashBoardContext.getWidth());
                KeyValue keyValue = new KeyValue(dashBoardContext.translateXProperty(),0,Interpolator.EASE_IN);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            }else{

            }
        }
        else {
            backBtn.setVisible(false);
            dashBoardContext.getChildren().clear();
            dashBoardContext.getChildren().add(homeFormContext);
            dashBoardContext.translateXProperty().set(dashBoardContext.getWidth());
            KeyValue keyValue = new KeyValue(dashBoardContext.translateXProperty(),0,Interpolator.EASE_IN);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
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

    public void roomOptionEntered(MouseEvent mouseEvent) {
        scaleTransZoomIn(roomOption);
    }

    public void roomOptionExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(roomOption);
    }

    public void markRoomEneterd(MouseEvent mouseEvent) {
        scaleTransZoomIn(markRoomOption);
    }

    public void markRoomExited(MouseEvent mouseEvent) {
        scaleTransZoomOut(markRoomOption);
    }
}
