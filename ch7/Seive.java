import java.util.Arrays;
public class Seive
{
    public static void main(String[]args)
    {
        int[] l = new int[1000];
        int currentSize = 1000;
        for(int i = 0; i < 1000; i++)
        {
            l[i] = (int)(2+i);
        }
        for(int k =0; k <1000; k++)
        {
            for( int j = 2; j<=1002;j++)
            {
                if(j != l[k] && l[k]%j == 0)
                {
                    l[k] = l[currentSize - 1];               
                    currentSize--;
                    for(int a = 2; a<=1002;a++)
                    
                }
            }
        }
        Arrays.sort(l);
        for(int p = 0; p < currentSize; p++)
        {
            System.out.println(l[p]);
        }
    }
}
