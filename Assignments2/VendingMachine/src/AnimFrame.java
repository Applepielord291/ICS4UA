import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/* Nigel Garcia
 * April 11 2025
 * AnimFrame
 * Cool animations YEAHHHH (creates a new window and plays cool animations)
 */

public class AnimFrame {
    //Variables that I need to access in other scripts
    static JFrame frame = new JFrame();
    static Icon idleAnim = new ImageIcon("VendingMachine/src/Animations/vendingMachineIdle.gif"); //Idle animation for vending machine
    static Icon boughtAnim = new ImageIcon("VendingMachine/src/Animations/VendingMachineBought.gif"); //Bought animation for vending machine
    static JLabel VendingLabel = new JLabel(idleAnim);

    //Setting up frame layout
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
        frame.setIconImage(new ImageIcon("VendingMachine/src/Images/ProgramIcon.png").getImage());

        VendingLabel.setBounds(0, 0, 450, 600);

        frame.add(panel);
        panel.add(VendingLabel);

        frame.setVisible(true);
    }

    //I ripped it off from online (https://sentry.io/answers/how-to-add-a-delay-in-java/)
    //Im aware of thread.sleep but was trying to find a method where it didnt stop the entire program (Therefore no Thread.sleep)
    //Oh, times like these make me miss Unity C#.. I miss my Time.deltaTime, my Coroutines, my Invokes
    //Oh yeah, this function is called when the user confirms a purchase, plays out the bought animation then goes back to idle anim.
    public static void playClip()
    {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        VendingLabel.setIcon(boughtAnim);
        scheduledExecutorService.schedule(() -> {
            VendingLabel.setIcon(idleAnim);
        }, 5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
