import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/* Nigel Garcia
 * May 27 2025
 * Transition Anim
 * frame movement looks cool, cool transition
 */

public class TransitionAnim {
    static int time = 0;
    static boolean reachedMiddle = false;
    public static void showFrame(String whichTurn)
    {
        time = 0; 
        reachedMiddle = false;
        ImageIcon pTurn = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipPlayerTurn.gif");
        ImageIcon eTurn = new ImageIcon("BattleShip\\Graphics\\MainFrame\\BattleShipEnemyTurn.gif");
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel bgLbl = new JLabel();
        frame.setUndecorated(true);

        if (whichTurn.equals("player"))
        {
            bgLbl = new JLabel(pTurn);
        }
        else bgLbl = new JLabel(eTurn);

        frame.setResizable(false);
        frame.setSize(375, 92);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(375, 92);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("");

        bgLbl.setBounds(0, 0, 375, 92);

        frame.add(panel);
        panel.add(bgLbl);

        frame.setVisible(true);
        frame.setLocation(0, 50);

        while (!reachedMiddle)
        {
            time+=1;
            frame.setLocation(time, 100);
            if (time == 775) 
            {
                reachedMiddle = true;
            }
        }
        
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
