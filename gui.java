import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.text.*;


public class gui extends Application
{
    SortingArray inputArray = new SortingArray();
    SortingMethod sorter = new SortingMethod(inputArray);


    @Override
    public void start(Stage primaryStage)
    {
        BorderPane rootPane = new BorderPane();
        Scene scene = new Scene(rootPane,720,480);

        InputPanel inputPanel = new InputPanel(scene,this.inputArray,this.sorter);
        MainPanel mainPanel = new MainPanel(scene,this.inputArray);
        this.sorter.setMainPanel(mainPanel);
        OutputPanel outputPanel = new OutputPanel(scene,this.sorter);
        this.sorter.setOutputPanel(outputPanel);
        rootPane.setTop(inputPanel);
        rootPane.setCenter(mainPanel);
        rootPane.setBottom(outputPanel);
        rootPane.setRight(new Pane());

        inputPanel.getChildren().get(2).setOnMouseClicked(e ->
        {
            if ((this.sorter.getSortingThread() == null || this.sorter.getSortingThread().isAlive() == false))
            {
                outputPanel.updateONotation();
                mainPanel.generateGraph(scene,inputArray);
            }
        });

        inputPanel.getChildren().get(4).setOnMouseClicked(e ->
        {
            if ((this.sorter.getSortingThread() == null || this.sorter.getSortingThread().isAlive() == false))
            {
                outputPanel.updateONotation();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Array Sorting Visualizer");
		primaryStage.show();
    }

    public static void main(String args[])
    {
        launch(args);
    }
}