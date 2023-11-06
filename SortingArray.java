import java.lang.Math;
import java.util.Arrays; 



public class SortingArray {
    private int elementCount;
    private int[] elements;

    public void generateValues() {
        elements = new int[elementCount];

        for (int i = 0; i < elementCount; i++) {
            elements[i] = (int) (Math.random()*(450) + 50);
        }
        
        System.out.println(Arrays.toString(elements));
    }

        
    
    /* setters & getters */

    public void setElementCount(int newElementCount) {
        elementCount = newElementCount;
    }

    public int getElementCount() {
        return elementCount;
    }

    public int[] getElements() {
        return elements;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
    }
}