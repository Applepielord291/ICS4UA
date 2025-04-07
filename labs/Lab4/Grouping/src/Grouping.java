import java.io.BufferedWriter;
import java.io.FileWriter;
//fix later
public class Grouping {
    public static void main(String[] args) throws Exception {
        String[][] names = {{"Abigail", "Ali", "Anderson"}, {"Bob", "Blake", "Bryan"}, {"Cam", "Charlie", "Clementine"}, {"Dennis", "Diana", "Dominic"}, {"Eden", "Elan", "Ebenezer"}};
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/Grouping/src/output.txt")))
        {
            for (int i = 0; i < 5; i++)
            {
                bw.write("Group " + (i + 1) + ":\n");
                for (int j = 0; j < 3; j++)
                {
                    bw.write(names[i][j] + "\n");
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
