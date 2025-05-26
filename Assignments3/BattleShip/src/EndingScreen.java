import javax.swing.*;
/* Nigel Garcia
 * May 24 2025
 * Ending Screen
 * Runs only after the game ends: game stats n stuff
 */
public class EndingScreen {
    public static void DisplayFrame()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setUndecorated(true);

        JLabel pTitle = new JLabel("Player Stats");
        JLabel eTitle = new JLabel("Enemy Stats");
        JLabel timesFired = new JLabel("Times fired: " + Main.player.timesFired);
        JLabel timesMissed = new JLabel("Times missed: " + Main.player.timesMissed);

        JLabel timesFiredE = new JLabel("Times fired: " + Main.enemy.timesFired);
        JLabel timesMissedE = new JLabel("Times missed: " + Main.enemy.timesMissed);

        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Post game");

        pTitle.setBounds(10, 10, 100, 25);
        eTitle.setBounds(210, 10, 100, 25);
        timesFired.setBounds(10, 25, 150, 25);
        timesMissed.setBounds(10, 40, 100, 25);
        timesFiredE.setBounds(210, 25, 150, 25);
        timesMissedE.setBounds(210, 40, 150, 25);

        frame.add(panel);
        panel.add(pTitle);
        panel.add(eTitle);
        panel.add(timesFired);
        panel.add(timesMissed);
        panel.add(timesFiredE);
        panel.add(timesMissedE);

        frame.setVisible(true);
    }
}
