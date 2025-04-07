import java.io.BufferedWriter;
import java.io.FileWriter;

//fix later
public class App {
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
                    for (int k = 0; k < 3; k++)
                    {
                        int rnd = (int)Math.round(Math.random() * 3);
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
