import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
//import java.awt.*;

public class Frame extends JFrame {
    public void showWindow() throws Exception
    {
        JFrame frame = new JFrame("test");
        JPanel panel = new JPanel();
        JButton button = new JButton("Load File");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("System");
        JMenu menu2 = new JMenu("About");
        JMenu subMenu = new JMenu("Exit");
        JTextArea textArea = new JTextArea(100, 100);
        JScrollPane scrollPane = new JScrollPane();
        
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        panel.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quiz Marker");
        panel.setSize(600, 400);
        button.setBounds(400, 25, 100, 25);
        scrollPane.setBounds(10, 10, 250, 300);

        frame.add(panel);
        panel.add(button);
        panel.add(menuBar);
        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menuBar.add(menu2);
        menu.add(subMenu);
        scrollPane.add(textArea);
        panel.add(scrollPane);
        
        try
        {
            textArea.read(new FileReader("labs/Lab4/QuizMarker/src/textFiles/input.txt"), null); 
            textArea.requestFocus();
            textArea.write(new FileWriter("labs/Lab4/QuizMarker/src/textFiles/input.txt"));
            //textArea.setText("");
            textArea.requestFocus();
        } 
        catch(Exception ioe) 
        {
            System.out.println("unable to acces file HAHAHAHAHAH");
        }

        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        //nothing right now
    }
    public void fileFinished(File file)
    {
        
    }
}
