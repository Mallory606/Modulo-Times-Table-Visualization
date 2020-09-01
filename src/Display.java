import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Display extends javafx.application.Application{

    private Canvas visual;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Modulo Times Table Visualization");

        visual = new Canvas(400, 400);

        FlowPane flow = new FlowPane();

        flow.getChildren().add(new Button("Start"));

        BorderPane border = new BorderPane();

        border.setCenter(visual);
        border.setRight(flow);

        Scene scene = new Scene(border, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer a = new AnimationTimer(){
            @Override
            public void handle(long now){

            }
        };
        a.start();
    }

    public void startWindow(String[] args){ launch(args); }
}
