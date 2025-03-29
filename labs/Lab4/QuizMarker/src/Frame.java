import javax.swing.*;
//import java.awt.*;

public class Frame {
    public void showWindow() throws Exception
    {
        JFrame frame = new JFrame("test");
        JPanel panel = new JPanel();
        JButton button = new JButton("Load File");
        JMenu menu = new JMenu("System");
        JMenu menu2 = new JMenu("About");
        JMenu subMenu = new JMenu("About");
        JMenuItem menuItem = new JMenuItem("About");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quiz Marker");
        panel.setSize(600, 400);
        frame.add(panel);
        panel.add(menu); panel.add(menu2);
        menu.addSeparator();
        menu.add(subMenu);
        subMenu.add(menuItem);
        panel.add(button);

        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        //nothing right now
    }
}
