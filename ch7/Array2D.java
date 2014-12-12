import java.util.Scanner;

/**
 * Write a description of class Array2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Array2D
{
    private int[][] table = 
    {
        {1,2,3},
        {4,5,6},
        {7,8,9},
        {10,11,12}
        };
    public Array2D()
    {
        
    }
    public String toString()
    {
        String str = "";
        for(int row = 0; row < table.length; row++)
        {
            for(int col = 0; col < table[row].length; col++)
            {
                str += table[row][col] + "\t";
            }
            str += "\n";
        }
        return str;
    }
    public String getRow(int row)
    {
        String str = "";
        for(int val : table[row])
        {
            str += val + "\t";
        }
        return str;
    }
    public String getCol( int col)
    {
        String str = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("What col? ");
        int col1 = sc.nextInt();
        for(int i = 0; i < table.length;i++)
        {
            System.out.println(table[i][col1]);        
            str += table[i][col1];
        }
        return str;
    }        
    public static void main(String[] args)
    {
        Array2D table = new Array2D();
        System.out.println(table.toString() );
    }
}
