import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/* Nigel Garcia
 * April 4 2025
 * GroupingRandomV2
 * Groups custom names in a random order
 */

public class GroupingRandom_V2 {
    public static void main(String[] args) throws Exception {
        String[][] names = new String[5][3];
        String[][] groupedNames = new String[5][3];
        Scanner scn = new Scanner(System.in);

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.println("Enter a name: ");
                names[i][j] = scn.nextLine();
            }
        }

        scn.close();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/GroupingRandom_V2/src/output.txt")))
        {
            for (int i = 0; i < 5; i++)
            {
                bw.write("Group " + (i + 1) + ":\n");
                for (int j = 0; j < 3; j++)
                {
                    boolean real = false;
                    int rnd = 0;
                    int rnd2 = 0;
                    
                    while(!real)
                    {
                        rnd = (int)Math.round(Math.random() * 4);
                        rnd2 = (int)Math.round(Math.random() * 2);
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
