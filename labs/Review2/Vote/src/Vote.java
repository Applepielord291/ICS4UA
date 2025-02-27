import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

//Nigel Garcia
//February 5 2025
//Outputs results based on votes A or B

public class Vote {

    public static char[] voteNumber;
    public static char[] bString;
    public static void main(String[] args) throws Exception 
    {
        try
        {
            File file = new File("./labs/Review2/Vote/src/output.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String a;
            Scanner scanner = new Scanner(System.in);

            System.out.println("singer a vote: ");
            a = scanner.nextLine();
            voteNumber = a.toCharArray();
            int aCount = 0;
            int bCount = 0;

            //check string if it contains/not contains A or B
            if (a.contains("A"))
            {
                for (int x = 0; x < voteNumber.length; x++)
                {
                    bString = a.toCharArray(); //save to array to compare
                    if (bString[x] == 'A')
                    {
                        aCount++;
                    }
                }
            }
            if (a.contains("B"))
            {
                for (int x = 0; x < voteNumber.length; x++)
                {
                    bString = a.toCharArray();
                    if (bString[x] == 'B')
                    {
                        bCount++;
                    }
                }
            }
            if (!a.contains("A") || !a.contains("B"))
            {
                System.out.println("only A and B are allowed.");
            }

            //output result based on number of A/B
            if (aCount > bCount)
            {
                System.out.println("check output file");
                bw.write("A wins by " + (aCount - bCount) + " votes!");
            }
            else if (bCount > aCount)
            {
                System.out.println("check output file");
                bw.write("B wins by " + (bCount - aCount) + " votes!");
            }
            else if (bCount == aCount)
            {
                System.out.println("check output file");
                bw.write("Singers are equal");
            }

            bw.close();
            scanner.close();

        }
        catch (Exception e)
        {
            System.out.println("Something went wrong.");
        }
    }
}
