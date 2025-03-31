import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Weather2 {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        int locations = 10;
        int days = 365;
        double[][] records = new double[locations][days];
        for (int i = 0; i < locations; i++)
        {
            for (int j = 0; j < days; j++)
            {
                records[i][j] = Math.round(-10 + Math.random() * 45);
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/Weather2/src/input.txt")))
        {
            for (int i = 0; i < locations; i++)
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
        System.out.println("Station: ");
        int res1 = scn.nextInt();
        System.out.println("Day: ");
        int res2 = scn.nextInt();
        System.out.println(records[res1][res2]);
        scn.close();
    }
}
