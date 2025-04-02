import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/* Nigel Garcia
 * March 30 2025
 * Weather2
 * Outputs temperatures and the useer can pick a location now
 */

public class Weather2 {
    static int locations = 10;
    static int days = 365;
    static double[][] records = new double[locations][days];
    public static void main(String[] args) throws Exception 
    {
        Weather2Frame w2f = new Weather2Frame();
        w2f.showFrame();
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
                bw.write("Location: " + (i + 1) + ": ");
                for (int j = 0; j < days; j++)
                {
                    bw.write(records[i][j] + " | ");
                }
            }
            bw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
    public void generate() throws IOException
    {
        
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
                bw.write("Location " + (i + 1) + ": ");
                for (int j = 0; j < days; j++)
                {
                    bw.write(records[i][j] + " | ");
                }
                bw.write("\n");
            }
            bw.close();
        }
    }
    public void tableAccess(int station, int month) throws IOException
    {
        /*int min = 0;
        int max = 0;
        switch(month)
        {
            case(1):
                min = 0;
                max = 30;
                break;
            case(2):
                min = 31;
                max = 58;
                break;
            case(3):
                min = 59;
                max = 89;
                break;
            case(4):
                min = 90;
                max = 119;
                break;
            case(5):
                min = 120;
                max = 150;
                break;
            case(6):
                min = 151;
                max = 180;
                break;
            case(7):
                min = 181;
                max = 211;
                break;
            case(8):
                min = 212;
                max = 242;
                break;
            case(9):
                min = 243;
                max = 272;
                break;
            case(10):
                min = 273;
                max = 303;
                break;
            case(11):
                min = 304;
                max = 333;
                break;
            case(12):
                min = 334;
                max = 365;
                break;
        }*/
        try (BufferedReader br = new BufferedReader(new FileReader("labs/Lab4/Weather2/src/input.txt")))
        {
            for (int i = 0; i < station; i++)
            {
                br.readLine();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
