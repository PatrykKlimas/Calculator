package main;


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Calculator extends Application implements EventHandler {
    private static void main(String[] args){
        launch(args);
    }
    private Stage stage;

    //elements of main scene
    private Scene mainscene;
    private static VBox vBoxmain=new VBox();
    private Label window=new Label(); //window to add numbers
    private Label window2=new Label(); //window to show results

    //necessarily variables
    private double w1,w2, memory;
    private int oper;

    private Button[] buttons=new Button[10]; //buttons for numbers
    private Button bC= new Button(); //button to delete one step
    private Button bpoint= new Button();
    private Button bprod= new Button(); //button to multiply
    private Button bdiv= new Button(); //button to dividing
    private Button badd= new Button(); //button to add
    private Button bmin= new Button(); //button to subtract
    private Button bCE= new Button(); //button to delete all
    private Button beq=new Button(); //button to equal
    private Button bMplus=new Button(); //button to add sth memory
    private Button bMminus=new Button(); //button to pick out sht from memory
    private Button bLogs=new Button(); //Integrals menu
    private Button bMatrix=new Button(); //Button to matrix menu

    private HBox r1= new HBox();
    private HBox r2= new HBox();
    private HBox r3= new HBox();
    private HBox r4= new HBox();
    private HBox r5= new HBox();

    //logarithms
    private Scene Logaritms;
    private HBox formula=new HBox();
    private Label log=new Label("log ");
    private Label logeq=new Label("=");
    private TextField loga=new TextField();
    private TextField logb=new TextField();
    private Button backLog=new Button("Back");

    //elements of Matrices scene
    private Scene matrixScene;
    private VBox vMatrix=new VBox();
    private Button back; //back to main menu
    private Button bdet; //button to calculate determinant
    private Button btrans; //button to show transposition
    private Button bmproduct; //button to count product of two matrices
    private Scene detScene; //scene for  determinant
    private ChoiceBox<String> dim; //dimension of matrix
    private Button backm;
    private Button calculate;
    private TextField[][] entries=new TextField[10][10]; // entries of matrices
    private VBox matrix=new VBox();
    private HBox[] rows=new HBox[12];
    private Label ldim, result;
    private int dimension=0;

    //Transpose
    private Label lrwos, lcols;
    private int rowsnumber=0;
    private int colsnumber=0;
    private ChoiceBox<Integer> nrows, ncols;
    private Scene tranScene;
    private VBox transmatrix=new VBox();
    private Button btran;
    private HBox trasmenu;
    private HBox[] transrows=new HBox[10];
    private Button backtrans;
    private TextField[][] transentries=new TextField[10][10];

    //Product
    private Label Adims, Bdims;
    private ChoiceBox<Integer> Arows, Acols, Bcols;
    private int Arowsnr=0;
    private int Acolsnr=0;
    private int Bcolsnr=0;
    private Scene prodScene;
    private Button backprod, coutproduct, Brows;
    private HBox prodmenu;
    private HBox productmatrix=new HBox();
    private VBox matricesaera=new VBox();
    private VBox matrixA, matrixB;
    private TextField[][] Aentries=new TextField[10][10];
    private TextField[][] Bentries=new TextField[10][10];
    private HBox[] Atransrows=new HBox[10];
    private HBox[] Btransrows=new HBox[10];
    private Label separate=new Label();



    @Override
    public void start(Stage primaryStage) throws Exception {
        vBoxmain.setPrefSize(260, 260);
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
        bMplus.setText("M+");
        bMplus.setOnAction(this);
        bMplus.setPrefSize(50,20);
        r4.getChildren().addAll(buttons[0], bpoint, bdiv, bMplus);
        r4.setSpacing(5);

        bLogs.setText("log(...)(...)");
        bLogs.setPrefSize(215,20);
        bLogs.setOnAction(this);


        bMminus.setText("M-");
        bMminus.setPrefSize(50,20);
        bMminus.setOnAction(this);
        r5.getChildren().addAll(bLogs, bMminus);
        r5.setSpacing(5);

        //Logarithms
        log.setPrefSize(25, 20);
        loga.setPrefSize(40, 20);
        loga.setOnAction(this);

        logb.setPrefSize(40, 20);
        logb.setOnAction(this);

        backLog.setPrefSize(70, 20);
        backLog.setOnAction(this);
        formula.getChildren().addAll(backLog, log, loga, logb, logeq);
        formula.setPrefSize(300, 40);
        formula.setSpacing(5);
        logeq.setAlignment( Pos.CENTER_LEFT);


        bMatrix.setText("Matrices");
        bMatrix.setPrefSize(270, 30);
        bMatrix.setOnAction(this);

        window.setPrefWidth(210);
        window.setPrefHeight(40);
        window.setAlignment(Pos.CENTER_RIGHT);
        window2.setPrefWidth(210);
        window2.setPrefHeight(40);
        window2.setAlignment(Pos.CENTER_RIGHT);

        vBoxmain.getChildren().addAll(window2,window, r1, r2, r3, r4, r5, bMatrix);

        //Matrices
        back=new Button("Back");
        back.setPrefSize(240, 30);
        back.setOnAction(this);
        bdet=new Button("det(A)");
        bdet.setPrefSize(240, 30);
        bdet.setOnAction(this);
        btrans=new Button("A^T");
        btrans.setPrefSize(240, 30);
        btrans.setOnAction(this);
        bmproduct=new Button("A*B");
        bmproduct.setPrefSize(240, 30);
        bmproduct.setOnAction(this);
        vMatrix.getChildren().addAll(btrans,bdet, bmproduct, back);
        vMatrix.setPrefSize(240, 170);
        vMatrix.setSpacing(10);

        //Determinants

        dim=new ChoiceBox();
        dim.getItems().addAll("1","2", "3", "4", "5", "6", "7", "8","9","10");
        dim.setPrefSize(50, 30);
        dim.setOnAction(this);

        ldim=new Label("  Dim: ");
        ldim.setPrefSize(40, 30);
        backm=new Button("Back");

        backm.setPrefSize(100, 30);
        backm.setOnAction(this);

        calculate=new Button("Calculate");
        calculate.setPrefSize(100,30);
        calculate.setOnAction(this);
        rows[0]=new HBox();
        rows[0].setSpacing(40);
        rows[0].getChildren().addAll(ldim, dim, backm, calculate);
        matrix.getChildren().addAll(rows[0]);
        matrix.setSpacing(10);
        matrix.setPrefSize(500, 230);
        result=new Label("");
        result.setPrefSize(500, 30);
        result.setAlignment(Pos.CENTER);
        result.setTextFill(Color.RED);
        rows[11]=new HBox();
        rows[11].getChildren().addAll(result);
        matrix.getChildren().add(result);
        for(int i=0; i<10;i++){
            for(int j=0; j<10; j++){
                entries[i][j]=new TextField();
                entries[i][j].setPrefSize(45, 30);
                entries[i][j].setVisible(false);
            }
            rows[i+1]=new HBox();
            rows[i+1].setSpacing(5);
            rows[i+1].getChildren().addAll(entries[i]);
            matrix.getChildren().add(rows[i+1]);
        }

        //Transpose

        lrwos=new Label("Rows: ");
        lcols=new Label("Cols: ");
        lcols.setPrefSize(50,30);
        lrwos.setPrefSize(50,30);

        nrows=new ChoiceBox<>();
        ncols=new ChoiceBox<>();
        nrows.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        ncols.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        ncols.setPrefSize(40,30);
        nrows.setPrefSize(40,30);
        ncols.setOnAction(this);
        nrows.setOnAction(this);

        trasmenu=new HBox();
        trasmenu.setSpacing(10);

        btran=new Button("Calculate");
        btran.setPrefSize(100, 30);
        btran.setOnAction(this);

        backtrans=new Button("Back");
        backtrans.setPrefSize(100,30);
        backtrans.setOnAction(this);

        trasmenu.getChildren().addAll(lrwos, nrows,lcols, ncols, btran, backtrans);
        transmatrix.getChildren().add(trasmenu);
        transmatrix.setPrefSize(500, 400);
        for(int i=0; i<10;i++){
            for(int j=0; j<10; j++){
                transentries[i][j]=new TextField();
                transentries[i][j].setPrefSize(45, 30);
                transentries[i][j].setVisible(false);
            }
            transrows[i]=new HBox();
            transrows[i].setSpacing(5);
            transrows[i].getChildren().addAll(transentries[i]);
            transmatrix.getChildren().add(transrows[i]);
        }
        transmatrix.setSpacing(5);

        //Product
        Adims=new Label("Dim A: ");
        Adims.setPrefSize(50, 30);
        Bdims=new Label("Dim A: ");
        Bdims.setPrefSize(50, 30);

        Arows=new ChoiceBox<Integer>();
        Arows.setPrefSize(50,30);
        Arows.setOnAction(this);

        Acols=new ChoiceBox<Integer>();
        Acols.setPrefSize(50,30);
        Acols.setOnAction(this);

        Bcols=new ChoiceBox<Integer>();
        Bcols.setPrefSize(50, 30);
        Bcols.setOnAction(this);

        Arows.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        Acols.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        Bcols.getItems().addAll(1,2,3,4,5,6,7,8,9,10);

        Brows=new Button("");
        Brows.setPrefSize(50,30);

        coutproduct=new Button("Calculate");
        coutproduct.setPrefSize(110, 30);
        coutproduct.setOnAction(this);

        backprod=new Button("Back");
        backprod.setPrefSize(60,30);
        backprod.setOnAction(this);

        prodmenu=new HBox();
        prodmenu.setSpacing(5);

        prodmenu.getChildren().addAll(Adims, Arows, Acols, Bdims, Brows, Bcols, coutproduct, backprod);

        matrixA=new VBox();
        for(int i=0; i<10;i++){
            for(int j=0; j<10; j++){
                Aentries[i][j]=new TextField();
                Aentries[i][j].setPrefSize(45, 30);
                Aentries[i][j].setVisible(false);
            }
            Atransrows[i]=new HBox();
            Atransrows[i].setSpacing(5);
            Atransrows[i].getChildren().addAll(Aentries[i]);
            matrixA.getChildren().add(Atransrows[i]);

        }

        matrixB=new VBox();
        for(int i=0; i<10;i++){
            for(int j=0; j<10; j++){
                Bentries[i][j]=new TextField();
                Bentries[i][j].setPrefSize(45, 30);
                Bentries[i][j].setVisible(false);
            }
            Btransrows[i]=new HBox();
            Btransrows[i].setSpacing(5);
            Btransrows[i].getChildren().addAll(Bentries[i]);
            matrixB.getChildren().add(Btransrows[i]);
        }
        separate.setText("\n \n \n \n \n \nX");

        productmatrix.getChildren().addAll(matrixA, separate, matrixB);


        matricesaera.getChildren().addAll(prodmenu, productmatrix);
        matricesaera.setPrefSize(800, 400);

        mainscene=new Scene(vBoxmain);
        stage=new Stage();
        stage.setTitle("Calculator");
        stage.setScene(mainscene);
        stage.setResizable(false);
        stage.show();

    }

    @Override
    public void handle(Event event) {

        //implementing numbers
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

        if (source == bmin || source == bprod || source == beq || source == badd || source== bdiv ) {
            //another operation (not first)
            if (window2.getText().length() != 0 && window.getText().length() != 0 && oper!=0 ) {
                if(!(oper==4 && Double.valueOf(window.getText())==0)) {
                    w1 = Double.valueOf(window.getText());
                    window.setText("");
                    w2 = calculate(w2, w1, oper);
                    if (source != beq) {
                        oper = source == badd ? 1 : (source == bmin ? 2 : (source == bprod ? 3 : (source==bdiv ? 4:0)));
                        String sing= source==badd ? "+" : (source == bmin ? "-" : (source == bprod ? "*" : "/"));
                        window2.setText(w2+sing);
                    }  else
                        window2.setText(String.valueOf(w2));
                }
            }
            if (window2.getText().length() == 0 && window.getText().length() != 0) {
                w2 = Double.valueOf(window.getText());
                window.setText("");
                if (source != beq) {
                    oper = source == badd ? 1 : (source == bmin ? 2 : (source == bprod ? 3 : (source==bdiv ? 4:0)));
                    String sing= source==badd ? "+" : (source == bmin ? "-" : (source == bprod ? "*" : "/"));
                    window2.setText(w2+sing);
                }  else
                    window2.setText(String.valueOf(w2));
            }
            if (window2.getText().length() != 0 && window.getText().length() == 0) {
                if(source==beq){
                    window2.setText(String.valueOf(w2));
                    oper=0;
                }else{
                        oper = source == badd ? 1 : (source == bmin ? 2 : (source == bprod ? 3 : (source==bdiv ? 4:0)));
                        String str= oper ==1 ? "+": (oper==2 ? "-" : (oper==3 ? "*": "/"));
                        window2.setText(w2+str);
                }
            }
            if(window2.getText().length()==0 && window.getText().length()==0 && source==bmin){
                window.setText("-");
            }

        }
        if(source==bMplus){
            if(window2.getText().length()!=0){
                memory=w2;
            }else if(window.getText().length()!=0){
                memory=Double.valueOf(window.getText());
                window.setText("");
            }
        }
        if(source==bMminus && memory!=0){
                window.setText(String.valueOf(memory));
        }

        //Matrices
        if(source==bLogs){
            if(Logaritms==null){
                Logaritms=new Scene(formula);
            }
            stage.setTitle("Logarithm");
            stage.setScene(Logaritms);
        }
        if(source==bMatrix){
            if(matrixScene==null)
                matrixScene=new Scene(vMatrix);
            stage.setTitle("Matrices");
            stage.setScene(matrixScene);
        }
        if(source==back){
            stage.setTitle("Calculator");
            stage.setScene(mainscene);
        }
        if(source==backLog){
            stage.setTitle("Calculator");
            stage.setScene(mainscene);
            loga.setText("");
            logb.setText("");
        }

        if(source==bdet){
            if(detScene==null){
                detScene=new Scene(matrix);
            }
            stage.setTitle("Determinant");
            stage.setScene(detScene);

        }
        if(source==btrans){
            if(tranScene==null){
                tranScene=new Scene(transmatrix);
            }
            stage.setTitle("Transposition");
            stage.setScene(tranScene);
        }
        if(source==bmproduct){
            if(prodScene==null){
                prodScene=new Scene(matricesaera);
            }
            stage.setTitle("Product");
            stage.setScene(prodScene);
        }


        if(source==backm || source==backtrans || source==backprod){
            stage.setTitle("Matrices");
            stage.setScene(matrixScene);
            for(int j=0; j<10; j++){
                for(int n=0; n<10; n++){
                    entries[j][n].setText("");
                    transentries[j][n].setText("");
                    Bentries[j][n].setText("");
                    Aentries[j][n].setText("");
                }
            }
        }

        if(source==dim) {
            int deg = Integer.valueOf(dim.getValue());
            if (deg > dimension) {
                for (int n = 0; n < deg; n++) {
                    for (int m = 0; m < deg; m++) {
                        entries[n][m].setVisible(true);
                    }
                }
        }
        if (deg < dimension) {
            for (int n = deg; n < dimension; n++) {
                for (int m = 0; m < dimension; m++) {
                    entries[n][m].setVisible(false);
                    entries[n][m].setText("");
                    entries[m][n].setVisible(false);
                    entries[m][n].setText("");
                }
            }
        }
        dimension = deg;

    }
    if(source==nrows){

        int rows=nrows.getValue();
        if(colsnumber!=0) {
            if (rowsnumber < rows) {
                for (int j = rowsnumber; j < rows; j++) {
                    for (int n = 0; n < colsnumber; n++) {
                        transentries[j][n].setVisible(true);
                    }
                }
            }
            if (rowsnumber > rows) {
                for (int j = rows; j < rowsnumber; j++) {
                    for (int n = 0; n < colsnumber; n++) {
                        transentries[j][n].setVisible(false);
                    }
                }
            }
        }
        rowsnumber=rows;
    }
        if(source==ncols){
            int cols=ncols.getValue();
            System.out.println(cols);
            if(rowsnumber!=0) {
                if (colsnumber < cols) {
                    for (int j = colsnumber; j < cols; j++) {
                        for (int n = 0; n < rowsnumber; n++) {

                            transentries[n][j].setVisible(true);
                        }
                    }
                }
                if (colsnumber > cols) {
                    for (int j = cols; j < colsnumber; j++) {
                        for (int n = 0; n < rowsnumber; n++) {
                            transentries[n][j].setVisible(false);
                        }
                    }
                }
            }
            colsnumber=cols;
        }

    if(source==calculate && dim.getValue()!=null){
        try {
            Matrix matrix=new Matrix(dimension ,dimension);
            for(int j=0; j<dimension; j++){
                for(int m=0; m<dimension; m++){
                    matrix.setEntry(j,m, Double.valueOf(entries[j][m].getText()) );
                }
            }
            result.setText("Det(A)= " +matrix.determinant());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    if(source==btran){
        int min=Math.min(colsnumber, rowsnumber);
        String x=" ";
        for(int j=0; j<min; j++){
            for(int n=j+1; n<min; n++){
                x=transentries[j][n].getText();
                transentries[j][n].setText(transentries[n][j].getText());
                transentries[n][j].setText(x);
            }
        }
        if(min==colsnumber && colsnumber!=rowsnumber){
            for(int j=min; j<rowsnumber; j++){
                for(int k=0; k<min; k++){
                    transentries[k][j].setText(transentries[j][k].getText());
                    transentries[j][k].setText("");
                    transentries[j][k].setVisible(false);
                    transentries[k][j].setVisible(true);

                }
            }
        }else if(min==rowsnumber && colsnumber!=rowsnumber){
            for(int j=min; j<colsnumber; j++){
                for(int k=0; k<min; k++){
                    transentries[j][k].setText(transentries[k][j].getText());
                    transentries[k][j].setText("");
                    transentries[k][j].setVisible(false);
                    transentries[j][k].setVisible(true);

                }
            }
        }
        int m=colsnumber;
        colsnumber=rowsnumber;
        rowsnumber=m;
        nrows.setValue(rowsnumber);
        ncols.setValue(colsnumber);
    }
    if(source==Arows){
        int r=Arows.getValue();
        if(Acols!=null){
            if(Arowsnr<r){
                for(int j=Arowsnr; j<r;j++){
                    for(int n=0; n<Acolsnr; n++){
                        Aentries[j][n].setVisible(true);
                    }
                }
            }else if(Arowsnr>r){
                for(int j=r; j<Arowsnr;j++){
                    for(int n=0; n<Acolsnr; n++){
                        Aentries[j][n].setVisible(false);
                        Aentries[j][n].setText("");
                    }
                }
            }
        }
        Arowsnr=r;
    }
        if(source==Acols){
            int c=Acols.getValue();
            if(Arows!=null){
                if(Acolsnr<c){
                    for(int j=Acolsnr; j<c;j++){
                        for(int n=0; n<Arowsnr; n++){
                            Aentries[n][j].setVisible(true);

                        }
                    }
                    if(Bcols!=null){
                        for(int j=Acolsnr; j<c; j++){
                            for(int n=0; n<Bcolsnr; n++){
                                Bentries[j][n].setVisible(true);
                            }
                        }
                    }
                }else if(Acolsnr>c){
                    for(int j=c; j<Acolsnr;j++){
                        for(int n=0; n<Arowsnr; n++){
                            Aentries[n][j].setVisible(false);
                            Aentries[n][j].setText("");
                        }
                    }
                    if(Bcols!=null){
                        for(int j=c; j<Acolsnr; j++){
                            for(int n=0; n<Bcolsnr; n++){
                                Bentries[j][n].setVisible(false);
                                Bentries[j][n].setText("");
                            }
                        }
                    }
                }
            }
            Acolsnr=c;
            Brows.setText(String.valueOf(c));
        }

        if(source==Bcols){
            int c=Bcols.getValue();
            if(Acols!=null ){
                if(Bcolsnr<c){
                    for(int j=Bcolsnr; j<c;j++){
                        for(int n=0; n<Acolsnr; n++){
                            Bentries[n][j].setVisible(true);
                        }
                    }
                }else if(Bcolsnr>c){
                    for(int j=c; j<Bcolsnr;j++){
                        for(int n=0; n<Acolsnr; n++){
                            Bentries[n][j].setVisible(false);
                            Bentries[n][j].setText("");
                        }
                    }
                }
            }
            Bcolsnr=c;

        }
        if(source==coutproduct){
            try {
                Matrix A=new Matrix(Arowsnr, Acolsnr);
                Matrix B=new Matrix(Acolsnr, Bcolsnr);
                Matrix P=new Matrix(Arowsnr, Bcolsnr);
                for(int j=0; j<Arowsnr; j++){
                    for(int n=0; n<Acolsnr; n++){
                        A.setEntry(j,n, Double.valueOf(Aentries[j][n].getText()));
                        Aentries[j][n].setText("");
                        Aentries[j][n].setVisible(false);
                    }
                }
                for(int j=0; j<Acolsnr; j++){
                    for(int n=0; n<Bcolsnr; n++){
                        B.setEntry(j,n, Double.valueOf(Bentries[j][n].getText()));
                        Bentries[j][n].setText("");
                        Bentries[j][n].setVisible(false);


                    }
                }
                Bcolsnr=0;
                P.product(A,B);
                Arows.setValue(P.getDimrow());
                Acols.setValue(P.getDimcol());
                Acolsnr=P.getDimcol();
                for(int j=0; j<P.getDimrow(); j++){
                    for(int n=0; n<P.getDimcol(); n++){
                        Aentries[j][n].setVisible(true);
                        Aentries[j][n].setText(String.valueOf(P.getEntry(j,n)));
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(source==loga || source==logb){
            if(!loga.getText().equals("") && !logb.getText().equals("")){
                try{
                    double a= Double.valueOf(loga.getText());
                    double b= Double.valueOf(logb.getText());
                    double c=Math.log(b)/Math.log(a);
                    logeq.setText("="+c);
                }catch( Exception e){
                    logeq.setText("=error!");
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
