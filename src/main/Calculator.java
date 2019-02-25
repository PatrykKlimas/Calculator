package main;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;


public class Calculator extends Application implements EventHandler {
    public static void main(String[] args){
        launch(args);
    }
    private VBox vBoxmain=new VBox();
    private Label window=new Label();
    private Button[] buttons=new Button[10];

    private Button bsth= new Button();
    private Button bpoint= new Button();
    private Button bprod= new Button();
    private Button bdiv= new Button();
    private Button badd= new Button();
    private Button bmin= new Button();

    private HBox r1= new HBox();
    private HBox r2= new HBox();
    private HBox r3= new HBox();
    private HBox r4= new HBox();
    @Override
    public void start(Stage primaryStage) throws Exception {
        vBoxmain.setPrefSize(300, 400);
        vBoxmain.setSpacing(5);

        for(int i =0; i<10; i++){
            buttons[i]=new Button();
            buttons[i].setPrefSize(50,20);
            buttons[i].setText(String.valueOf(i));
            buttons[i].setOnAction(this);
        }

        badd.setText("+");
        badd.setPrefSize(50,20);
        r1.getChildren().addAll(buttons[1],buttons[2],buttons[3], badd);
        r1.setSpacing(5);

        bmin.setText("-");
        bmin.setPrefSize(50,20);
        r2.getChildren().addAll(buttons[4], buttons[5], buttons[6], bmin);
        r2.setSpacing(5);

        bprod.setText("*");
        bprod.setPrefSize(50,20);
        r3.getChildren().addAll(buttons[7],buttons[8],buttons[9], bprod);
        r3.setSpacing(5);

        bpoint.setText(" . ");
        bpoint.setPrefSize(50,20);
        bsth.setText("__");
        bsth.setPrefSize(50,20);
        bdiv.setText("/");
        bdiv.setPrefSize(50,20);
        r4.getChildren().addAll(bsth, buttons[0], bpoint, bdiv);
        r4.setSpacing(5);

        window.setPrefWidth(200);
        window.setPrefHeight(40);
        window.setAlignment(Pos.CENTER_RIGHT);

        vBoxmain.getChildren().addAll(window, r1, r2, r3, r4);



        Scene scene=new Scene(vBoxmain);
        Stage stage=new Stage();
        stage.setTitle("Calculator");
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void handle(Event event) {
        int i;
        if((i=index(event, buttons, 9))!=-1000){
            window.setText(window.getText()+i);
        }


    }
    public static int index(Event e, Button[] buttons, int n){
        for(int i=0; i<=n; i++){
            if(e.getSource()==buttons[i]){
                return i;
            }
        }
        return -1000;
    }




}
