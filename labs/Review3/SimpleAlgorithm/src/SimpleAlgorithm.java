import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

//Nigel Garcia
//February 6 2025
//Code that outputs age of the oldest child given the age of the youngest and middle

public class SimpleAlgorithm {
    public static void main(String[] args) throws Exception 
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("labs/Review3/SimpleAlgorithm/src/output.txt"));

            //Inputs
            System.out.println("Input age for the youngest child");
            int Y = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter age for the middle child");
            int M = Integer.parseInt(scanner.nextLine());

            //check if (0 <= Y <= 50) and (Y <= M <= 50)
            if (M >= Y && M <= 50)
            {
                int O = M + (M - Y);
                bufferedWriter.write("youngest: " + Y);
                bufferedWriter.write(" Middle: " + M);
                bufferedWriter.write(" Oldest: " + O);
                System.out.println("check the outpput file located in");
            }
            else
            {
                System.out.println("Middle age must be larger than younger age");
            }
            scanner.close();
            bufferedWriter.close();
        }
        catch (Exception e)
        {
            System.out.println("something went wrong");
        }
    }
}
