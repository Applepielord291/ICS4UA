import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Weather2Frame extends JFrame 
{
    public static JTextArea textArea2 = new JTextArea(50, 50);
    public static JTextArea textArea3 = new JTextArea(50, 50);
    public static JTextArea textArea4 = new JTextArea(50, 50);
    public void showFrame() throws Exception
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea(100, 400);
        
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JScrollPane scrollPane = new JScrollPane(textArea);
        JScrollPane scrollPane2 = new JScrollPane(textArea4);
        JButton btn = new JButton("Regenerate table");

        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        panel.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("I LOVE JFRAMESSSS RAHHHH");
        panel.setSize(600, 400);

        scrollPane.setBounds(100, 95, 350, 210);
        textArea2.setBounds(100, 65, 75, 20);
        textArea3.setBounds(300, 65, 75, 20);
        scrollPane2.setBounds(465, 100, 100, 210);
        label2.setBounds(100, 25, 100, 50);
        label3.setBounds(300, 25, 200, 50);
        btn.setBounds(165, 310, 200, 25);

        label2.setText("Station number");
        label3.setText("Month (as a number)");
        btn.addActionListener(e -> buttonClicked());

        frame.add(panel);
        panel.add(scrollPane);
        panel.add(label2);
        panel.add(label3);
        panel.add(textArea2);
        panel.add(textArea3);
        panel.add(btn);
        panel.add(scrollPane2);

        try
        {
            textArea.read(new BufferedReader(new FileReader("labs/Lab4/Weather2/src/input.txt")), null);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
    public static void buttonClicked()
    {
        int StationNumber = Integer.parseInt(textArea2.getText());
        int month = Integer.parseInt(textArea3.getText());
        Weather2 w2 = new Weather2();
        try {
            w2.tableAccess(StationNumber, month);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try
        {
            textArea4.read(new BufferedReader(new FileReader("labs/Lab4/Weather2/src/result.txt")), null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
