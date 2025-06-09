import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* 
 * May 23 2025
 * Frame
 * The Frame for the BattleShip Program
 */

public class MainFrame {
    //variables declared in class to be accessed by all functions
    public static JTextPane xCordTxt = new JTextPane();
    public static JTextPane yCordTxt = new JTextPane();
    public static JTextPane moveHistoryTxt = new JTextPane();
    public static JPanel playerGrid = new JPanel();
    public static JPanel enemyGrid = new JPanel();
    public static JPanel ammoGrid = new JPanel();
    public static JPanel enemyAmmoGrid = new JPanel();
    static ImageIcon bgAnim = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameBg.gif");
    static ImageIcon bgAnimFadeOut = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameFadeOut.gif");
    static ImageIcon ammoActive = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoActive.png");
    static ImageIcon ammoUsed = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoUsed.png");
    static JLabel bgLbl = new JLabel(bgAnimFadeOut); //used to display background graphic
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static boolean isEnemyTurn = false; //used only for pvp, tracking if its enemy or player turn

    public static void ShowFrame() //Function called upon to display frame after user enters a game (pressing ready btn in selection frame)
    {
        //okay, so for this chunk of code,i need to redeclare the variables and reload the frame again
        //if I dont do this, the frame and its components dosent load properly if the user decides that they want to play another round
        //I know for sure theres a better way to do this, but the entire program is already a mess anyway.
        frame.removeAll();
        frame.revalidate();
        frame.repaint();
        xCordTxt = new JTextPane();
        yCordTxt = new JTextPane();
        moveHistoryTxt = new JTextPane();
        playerGrid = new JPanel();
        enemyGrid = new JPanel();
        ammoGrid = new JPanel();
        enemyAmmoGrid = new JPanel();
        bgAnim = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameBg.gif");
        bgAnimFadeOut = new ImageIcon("BattleShip/Graphics/MainFrame/MainFrameFadeOut.gif");
        bgLbl = new JLabel(bgAnimFadeOut); 
        frame = new JFrame();
        panel = new JPanel();
        ammoActive = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoActive.png");
        ammoUsed = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoUsed.png");
        isEnemyTurn = false;

        //player turn first
        GameRules.playerCanAttack = true;

        //hide frame border
        frame.setUndecorated(true);

        //component declaration
        //seperated by empty lines for some organization
        JScrollPane moveHistory = new JScrollPane(moveHistoryTxt);

        ImageIcon playerMapIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\BattleShipPlayerMapTitle.png");
        ImageIcon enemyMapIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\BattleShipEnemyPreview.png");
        ImageIcon turnHistoryIcon = new ImageIcon("BattleShip\\Graphics\\MainFrame\\TurnHistoryTitle.png");
        ImageIcon ammoLeftIcon = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoCount.png");
        ImageIcon atkIcon = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAttackIcon.png");
        ImageIcon surrenderIcon = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipSurrenderIcon.png");

        JButton sendBtn = new JButton(atkIcon);
        JButton surrenderBtn = new JButton(surrenderIcon);
        
        JLabel ammoCountLbl = new JLabel(ammoLeftIcon);
        JLabel xLbl = new JLabel("X");
        JLabel yLbl = new JLabel("Y");
        JLabel playerMapTitle = new JLabel(playerMapIcon);
        JLabel enemyMapTitle = new JLabel(enemyMapIcon);
        JLabel moveHistoryLbl = new JLabel(turnHistoryIcon);

        //frame essentials
        frame.setResizable(false);
        frame.setSize(900, 625);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(900, 625);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BattleShip");

        //self-explanatory
        moveHistoryTxt.setEditable(false);

        //setting component positions
        //seperated by empty lines for some organization
        playerGrid.setBounds(10, 10, 300, 300);
        enemyGrid.setBounds(575, 10, 300, 300);
        ammoGrid.setBounds(625, 450, 200, 125);
        enemyAmmoGrid.setBounds(625, 450, 200, 125);
        
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

        //sets grid size by element number (using gridlayout so i dont have to manually set positions), so it can actually display images
        playerGrid.setLayout(new GridLayout(Main.player.map.length, Main.player.map.length));
        enemyGrid.setLayout(new GridLayout(Main.enemy.map.length, Main.enemy.map.length));
        ammoGrid.setLayout(new GridLayout(2, Main.player.ammoCount/2));
        enemyAmmoGrid.setLayout(new GridLayout(2, Main.enemy.ammoCount/2));

        //Functions to display the grid information
        updateAmmoGrid();
        updateEnemAmmoGrid();
        displayPlayerMap();
        for (int i = 0; i < Main.enemy.map.length; i++)
        {
            for (int j = 0; j < Main.enemy.map.length; j++)
            {
                if (GameRules.enemyMapVisible) enemyGrid.add(new JLabel(Main.ImageToAdd(Main.enemy.map[i][j], 300)));
                else enemyGrid.add(new JLabel(Main.ImageToAdd('-', 300)));
            }
        }
        
        //button events
        sendBtn.addActionListener(e -> userClickedAttack());
        surrenderBtn.addActionListener(e -> userSurrender());

        //components arent added until after 2 seconds (when the fadeout transition ends) 
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
            panel.add(enemyAmmoGrid);
            panel.add(bgLbl);
            bgLbl.setIcon(bgAnim);
            frame.setVisible(true);
        }, 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

        //these arent in the timer since these display the actual fadeout animation
        frame.add(panel);
        panel.add(bgLbl);

        frame.setVisible(true);
    }
    public static void updateAmmoGrid() //reloads the ammo grid with new information (called every turn)
    {
        //reset so that theres not double elements
        ammoGrid.removeAll();
        for (int i = 0; i < Main.player.ammoCount; i++) //for number of ammo, add ammo available image
        {
            Image curr = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoActive.png").getImage().getScaledInstance(62, 62, 0);
            ammoGrid.add(new JLabel(new ImageIcon(curr)));
        }
        for (int i = 0; i < Main.player.timesFired; i++) //for number of ammo used, add ammo used image
        {
            Image curr = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoUsed.png").getImage().getScaledInstance(62, 62, 0);
            ammoGrid.add(new JLabel(new ImageIcon(curr)));
        }
    }
    public static void updateEnemAmmoGrid() //same as updateAmmoGrid (only called in pvp mode)
    {
        enemyAmmoGrid.removeAll();
        for (int i = 0; i < Main.player.ammoCount; i++)
        {
            Image curr = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoActive.png").getImage().getScaledInstance(62, 62, 0);
            enemyAmmoGrid.add(new JLabel(new ImageIcon(curr)));
        }
        for (int i = 0; i < Main.player.timesFired; i++)
        {
            Image curr = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipAmmoUsed.png").getImage().getScaledInstance(62, 62, 0);
            enemyAmmoGrid.add(new JLabel(new ImageIcon(curr)));
        }
    }
    public static void userSurrender() //called when user clicks surrender button
    {
        //popup with yes or no, if yes clicked, display end frame
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to surrender?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (ans == JOptionPane.YES_OPTION) 
        {
            Main.player.ammoCount = 0;
            EndingScreen.DisplayFrame();
        }
    }
    public static void userClickedAttack() //called when user clicks attack button
    {
        if (xCordTxt.getText() != "" && yCordTxt.getText() != "") //check if cords arent empty
        {
            if (GameRules.playerCanAttack && !isEnemyTurn) //this condition looks confusing but let me explain
            {
                //the first variable makes it so that they cant attack during the entire duration of other phase
                //the second variable acts as a cooldown between the turns:
                //its so that the player wont be able to attack right after the other players sends an attack
                if ((Integer.parseInt(xCordTxt.getText()) <= Main.player.map.length && Integer.parseInt(xCordTxt.getText()) > 0) && (Integer.parseInt(yCordTxt.getText()) <= Main.player.map.length && Integer.parseInt(yCordTxt.getText()) > 0))
                {
                    //this condition is long but its just check if the coordinate is a valid one (not outside of array bounds)
                    Main.userSendsAttack(xCordTxt.getText(), yCordTxt.getText());
                }
                else JOptionPane.showMessageDialog(null, new JLabel("Invalid coordinates!"));
            }
            else if (!GameRules.playerCanAttack && isEnemyTurn)
            {
                if ((Integer.parseInt(xCordTxt.getText()) <= Main.player.map.length && Integer.parseInt(xCordTxt.getText()) > 0) && (Integer.parseInt(yCordTxt.getText()) <= Main.player.map.length && Integer.parseInt(yCordTxt.getText()) > 0))
                {
                    if (GameRules.difficulty == GameRules.AIDifficulty.pvp) Main.enemySendsAttack(xCordTxt.getText(), yCordTxt.getText()); //called only in pvp
                }
                else JOptionPane.showMessageDialog(null, new JLabel("Invalid coordinates!"));
            }
            else JOptionPane.showMessageDialog(null, new JLabel("Its not your turn yet!")); //called only in non-pvp
        }
        else JOptionPane.showMessageDialog(null, new JLabel("You have to enter coordinates!")); //called when cords are empty
    }
    public static void enemyTurn() //called when enemy turn starts ONLY in pvp mode
    {
        //check if user has enemy map visibility disabled (in this case the enemy of enemy is the player)
        //it refreshes the grid with the enemys map and the players hidden map
        //this function assumes 2 people are playing together locally, which is why I added this feature
        if (!GameRules.enemyMapVisible)
        {
            playerGrid.removeAll();
            enemyGrid.removeAll();
            for (int i = 0; i < Main.player.map.length; i++)
            {
                for (int j = 0; j < Main.player.map.length; j++)
                {
                    playerGrid.add(new JLabel(Main.ImageToAdd(Main.player.hiddenMap[i][j], 300)));
                    enemyGrid.add(new JLabel(Main.ImageToAdd(Main.enemy.map[i][j], 300)));
                }
            }
            frame.revalidate();
            frame.repaint();
        }
        isEnemyTurn = true;
    }
    public static void userTurn() //same thing as with enemyTurn but on the players side
    {
        if (!GameRules.enemyMapVisible)
        {
            playerGrid.removeAll();
            enemyGrid.removeAll();
            for (int i = 0; i < Main.player.map.length; i++)
            {
                for (int j = 0; j < Main.player.map.length; j++)
                {
                    playerGrid.add(new JLabel(Main.ImageToAdd(Main.player.map[i][j], 300)));
                    enemyGrid.add(new JLabel(Main.ImageToAdd(Main.enemy.hiddenMap[i][j], 300)));
                }
            }
            frame.revalidate();
            frame.repaint();
        }
        isEnemyTurn = false;
    }
    public static void userTurnStarted() //animation handler for player turn (the animation top of the screen)
    {
        TransitionAnim.showFrame("player");
    }
    public static void enemyTurnStarted() //animation handler for enemy turn (the animation top of the screen)
    {
        TransitionAnim.showFrame("enemy");
    }
    public static void displayPlayerMap() //displays player map on grid
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
