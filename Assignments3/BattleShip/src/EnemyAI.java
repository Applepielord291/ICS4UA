/* Nigel Garcia
 * May 23 2025
 * EnemyAI
 * Script that handles the behaviour for the computer in battleship
 */
import java.io.File;

import javax.swing.JLabel;

public class EnemyAI {
    public static void enemyTurn(PlayerStats player, PlayerStats enem)
    {
        String result = "Missed!";
        int xPoint = (int)Math.floor(Math.random() * player.map.length);
        int yPoint = (int)Math.floor(Math.random() * player.map.length);
        if (player.map[xPoint][yPoint] != '-' && enem.ammoCount > 0)
        {
            Main.DestroyEntireShip(player.map[xPoint][yPoint], true);
            player.map[xPoint][yPoint] = '-';
            enem.timesHit += 1;
            result = "Hit!";
        }
        else if (player.map[xPoint][yPoint] == '-') enem.timesMissed += 1;
        enem.ammoCount -= 1;
        enem.timesFired += 1;
        //call functio do edit history
        Main.MoveHistory("Enemy", result);
        MainFrame.playerGrid.removeAll();
        try 
        {
            Main.createMapFile(player.map, new File("BattleShip/src/playerMap.txt"));
            for (int i = 0; i < Main.player.map.length; i++)
            {
                for (int j = 0; j < Main.player.map.length; j++)
                {
                    MainFrame.playerGrid.add(new JLabel(Main.ImageToAdd(player.map[i][j])));
                }
            }
        }
        catch (Exception e)
        {
            //error popup window here
        }

        boolean didGameEnd = Main.GameEnd(true);
        if (didGameEnd) 
        {
            EndingScreen.DisplayFrame();
        }



        //make sure to add AI difficulties later if theres time
    }
}
