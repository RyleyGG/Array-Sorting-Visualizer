/////////////////////////////////////////
// This program will take various array sorting methods and display them visually
// Current sorting implementation ideas: bubble sort, selection sort, merge sort, quick sort, gnome sort
/////////////////////////////////////////

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class SortingArray
{
    private int elementCount;
    private int[] elements;

    public static void main(String args[])
    {
        SortingArray curArray = new SortingArray();

        curArray.setAttributes();

        System.out.println("Your current array length is: " + curArray.elementCount);
        System.out.println(Arrays.toString(curArray.elements));

        curArray.chooseSortingMethod();
    }

    public void setAttributes()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many elements should be in the array? ");
        setElementCount(input.nextInt());
        elements = new int[elementCount];
        input.close();

        for (int i = 0; i < elementCount; i++)
        {
            elements[i] = (int) (Math.random()*(100-0) + 0);
        }
    }

    public void chooseSortingMethod()
    {
        Scanner input = new Scanner(System.in);
        //System.out.println("Which sorting method would you like to use?");
        System.out.println("Automatically starting the bubble sort...");
        Bubble sorter = new Bubble();
        System.out.println(Arrays.toString(sorter.sort(elements)));
        sorter.oNotation(elements);
        input.close();
    }

        
    
    /////////////////// Boring setters and getters
    public void setElementCount(int newElementCount)
    {
        elementCount = newElementCount;
    }

    public int getElementCount()
    {
        return elementCount;
    }
}