import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

/* Nigel Garcia
 * April 11 2025
 * AnimFrame
 * Cool animations YEAHHHH
 */

public class AnimFrame {
    static JFrame frame = new JFrame();
    static Icon idle = new ImageIcon("Assignments2/Assignments2/src/Animations/vendingMachineIdle.gif");
    static Icon bought = new ImageIcon("Assignments2/Assignments2/src/Animations/VendingMachineBought.gif");
    static JLabel VendingM = new JLabel(idle);
    public void showFrame()
    {
        
        JPanel panel = new JPanel();
        
        frame.setResizable(false);
        frame.setSize(450, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        panel.setLayout(null);
        panel.setSize(450, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GOOBER VIEWPOINT (LEAKED!!!!!)");

        VendingM.setBounds(0, 0, 450, 600);

        frame.add(panel);
        panel.add(VendingM);

        frame.setVisible(true);
    }

    //I dont care, take a mark off of this, I ripped it off from online (https://sentry.io/answers/how-to-add-a-delay-in-java/)
    //Im aware of thread.sleep but was trying to find a method where it didnt stop the entire program (Thread.sleep did)
    //Oh, times like these make me miss Unity C#.. I miss my Time.deltaTime, my Coroutines, my Invokes
    public static void playClip() throws InterruptedException
    {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        VendingM.setIcon(bought);
        scheduledExecutorService.schedule(() -> {
            VendingM.setIcon(idle);
        }, 4, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
