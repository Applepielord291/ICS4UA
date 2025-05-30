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
                    if (player.map[i][j] != '-' && player.map[i][j] != 'x' && player.map[i][j] != 'X') 
                    {
                        xPoint = i;
                        yPoint = j;
                        break;
                    }
                }
            }
        }
        
        if (player.map[xPoint][yPoint] != '-' && player.map[xPoint][yPoint] != 'x' && player.map[xPoint][yPoint] != 'X' && enem.ammoCount > 0)
        {
            if (GameRules.atkType == GameRules.AttackType.fullShip) Main.DestroyEntireShip(player.map[xPoint][yPoint], true);
            player.map[xPoint][yPoint] = 'X';
            player.hiddenMap[xPoint][yPoint] = 'X';
            result = "Hit!";
        }
        else 
        {
            enem.timesMissed += 1;
            player.map[xPoint][yPoint] = 'x';
            player.hiddenMap[xPoint][yPoint] = 'x';
        }
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
            else
            {
                GameRules.playerCanAttack = true;
                MainFrame.userTurnStarted();
            }
        }, 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
