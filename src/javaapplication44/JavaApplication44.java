/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication44;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaApplication44 extends Application{

   private ListView List1 ,List2;
  private Button copyBtn;
    @Override
    public void start(Stage primaryStage) throws Exception {
        List1 = new ListView();
        List1.getItems().addAll("rawan ","esam","ola", "alaa","sara");
        List1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         copyBtn = new Button("copy ");
         copyBtn.setOnAction(new copy());
           List2 = new ListView();
        
         HBox cont = new HBox (10,List1,copyBtn,List2);
         cont.setAlignment(Pos.CENTER);
         Scene scene = new Scene(cont,700,250);
      primaryStage.setScene(scene);
         primaryStage.show();
         
         
         }
    public static void main(String[] args) {
        launch(args);
    }

   
    
    private class copy implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
         ObservableList x =   List1.getSelectionModel().getSelectedItems();
        List2.getItems().setAll(x);
        }
        
    }
    
}
