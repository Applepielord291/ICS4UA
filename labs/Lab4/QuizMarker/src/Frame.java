import javax.swing.*;
import java.io.FileReader;
import java.io.BufferedReader;
//import java.awt.*;

public class Frame extends JFrame {
    JTextArea textArea = new JTextArea(100, 100);
    JTextArea textArea2 = new JTextArea(50, 50);
    JTextArea textArea3 = new JTextArea(20, 20);
    JTextArea textArea4 = new JTextArea(20, 20);
    String result = " ";
    public void showWindow() throws Exception
    {
        JFrame frame = new JFrame("test");
        JPanel panel = new JPanel();
        JButton button = new JButton("Load File");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("System");
        JMenu menu2 = new JMenu("About");
        JMenu subMenu = new JMenu("Exit");
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        panel.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quiz Marker");
        panel.setSize(600, 400);
        button.setBounds(400, 25, 100, 25);
        scrollPane.setBounds(10, 10, 250, 300);
        textArea2.setBounds(350, 200, 150, 100);
        textArea3.setBounds(350, 165, 200, 25);
        textArea4.setBounds(350, 130, 200, 25);
        button.addActionListener(e -> selectionButtonPressed());
        
        frame.add(panel);
        panel.add(button);
        panel.add(menuBar);
        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menuBar.add(menu2);
        menu.add(subMenu);
        panel.add(scrollPane);
        panel.add(textArea2);
        panel.add(textArea2);
        panel.add(textArea3);
        panel.add(textArea4);
        
        frame.setVisible(true);
    }
    public void selectionButtonPressed()
    {
        try
        {
            textArea.read(new BufferedReader(new FileReader("labs/Lab4/QuizMarker/src/textFiles/input.txt")), null); 
            textArea2.setText(fileGeneration.res);
            textArea3.setText(fileGeneration.res2);
            textArea4.setText(fileGeneration.res3);
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        //nothing right now
    }
}
