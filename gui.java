import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class gui extends Application {
    SortingArray inputArray = new SortingArray();
    SortingMethod sorter = new SortingMethod(inputArray);


    @Override
    public void start(Stage primaryStage) {
        // init
        BorderPane rootPane = new BorderPane();
        Scene scene = new Scene(rootPane,720,480);

        // constructing primary view
        MainPanel mainPanel = new MainPanel(scene, this.inputArray);
        InputPanel inputPanel = new InputPanel(scene, this.inputArray, this.sorter);
        OutputPanel outputPanel = new OutputPanel(scene, this.sorter);
        this.sorter.setMainPanel(mainPanel);
        this.sorter.setOutputPanel(outputPanel);
        rootPane.setTop(inputPanel);
        rootPane.setCenter(mainPanel);
        rootPane.setBottom(outputPanel);
        rootPane.setRight(new Pane());

        // if generate button is selected
        inputPanel.getChildren().get(2).setOnMouseClicked(e -> {
            if ((this.sorter.getSortingThread() == null || this.sorter.getSortingThread().isAlive() == false)) {
                outputPanel.updateONotation();
                mainPanel.generateGraph(scene, inputArray);
            }
        });

        // if sort button is selected
        inputPanel.getChildren().get(4).setOnMouseClicked(e -> {
            if ((this.sorter.getSortingThread() == null || this.sorter.getSortingThread().isAlive() == false)) {
                outputPanel.updateONotation();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Array Sorting Visualizer");
		primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}