/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication44;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import static javafx.scene.text.Font.font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;

public class Login extends Application {

    private TextField txt1, txt2;
    private Label L1, L2, L3;
    private Button btn1, btn2;
    private PasswordField pass;

    Stage s1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gp = new GridPane();
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);
        L1 = new Label("Welcome");
        L1.setId("L1");

        gp.add(L1, 0, 0);

        L2 = new Label("username : ");
        gp.add(L2, 0, 1);
        L2.setId("LL");
        txt1 = new TextField();
        gp.add(txt1, 1, 1);

        L3 = new Label("Password : ");
        gp.add(L3, 0, 2);
        L3.setId("LL");
        pass = new PasswordField();

        gp.add(pass, 1, 2);

        btn1 = new Button("Sign in");
        btn1.setId("btn1");
        gp.add(btn1, 1, 3);
        GridPane.setHalignment(btn1, HPos.CENTER);
        btn1.setOnAction(new sign());

        btn2 = new Button("Exit");
        btn2.setId("btn1");
        gp.add(btn2, 1, 3);
        GridPane.setHalignment(btn2, HPos.RIGHT);
        btn2.setOnAction(new Exit());

        Scene scene = new Scene(gp, 700, 250);

        scene.getStylesheets().add("Lstyle.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login page");
        primaryStage.show();
        s1 = primaryStage;
    }

    private class sign implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            try {
                Scanner s = new Scanner(new File("C:\\Users\\Kareem Radwan\\Documents\\NetBeansProjects\\JavaApplication44\\src\\javaapplication44\\t.txt"));

                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    String[] vars = line.split(" ");
                    System.out.println("v1 : " + vars[0] + " s2:" + vars[1]);
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] messageDigest = md.digest(pass.getText().getBytes());
                    BigInteger number = new BigInteger(1, messageDigest);
                    String hashtext = number.toString(16);

                    if (txt1.getText().toString().equals(vars[0]) && hashtext.equals(vars[1])) {
                        // TODO 
                        Login2 L22 = new Login2();
                        s1.close();
                        try {
                            L22.start(new Stage());
                        } catch (Exception ex) {
                        }
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                }

            } catch (Exception e) {
                System.out.println("Ec : " + e.getLocalizedMessage());
            } }
    }

    private class Exit implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
