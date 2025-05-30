import javax.swing.*;

/* Nigel Garcia
 * May 27 2025
 * QuitMenu
 * Frame to display various buttons that leads to different frames
 */

public class QuitMenu {
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    public static void showFrame(JFrame currFrame)
    {
        JButton quitToSelect = new JButton("Quit to select");
        JButton closeApp = new JButton("Close Application");

        frame.setUndecorated(true);

        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("PauseMenu");

        quitToSelect.setBounds(125, 125, 150, 45);
        closeApp.setBounds(125, 175, 150, 45);

        quitToSelect.addActionListener(e -> changeToSelect(currFrame));
        closeApp.addActionListener(e -> shutDownProgram(currFrame));

        frame.add(panel);
        panel.add(quitToSelect);
        panel.add(closeApp);

        frame.setVisible(true);
    }
    public static void changeToSelect(JFrame frameToClose)
    {
        SelectionFrame.ShowFrame();
        Main.resetInfo();
        frameToClose.dispose();
        frame.dispose();
    }
    public static void shutDownProgram(JFrame frameToClose)
    {
        frameToClose.dispose();
        frame.dispose();
        System.exit(0);
    }
}
