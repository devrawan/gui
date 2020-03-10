/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication44;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class conversion extends Application{
private Label l1,L2,L3;
private TextField text;
private RadioButton r1,r2;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        l1 = new Label("Enter--");
       
        text = new TextField();
        L2 = new Label("new temporary : ");
        L3 = new Label();
        ToggleGroup t = new ToggleGroup();
        r1 = new RadioButton("fah");
        r1.setOnAction(new conv());
        r2 = new RadioButton("kelven");
        r2.setOnAction(new conv());
        t.getToggles().addAll(r1,r2);
        
        HBox box = new HBox(10,r1,r2);
        box.setAlignment(Pos.CENTER);
        
        HBox box2 = new HBox(10,L2,L3);
        box2.setAlignment(Pos.CENTER);
        VBox cont = new VBox(10,l1,text,box,box2);
        cont.setAlignment(Pos.CENTER);
    Scene scene = new Scene(cont,700,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    private class conv implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           if(event.getSource()==r1){
               L3.setText(Double.parseDouble(text.getText())* 9/5  + 32+"");
           }else{
                L3.setText(Double.parseDouble(text.getText())+ 273.15+"");
           }
        
        
        }
        
    }
}
