import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.text.*;

public class OutputPanel extends HBox {
    TextField oNotationOutput = new TextField();

    public OutputPanel(Scene scene, SortingMethod sorter) {
        this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(Double.MAX_VALUE);

        Text oNotationText = new Text("O-Notation Output: ");
        oNotationOutput.setEditable(false);
        this.getChildren().addAll(oNotationText,oNotationOutput);
    }

    public void updateONotation() {
        this.oNotationOutput.setText(null);
    }
    
    public void updateONotation(double input) {
        this.oNotationOutput.setText(Double.toString(input));
    }
}