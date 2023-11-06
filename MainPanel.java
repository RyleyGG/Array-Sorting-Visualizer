import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.beans.binding.Bindings;

public class MainPanel extends HBox {
    Rectangle[] graphRectArr;
    int largestArrNum = 0;
    Scene scene;

    public MainPanel(Scene scene, SortingArray inputArray) {
        // init
        this.scene = scene;
        this.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        this.setStyle("-fx-border-color: black;\n" +
        "-fx-border-width: 1;\n");
        this.setAlignment(Pos.BOTTOM_LEFT);
    }

    public void generateGraph(Scene scene, SortingArray inputArray) {
        // remove all prev rects and init new arr
        this.graphRectArr = new Rectangle[inputArray.getElementCount()];
        this.getChildren().remove(0,this.getChildren().size());

        // bar sizing is relative based on the largest value randomly generated.
        for (int i = 0; i < inputArray.getElementCount();i++)
        {
            if (inputArray.getElements()[i] > this.largestArrNum)
            {
                this.largestArrNum = inputArray.getElements()[i];
            }
        }

        // creating the rectangles for the bar graph
        for (int i = 0; i < inputArray.getElementCount(); i++) {
            int curValue = inputArray.getElements()[i];
            Rectangle rect = new Rectangle();

            // applying rect width
            rect.widthProperty().bind(Bindings.createDoubleBinding(
                () -> ((scene.widthProperty().getValue()-scene.widthProperty().getValue()*0.2)/inputArray.getElementCount()), scene.widthProperty()));

            // applying rect height. Height is relative such that largest number is 80% of the maximum height in the current scene
            rect.heightProperty().bind(Bindings.createDoubleBinding(
                () -> (scene.heightProperty().getValue()*0.8)*((double) curValue/(double) this.largestArrNum), scene.heightProperty()));
            rect.setStroke(Color.BLACK);
            rect.setFill(Color.web("#008BFF"));
            this.graphRectArr[i] = rect;
        }

        //Adding rectangles to pane
        for (int i = 0; i < this.graphRectArr.length; i++) {
            this.getChildren().add(this.graphRectArr[i]);
        }
    }

    // for a given rect index, flip its color (assume binary choice between green and blue)
    public void updateGraphColor(int... selectedBarIndex) {
        for (int i = 0; i < selectedBarIndex.length; i++) {
            try {
                Rectangle rect = this.graphRectArr[selectedBarIndex[i]];

                if (rect.getFill() == Color.GREEN) {
                    rect.setFill(Color.web("#008BFF"));
                }
                else {
                    rect.setFill(Color.GREEN);
                }

                rect.setStroke(Color.BLACK);
            }
            catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    //Both indices inclusive
    public void updateGraphOrder(int[] inputArray, int startIndex, int endIndex) {
        for (int i = 0; i < inputArray.length; i++) {
            if (i >= startIndex && i <= endIndex) {
                //Creating the rectangles for the bar graph
                for (int x = startIndex; x < endIndex+1; x++) {
                    int curValue = inputArray[x];
                    int largestNumTemp = this.largestArrNum;
                    Rectangle rect = new Rectangle();
                    rect.widthProperty().bind(Bindings.createDoubleBinding(
                        () -> ((scene.widthProperty().getValue()-scene.widthProperty().getValue()*0.2)/inputArray.length),this.scene.widthProperty())
                    );
                    
                    rect.heightProperty().bind(Bindings.createDoubleBinding(
                        () -> (scene.heightProperty().getValue()*0.8) * ((double) curValue/(double) largestNumTemp),this.scene.heightProperty())
                    );

                    rect.setStroke(Color.BLACK);
                    rect.setFill(Color.web("#008BFF"));
                    this.graphRectArr[x] = rect;
                }

                //Adding rectangles to pane & setting action
                for (int x = startIndex; x < endIndex+1; x++) {
                    this.getChildren().set(x,this.graphRectArr[x]);
                }
            }
        }
    }
}