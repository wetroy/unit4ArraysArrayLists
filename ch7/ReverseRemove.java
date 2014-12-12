import java.util.ArrayList;

/**
 * Write a description of class ReverseRemove here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReverseRemove
{
    public static void romoveElement(ArrayList<String> list, String match)
    {
        for(int i = list.size() - 1; i >= 0; i--)
        {
            if(match.equals(list.get(i)))
            {
                list.remove(i);
            }
        }
    }
}
