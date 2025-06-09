import java.awt.GridLayout;

import javax.swing.*;

/* 
 * May 24 2025
 * Ending Screen
 * Runs only after the game ends: game stats n stuff as well as the ability to quit 
 */

public class EndingScreen {
    //variables declared in class to be accessed by all functions
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    public static void DisplayFrame()
    {
        //reload frame so that everything displays
        frame.removeAll(); 
        frame.revalidate();
        frame.repaint();

        frame = new JFrame();
        panel = new JPanel();

        frame.setUndecorated(true);

        //component declaration
        //seperated by empty lines for some organization
        ImageIcon quitBtnIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\QuitBtn.png");
        ImageIcon playerStatIcon = new ImageIcon("BattleShip\\Graphics\\EndingFrame\\PlayerStatsIcon.png");
        ImageIcon enemyStatIcon = new ImageIcon("BattleShip\\Graphics\\EndingFrame\\EnemyStatsIcon.png");
        ImageIcon bgIcon = new ImageIcon("BattleShip\\Graphics\\EndingFrame\\EndingFrameBg.png");

        JLabel pTitle = new JLabel(playerStatIcon);
        JLabel eTitle = new JLabel(enemyStatIcon);
        JLabel timesFired = new JLabel("Times fired: " + Main.player.timesFired);
        JLabel timesMissed = new JLabel("Times missed: " + Main.player.timesMissed);
        JLabel bgLbl = new JLabel(bgIcon);
        JLabel whoWinsLbl = new JLabel("Game Result: " + whoWins());

        JButton quitBtn = new JButton(quitBtnIcon);

        JLabel timesFiredE = new JLabel("Times fired: " + Main.enemy.timesFired);
        JLabel timesMissedE = new JLabel("Times missed: " + Main.enemy.timesMissed);

        JPanel playerGrid = new JPanel();
        JPanel enemyGrid = new JPanel();

        //sets grid size by element number (using gridlayout so i dont have to manually set positions), so it can actually display images
        playerGrid.setLayout(new GridLayout(Main.player.map.length, Main.player.map.length));
        enemyGrid.setLayout(new GridLayout(Main.enemy.map.length, Main.enemy.map.length));

        //adds post-game maps onto the frame
        for (int i = 0; i < Main.player.map.length; i++)
        {
            for (int j = 0; j < Main.player.map.length; j++)
            {
                playerGrid.add(new JLabel(Main.ImageToAdd(Main.player.map[i][j], 150)));
                enemyGrid.add(new JLabel(Main.ImageToAdd(Main.enemy.map[i][j], 150)));
            }
        }

        //frame essentials
        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Post game");

        //setting component positions
        //seperated by empty lines for some organization
        pTitle.setBounds(20, 10, 150, 37);
        eTitle.setBounds(210, 10, 150, 37);
        timesFiredE.setBounds(210, 45, 150, 25);
        timesMissedE.setBounds(210, 60, 100, 25);
        timesFired.setBounds(20, 45, 150, 25);
        timesMissed.setBounds(20, 60, 150, 25);

        bgLbl.setBounds(0, 0, 400, 400);
        whoWinsLbl.setBounds(145, 100, 150, 45);

        quitBtn.setBounds(125, 350, 125, 31);

        playerGrid.setBounds(20, 175, 150, 150);
        enemyGrid.setBounds(210, 175, 150, 150);

        //button event
        quitBtn.addActionListener(e -> userClickedQuit());

        frame.add(panel);
        panel.add(pTitle);
        panel.add(eTitle);
        panel.add(timesFired);
        panel.add(timesMissed);
        panel.add(timesFiredE);
        panel.add(timesMissedE);
        panel.add(quitBtn);
        panel.add(playerGrid);
        panel.add(enemyGrid);
        panel.add(whoWinsLbl);
        panel.add(bgLbl);

        frame.setVisible(true);
    }
    public static void userClickedQuit() //called when user clicks the quit button, displays the quit menu
    {
        QuitMenu.showFrame(MainFrame.frame);
        frame.dispose();
    }
    public static String whoWins() //checks which side wins thendisplays it on the frame
    {
        if (Main.player.timesMissed < Main.enemy.timesMissed) return "Player Wins"; 
        else if (Main.player.timesMissed == Main.enemy.timesMissed) return "Tie";
        else return "Enemy Wins";
    }
}
