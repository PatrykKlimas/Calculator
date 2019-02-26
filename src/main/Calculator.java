package main;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
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
import java.util.ArrayList;


public class Calculator extends Application implements EventHandler {
    public static void main(String[] args){
        launch(args);
    }
    private VBox vBoxmain=new VBox();
    private Label window=new Label();
    private Label window2=new Label();
    private Button[] buttons=new Button[10];
    double w1;
    double w2;
    int oper;

    private Button bC= new Button();
    private Button bpoint= new Button();
    private Button bprod= new Button();
    private Button bdiv= new Button();
    private Button badd= new Button();
    private Button bmin= new Button();
    private Button bCE= new Button();
    private Button beq=new Button();

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
        badd.setOnAction(this);
        beq.setText("=");
        beq.setOnAction(this);
        beq.setPrefSize(50, 20);
        r1.getChildren().addAll(buttons[1],buttons[2],buttons[3], badd, beq);
        r1.setSpacing(5);

        bmin.setText("-");
        bmin.setPrefSize(50,20);
        bmin.setOnAction(this);
        bCE.setText("CE");
        bCE.setPrefSize(50,20);
        bCE.setOnAction(this);
        r2.getChildren().addAll(buttons[4], buttons[5], buttons[6], bmin, bCE);
        r2.setSpacing(5);

        bprod.setText("*");
        bprod.setPrefSize(50,20);
        bprod.setOnAction(this);
        bC.setText("C");
        bC.setPrefSize(50,20);
        bC.setOnAction(this);
        r3.getChildren().addAll(buttons[7],buttons[8],buttons[9], bprod, bC);
        r3.setSpacing(5);


        bpoint.setText(" . ");
        bpoint.setPrefSize(50,20);
        bpoint.setOnAction(this);


        bdiv.setText("/");
        bdiv.setPrefSize(50,20);
        bdiv.setOnAction(this);
        buttons[0].setPrefSize(105, 20);
        r4.getChildren().addAll(buttons[0], bpoint, bdiv);
        r4.setSpacing(5);

        window.setPrefWidth(210);
        window.setPrefHeight(40);
        window.setAlignment(Pos.CENTER_RIGHT);
        window2.setPrefWidth(210);
        window2.setPrefHeight(40);
        window2.setAlignment(Pos.CENTER_RIGHT);

        vBoxmain.getChildren().addAll(window2,window, r1, r2, r3, r4);



        Scene scene=new Scene(vBoxmain);
        Stage stage=new Stage();
        stage.setTitle("Calculator");
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void handle(Event event) {
        int i;

        if ((i = index(event, buttons, 9)) != -1000) {
            window.setText(window.getText() + i);
        }
        Object source = event.getSource();
        i = window.getText().length();
        if (source == bC) {
            if (i != 0) {
                window.setText(window.getText().substring(0, i - 1));
            }
        }
        if (source == bpoint) {
            if (!window.getText().contains(".") && window.getText().length() != 0)
                window.setText(window.getText() + ".");
        }

        if (source == bCE) {
            window.setText("");
            window2.setText("");
            w1 = w2 = oper = 0;

        }
        if (source == beq) {

        }

        if (source == bmin || source == bprod || source == beq || source == badd) {
            if (window2.getText().length() != 0 && window.getText().length() != 0) {
                w1 = Double.valueOf(window.getText());
                window.setText("");
                w2 = calculate(w2, w1, oper);
                if (source != beq)
                    oper = source == badd ? 1 : (source == bmin ? 2 : (source==bprod ? 3 : 0));
                if (source == bmin)
                    window2.setText(w2 + "-");
                else if (source == bprod)
                    window2.setText(w2 + "*");
                else if (source == badd)
                    window2.setText(w2 + "+");
                else
                    window2.setText(String.valueOf(w2));
            }
            if (window2.getText().length() == 0 && window.getText().length() != 0) {
                if (source != beq)
                    oper = source == badd ? 1 : (source == bmin ? 2 : 3);
                w2 = Double.valueOf(window.getText());
                window.setText("");
                if (source == bmin)
                    window2.setText(w2 + "-");
                else if (source == bprod)
                    window2.setText(w2 + "*");
                else if (source == badd)
                    window2.setText(w2 + "+");
                else
                    window2.setText(String.valueOf(w2));
            }
            if (window2.getText().length() != 0 && window.getText().length() == 0) {
                if(source==beq){
                    window2.setText(String.valueOf(w2));
                    oper=0;
                }else{
                    if(oper==0 && source!=beq){
                        oper = source == badd ? 1 : (source == bmin ? 2 : 3);
                        String str= oper ==1 ? "+": (oper==2 ? "-" : "*");
                        window2.setText(window2.getText()+str);
                    }else if(source!=beq && oper!=0){
                        oper = source == badd ? 1 : (source == bmin ? 2 : 3);
                        String str= oper ==1 ? "+": (oper==2 ? "-" : "*");
                        window2.setText(window2.getText().substring(0, window2.getText().length()-1)+str);
                    }else if( oper !=0 && source==beq){
                        oper=0;
                        window2.setText(window2.getText().substring(0, window2.getText().length()-1));
                    }

                }
            }

        }
    }



    public static double calculate(double a, double b, int k){
        switch (k){
            case 1:
            {
                return a+b;
            }
            case 2:
            {
                return a-b;
            }
            case 3:
            {
                return a*b;
            }
            case 4:
            {
                return a/b;
            }
            default:
            {
                return 0;
            }
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
