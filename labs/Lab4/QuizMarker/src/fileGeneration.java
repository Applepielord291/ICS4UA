import java.io.BufferedWriter;
import java.io.FileWriter;

public class fileGeneration {
    public static void main(String[] args) throws Exception 
    {
        
    }
    public void makeFile() throws Exception
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/QuizMarker/src/textFiles/input.txt")))
        {
            int test = 0;
            char[][] ansAndKey = new char[20][2];
            bw.write("Student response\n");
            for (int i = 0; i < 20; i++)
            {
                ansAndKey[i][0] = Letter(test);
                bw.write(ansAndKey[i][0]); bw.write("\n");
            }
            bw.write("Answer Key\n");
            for (int i = 0; i < 20; i++)
            {
                ansAndKey[i][1] = Letter(test);
                bw.write(ansAndKey[i][1]); bw.write("\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to create file");
        }
    }
    public static char Letter(int rnd)
    {
        rnd = (int)(1 + Math.random() * 3);
        switch(rnd)
        {
            case(1):
                return 'A';
            case(2):
                return 'B';
            case(3):
                return 'C';
            case(4):
                return 'D';
        }
        return ' ';
    }
}
