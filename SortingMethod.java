import java.lang.Math;
import java.util.Arrays;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SortingMethod
{
    private int step;
    private SortingArray curArray = new SortingArray();
    private Map<Integer, Runnable> sortingMethods = new HashMap<Integer,Runnable>();



    public SortingMethod() //Initializing all sorting methods when the program is first launched
    {
        //When the sorter is first initialized, its associated array is set to a blank 'initialization array' as seen here
        //That way, there is essentially no performance hit from the below map being constructed
        //Immediately after this constructor is completed, the initialization array will be replaced with the actual input array used throughout the program
        int[] initializationArray = new int[0];
        this.curArray.setElements(initializationArray);

        this.sortingMethods.put(0,() -> bubble(this.curArray.getElements()));
        this.sortingMethods.put(1,() -> reverseBubble(this.curArray.getElements()));
    }

    public void selectMethod(int selectedMethod, SortingMethod sorter)
    {
        sorter.sortingMethods.get(selectedMethod).run(); //The dropdown list in the GUI and the sortingMethods list have the same order, thus its possible to use the index of the selected dropdown item to point to the correct sorting method
        //sorter.oNotation(elements);
    }

    public void oNotation(int[] inputArray)
    {
        System.out.println("Big O Notation: " + "O(N^" + Math.log(step)/Math.log(inputArray.length) + ")");
    }

    public int[] bubble(int[] inputArray)
    {
        step = 0;
        int temp;
        int notSortedCheck = 0;
        int[] newArray = inputArray;

        while (notSortedCheck != newArray.length)
        {
            notSortedCheck = 0;
            for (int i = 0; i < newArray.length; i++)
            {
                if ((i + 1 < newArray.length) && (newArray[i + 1] < newArray[i]))
                {
                    temp = inputArray[i];
                    newArray[i] = inputArray[i + 1];
                    newArray[i + 1] = temp;
                }
                else
                {
                    notSortedCheck++;
                }
                
                step++;
            }
        }

        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    public int[] reverseBubble(int[] inputArray)
    {
        step = 0;
        int temp;
        int notSortedCheck = 0;
        int[] newArray = inputArray;

        while (notSortedCheck != newArray.length)
        {
            notSortedCheck = 0;
            for (int i = 0; i < newArray.length; i++)
            {
                if ((i + 1 < newArray.length) && (newArray[i + 1] > newArray[i]))
                {
                    temp = inputArray[i];
                    newArray[i] = inputArray[i + 1];
                    newArray[i + 1] = temp;
                }
                else
                {
                    notSortedCheck++;
                }
                
                step++;
            }
        }
        
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }



    public void setCurArray(SortingArray curArray)
    {
        this.curArray = curArray;
    }
}
