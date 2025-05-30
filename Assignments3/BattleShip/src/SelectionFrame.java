import java.awt.GridLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/* Nigel Garcia
 * May 23 2025
 * Selection Frame
 * This takes place after the opening frame, where the user has to select game rules and check maps.
 */

public class SelectionFrame {
    public static JTextPane MapSize = new JTextPane();
    
    public static JPanel playerGrid = new JPanel();
    public static JPanel enemyGrid = new JPanel();
    
    public static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();

    public static ImageIcon bgAnim = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipTitleScreen.gif");
    static ImageIcon titleFadeIn = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipTitleFade.gif");
    static ImageIcon titleFadeOut = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipTitleFadeOut.gif");
    static ImageIcon enemyMapTitleIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/BattleShipEnemyPreview.png");
    public static JLabel bgLbl = new JLabel(bgAnim); //used to display background graphic

    static JButton cheatBtn = new JButton("Display Enemy Map");
    static JButton unCheatBtn = new JButton("Hide Enemy Map");

    static JLabel enemyMapPreviewLbl = new JLabel(enemyMapTitleIcon);

    static ImageIcon easySelectIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\EasySelected.png");
    static ImageIcon easyUnselectIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\EasyUnselected.png");
    static ImageIcon hardSelectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\HardSelected.png");
    static ImageIcon hardUnselectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\HardUnselected.png");
    static ImageIcon pvpSelectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\PvpSelected.png");
    static ImageIcon pvpUnselectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\PvpUnselected.png");
    static ImageIcon singleSelectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\SingleSegmentSelected.png");
    static ImageIcon singleUnselectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\SingleSegmentUnselected.png");
    static ImageIcon multipleSelectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\FullShipSinksSelected.png");
    static ImageIcon multipleUnselectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\FullShipSinksUnselected.png");

    static JButton easyBtn = new JButton(easySelectIcon);
    static JButton hardBtn = new JButton(hardUnselectedIcon);
    static JButton pvpBtn = new JButton(pvpUnselectedIcon);

    static JButton singleSegBtn = new JButton("Single Segment");
    static JButton fullShipBtn = new JButton("Full Ship Sinks");
    public static void ShowFrame()
    {
        GameRules.atkType = GameRules.AttackType.fullShip;
        GameRules.difficulty = GameRules.AIDifficulty.Easy;

        frame.removeAll();
        frame.revalidate();
        frame.repaint();
        GameRules.currF = GameRules.CurrentFrame.selectionScreen;

        //just testing something
        MapSize = new JTextPane();
        playerGrid = new JPanel();
        enemyGrid = new JPanel();
        frame = new JFrame();
        panel = new JPanel();
        bgAnim = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipTitleScreen.gif");
        titleFadeIn = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipTitleFade.gif");
        titleFadeOut = new ImageIcon("BattleShip/Graphics/TitleScreen/BattleShipTitleFadeOut.gif");
        enemyMapTitleIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/BattleShipEnemyPreview.png");
        bgLbl = new JLabel(bgAnim); //used to display background graphic
        cheatBtn = new JButton("Display Enemy Map");
        unCheatBtn = new JButton("Hide Enemy Map");
        enemyMapPreviewLbl = new JLabel(enemyMapTitleIcon);

        frame.setUndecorated(true);

        ImageIcon readyBtnIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/BattleShipReadyBtn.png");
        ImageIcon modIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/ModifyGameRulesLbl.png");
        ImageIcon mapIconTitle = new ImageIcon("BattleShip/Graphics/SelectionScreen/BattleShipMapSize.png");
        ImageIcon aiDifficultyIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/BattleShipAIDiff.png");
        ImageIcon playerMapTitleIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/BattleShipPlayerMapTitle.png");
        ImageIcon playerSettingsIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/BattleShipPlayerSettingsTitle.png");
        ImageIcon attackTypeIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/BattleShipAttackTypeLbl.png");
        ImageIcon setMapSizeIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/BattleShipSetSize.png");
        ImageIcon quitBtnIcon = new ImageIcon("BattleShip/Graphics/SelectionScreen/QuitBtn.png");

        easySelectIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\EasySelected.png");
        easyUnselectIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\EasyUnselected.png");
        hardSelectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\HardSelected.png");
        hardUnselectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\HardUnselected.png");
        pvpSelectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\PvpSelected.png");
        pvpUnselectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\PvpUnselected.png");

        singleSelectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\SingleSegmentSelected.png");
        singleUnselectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\SingleSegmentUnselected.png");
        multipleSelectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\FullShipSinksSelected.png");
        multipleUnselectedIcon = new ImageIcon("BattleShip\\Graphics\\SelectionScreen\\FullShipSinksUnselected.png");
        
        JButton confirmMapBtn = new JButton("Confirm");
        JButton readyBtn = new JButton(readyBtnIcon);
        
        easyBtn = new JButton(easySelectIcon);
        hardBtn = new JButton(hardUnselectedIcon);
        pvpBtn = new JButton(pvpUnselectedIcon);
        singleSegBtn = new JButton(singleUnselectedIcon);
        fullShipBtn = new JButton(multipleSelectedIcon);
        JButton quitBtn = new JButton(quitBtnIcon);

        JLabel modTitle = new JLabel(modIcon);
        JLabel mapSizeLbl = new JLabel(mapIconTitle);
        JLabel playerTitleLbl = new JLabel(playerSettingsIcon);
        JLabel attackTypeLbl = new JLabel(attackTypeIcon);
        JLabel mapPreviewLbl = new JLabel(playerMapTitleIcon);
        JLabel setMapSizeLbl = new JLabel(setMapSizeIcon);
        
        JLabel diffLbl = new JLabel(aiDifficultyIcon);

        MapSize.setAlignmentX(0);
        MapSize.setAlignmentY(0);
        MapSize.setFont(MapSize.getFont().deriveFont(14f));

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        bgLbl.setIcon(titleFadeOut);
        scheduledExecutorService.schedule(() -> {
            panel.remove(bgLbl); 

            panel.add(setMapSizeLbl);
            setMapSizeLbl.add(MapSize);
            panel.add(confirmMapBtn);
            panel.add(readyBtn);
            panel.add(mapSizeLbl);
            panel.add(cheatBtn);
            panel.add(playerTitleLbl);
            panel.add(mapPreviewLbl);
            panel.add(diffLbl);
            panel.add(easyBtn);
            panel.add(playerGrid);
            panel.add(attackTypeLbl);
            panel.add(singleSegBtn);
            panel.add(fullShipBtn);
            panel.add(quitBtn);
            panel.add(hardBtn);
            panel.add(pvpBtn);

            panel.add(bgLbl);
            bgLbl.setIcon(bgAnim);
        }, 3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

        frame.setResizable(false);
        frame.setSize(800, 450);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BattleShipSelect");

        bgLbl.setBounds(0, 0, 800, 450);

        setMapSizeLbl.setBounds(5, 80, 150, 37);
        MapSize.setBounds(95, 6, 35, 20);
        playerGrid.setBounds(575, 40, 150, 150);
        enemyGrid.setBounds(575, 240, 150, 150);
        
        confirmMapBtn.setBounds(160, 80, 95, 37);
        readyBtn.setBounds(285, 325, 200, 50);
        cheatBtn.setBounds(5, 125, 150, 25);
        unCheatBtn.setBounds(5, 125, 150, 25);
        easyBtn.setBounds(330, 100, 100, 25);
        hardBtn.setBounds(330, 130, 100, 25);
        pvpBtn.setBounds(330, 160, 100, 25);
        singleSegBtn.setBounds(50, 300, 150, 25);
        fullShipBtn.setBounds(50, 330, 150, 25);
        quitBtn.setBounds(323, 385, 125, 31);

        mapSizeLbl.setBounds(5, 10, 250, 65);
        modTitle.setBounds(260, 10, 250, 65);
        playerTitleLbl.setBounds(5, 200, 250, 65);
        mapPreviewLbl.setBounds(575, 10, 150, 25);
        diffLbl.setBounds(260, 10, 250, 65);
        enemyMapPreviewLbl.setBounds(575, 210, 150, 25);
        attackTypeLbl.setBounds(50, 270, 150, 25);

        confirmMapBtn.addActionListener(e -> userConfirmedSize());
        readyBtn.addActionListener(e -> userClickedReady());
        cheatBtn.addActionListener(e -> userViewEnemMap());
        easyBtn.addActionListener(e -> userClickedEasyBtn());
        singleSegBtn.addActionListener(e -> userClickedSingle());
        fullShipBtn.addActionListener(e -> userClickedFullSink());
        unCheatBtn.addActionListener(e -> userChangedWays());
        quitBtn.addActionListener(e -> userExit());
        hardBtn.addActionListener(e -> userClickedHard());
        pvpBtn.addActionListener(e -> userClickedPvp());

        frame.add(panel);

        panel.add(bgLbl);
        frame.setVisible(true);

        GameRules.enemyMapVisible = false;
    }
    public static void userClickedPvp()
    {
        GameRules.difficulty = GameRules.AIDifficulty.pvp;
        pvpBtn.setIcon(pvpSelectedIcon);
        easyBtn.setIcon(easyUnselectIcon);
        hardBtn.setIcon(hardUnselectedIcon);
    }
    public static void userClickedHard()
    {
        GameRules.difficulty = GameRules.AIDifficulty.impossible;
        pvpBtn.setIcon(pvpUnselectedIcon);
        easyBtn.setIcon(easyUnselectIcon);
        hardBtn.setIcon(hardSelectedIcon);
    }
    public static void userExit()
    {
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the application?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (ans == JOptionPane.YES_OPTION) 
        {
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            panel.removeAll();
            panel.add(bgLbl);
            bgLbl.setIcon(titleFadeIn);
            scheduledExecutorService.schedule(() -> {
                frame.dispose();
                System.exit(0);
            }, 3, TimeUnit.SECONDS);
            scheduledExecutorService.shutdown();
        }
        
    }
    public static void userChangedWays()
    {
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to hide the enemies map?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (ans == JOptionPane.YES_OPTION) 
        {
            GameRules.enemyMapVisible = false;
            panel.remove(bgLbl); //java is silly and the only way the thing T DW - THERES LAYERS yeha theres layers so this is the only way
            panel.remove(enemyGrid); 
            panel.remove(enemyMapPreviewLbl);
            panel.add(cheatBtn);
            panel.remove(unCheatBtn);
            panel.add(bgLbl);
            frame.revalidate();
            frame.repaint();
        }
    }
    public static void userClickedFullSink()
    {
        GameRules.atkType = GameRules.AttackType.fullShip;
        singleSegBtn.setIcon(singleUnselectedIcon);
        fullShipBtn.setIcon(multipleSelectedIcon);
    }
    public static void userClickedSingle()
    {
        GameRules.atkType = GameRules.AttackType.singleSegment;
        singleSegBtn.setIcon(singleSelectedIcon);
        fullShipBtn.setIcon(multipleUnselectedIcon);
    }
    public static void userClickedEasyBtn()
    {
        GameRules.difficulty = GameRules.AIDifficulty.Easy;
        pvpBtn.setIcon(pvpUnselectedIcon);
        easyBtn.setIcon(easySelectIcon);
        hardBtn.setIcon(hardUnselectedIcon);
    }
    public static void userConfirmedSize()
    {
        try
        {
            if (Integer.parseInt(MapSize.getText()) >= 5 && Integer.parseInt(MapSize.getText()) <= 10)
            {
                playerGrid.removeAll();
                enemyGrid.removeAll();
                Main.mapSizeSet(Integer.parseInt(MapSize.getText()));
                playerGrid.setLayout(new GridLayout(Main.player.map.length, Main.player.map.length));
                enemyGrid.setLayout(new GridLayout(Main.enemy.map.length, Main.enemy.map.length));
                
                panel.remove(bgLbl); 
                panel.add(bgLbl);
                frame.revalidate();
                frame.repaint();
            }
            else
            {
                JOptionPane.showMessageDialog(null, new JLabel("Map size can only be between 5-10"));
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, new JLabel("You must enter a map size value! (5 - 10)"));
        }
    }
    public static void userClickedReady()
    {
        
        try
        {
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            panel.removeAll();
            panel.add(bgLbl);
            bgLbl.setIcon(titleFadeIn);
            scheduledExecutorService.schedule(() -> {
                MainFrame.ShowFrame();
                frame.dispose();
            }, 3, TimeUnit.SECONDS);
            scheduledExecutorService.shutdown();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, new JLabel("You have to generate a map first!"));
        }
        
    }
    public static void userViewEnemMap()
    {
        //display popup to confirm, then display enemy map.
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to display the enemies map?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (ans == JOptionPane.YES_OPTION) 
        {
            GameRules.enemyMapVisible = true;
            panel.remove(bgLbl); 
            panel.add(enemyGrid); 
            panel.add(enemyMapPreviewLbl);
            panel.remove(cheatBtn);
            panel.add(unCheatBtn);
            panel.add(bgLbl);
            frame.revalidate();
            frame.repaint();
        }
    }
}
