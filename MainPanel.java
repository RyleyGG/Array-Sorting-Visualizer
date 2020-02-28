import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.text.*;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import java.util.Arrays;

public class MainPanel extends HBox
{
    Rectangle[] graphRectArr;
    int largestArrNum = 0;
    Scene scene;

    public MainPanel(Scene scene, SortingArray inputArray)
    {
        this.scene = scene;
        this.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        this.setStyle("-fx-border-color: black;\n" +
        "-fx-border-width: 1;\n");
        this.setAlignment(Pos.BOTTOM_LEFT);
        /*
        //Outline rectangle
        Rectangle outlineRect = new Rectangle();
        outlineRect.widthProperty().bind(scene.widthProperty());
        outlineRect.heightProperty().bind(scene.heightProperty().subtract(scene.getHeight()*0.25));
        outlineRect.setFill(Color.TRANSPARENT);
        outlineRect.setStroke(Color.BLACK);

        this.getChildren().add(outlineRect);
        */
    }

    public void generateGraph(Scene scene, SortingArray inputArray)
    {
        this.graphRectArr = new Rectangle[inputArray.getElementCount()];
        this.getChildren().remove(0,this.getChildren().size());

        //Setting up the largest array number for bar graph creation
        for (int i = 0; i < inputArray.getElementCount();i++)
        {
            if (inputArray.getElements()[i] > this.largestArrNum)
            {
                this.largestArrNum = inputArray.getElements()[i];
            }
        }

        //Creating the rectangles for the bar graph
        for (int i = 0; i < inputArray.getElementCount(); i++)
        {
            int curValue = inputArray.getElements()[i];
            int largestNumTemp = this.largestArrNum;
            Rectangle rect = new Rectangle();
            rect.widthProperty().bind(Bindings.createDoubleBinding(
                () -> ((scene.widthProperty().getValue()-scene.widthProperty().getValue()*0.2)/inputArray.getElementCount()),scene.widthProperty()));
            //System.out.println(rect.widthProperty());
            
            rect.heightProperty().bind(Bindings.createDoubleBinding(
                () -> (scene.heightProperty().getValue()*0.8)*((double) curValue/(double) largestNumTemp),scene.heightProperty()));
            rect.setStroke(Color.BLACK);
            rect.setFill(Color.web("#008BFF"));
            this.graphRectArr[i] = rect;
        }

        //Adding rectangles to pane & setting action
        for (int i = 0; i < this.graphRectArr.length; i++)
        {
            this.getChildren().add(this.graphRectArr[i]);
            /*
            int indexTemp = i;
            this.getChildren().get(i).setOnMouseEntered(e ->
            {
                System.out.println(indexTemp+1);
            });
            */
        }
    }

    public void updateGraphColor(int... selectedBarIndex)
    {
        for (int i = 0; i < selectedBarIndex.length; i++)
        {
            try
            {
                Rectangle rect = this.graphRectArr[selectedBarIndex[i]];

                if (rect.getFill() == Color.GREEN)
                {
                    rect.setFill(Color.web("#008BFF"));
                }
                else
                {
                    rect.setFill(Color.GREEN);
                }

                rect.setStroke(Color.BLACK);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            }
        }
    }

    //Both indices inclusive
    public void updateGraphOrder(int[] inputArray, int startIndex, int endIndex)
    {
        for (int i = 0; i < inputArray.length; i++)
        {
            if (i >= startIndex && i <= endIndex)
            {
                //Creating the rectangles for the bar graph
                for (int x = startIndex; x < endIndex+1; x++)
                {
                    int curValue = inputArray[x];
                    int largestNumTemp = this.largestArrNum;
                    Rectangle rect = new Rectangle();
                    rect.widthProperty().bind(Bindings.createDoubleBinding(
                        () -> ((scene.widthProperty().getValue()-scene.widthProperty().getValue()*0.2)/inputArray.length),this.scene.widthProperty()));
                    //System.out.println(rect.widthProperty());
                    
                    rect.heightProperty().bind(Bindings.createDoubleBinding(
                        () -> (scene.heightProperty().getValue()*0.8)*((double) curValue/(double) largestNumTemp),this.scene.heightProperty()));

                        rect.setStroke(Color.BLACK);
                        rect.setFill(Color.web("#008BFF"));
                        this.graphRectArr[x] = rect;
                }

                //Adding rectangles to pane & setting action
                for (int x = startIndex; x < endIndex+1; x++)
                {
                    this.getChildren().set(x,this.graphRectArr[x]);
                    /*
                    int indexTemp = x;
                    this.getChildren().get(x).setOnMouseEntered(e ->
                    {
                        System.out.println(indexTemp+1);
                    });
                    */
                }
            }
        }
    }
}