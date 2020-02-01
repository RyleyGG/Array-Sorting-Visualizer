/////////////////////////////////////////
// This program will take various array sorting methods and display them visually
// Current sorting implementation ideas: bubble sort, selection sort, merge sort, quick sort, gnome sort
/////////////////////////////////////////

import java.lang.Math;


public class SortingArray
{
    private int elementCount; //Number of elements in the array
    private int[] elements; //Specific elements of the array

    public static void main(String args[])
    {
        SortingArray curArray = new SortingArray(); //Create the array object that will be used throughout the program
        SortingMethod sorter = new SortingMethod(); //Create the sorter and initialize all sorting methods

        sorter.setCurArray(curArray); //After initializing the sorter above, set its current array to curArray, the array used throughout the program

        new gui(curArray,sorter); //Generate the GUI
    }

    public void generateValues()
    {
        elements = new int[elementCount];

        for (int i = 0; i < elementCount; i++)
        {
            elements[i] = (int) (Math.random()*(500-1) + 1);
        }
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