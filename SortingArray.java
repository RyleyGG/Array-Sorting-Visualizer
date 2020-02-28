/////////////////////////////////////////
// This program will take various array sorting methods and display them visually
// Current sorting implementation ideas: bubble sort, selection sort, merge sort, quick sort, gnome sort
/////////////////////////////////////////

import java.lang.Math;
import java.util.Arrays; 



public class SortingArray
{
    private int elementCount; //Number of elements in the array
    private int[] elements; //Specific elements of the array

    public void generateValues()
    {
        elements = new int[elementCount];

        for (int i = 0; i < elementCount; i++)
        {
            elements[i] = (int) (Math.random()*(450) + 50);
        }
        
        System.out.println(Arrays.toString(elements));
    }

        
    
    /////////////////// Setters and getters
    public void setElementCount(int newElementCount)
    {
        elementCount = newElementCount;
    }

    public int getElementCount()
    {
        return elementCount;
    }

    public int[] getElements()
    {
        return elements;
    }

    public void setElements(int[] elements)
    {
        this.elements = elements;
    }
}