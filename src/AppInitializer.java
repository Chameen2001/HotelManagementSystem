import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL resource = getClass().getResource("view/ThemeForm.fxml");
//        URL resource = getClass().getResource("view/LogInForm.fxml");
//        URL resource = getClass().getResource("view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load,1152 ,700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blue Ocean");
        primaryStage.show();
        scene.getStylesheets().add("css/StyleSheet1.css");

    }
}
