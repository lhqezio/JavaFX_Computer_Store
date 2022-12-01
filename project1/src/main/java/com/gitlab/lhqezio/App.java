package com.gitlab.lhqezio;

import com.gitlab.lhqezio.gui.DisplayGui;
import com.gitlab.lhqezio.user.*;
import com.gitlab.lhqezio.util.ProductsList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        DisplayGui dg = new DisplayGui();
        ProductsList pl = new ProductsList();
        primaryStage.setTitle("Computer Shop");
        primaryStage.setScene(new Scene(dg.login()));
        primaryStage.setMinWidth(960);
        primaryStage.setMinHeight(540);
        primaryStage.show();
        dg.getLoginButton().setOnAction(e -> {
            Auth auth = new Auth();
                int retVal = auth.check(dg.getUsername(), dg.getPassword().toCharArray());
                if(retVal == 0){
                    try {

                        primaryStage.setScene(dg.menu(pl));

                    }
                    catch(Exception ex) {
                    }
                }
                else{
                    Group loginFailed = dg.login();
                    VBox v = (VBox)loginFailed.getChildren().get(0);
                    v.getChildren().add(new Label("Login Failed"));
                    primaryStage.setScene(new Scene(loginFailed));
                }
                primaryStage.show();
        });
    }
}
