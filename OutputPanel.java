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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.text.*;

public class OutputPanel extends HBox
{
    TextField oNotationOutput = new TextField();

    public OutputPanel(Scene scene, SortingMethod sorter)
    {
        this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(Double.MAX_VALUE);

        Text oNotationText = new Text("O-Notation Output: ");
        oNotationOutput.setEditable(false);
        this.getChildren().addAll(oNotationText,oNotationOutput);
    }

    public void updateONotation()
    {
        this.oNotationOutput.setText(null);
    }
    
    public void updateONotation(double input)
    {
        this.oNotationOutput.setText(Double.toString(input));
    }
}