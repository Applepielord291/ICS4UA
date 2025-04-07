import java.io.BufferedWriter;
import java.io.FileWriter;

/* Nigel Garcia
 * April 4 2025
 * GroupingRandom
 * Groups names together in a random order
 */

public class GroupingRandom {
    public static void main(String[] args) throws Exception {
        String[][] names = {{"Abigail", "Ali", "Anderson"}, {"Bob", "Blake", "Bryan"}, {"Cam", "Charlie", "Clementine"}, {"Dennis", "Diana", "Dominic"}, {"Eden", "Elan", "Ebenezer"}};
        String[][] groupedNames = new String[5][3];
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/GroupingRandom/src/output.txt")))
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
