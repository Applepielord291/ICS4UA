import java.io.BufferedWriter;
import java.io.FileWriter;

public class fileGeneration {
    static String res = "";
    static String res2 = "";
    static String res3 = "";
    public static void main(String[] args) throws Exception 
    {
        
    }
    public void makeFile() throws Exception
    {
        int test = 0;
        char[][] ansAndKey = new char[20][2];
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/QuizMarker/src/textFiles/input.txt")))
        {
            bw.write("Student Response:\n");
            for (int i = 0; i < 20; i++)
            {
                ansAndKey[i][0] = Letter(test);
                bw.write(ansAndKey[i][0]); bw.write("\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to create file 1");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/QuizMarker/src/textFiles/key.txt")))
        {
            for (int i = 0; i < 20; i++)
            {
                ansAndKey[i][1] = Letter(test);
                bw.write(ansAndKey[i][1]); bw.write("\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to create file 2");
        }

        compare(ansAndKey);
    }
    public static void compare(char[][] ansAndKey)
    {
        int correctCount = 0;
        int wrongCount = 0;
        for (int i = 0; i < 20; i++)
        {
            if (ansAndKey[i][0] == ansAndKey[i][1]) correctCount++;
            else 
            {
                wrongCount++;
            }
        }
        if (wrongCount > correctCount) 
        {
            res = "Verdict: Failed.";
        }
        else if (wrongCount <= correctCount) 
        {
            res = "Verdict: Passed.";
        }
        res2 = "Number of correct answer(s): " + correctCount;
        res3 = "Number of incorrect answer(s) " + wrongCount;
        System.out.println(correctCount + "/" + (wrongCount + correctCount));
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
