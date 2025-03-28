//import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception 
    {
        Frame frame = new Frame();
        frame.showWindow();

        fileGeneration fileG = new fileGeneration();
        fileG.makeFile(); 
    }
}
