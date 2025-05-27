import javax.swing.*;
import java.awt.GridLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* Nigel Garcia
 * May 23 2025
 * Frame
 * The Frame for the BattleShip Program
 */

public class MainFrame {
    public static JTextPane xCordTxt = new JTextPane();
    public static JTextPane yCordTxt = new JTextPane();

    public static JTextPane moveHistoryTxt = new JTextPane();
    public static JTextPane ammoLeftTxt = new JTextPane();

    public static JPanel playerGrid = new JPanel();
    public static JPanel enemyGrid = new JPanel();

    static ImageIcon bgAnim = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameBg.gif");
    static ImageIcon bgAnimFadeOut = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameFadeOut.gif");
    static JLabel bgLbl = new JLabel(bgAnimFadeOut); //used to display background graphic

    static JFrame frame = new JFrame();

    static JPanel panel = new JPanel();

    public static void ShowFrame()
    {

        frame.setUndecorated(true);

        JButton sendBtn = new JButton("Attack!");
        JButton surrenderBtn = new JButton("Surrender");

        JScrollPane moveHistory = new JScrollPane(moveHistoryTxt);

        JLabel ammoCountLbl = new JLabel("Ammo Count");
        JLabel xLbl = new JLabel("X");
        JLabel yLbl = new JLabel("Y");

        

        frame.setResizable(false);
        frame.setSize(900, 625);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(900, 625);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BattleShip");

        moveHistoryTxt.setEditable(false);

        playerGrid.setBounds(10, 10, 300, 300);

        if (GameRules.enemyMapVisible)
        {
            enemyGrid.setBounds(575, 10, 300, 300);
        }
        

        xCordTxt.setBounds(25, 400, 100, 25);
        yCordTxt.setBounds(25, 430, 100, 25);
        moveHistory.setBounds(317, 10, 250, 300);
        ammoLeftTxt.setBounds(150, 400, 100, 25);

        ammoCountLbl.setBounds(150, 375, 100, 25);
        xLbl.setBounds(5, 400, 25, 25);
        yLbl.setBounds(5, 430, 25, 25);
        bgLbl.setBounds(0, 0, 900, 625);

        sendBtn.setBounds(385, 350, 100, 25);
        surrenderBtn.setBounds(385, 380, 100, 25);

        playerGrid.setLayout(new GridLayout(Main.player.map.length, Main.player.map.length));
        if (GameRules.enemyMapVisible)
        {
            enemyGrid.setLayout(new GridLayout(Main.enemy.map.length, Main.enemy.map.length));
        }
        
        displayPlayerMap();
        
        
        if (GameRules.enemyMapVisible)
        {
            for (int i = 0; i < Main.enemy.map.length; i++)
            {
                for (int j = 0; j < Main.enemy.map.length; j++)
                {
                    enemyGrid.add(new JLabel(Main.ImageToAdd(Main.enemy.map[i][j])));
                }
            }
        }
        

        sendBtn.addActionListener(e -> Main.userSendsAttack(xCordTxt.getText(), yCordTxt.getText()));

        surrenderBtn.addActionListener(e -> userSurrender());

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        
        scheduledExecutorService.schedule(() -> {
            userTurnStarted();
            panel.remove(bgLbl);
            panel.add(xCordTxt);
            panel.add(yCordTxt);
            panel.add(surrenderBtn);

            panel.add(playerGrid);

            if (GameRules.enemyMapVisible) 
            {
                panel.add(enemyGrid);
            }

            panel.add(sendBtn);
            panel.add(moveHistory);
            panel.add(ammoLeftTxt);
            panel.add(ammoCountLbl);
            panel.add(xLbl);
            panel.add(yLbl);
            panel.add(bgLbl);
            bgLbl.setIcon(bgAnim);
            frame.setVisible(true);
        }, 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

        frame.add(panel);
        panel.add(bgLbl);

        frame.setVisible(true);

        ammoLeftTxt.setText(Main.player.ammoCount + "");
    }
    public static void userSurrender()
    {
        Main.player.ammoCount = 0;
        EndingScreen.DisplayFrame();
    }
    public static void userClickedAttack()
    {
        Main.userSendsAttack(xCordTxt.getText(), yCordTxt.getText());
    }
    public static void userTurnStarted()
    {
        TransitionAnim.showFrame("player");
    }
    public static void enemyTurnStarted()
    {
        TransitionAnim.showFrame("enemy");
    }
    public static void displayPlayerMap()
    {
        playerGrid.removeAll();
        for (int i = 0; i < Main.player.map.length; i++)
        {
            for (int j = 0; j < Main.player.map.length; j++)
            {
                playerGrid.add(new JLabel(Main.ImageToAdd(Main.player.map[i][j])));
            }
        }
    }
}
