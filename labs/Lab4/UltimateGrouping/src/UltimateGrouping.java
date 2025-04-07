import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class UltimateGrouping {
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
                    boolean real = false;
                    int rnd = 0;
                    int rnd2 = 0;
                        
                    while(!real)
                    {
                        rnd = (int)Math.round(Math.random() * (groups - 1));
                        rnd2 = (int)Math.round(Math.random() * (columns - 1));
                        if (names[rnd][rnd2] != null) real = true;
                    }

                    groupedNames[i][j] = names[rnd][rnd2];
                    names[rnd][rnd2] = null;
                    bw.write(groupedNames[i][j] + "\n");
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
