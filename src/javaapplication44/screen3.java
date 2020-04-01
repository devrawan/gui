/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication44;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class screen3 extends Application {

    private TextField t1, t2, t3, t4;
    private Label L0,L1, L2, L3, L4, L5;
    private Button b1, b2, b3;
     private ListView<String> listViewNames;
     private HBox h;
    Stage s5;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gp = new GridPane();
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);
        
        L1 = new Label("Student");
        L1.setId("L1");
        gp.add(L1, 0, 0);
        L0 = new Label("Data");
        L0.setId("L1");
        gp.add(L0, 1, 0);
        L2 = new Label("id: ");
        L2.setId("h2");
        gp.add(L2, 0, 1);
       ;
        t1 = new TextField();
        gp.add(t1, 1, 1);
        
        L3 = new Label("Name: ");
         L3.setId("h2");
        gp.add(L3, 0, 2);
        t2 = new TextField();
        gp.add(t2, 1, 2);
        L4 = new Label("Major: ");
         L4.setId("h2");
        gp.add(L4, 0, 3);
        t3 = new TextField();
        gp.add(t3, 1, 3);
        L5 = new Label("Grade:");
         L5.setId("h2");
        gp.add(L5, 0, 4);
        t4 = new TextField();
        gp.add(t4, 1, 4);
        b1 = new Button("Add");
        b1.setId("b1");
        b1.setOnAction(new Add());
        gp.add(b1, 1, 5);
        GridPane.setHalignment(b1, HPos.LEFT);
        b2 = new Button("Reset");
        b2.setId("b1");
        b2.setOnAction(new Reset());
        gp.add(b2, 1, 5);
        GridPane.setHalignment(b2, HPos.CENTER);    
        b3 = new Button("Exit");
        b3.setId("b1");
        b3.setOnAction(new Exit());
        gp.add(b3, 1, 5);
        GridPane.setHalignment(b3, HPos.RIGHT);
        listViewNames=new ListView();
        h=new HBox(10,gp,listViewNames);
        h.setAlignment(Pos.CENTER);
        Scene scene = new Scene(h, 700, 250);
        scene.getStylesheets().add("Pstyle.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Entry Page");
        primaryStage.show();
      s5=primaryStage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private class Add implements EventHandler<ActionEvent>{
         ArrayList<Student>s=new   ArrayList();
        @Override
        public void handle(ActionEvent event) {
        
     
        Student s1 = new Student(new Integer(t1.getText()),t2.getText(),t3.getText()
                ,new Double(t4.getText()));
        s.add(s1);
        
       Collections.sort(s);
     listViewNames.getItems().setAll("");
        for(int i=0;i<s.size();i++){
       listViewNames.getItems().add(s.get(i).toString());
        }
        
        
    }}
     private class Reset implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           t1.setText("");
         t2.setText("");
          t3.setText("");
           t4.setText("");
        }
        
    }
      private class Exit implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           System.exit(0);  }
         
    }
      
    }
