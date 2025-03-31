import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/* Nigel Garcia
 * March 30 2025
 * Weather
 * Outputs temperatures
 */

public class Weather 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        int months = 12;
        int days = 30;
        double[][] records = new double[months][days];
        for (int i = 0; i < months; i++)
        {
            for (int j = 0; j < days; j++)
            {
                records[i][j] = Math.round(-10 + Math.random() * 45);
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/Weather/src/input.txt")))
        {
            for (int i = 0; i < months; i++)
            {
                for (int j = 0; j < days; j++)
                {
                    bw.write("" + records[i][j] + " ");
                }
            }
            bw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Day: ");
        int res = scn.nextInt();
        if (res > 0)
        {
            for (int i = 0; i < months; i++)
            {
                if (i == res)
                {
                    for (int j = 0; j < days; j++)
                    {
                        System.out.println("Temperatures are: " + records[res][j]);
                    }
                }
            }
        }
        else 
        {
            for (int i = 0; i < months; i++)
            {
                for (int j = 0; j < days; j++)
                {
                    System.out.println("Temperatures are: " + records[res][j]);
                }
            }
        }
        scn.close();
    }
}
