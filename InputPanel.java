import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.text.*;

public class InputPanel extends HBox {
    public InputPanel(Scene scene, SortingArray inputArray, SortingMethod sorter) {
        this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(Double.MAX_VALUE);

        Text arraySizeText = new Text();
        arraySizeText.setText("Array Size (1500 maximum):");
        TextField arraySizeInput = new TextField();
        Button generateButton = new Button("Generate");
        generateButton.setOnAction(e -> {
            try {
                if (Integer.parseInt(arraySizeInput.getText()) <= 1500 && (sorter.getSortingThread() == null || sorter.getSortingThread().isAlive() == false)) {
                    inputArray.setElementCount(Integer.parseInt(arraySizeInput.getText()));
                    inputArray.generateValues();
                }
            }
            catch (NumberFormatException v) {
            }
        });

        String[] methodList =  new String[2];
        methodList[0] = "Bubble Sort";
        methodList[1] = "Reverse Bubble Sort";

        ComboBox<String> sortingOptions = new ComboBox<String>(FXCollections.observableArrayList(methodList));
        Button sortButton = new Button("Sort");
        sortButton.setOnAction(e -> {
            for (int i = 0; i < methodList.length; i++) {
                if (sortingOptions.getValue() == methodList[i] && (sorter.getSortingThread() == null || sorter.getSortingThread().isAlive() == false)) {
                    sorter.selectMethod(i, sorter);
                }
            }
        });

        this.getChildren().addAll(arraySizeText,arraySizeInput,generateButton,sortingOptions,sortButton);
    }
}