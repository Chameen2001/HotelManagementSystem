package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

public class LogInFormController {
    public Pane sliderPn;
    public JFXButton slideButton;
    public JFXButton logInBtn;
    public AnchorPane logInFormContext;
    public AnchorPane logInFormContextRoot;
    public TextField txtUserOrAdmin;
    public PasswordField txtPassword;
    public Label slideAsReceptionistLbl;
    public Label slideAsAdminLbl1;
    int x=0;

    public void swipeMeth(String text,double value){
        TranslateTransition transition1 = new TranslateTransition();
        transition1.setDuration(Duration.millis(120));
        transition1.setNode(slideButton);
        transition1.setToX(value);
        transition1.play();

        transition1.setOnFinished((event) -> {
            slideButton.setText(text);
        });
    }

    public void slideButtonMeth(ActionEvent actionEvent) {
        if(x==0) {
            swipeMeth("As Receptionist",195.5);
            x=1;
        }else {
            swipeMeth("As Admin",0);
            x=0;
        }
    }

    public void asReceptionistLabelClicked(MouseEvent mouseEvent) {
        swipeMeth("As Receptionist",195.5);
        x=1;
    }

    public void asAdminLabelClicked(MouseEvent mouseEvent) {
        swipeMeth("As Admin",0);
        x=0;
    }

    public void logInBtnMeth(ActionEvent actionEvent) throws IOException {
        if(x==0){
            if(txtUserOrAdmin.getText().equals("") && txtPassword.getText().equals("")){
                Parent load = FXMLLoader.load(getClass().getResource("../view/admin/DashBoardForm.fxml"));
                Scene scene = logInFormContextRoot.getScene();

                load.translateXProperty().set(scene.getWidth());
                logInFormContextRoot.getChildren().add(load);

                KeyValue keyValue = new KeyValue(load.translateXProperty(),0,Interpolator.EASE_OUT);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(500),keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.setOnFinished(event -> {
                    logInFormContextRoot.getChildren().remove(logInFormContext);
                });
                timeline.play();
            }else{
                new Alert(Alert.AlertType.WARNING,"Admin Name or Password Are Incorrect", ButtonType.OK).show();
            }
        }else{
            if(txtUserOrAdmin.getText().equals("") && txtPassword.getText().equals("")) {
                Parent load = FXMLLoader.load(getClass().getResource("../view/receptionist/DashBoardForm.fxml"));
                Scene scene = logInFormContextRoot.getScene();

                load.translateXProperty().set(scene.getWidth());
                logInFormContextRoot.getChildren().add(load);

                KeyValue keyValue = new KeyValue(load.translateXProperty(), 0, Interpolator.EASE_OUT);
                KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(keyFrame);
                timeline.setOnFinished(event -> {
                    logInFormContextRoot.getChildren().remove(logInFormContext);
                });
                timeline.play();
            }else {

            }

        }


    }


}
