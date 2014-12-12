import java.util.Random;
import java.util.Scanner;
import java.util.*;
/**
* Write a description of class RandomDistribution here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class RandomDistribution
{
    public static void main(String[]args)
    {
            Scanner in = new Scanner(System.in);
            System.out.println("How many random numbers do you want to generate?" );
            int num = in.nextInt();
            System.out.println("What is the number of values for each random draw? ");
            int total = in.nextInt();
            int[] a = new int[total]; 
            for(int i = 0; i<total ; i++)
            {
                a[i]= (int)(Math.random() * num);
            }
            for(int i=1 ; i <= total ; i++)
            {
                System.out.println(i+": "+a[i-1]);
            }
        }

}