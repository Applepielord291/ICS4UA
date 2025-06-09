import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* 
 * May 23 2025
 * EnemyAI
 * Script that handles the behaviour for the computer in battleship
 */

public class EnemyAI {
    static String result = "Missed!";
    public static void enemyTurn(PlayerStats player, PlayerStats enem) //called after players turn if AI difficulty is not set to pvp
    {
        result = "Missed!";
        int xPoint = 0;
        int yPoint = 0;
        if (GameRules.difficulty == GameRules.AIDifficulty.Easy) //generates 2 random points
        {
            xPoint = (int)Math.floor(Math.random() * player.map.length);
            yPoint = (int)Math.floor(Math.random() * player.map.length);
        }
        else if (GameRules.difficulty == GameRules.AIDifficulty.impossible) //searches for a valid point using linear search
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
        
        if (player.map[xPoint][yPoint] != '-' && player.map[xPoint][yPoint] != 'x' && player.map[xPoint][yPoint] != 'X' && enem.ammoCount > 0) //checks if point is valid
        {
            //Destroy entire ship if attacktype is fullship
            if (GameRules.atkType == GameRules.AttackType.fullShip) Main.DestroyEntireShip(player.map[xPoint][yPoint], true);

            //place hit marker on the map and change result
            player.map[xPoint][yPoint] = 'X';
            player.hiddenMap[xPoint][yPoint] = 'X';
            result = "Hit!";
        }
        else 
        {
            //place miss marker
            enem.timesMissed += 1;
            player.map[xPoint][yPoint] = 'x';
            player.hiddenMap[xPoint][yPoint] = 'x';
        }
        enem.ammoCount -= 1;
        enem.timesFired += 1;

        //TODO redundant, delete later
        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1);
            scheduledExecutorService2.schedule(() -> {
            //attack animation here (hit or miss depending on String result value)
            
        }, 1, TimeUnit.SECONDS);
        scheduledExecutorService2.shutdown();

        //timer between turns
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            //add attack animation here
            scheduledExecutorService.schedule(() -> {
            
            //refresh frame to display new info, and checks if the game ended
            Main.MoveHistory("Enemy", result);
            MainFrame.displayPlayerMap();
            MainFrame.frame.revalidate();
            MainFrame.frame.repaint();
            boolean didGameEnd = Main.GameEnd(true);
            if (didGameEnd) //display ending frame
            {
                EndingScreen.DisplayFrame();
            }
            else //switch to player turn and display player turn animation
            {
                GameRules.playerCanAttack = true;
                MainFrame.userTurnStarted();
            }
        }, 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
