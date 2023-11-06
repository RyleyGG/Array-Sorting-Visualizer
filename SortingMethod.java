import java.lang.Math;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Platform;


public class SortingMethod {
    private int step;
    private SortingArray curArray = new SortingArray();
    private Map<Integer, Runnable> sortingMethodRunnables = new HashMap<Integer,Runnable>();
    private String[] sortingMethodNames = {
        "Bubble Sort",
        "Reverse Bubble Sort"
    };
    private MainPanel mainPanel;
    private OutputPanel outputPanel;
    // all sorting occurs in separate thread to increase responsiveness
    private Thread sortingThread;



    public SortingMethod(SortingArray inputArray) {
        /*
            Initializing all sorting methods when the program is first launched.
            When the sorter is first initialized, its associated array is set to a blank 'initialization array' as seen here.
            That way, there is essentially no performance hit from the below map being constructed.
            Immediately after this constructor is completed, the initialization array will be replaced with the actual input array used throughout the program.
        */
        this.curArray.setElements(new int[0]);

        this.sortingMethodRunnables.put(0,() -> bubble(this.curArray.getElements()));
        this.sortingMethodRunnables.put(1,() -> reverseBubble(this.curArray.getElements()));

        this.setCurArray(inputArray);
    }

    public void executeMethod(int methodIndex, SortingMethod sorter) {
         /*
            The dropdown list in the GUI and the sortingMethods list have the same order,
            thus its possible to use the index of the selected dropdown item to point to the correct sorting method
         */
        sorter.sortingMethodRunnables.get(methodIndex).run();
    }

    public double oNotation(int[] inputArray) {
        return Math.log(this.step)/Math.log(inputArray.length);
    }

    public void bubble(int[] inputArray) {
        this.step = 0;
        int[] newArray = inputArray;


        
        this.sortingThread = new Thread(() -> {
            int notSortedCheck = 0;
            while (notSortedCheck != newArray.length) {
                notSortedCheck = 0;
                for (int i = 0; i < newArray.length; i++) {
                    int ndx = i;

                    //All GUI updates occur within a Platform.runlater() so that the javafx application thread is used (IllegalStateException thrown otherwise)
                    Platform.runLater(() -> {
                        this.mainPanel.updateGraphColor(ndx, ndx+1);
                    });

                    try {
                        Thread.sleep(10000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    if ((i + 1 < newArray.length) && (newArray[i + 1] < newArray[i])) {
                        int temp = inputArray[i];
                        newArray[i] = inputArray[i + 1];
                        newArray[i + 1] = temp;
                        this.curArray.setElements(newArray);
                    }
                    else {
                        notSortedCheck++;
                    }   

                    Platform.runLater(() -> {
                        this.mainPanel.updateGraphColor(ndx, ndx+1);
                    });
                    this.step++;
                }
            }
            outputPanel.updateONotation(this.oNotation(newArray));
        });
        this.sortingThread.start();
    }

    public void reverseBubble(int[] inputArray) {
        this.step = 0;
        int[] newArray = inputArray;


        this.sortingThread = new Thread(() -> {
            int notSortedCheck = 0;
            while (notSortedCheck != newArray.length) {
                notSortedCheck = 0;
                for (int i = 0; i < newArray.length; i++) {
                    int ndx = i;

                    //All GUI updates occur within a Platform.runlater() so that the javafx application thread is used (IllegalStateException thrown otherwise)
                    Platform.runLater(() -> {
                        this.mainPanel.updateGraphColor(ndx, ndx+1);
                    });

                    try {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if ((i + 1 < newArray.length) && (newArray[i + 1] > newArray[i])) {
                        int temp = inputArray[i];
                        newArray[i] = inputArray[i + 1];
                        newArray[i + 1] = temp;
                    }
                    else {
                        notSortedCheck++;
                    }

                    Platform.runLater(() -> {
                        this.mainPanel.updateGraphColor(ndx, ndx+1);
                    });
                    this.step++;
                }
            }
            outputPanel.updateONotation(this.oNotation(newArray));
        });
        this.sortingThread.start();
        
        this.oNotation(newArray);
        System.out.println(Arrays.toString(newArray));
    }

    /* setters & getters */

    public void setCurArray(SortingArray curArray) {
        this.curArray = curArray;
    }

    public Thread getSortingThread() {
        return this.sortingThread;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setOutputPanel(OutputPanel outputPanel) {
        this.outputPanel = outputPanel;
    }

    public Map<Integer, Runnable> getSortingMethodRunnables() {
        return this.sortingMethodRunnables;
    }

    public String[] getSortingMethodNames() {
        return this.sortingMethodNames;
    }
}

