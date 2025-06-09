import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/* 
 * May 27 2025
 * Transition Anim
 * frame movement looks cool, cool transition (used only in main frame, it is a transition animation between player and enemy turns but fancy)
 */

public class TransitionAnim {
    //variables declared in class to be accessed by all functions
    static int time = 0; //frame position tracker
    static boolean reachedMiddle = false;
    public static void showFrame(String whichTurn) //Called when either a player or enemy turn begins (as indicated by parameter)
    {
        //okay, so for this chunk of code,i need to redeclare the variables and reload the frame again
        //if I dont do this, the frame and its components dosent load properly if the user decides that they want to play another round
        //I know for sure theres a better way to do this, but the entire program is already a mess anyway.
        time = 0; 
        reachedMiddle = false;

        ImageIcon pTurn = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipPlayerTurn.gif");
        ImageIcon eTurn = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipEnemyTurn.gif");

        //component declaration
        //seperated by empty lines for some organization
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JLabel bgLbl = new JLabel();

        //hide frame border
        frame.setUndecorated(true);

        //checks whos turn it is (from parameter)
        //displays player turn animation or enemy turn animation based on parameter
        if (whichTurn.equals("player")) bgLbl = new JLabel(pTurn);
        else bgLbl = new JLabel(eTurn);

        //frame essentials
        frame.setResizable(false);
        frame.setSize(375, 92);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(375, 92);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("");

        //setting component position
        bgLbl.setBounds(0, 0, 375, 92);

        //add to frame
        frame.add(panel);
        panel.add(bgLbl);

        frame.setVisible(true);

        //sets frame location on user screen space (in this case, on left side)
        frame.setLocation(0, 50);

        //while frame not in middle, frame smoothly moves right until it reaches middle value (x = 775)
        while (!reachedMiddle)
        {
            time+=1;
            frame.setLocation(time, 100);
            if (time == 775) 
            {
                reachedMiddle = true;
            }
        }
        
        //if reached middle, wait 2 seconds, then continue smoothly moving right
        //if reached other side of the users screen, dispose the frame
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(() -> {
            while (reachedMiddle)
            {
                time+=1;
                frame.setLocation(time, 100);
                if (time == 1920) 
                {
                    frame.removeAll();
                    frame.setVisible(false);
                    reachedMiddle = false;
                }
            }
        }, 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
