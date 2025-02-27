import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

//Nigel garcia
//February 6 2025
//outputs description of alien given the input of alien witness (you)
// TroyMartin = at least 3 antenna at most 4 eyes
// VladSaturnian = at most 6 antenna and at least 2 eyes
// GraemeMercurian = at most 2 antennas and at most 3 eyes

//Remember to add textfile for output before I submit

public class Alien {
    public static void main(String[] args) throws Exception 
    {
        try
        {
            //Input
            File file = new File("labs/Review4/Alien/src/output.txt");
            Scanner scanner = new Scanner(System.in);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            System.out.println("How many antennas?");
            int antennaNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("How many eyes?");
            int eyeNumber = Integer.parseInt(scanner.nextLine());

            //Check which alien it is
            if (antennaNumber >= 3 && eyeNumber <= 4)
            {
                bufferedWriter.write("TroyMartin");
            }
            if (antennaNumber <= 6 && eyeNumber >= 2)
            {
                bufferedWriter.write("VladSaturnian");
            }
            if (antennaNumber <= 2 && eyeNumber <= 3)
            {
                bufferedWriter.write("GraemeMercurian");
            }
            System.out.println("please check the name result located in ./Review4/Alien/output.txt");
            bufferedWriter.close();
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
    }
}
