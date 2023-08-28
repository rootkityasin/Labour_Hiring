package LabourHiring;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserChatScene extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UserChatScene.class.getResource("UserChatScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        //stage.setTitle("Messenger");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}