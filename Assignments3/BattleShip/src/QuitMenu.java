import javax.swing.*;

/* 
 * May 27 2025
 * QuitMenu
 * Frame to display various buttons that leads to different frames
 */

public class QuitMenu {
    //variables declared in class to be accessed by all functions
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    public static void showFrame(JFrame currFrame) //called when user clicks quit button in ending screen (parameter may be redundant) (nvm its not, just a weird way to close the MainFrame)
    {
        //components
        JButton quitToSelect = new JButton("Quit to select");
        JButton closeApp = new JButton("Close Application");

        //hide frame border
        frame.setUndecorated(true);

        //frame essentials
        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("PauseMenu");

        //component positions
        quitToSelect.setBounds(125, 125, 150, 45);
        closeApp.setBounds(125, 175, 150, 45);

        //button events
        quitToSelect.addActionListener(e -> changeToSelect(currFrame));
        closeApp.addActionListener(e -> shutDownProgram(currFrame));

        frame.add(panel);
        panel.add(quitToSelect);
        panel.add(closeApp);

        frame.setVisible(true);
    }
    public static void changeToSelect(JFrame frameToClose) //Brings user back to SelectionFrame and closes all other frames
    {
        SelectionFrame.ShowFrame();
        Main.resetInfo();
        frameToClose.dispose();
        frame.dispose();
    }
    public static void shutDownProgram(JFrame frameToClose) //closes all frames and closes the application
    {
        frameToClose.dispose();
        frame.dispose();
        System.exit(0);
    }
}
