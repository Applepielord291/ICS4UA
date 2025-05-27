import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* Nigel Garcia
 * May 23 2025
 * EnemyAI
 * Script that handles the behaviour for the computer in battleship
 */

public class EnemyAI {
    static String result = "Missed!";
    public static void enemyTurn(PlayerStats player, PlayerStats enem)
    {
        result = "Missed!";
        int xPoint = 0;
        int yPoint = 0;
        if (GameRules.difficulty == GameRules.AIDifficulty.Easy)
        {
            xPoint = (int)Math.floor(Math.random() * player.map.length);
            yPoint = (int)Math.floor(Math.random() * player.map.length);
        }
        else if (GameRules.difficulty == GameRules.AIDifficulty.impossible)
        {
            for (int i = 0; i < player.map.length; i++)
            {
                for (int j = 0; j < player.map.length; j++)
                {
                    if (player.map[i][j] != '-') 
                    {
                        xPoint = i+1;
                        yPoint = j+1;
                        break;
                    }
                }
            }
        }
        
        if (player.map[xPoint][yPoint] != '-' && enem.ammoCount > 0)
        {
            if (GameRules.atkType == GameRules.AttackType.fullShip) Main.DestroyEntireShip(player.map[xPoint][yPoint], true);
            player.map[xPoint][yPoint] = '-';
            enem.timesHit += 1;
            result = "Hit!";
        }
        else if (player.map[xPoint][yPoint] == '-') enem.timesMissed += 1;
        enem.ammoCount -= 1;
        enem.timesFired += 1;
        //call functio do edit history

        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1);
            //add attack animation here
            scheduledExecutorService2.schedule(() -> {
            //attack animation here (hit or miss depending on String result value)
            
        }, 1, TimeUnit.SECONDS);
        scheduledExecutorService2.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            //add attack animation here
            scheduledExecutorService.schedule(() -> {
            
            Main.MoveHistory("Enemy", result);
            MainFrame.displayPlayerMap();
            MainFrame.frame.revalidate();
            MainFrame.frame.repaint();
            boolean didGameEnd = Main.GameEnd(true);
            if (didGameEnd) 
            {
                EndingScreen.DisplayFrame();
            }
            MainFrame.userTurnStarted();
        }, 3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
