import java.io.BufferedWriter;
import java.io.FileWriter;

public class fileGeneration {
    public static void main(String[] args) throws Exception 
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("labs/Lab4/QuizMarker/src/textFiles")))
        {
            
        }
        catch (Exception e)
        {
            System.out.println("Failed to create file");
        }
        finally
        {
            
        }
    }
}
