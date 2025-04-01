import java.io.BufferedWriter;
import java.io.FileWriter;

/* Nigel Garcia
 * March 28 2025
 * fileGeneration
 * Randomly generates test input answers and an answer key (both A-D) to use for the program.
 */
public class fileGeneration {
    static String res = "";
    static String res2 = "";
    static String res3 = "";
    public static void main(String[] args) throws Exception {}
    public void makeFile() //throws Exception //Generates file and random answers
    {
        int test = 0;
        char[][] ansAndKey = new char[20][2];
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/QuizMarker/src/textFiles/input.txt")))
        {
            for (int i = 0; i < 20; i++)
            {
                ansAndKey[i][0] = Letter(test);
                bw.write((i + 1) + ". " + ansAndKey[i][0]); bw.write("\n");
            }
            bw.close();
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
            bw.close();
        }
        catch (Exception e)
        {
            System.out.println("Failed to create file 2");
        }

        compare(ansAndKey);
    }
    public static void compare(char[][] ansAndKey) //Compares if answers are right or not
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
            res = "Failed.";
        }
        else if (wrongCount <= correctCount) 
        {
            res = "Passed.";
        }
        res2 = "" + correctCount;
        res3 = "" + wrongCount;
    }
    public static char Letter(int rnd) //Randomly generates a letter
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
