import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Display extends javafx.application.Application{

    private Visualization vis;
    private Canvas visual;
    private int numDots;
    private int timesTable;
    private boolean started = false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Modulo Times Table Visualization");

        numDots = 8;
        timesTable = 2;

        visual = new Canvas(405, 400);
        Button start = new Button("Start");
        start.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if(!started){
                started = true;
                start.setText("Pause");
            }
            else{
                started = false;
                start.setText("Start");
            }
        });

        FlowPane flow = new FlowPane();

        flow.getChildren().add(start);

        BorderPane border = new BorderPane();

        border.setCenter(visual);
        border.setRight(flow);

        Scene scene = new Scene(border, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer a = new AnimationTimer(){
            @Override
            public void handle(long now){
                if(started){
                    initializeVis();
                }
            }
        };
        a.start();
    }

    public void startWindow(String[] args){ launch(args); }

    private void initializeVis(){
        GraphicsContext gc = visual.getGraphicsContext2D();
        int[] dotCoord;
        vis = new Visualization(timesTable, numDots);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.DARKRED);
        gc.setLineWidth(3);
        gc.strokeOval(0, 0, 400, 400);
        gc.setStroke(Color.BLACK);
        for(int i = 0; i < numDots; i++){
            dotCoord = vis.getDot(i);
            gc.fillOval(dotCoord[0], dotCoord[1], 3, 3);
        }
    }
}
