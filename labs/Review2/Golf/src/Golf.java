
//Nigel Garcia
//February 5 2025
//Outputs a chart with a table number of holes and a score in a txt file

import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;

public class Golf {
    public static void main(String[] args) throws Exception 
    {
        try
        {
            int[] score = new int[5];
            File file = new File("./labs/Review2/Golf/src/table.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            Scanner scanner = new Scanner(System.in);
            int birdie = 0;

            //Input
            for (int i = 0; i < score.length; i++)
            {
                System.out.println("enter a score");
                score[i] = Integer.parseInt(scanner.nextLine());
                if (score[i] >= 3)
                {
                    birdie++;
                }
            }
        
            //write to file
            bufferedWriter.write("Hole: 1 | 2 | 3 | 4 | 5");
            bufferedWriter.write(System.lineSeparator() + "Score: " + score[0] + " | " + score[1] + " | " + score[2] + " | " + score[3] + " | " + score[4]);
            bufferedWriter.write(" final score: " + (score[0] + score[1] + score[2] + score[3] + score[4]));
            bufferedWriter.write(System.lineSeparator() + "Birdie: " + birdie);
            System.out.println("please check the output file located in " + file.toString()); 

            //close to save memory
            bufferedWriter.close(); 
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong.");
        }
        
    }
}
