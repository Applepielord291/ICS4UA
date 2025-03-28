import javax.swing.*;
//import java.awt.*;

public class Frame {
    public void showWindow() throws Exception
    {
        JFrame frame = new JFrame("test");
        JPanel panel = new JPanel();
        JButton button = new JButton("System");
        JMenu menu = new JMenu("Title");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quiz Marker");
        panel.setSize(600, 400);
        frame.add(panel);
        panel.add(menu);

        panel.add(button);
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        //nothing right now
    }
}
