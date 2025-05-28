import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Image;
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

    public static JPanel playerGrid = new JPanel();
    public static JPanel enemyGrid = new JPanel();
    public static JPanel ammoGrid = new JPanel();

    static ImageIcon bgAnim = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameBg.gif");
    static ImageIcon bgAnimFadeOut = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameFadeOut.gif");
    static ImageIcon ammoActive = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoActive.png");
    static ImageIcon ammoUsed = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoUsed.png");

    static JLabel bgLbl = new JLabel(bgAnimFadeOut); //used to display background graphic

    static JFrame frame = new JFrame();

    static JPanel panel = new JPanel();

    public static void ShowFrame()
    {
        frame.removeAll();
        frame.revalidate();
        frame.repaint();

        //just testing something
        xCordTxt = new JTextPane();
        yCordTxt = new JTextPane();
        moveHistoryTxt = new JTextPane();
        playerGrid = new JPanel();
        enemyGrid = new JPanel();
        ammoGrid = new JPanel();
        bgAnim = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameBg.gif");
        bgAnimFadeOut = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameFadeOut.gif");
        bgLbl = new JLabel(bgAnimFadeOut); //used to display background graphic
        frame = new JFrame();
        panel = new JPanel();
        ammoActive = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoActive.png");
        ammoUsed = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoUsed.png");

        GameRules.currF = GameRules.CurrentFrame.mainScreen;

        frame.setUndecorated(true);

        JButton sendBtn = new JButton("Attack!");
        JButton surrenderBtn = new JButton("Surrender");

        JScrollPane moveHistory = new JScrollPane(moveHistoryTxt);

        ImageIcon playerMapIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\BattleShipPlayerMapTitle.png");
        ImageIcon enemyMapIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\BattleShipEnemyPreview.png");
        ImageIcon turnHistoryIcon = new ImageIcon("BattleShip\\Graphics\\MainFrame\\TurnHistoryTitle.png");
        ImageIcon ammoLeftIcon = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoCount.png");
        
        JLabel ammoCountLbl = new JLabel(ammoLeftIcon);
        JLabel xLbl = new JLabel("X");
        JLabel yLbl = new JLabel("Y");
        JLabel playerMapTitle = new JLabel(playerMapIcon);
        JLabel enemyMapTitle = new JLabel(enemyMapIcon);

        JLabel moveHistoryLbl = new JLabel(turnHistoryIcon);

        frame.setResizable(false);
        frame.setSize(900, 625);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(900, 625);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BattleShip");

        moveHistoryTxt.setEditable(false);

        playerGrid.setBounds(10, 10, 300, 300);
        enemyGrid.setBounds(575, 10, 300, 300);
        ammoGrid.setBounds(625, 450, 200, 125);
        
        playerMapTitle.setBounds(85, 315, 150, 25);
        enemyMapTitle.setBounds(650, 315, 150, 25);

        xCordTxt.setBounds(317, 335, 100, 25);
        yCordTxt.setBounds(467, 335, 100, 25);
        moveHistory.setBounds(317, 85, 250, 225);

        ammoCountLbl.setBounds(645, 410, 150, 30);
        xLbl.setBounds(317, 310, 25, 25);
        yLbl.setBounds(467, 310, 25, 25);
        bgLbl.setBounds(0, 0, 900, 625);
        moveHistoryLbl.setBounds(317, 10, 250, 65);

        sendBtn.setBounds(385, 380, 100, 25);
        surrenderBtn.setBounds(385, 410, 100, 25);

        playerGrid.setLayout(new GridLayout(Main.player.map.length, Main.player.map.length));
        enemyGrid.setLayout(new GridLayout(Main.enemy.map.length, Main.enemy.map.length));
        ammoGrid.setLayout(new GridLayout(2, Main.player.ammoCount/2));

        updateAmmoGrid();
        
        displayPlayerMap();
        
        for (int i = 0; i < Main.enemy.map.length; i++)
        {
            for (int j = 0; j < Main.enemy.map.length; j++)
            {
                if (GameRules.enemyMapVisible) enemyGrid.add(new JLabel(Main.ImageToAdd(Main.enemy.map[i][j], 300)));
                else enemyGrid.add(new JLabel(Main.ImageToAdd('-', 300)));
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

            panel.add(enemyGrid);

            panel.add(sendBtn);
            panel.add(moveHistoryLbl);
            panel.add(moveHistory);
            panel.add(ammoCountLbl);
            panel.add(xLbl);
            panel.add(yLbl);
            panel.add(playerMapTitle);
            panel.add(enemyMapTitle);
            panel.add(ammoGrid);
            panel.add(bgLbl);
            bgLbl.setIcon(bgAnim);
            frame.setVisible(true);
        }, 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

        frame.add(panel);
        panel.add(bgLbl);

        frame.setVisible(true);
    }
    public static void updateAmmoGrid()
    {
        ammoGrid.removeAll();
        for (int i = 0; i < Main.player.ammoCount; i++)
        {
            Image curr = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoActive.png").getImage().getScaledInstance(62, 62, 0);
            ammoGrid.add(new JLabel(new ImageIcon(curr)));
        }
        for (int i = 0; i < Main.player.timesFired; i++)
        {
            Image curr = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoUsed.png").getImage().getScaledInstance(62, 62, 0);
            ammoGrid.add(new JLabel(new ImageIcon(curr)));
        }
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
                playerGrid.add(new JLabel(Main.ImageToAdd(Main.player.map[i][j], 300)));
            }
        }
    }
}
