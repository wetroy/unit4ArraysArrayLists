

/**
 * Write a description of class PartiallyFilledArray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartiallyFilledArray
{
    /** description of instance variable x (add comment for each instance variable) */
    private int[] values;
    private int currentSize;
    
    /**
     * Default constructor for objects of class PartiallyFilledArray
     */
    public PartiallyFilledArray()
    {
        values = new int[10];
        currentSize = 0;
        
    }
    
    public String toString()
    {
        String str = "[ ";
        for(int i = 0; i < currentSize; i++)
        {
            if(i>0)
            {
                
                str += values[i] + ", ";
            }
            str += values[i];
        }
        str += " ]";
        return str;
    }
    
    public void fillNElements(int numberOfElements, int maxValue)
    {
        for(int i = 0; i< numberOfElements; i++)
        {
            values[i] = (int)(Math.random() * maxValue);
            currentSize++;
        }
    }
    
    public void removeElementAtIndex(int index)
    {
        values[index] = values[currentSize - 1];
        currentSize--;
    }
    
    public void swapElements(int index1, int index2)
    {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }
    
    public void insertElement(int val)
    {
        if(currentSize >= values.length)
        {
            growArray();
        }

        values[currentSize] = val;
        currentSize++;
    }
        
    private void growArray()
    {
        int newArraySize = values.length*2;
        int[] newArray = new int[newArraySize];
        
        for(int i = 0; i < values.length; i++)
        {
            newArray[i] = values[i];
        }
        values = newArray;
    }
}
