import java.lang.Math;

public class SortingMethod
{
    int step;

    public void oNotation(int[] inputArray)
    {
        System.out.println(inputArray.length);
        System.out.println(step);
        System.out.println("Big O Notation: " + "O(N^" + Math.log(step)/Math.log(inputArray.length) + ")");
    }
}

class Bubble extends SortingMethod
{
    public int[] sort(int[] inputArray)
    {
        step = 0;
        int temp;
        int notSortedCheck = 0;
        int[] newArray = inputArray;

        while (notSortedCheck != newArray.length-1)
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
        return newArray;
    }
}