/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication44;

import com.sun.istack.internal.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Menue extends Application{
     private TextArea TxtArea;
    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setTitle("work in menue");
       MenuBar Menuebar = new MenuBar();
       Menu MenueFile = new Menu("_File");
       MenuItem menuItemOpen = new MenuItem("_Open");
       MenuItem menuItemClose = new MenuItem("_Close");
       MenuItem menuItemExit = new MenuItem("_Exit");
       MenueFile.getItems().addAll(menuItemOpen,menuItemClose,menuItemExit);
       Menu MenueEdit = new Menu("_Edit");
       MenuItem menuItemFont = new MenuItem("_Font");
        MenuItem menuItemColor = new MenuItem("_Color");
        MenueEdit.getItems().addAll(menuItemFont,menuItemColor);
        Menuebar.getMenus().addAll(MenueFile,MenueEdit);
        TxtArea= new TextArea("initial text");
        EventHandler1 ev1 = new EventHandler1();
        menuItemOpen.setOnAction(ev1);
        menuItemClose.setOnAction(ev1);
        menuItemExit.setOnAction(ev1);
        menuItemFont.setOnAction(ev1);
        menuItemColor.setOnAction(ev1);
        VBox v = new VBox(Menuebar,TxtArea);
        Scene scene = new Scene(v,200,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
      public static void main(String[] args) {
        launch(args);
    }
    
    private class EventHandler1 implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            String menuItem = ((MenuItem)event.getSource()).getText();
            switch(menuItem){
                case"_Open":
                    FileChooser fc = new FileChooser();
                    fc.setInitialFileName(".");
                    File file = fc.showOpenDialog(null);
                    TxtArea.setText("");
                    TxtArea.setWrapText(true);
                    { try{
                        Scanner s = new Scanner(file);
                        while(s.hasNext()){
                           TxtArea.appendText(s.nextLine());
                        }
                        s.close();
                    }catch(FileNotFoundException e){
                                System.out.println("*****");
                        //Logger.getLogger(Menue.class.getName()).log(Level.SEVERE,null,e);
                    }}
                    break;
                    
               case"_Close":
                   TxtArea.clear();
                   break;
                    
                    case"_Exit":
                        System.exit(0);
                    break;
                    case"_Font":
                         Dialog<String>dialogfont = new ChoiceDialog<>("",FXCollections.observableArrayList("15px","20px","25px"));
                            dialogfont.setTitle("font selection");
                            dialogfont.setHeaderText("selectfont");
                            String font = dialogfont.showAndWait().get();
                            TxtArea.setStyle("-fx-font-size:"+font+";");
                        break;
                        case"_Color":
                            Dialog<String>dialogColor = new ChoiceDialog<>("",FXCollections.observableArrayList("Red","Blue","Green"));
                            dialogColor.setTitle("color Selection");
                            dialogColor.setHeaderText("selectColor");
                            String Color = dialogColor.showAndWait().get();
                            TxtArea.setStyle("-fx-text-fill:"+Color+";");
                            break;
            }
             }
        
    }
    
}
