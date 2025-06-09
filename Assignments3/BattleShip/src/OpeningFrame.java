import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/* 
 * May 23 2025
 * OpeningFrame
 * The Title Screen for the battleship program
 */

public class OpeningFrame {
    //variables declared in class to be accessed by all functions
    static ImageIcon titleAnim = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipTitleScreen.gif");
    static ImageIcon titleFadeIn = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipTitleFade.gif");
    static ImageIcon titleFadeOut = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipTitleFadeOut.gif");
    static ImageIcon startBtnIcon = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipStartBtn.png");
    static ImageIcon quitBtnIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/QuitBtn.png");
    static JButton quitBtn = new JButton(quitBtnIcon);
    static JButton startBtn = new JButton(startBtnIcon);
    static JLabel lbl = new JLabel(titleAnim);
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    public static void ShowFrame() //called when program starts: this is the title screen.
    {
        //hide frame border
        frame.setUndecorated(true);

        //display components after the fade effect finishes (after 3 seconds)
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        lbl.setIcon(titleFadeOut);
        scheduledExecutorService.schedule(() -> {
            
            panel.remove(lbl);
            panel.add(startBtn);
            panel.add(quitBtn);
            panel.add(lbl);
            lbl.setIcon(titleAnim);
        }, 3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
        
        //frame essentials
        frame.setResizable(false);
        frame.setSize(800, 450);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        panel.setLayout(null);
        panel.setSize(800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BattleShipOpening");
        
        //setting components position
        startBtn.setBounds(285, 315, 200, 50);
        quitBtn.setBounds(320, 375, 125, 31);
        lbl.setBounds(0, 0, 800, 450);

        //button events
        startBtn.addActionListener(e -> userClickedStart());
        quitBtn.addActionListener(e -> userExit());

        frame.add(panel);
        panel.add(lbl);
        frame.setVisible(true);
    }
    public static void userExit() //function called when the user clicked the quit button, closes the application
    {
        frame.dispose();
        System.exit(0); 
        //I only just learned about System.exit not too long ago, if its not a good way to close applications let me know
    }
    public static void userClickedStart() //function called when the user clicked the start button
    {
        //triggers the fade effect, disables components and switches to the next window (SelectionFrame) after 3 seconds
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        lbl.setIcon(titleFadeIn);
        panel.remove(startBtn);
        panel.remove(quitBtn);
        scheduledExecutorService.schedule(() -> {
            SelectionFrame.ShowFrame();
            frame.dispose();
        }, 3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
