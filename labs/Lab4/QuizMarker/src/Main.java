//import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception 
    {
        fileGeneration fileG = new fileGeneration();
        fileG.makeFile(); 

        Frame frame = new Frame();
        frame.showWindow();
    }
}
