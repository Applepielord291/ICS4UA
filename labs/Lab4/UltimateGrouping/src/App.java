import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("How many rows?");
        int rows = scn.nextInt();
        System.out.println("How many columns?");
        int columns = scn.nextInt();
        System.out.println("How many groups?");
        int groups = scn.nextInt();
        String[][] names = new String[rows][columns];
        String[][] groupedNames = new String[groups][((rows * columns) / groups)];
        

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.println("Enter a name: ");
                names[i][j] = scn.nextLine();
            }
        }

        scn.close();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/UltimateGrouping/src/output.txt")))
        {
            for (int i = 0; i < groups; i++)
            {
                bw.write("Group " + (i + 1) + ":\n");
                for (int j = 0; j < columns; j++)
                {
                    for (int k = 0; k < columns; k++)
                    {
                        int rnd = (int)Math.round(Math.random() * ((rows * columns) / groups));
                        if (groupedNames[rnd][k] == null)
                        {
                            groupedNames[rnd][k] = names[rnd][k];
                            bw.write(groupedNames[rnd][k] + "\n");
                            break;
                        }
                    }
                }
                bw.write("\n\n");
            }
            bw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
