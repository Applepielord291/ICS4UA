import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

//Nigel garcia
//February 6 2025
//sort bowls by weights and outputs the middle weight value

//remember to output in file before I submit

public class Middle {
    public static void main(String[] args) throws Exception 
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("labs/Review5/Middle/src/results.txt"));
            int[] weightValues = new int[3];
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;

            //Input
            System.out.println("what is the weight of the first bowl?");
            int firstBowl = Integer.parseInt(scanner.nextLine());
            weightValues[0] = firstBowl;
            System.out.println("What is the weight of the second bowl?");
            int secondBowl = Integer.parseInt(scanner.nextLine());
            weightValues[1] = secondBowl;
            System.out.println("what is the weight of the last bowl?");
            int lastBowl = Integer.parseInt(scanner.nextLine());
            weightValues[2] = lastBowl;

            for (int x = 0; x < weightValues.length; x++)
            {
                if (firstBowl > weightValues[x])
                {
                    count1++;
                }
                if (secondBowl > weightValues[x])
                {
                    count2++;
                }
                if (lastBowl > weightValues[x])
                {
                    count3++;
                }
            }

            if (count1 == 1)
            {
                bufferedWriter.write(Integer.toString(firstBowl));
            }
            else if (count2 == 1)
            {
                bufferedWriter.write(Integer.toString(secondBowl));
            }
            else if (count3 == 1)
            {
                bufferedWriter.write(Integer.toString(lastBowl));
            }
            System.out.println("Please check the output file containing median value located in ./Review5/Middle/output.txt");
            scanner.close();
            bufferedWriter.close();
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
    }
}
