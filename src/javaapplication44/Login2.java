/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication44;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login2 extends Application{

    Button b1 , b2;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
    b1 = new Button("Add Student");
    b2= new Button("View Student");
    VBox v = new VBox(10,b1,b2);
    v.setAlignment(Pos.CENTER);
    Scene scene = new Scene (v,700,250);
    scene.getStylesheets().add("Ostyle.css");
    primaryStage.setScene(scene);
    primaryStage.setTitle("option page");
    primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
