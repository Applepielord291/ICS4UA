import javax.swing.*;

/* Nigel Garcia
 * April 11 2025
 * AnimFrame
 * Cool animations YEAHHHH
 */

public class AnimFrame {
    public void showFrame()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel idleAnim = new JLabel();

        frame.setResizable(false);
        frame.setSize(300, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        panel.setLayout(null);
        panel.setSize(300, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ABSOLUTE CINEMA");

        frame.add(panel);

        frame.setVisible(true);
    }
}
