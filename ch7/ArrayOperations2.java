import java.util.Arrays;

/**
 * Write a description of class ArrayOperations2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayOperations2
{
    /** description of instance variable x (add comment for each instance variable) */
    private int[] values;
    private int currentSize;
    /**
     * Default constructor for objects of class ArrayAlgorithms
     */
    public ArrayOperations2()
    {
        values = new int[10];
        currentSize = 0;        
    }
    
    public void fillWithSquares()
    {
        currentSize = 0;           
        for(int i = 0; i < values.length; i++)
        {
            values[i] = i*i;
            currentSize++;
        }
        System.out.println(Arrays.toString(values));    
        System.out.println(currentSize);
    }
    public void swapFirstAndLast()
    {
        for(int index = 0; index < (currentSize / 2); index++)
        {
            int temp = values[index];
            values[index] = values[currentSize - index - 1];
            values[currentSize - index - 1] = temp;
        }
        System.out.println(Arrays.toString(values));
        System.out.println(currentSize);        
    }
    public void zero()
    {
        for(int i = 0; i < currentSize;i++)
        {
            values[i] = 0;
        }
        System.out.println(Arrays.toString(values));
    }
    public void replaceLarge()
    {
        for(int i = 1; i< currentSize - 1; i++)
        {
            int large = values[i-1];
            if(values[i+1] > large)
            {
                large = values[i+1];
            }
            values[i] = large;
        }
        System.out.println(Arrays.toString(values));       
    }
    public void remove()
    {
        int values2 = new int[10];
        for(int i = 0; i < values.length; i++)
        {
            if(i != ((currentSize - 1)/2))
            {
                values2[i] = values[i];
            }
        }
    }
}
