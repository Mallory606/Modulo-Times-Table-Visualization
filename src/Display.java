import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Display extends javafx.application.Application{

    private Visualization vis;
    private Canvas visual;
    private Label currTimesTable;
    private TextField numDotsField;
    private TextField timesTableField;
    private Slider intervalSlider;
    private Slider incrementSlider;
    private int numDots;
    private double timesTable;
    private double increment;
    private int interval;
    private Color color;
    private int favIndex;
    private boolean started;
    private boolean soloFrame;
    private boolean firstRun;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Modulo Times Table Visualization");

        numDots = 0;
        timesTable = 2;
        increment = 1;
        interval = 1000;
        color = Color.BLACK;
        favIndex = 0;
        started = false;
        soloFrame = false;
        firstRun = true;

        visual = new Canvas(410, 410);

        currTimesTable = new Label("Current Times Table: " + timesTable);

        Button start = new Button("Start");
        start.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if(!started){
                started = true;
                start.setText("Pause");
                if(soloFrame){
                    updateValuesNewVis();
                    soloFrame = false;
                }
            }
            else{
                started = false;
                start.setText("Start");
            }
        });
        Button changeColor = new Button("Change Color");
        changeColor.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if(color == Color.BLACK){ color = Color.YELLOWGREEN; }
            else if(color == Color.YELLOWGREEN){ color = Color.RED; }
            else if(color == Color.RED){ color = Color.MEDIUMTURQUOISE; }
            else if(color == Color.MEDIUMTURQUOISE){ color = Color.VIOLET; }
            else if(color == Color.VIOLET){ color = Color.MEDIUMVIOLETRED; }
            else if(color == Color.MEDIUMVIOLETRED){color = Color.MEDIUMBLUE; }
            else if(color == Color.MEDIUMBLUE){ color = Color.DARKOLIVEGREEN; }
            else if(color == Color.DARKOLIVEGREEN){ color = Color.DARKORANGE; }
            else if(color == Color.DARKORANGE){ color = Color.AQUA; }
            else{ color = Color.BLACK; }
        });
        Button restart = new Button("Restart");
        restart.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            updateValuesNewVis();
            soloFrame = false;
            if(!started){
                started = true;
                start.setText("Pause");
            }
        });

        HBox numDotsInterface = new HBox(10);
        Label numDotsLabel = new Label("Number of Dots");
        numDotsField = new TextField("0");
        numDotsInterface.getChildren().add(numDotsLabel);
        numDotsInterface.getChildren().add(numDotsField);

        HBox timesTableInterface = new HBox(10);
        Label timesTableLabel = new Label("Initial Times Table");
        timesTableField = new TextField("2");
        timesTableInterface.getChildren().add(timesTableLabel);
        timesTableInterface.getChildren().add(timesTableField);

        HBox intervalInterface = new HBox(10);
        Label intervalLabel = new Label("Frames per Second");
        intervalSlider = new Slider(0.5, 2.5, 1);
        intervalSlider.setMinorTickCount(1);
        intervalSlider.setMajorTickUnit(1);
        intervalSlider.setShowTickMarks(true);
        intervalSlider.setShowTickLabels(true);
        intervalSlider.setSnapToTicks(true);
        intervalInterface.getChildren().add(intervalLabel);
        intervalInterface.getChildren().add(intervalSlider);

        HBox incrementInterface = new HBox(10);
        Label incrementLabel = new Label("Increment Size");
        incrementSlider = new Slider(0, 5, 1);
        incrementSlider.setMinorTickCount(4);
        incrementSlider.setMajorTickUnit(1);
        incrementSlider.setShowTickMarks(true);
        incrementSlider.setShowTickLabels(true);
        incrementSlider.setSnapToTicks(true);
        incrementInterface.getChildren().add(incrementLabel);
        incrementInterface.getChildren().add(incrementSlider);

        Button jumpTo = new Button("Jump to Frame");
        jumpTo.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            updateValuesNewVis();
            increment = 0;
            soloFrame = true;
            if(started){
                started = false;
                start.setText("Start");
            }
        });

        Button favorites = new Button("Favorites");
        favorites.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if(favIndex == 0){
                numDots = 69;
                timesTable = 337;
                color = Color.DARKOLIVEGREEN;
                favIndex++;
            }
            else if(favIndex == 1){
                numDots = 360;
                timesTable = 305;
                color = Color.MEDIUMVIOLETRED;
                favIndex++;
            }
            else if(favIndex == 2){
                numDots = 152;
                timesTable = 51.799999999998;
                color = Color.RED;
                favIndex++;
            }
            else if(favIndex == 3){
                numDots = 200;
                timesTable = 100.999999999811;
                color = Color.AQUA;
                favIndex++;
            }
            else if(favIndex == 4){
                numDots = 289;
                timesTable = 30;
                color = Color.DARKORANGE;
                favIndex++;
            }
            else if(favIndex == 5){
                numDots = 266;
                timesTable = 67;
                color = Color.YELLOWGREEN;
                favIndex++;
            }
            else if(favIndex == 6){
                numDots = 317;
                timesTable = 106;
                color = Color.VIOLET;
                favIndex++;
            }
            else if(favIndex == 7){
                numDots = 202;
                timesTable = 202;
                color = Color.MEDIUMTURQUOISE;
                favIndex++;
            }
            else if(favIndex == 8){
                numDots = 175;
                timesTable = 36.3;
                color = Color.MEDIUMBLUE;
                favIndex++;
            }
            else{
                numDots = 206;
                timesTable = 308;
                color = Color.BLACK;
                favIndex = 0;
            }

            increment = 0;
            soloFrame = true;
            firstRun = false;
            if(started){
                started = false;
                start.setText("Start");
            }
        });

        VBox buttonInterface = new VBox(10);
        buttonInterface.setAlignment(Pos.TOP_CENTER);

        buttonInterface.getChildren().add(currTimesTable);
        buttonInterface.getChildren().add(start);
        buttonInterface.getChildren().add(changeColor);
        buttonInterface.getChildren().add(restart);
        buttonInterface.getChildren().add(numDotsInterface);
        buttonInterface.getChildren().add(timesTableInterface);
        buttonInterface.getChildren().add(intervalInterface);
        buttonInterface.getChildren().add(incrementInterface);
        buttonInterface.getChildren().add(jumpTo);
        buttonInterface.getChildren().add(favorites);

        BorderPane border = new BorderPane();

        border.setCenter(visual);
        border.setRight(buttonInterface);
        BorderPane.setAlignment(visual, Pos.CENTER);
        BorderPane.setAlignment(buttonInterface, Pos.CENTER);

        Scene scene = new Scene(border, 700, 410);
        primaryStage.setScene(scene);
        primaryStage.show();

        Thread intervalTimer = new Thread(() -> {
            Object o = new Object();
            synchronized(o){
                while(true){
                    try{
                        o.wait(interval);
                        updateValues();
                        timesTable += increment;
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        AnimationTimer a = new AnimationTimer(){
            @Override
            public void handle(long now){
                if(started || soloFrame){
                    if(firstRun){
                        updateValuesNewVis();
                        firstRun = false;
                        if(soloFrame){ increment = 0; }
                    }
                    initializeVis();
                    currTimesTable.setText("Current Times Table: " + timesTable);
                }
            }
        };
        intervalTimer.start();
        a.start();
    }

    public void startWindow(String[] args){ launch(args); }

    private void initializeVis(){
        GraphicsContext gc = visual.getGraphicsContext2D();
        if(numDots%2 != 0){ numDots++; }
        vis = new Visualization(numDots);
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 405, 405);
        gc.setFill(Color.BLACK);
        gc.setStroke(color);
        gc.setLineWidth(3);
        gc.strokeOval(5, 5, 400, 400);
        drawVis(gc);
        /*
        double[] dotCoord;
        gc.setStroke(Color.BLACK);
        for(int i = 0; i < numDots; i++){
            dotCoord = vis.getDot(i);
            gc.fillOval(dotCoord[0]+5, dotCoord[1]+5, 3, 3);
        }
        */
    }

    private void drawVis(GraphicsContext gc){
        double product;
        double[] origin, end;
        gc.setStroke(color);
        gc.setLineWidth(1);
        for(int i = 0; i < numDots; i++){
            product = (i*timesTable)%numDots;
            origin = vis.getDot(i);
            end = vis.getDot((int)product);
            gc.strokeLine(origin[0]+5, origin[1]+5, end[0]+5, end[1]+5);
        }
    }

    private void updateValuesNewVis(){
        String temp = numDotsField.getText();
        int newNumDots = 0;
        boolean validInput = false;
        if(!temp.equals("")){
            try{
                newNumDots = Integer.parseInt(temp);
                validInput = true;
            } catch(NumberFormatException n){
                System.out.println(temp +
                        " is not a valid input for the number of dots.");
            }
        }
        if(validInput){
            if(newNumDots >= 0){ numDots = Math.min(newNumDots, 360); }
        }

        temp = timesTableField.getText();
        double newTimesTable = 0;
        validInput = false;
        if(!temp.equals("")){
            try{
                newTimesTable = Double.parseDouble(temp);
                validInput = true;
            } catch(NumberFormatException n){
                System.out.println(temp +
                        " is not a valid input for the times table.");
            }
        }
        if(validInput){
            if(newTimesTable >= 0){ timesTable= Math.min(newTimesTable, 360); }
        }

        increment = incrementSlider.getValue();
    }

    private void updateValues(){
        double newInterval = intervalSlider.getValue();
        if(newInterval == 0.5){ interval = 2000; }
        else if(newInterval == 1){ interval = 1000; }
        else if(newInterval == 1.5){ interval = 750; }
        else if(newInterval == 2){ interval = 500; }
        else{ interval = 250; }
    }
}
