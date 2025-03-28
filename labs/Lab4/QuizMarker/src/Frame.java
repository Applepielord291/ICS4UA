import javax.swing.*;
import java.awt.*;

public class Frame {
    public void showWindow() throws Exception
    {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("what");
        frame.setBackground(new Color(220, 220, 220));
        emptyLabel.setBackground(new Color(20, 20, 20));
        emptyLabel.setPreferredSize(new Dimension(128, 128));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        frame.setTitle("WOWEEEE");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        //nothing right now
    }
}
