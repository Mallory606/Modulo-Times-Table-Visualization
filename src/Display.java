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

        numDots = 82;
        timesTable = 2;

        visual = new Canvas(405, 405);
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

        Scene scene = new Scene(border, 600, 405);
        primaryStage.setScene(scene);
        primaryStage.show();


        initializeVis();

        AnimationTimer a = new AnimationTimer(){
            @Override
            public void handle(long now){
                if(started){
                }
            }
        };
        a.start();
    }

    public void startWindow(String[] args){ launch(args); }

    private void initializeVis(){
        GraphicsContext gc = visual.getGraphicsContext2D();
        double[] dotCoord;
        if(numDots%2 != 0){ numDots++; }
        vis = new Visualization(timesTable, numDots);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.YELLOWGREEN);
        gc.setLineWidth(3);
        gc.strokeOval(0, 0, 400, 400);
        gc.setStroke(Color.BLACK);
        for(int i = 0; i < numDots; i++){
            dotCoord = vis.getDot(i);
            gc.fillOval(dotCoord[0], dotCoord[1], 3, 3);
        }
    }
}
