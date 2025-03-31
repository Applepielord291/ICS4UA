/* Nigel Garcia
 * March 28 2025
 * Main
 * This is the main Script, Run this to run the program.
 */

public class Main {
    public static void main(String[] args) throws Exception 
    {
        fileGeneration fileG = new fileGeneration(); //refer to the script "fileGeneration"
        fileG.makeFile(); 

        Frame frame = new Frame(); //refer to the script "Frame"
        frame.showWindow();
    }
}
