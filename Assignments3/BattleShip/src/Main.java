import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.File;
import java.io.FileReader;

/* Nigel Garcia
 * May 23 2025
 * Main
 * The main script for the program, run it in here.
 */

/* As always, a timeline will be included at the bottom of this script. */

public class Main {
    public static char[][] map = new char[0][0];

    public static PlayerStats player = new PlayerStats();
    public static PlayerStats enemy = new PlayerStats();

    //ship Objects
    public static ShipType Frigate = new ShipType(); 
    public static ShipType attackBoat = new ShipType();
    public static ShipType dinghy = new ShipType();
    public static ShipType dreadNaught = new ShipType();
    public static ShipType subMarine = new ShipType();

    //stores turn history
    public static File moveHistoryFile = null;
    public static void main(String[] args) throws Exception 
    {
        //Assigning values for each ship object
        Frigate.length = 3;
        Frigate.shipVisual = 'F';
        Frigate.shipOnMap = false;

        attackBoat.length = 2;
        attackBoat.shipVisual = 'A';
        attackBoat.shipOnMap = false;

        dinghy.length = 1;
        dinghy.shipVisual = 'D';
        dinghy.shipOnMap = false;

        dreadNaught.length = 5;
        dreadNaught.shipVisual = 'N';
        dreadNaught.shipOnMap = false;

        subMarine.length = 4;
        subMarine.shipVisual = 'S';
        subMarine.shipOnMap = false;

        player.timesFired = 0;
        player.timesHit = 0;
        player.timesMissed = 0;

        //display title screen
        OpeningFrame.ShowFrame();
    }
    public static void mapSizeSet(int size)
    {
        //this function is called when the user sets a size in SelectionFrame
        player.map = new char[size][size];
        enemy.map = new char[size][size];
        //upperLimit is used to manage how many ships there will be on the map (upperLimit changes depending on map size)
        int upperLimit = 2; 
        //changes both ammoCount and upperLimit depending on mapSize
        if (size >= 5 && size < 8) 
        {
            player.ammoCount = 10;
            enemy.ammoCount = 10;
            upperLimit = 2;
        }
        else if (size >= 8 && size < 10)
        {
            player.ammoCount = 15;
            enemy.ammoCount = 15;
            upperLimit = 3;
        }
        else if (size >= 10)
        {
            player.ammoCount = 25;
            enemy.ammoCount = 25;
            upperLimit = 4;
        }

        //fills the entire player/enemy map with empty spaces
        for (int i = 0; i < player.map.length; i++)
        {
            for (int j = 0; j < player.map.length; j++)
            {
                player.map[i][j] = '-';
            }
        }
        enemy.map = new char[size][size];
        for (int i = 0; i < enemy.map.length; i++)
        {
            for (int j = 0; j < enemy.map.length; j++)
            {
                enemy.map[i][j] = '-';
            }
        }

        //array to give functionality to the upperLimit value
        ShipType[] currentType = {Frigate, attackBoat, dinghy, dreadNaught, subMarine};
        player.map = GenerateRandomPoint(size, player.map, currentType[0], currentType, 0, upperLimit);
        enemy.map = GenerateRandomPoint(size, enemy.map, currentType[0], currentType, 0, upperLimit);
        
        createMapFile(player.map, new File("BattleShip/src/playerMap.txt"));
        createMapFile(enemy.map, new File("BattleShip/src/enemyMap.txt"));

        //adds the ships to the array as ImageIcons
        for (int i = 0; i < player.map.length; i++)
        {
            for (int j = 0; j < player.map.length; j++)
            {
                SelectionFrame.playerGrid.add(new JLabel(ImageToAdd(player.map[i][j])));
            }
        }
        for (int i = 0; i < enemy.map.length; i++)
        {
            for (int j = 0; j < enemy.map.length; j++)
            {
                SelectionFrame.enemyGrid.add(new JLabel(ImageToAdd(enemy.map[i][j])));
            }
        }
        
    }
    public static ImageIcon ImageToAdd(char visual)
    {
        //each char has their own respective ImageIcon
        //used image Icons to make the program look cooler.
        if (visual == '-') 
        {
            Image curr = new ImageIcon("BattleShip/Graphics/MapVisuals/BattleShipEmpty.png").getImage().getScaledInstance(300/player.map.length, 300/player.map.length, 0);
            return new ImageIcon(curr);
        }
        else if (visual == Frigate.shipVisual) 
        {
            Image curr = new ImageIcon("BattleShip/Graphics/MapVisuals/BattleShipFrigate.png").getImage().getScaledInstance(300/player.map.length, 300/player.map.length, 0);
            return new ImageIcon(curr);
        }
        else if (visual == attackBoat.shipVisual) 
        {
            Image curr = new ImageIcon("BattleShip/Graphics/MapVisuals/BattleShipAttackBoat.png").getImage().getScaledInstance(300/player.map.length, 300/player.map.length, 0);
            return new ImageIcon(curr);
        }
        else if (visual == dinghy.shipVisual) 
        {
            Image curr = new ImageIcon("BattleShip/Graphics/MapVisuals/BattleShipDinghy.png").getImage().getScaledInstance(300/player.map.length, 300/player.map.length, 0);
            return new ImageIcon(curr);
        }
        else if (visual == dreadNaught.shipVisual) 
        {
            Image curr = new ImageIcon("BattleShip/Graphics/MapVisuals/BattleShipDreadnaught.png").getImage().getScaledInstance(300/player.map.length, 300/player.map.length, 0);
            return new ImageIcon(curr);
        }
        else if (visual == subMarine.shipVisual) 
        {
            Image curr = new ImageIcon("BattleShip/Graphics/MapVisuals/BattleShipSub.png").getImage().getScaledInstance(300/player.map.length, 300/player.map.length, 0);
            return new ImageIcon(curr);
        }
        else
        {
            //TODO add error popup here
            return null;
        }
    }
    public static char[][] GenerateRandomPoint(int size, char[][] map, ShipType curr, ShipType[] shipList, int current, int upperLimit) 
    {
        //generates rotation (vertical or horizontal)
        //generates a random point (inside the bounds of the array)
        //depending on rotation, keeps looping either left or down, placing the ship graphic until it reaches the ship length
        //if theres any obstacle (loop runs into a ship or reaches the end of the array) delete the CURRENT boat and recall the function again (recursive)
        int rndX = (int)Math.round(Math.random() * (map.length-1));
        int rndY = (int)Math.round(Math.random() * (map.length-1));
        int[] res = {rndX, rndY};
        int rotation = (int)Math.round(Math.random() * (1));
        for (int i = res[0]; i < res[0] + curr.length; i++)
        {
            if (i >= map.length) 
            {
                for (int k = 0; k < map.length; k++)
                {
                    for (int l = 0; l < map.length; l++)
                    {
                        if (map[k][l] == curr.shipVisual) map[k][l] = '-';
                    }
                }
                return GenerateRandomPoint(size, map, curr, shipList, current, upperLimit);
            }
            if (rotation == 0)
            {
                if ((res[0] > map.length || res[0] < 0) || (map[res[1]][i] != '-')) 
                {
                    for (int k = 0; k < map.length; k++)
                    {
                        for (int l = 0; l < map.length; l++)
                        {
                            if (map[k][l] == curr.shipVisual) map[k][l] = '-';
                        }
                    }
                    return GenerateRandomPoint(size, map, curr, shipList, current, upperLimit);
                }
                else
                {
                    map[res[1]][i] = curr.shipVisual;
                }
            }
            if (rotation == 1)
            {
                if ((res[0] > map.length || res[0] < 0) || (map[i][res[1]] != '-')) 
                {
                    for (int k = 0; k < map.length; k++)
                    {
                        for (int l = 0; l < map.length; l++)
                        {
                            if (map[k][l] == curr.shipVisual) map[k][l] = '-';
                        }
                    }
                    return GenerateRandomPoint(size, map, curr, shipList, current, upperLimit);
                }
                else
                {
                    map[i][res[1]] = curr.shipVisual;
                }
            }
        }
        if (current < upperLimit) 
        {
            current += 1;
            return GenerateRandomPoint(size, map, shipList[current], shipList, current, upperLimit);
        }
        else 
        {
            return map;
        }
    }
    public static void userSendsAttack(String xCord, String yCord)
    {
        //Function called upon when the user clicks the attack button after entering an x and y coordinate on the MainFrame
        if (!xCord.equals("") && !yCord.equals("") && player.ammoCount > 0)
        {
            //string value used for the move history file
            String hitOrMiss = "Miss!";
            int x = Integer.parseInt(xCord)-1; int y = Integer.parseInt(yCord)-1;
            if (enemy.map[y][x] != '-') 
            {
                hitOrMiss = "Hit!";
                if (GameRules.atkType == GameRules.AttackType.fullShip) DestroyEntireShip(enemy.map[y][x], false);
                enemy.map[y][x] = '-';
            }

            //refreshes the map grid
            MainFrame.enemyGrid.removeAll();
            try (BufferedReader br = new BufferedReader(new FileReader("BattleShip/src/enemyMap.txt")))
            {
                createMapFile(enemy.map, new File("BattleShip/src/enemyMap.txt"));
                for (int i = 0; i < enemy.map.length; i++)
                {
                    for (int j = 0; j < enemy.map.length; j++)
                    {
                        MainFrame.enemyGrid.add(new JLabel(ImageToAdd(enemy.map[i][j])));
                    }
                }
            }
            catch (Exception e)
            {
                //TODO add error popup here
            }

            MoveHistory("Player", hitOrMiss);
            player.ammoCount -= 1;
            MainFrame.ammoLeftTxt.setText(player.ammoCount + "");

            //attack animation plays 1 second after user enters their attack
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.schedule(() -> {
                //attack animation here
                
            }, 1, TimeUnit.SECONDS);
            scheduledExecutorService.shutdown();

            //switches to enemy turn 3 seconds after the user sends their attack
            //dont forget to disable player attacking after those 3 seconds
            ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1);
            //add attack animation here
            scheduledExecutorService2.schedule(() -> {
                boolean didGameEnd = GameEnd(false);
                if (!didGameEnd) 
                {
                    MainFrame.enemyTurnStarted();
                    EnemyAI.enemyTurn(player, enemy);
                }
                else 
                {
                    EndingScreen.DisplayFrame();
                }
            }, 3, TimeUnit.SECONDS);
            scheduledExecutorService2.shutdown();
        }
    }
    public static void DestroyEntireShip(char key, boolean isPlayer)
    {
        //determines what ship was hit and takes the boat length value
        //boat length value is taken so that the algorithm can remove the enite ship (loop through each segment of the ship to destroy)
        int shipLength = 0;
        if (key == Frigate.shipVisual) shipLength = Frigate.length;
        else if (key == attackBoat.shipVisual) shipLength = attackBoat.length;
        else if (key == dinghy.shipVisual) shipLength = dinghy.length;
        else if (key == dreadNaught.shipVisual) shipLength = dreadNaught.length;
        else if (key == subMarine.shipVisual) shipLength = subMarine.length;

        //Decided to use Linear search when destrouing the rest of the ship
        //binary search would be way too complicated for this situation since it would rewuire sorting then unsorting the map
        if (isPlayer)
        {
            for (int i = 0; i < player.map.length; i++)
            {
                for (int j = 0; j < player.map.length; j++)
                {
                    if (player.map[i][j] == key)
                    {
                        player.map[i][j] = '-';
                        shipLength -= 1;
                    }
                    if (shipLength == 0) break;
                }
            }
        }
        else
        {
            for (int i = 0; i < enemy.map.length; i++)
            {
                for (int j = 0; j < enemy.map.length; j++)
                {
                    if (enemy.map[i][j] == key)
                    {
                        enemy.map[i][j] = '-';
                        shipLength -= 1;
                    }
                    if (shipLength == 0) break;
                }
            }
        }
    }

    public static boolean GameEnd(boolean isPlayer)
    {
        //uses linear search to check if the game ended
        if (isPlayer)
        {
            if (player.ammoCount == 0) return true;
            for (int i = 0; i < player.map.length; i++)
            {
                for (int j = 0; j < player.map.length; j++)
                {
                    if (player.map[i][j] != '-') return false;
                }
            }
            return true;
        }
        else
        {
            if (player.ammoCount == 0) return true;
            for (int i = 0; i < enemy.map.length; i++)
            {
                for (int j = 0; j < enemy.map.length; j++)
                {
                    if (enemy.map[i][j] != '-') return false;
                }
            }
            return true;
        }
    }

    public static void createMapFile(char[][] map, File file)
    {
        //redundant function, dont forget to remove it later
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map.length; j++)
                {
                    bw.write(map[i][j] + " ");
                }
                bw.write("\n");
            }
        }
        catch(IOException e)
        {
            //TODO add error popup here
        }
    }

    public static void MoveHistory(String player, String hitOrMiss)
    {
        //stores each turn result onto a text file
        if (moveHistoryFile == null)
        {
            moveHistoryFile = new File("BattleShip/src/MoveHistory.txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(moveHistoryFile)))
            {
                bw.write(player + " " + hitOrMiss + "\n");
                bw.close();
            }
            catch (Exception e)
            {
                //TODO add error popup here
            }
        }
        else
        {
            try (FileWriter fw = new FileWriter(moveHistoryFile, true))
            {
                fw.write(player + " " + hitOrMiss + "\n");
            }
            catch (Exception e)
            {
                //TODO add error popup here
            }
        }

        //displays the file onto a JTextPane for the user to see on the MainFrame
        try {
            MainFrame.moveHistoryTxt.read(new BufferedReader(new FileReader("BattleShip/src/MoveHistory.txt")), null);
        } catch (Exception e) {
            //TODO add error popup here
        }
    }
}

/* TODO TIMELINE:
 * Main goal: Finish core functionality before the end of today. When creating games, the top priority is to make sure it runs. Add all the fancy mechanics and visuals later.
 *      An important thing I learned is that people prefer games that are simple yet polished instead of gimmicky yet unpolished.
 * 
 * (Day 1: May 23, 2025)
 *  - Created MainFrame, Main, EnemyAI, ShipType, OpeningFrame, and SelectionFrame. (11:16AM)
 *  - Added the 5 ShipTypes (Frigate, attackBoat, dinghy, dreadNaught, subMarine) as objects (11:29AM)
 *  - Added Functionality to OpeningFrame and started working on SelectionFrame (11:40AM)
 *  - Added custom map size input in the SelectionFrame (11:43AM)
 *  - Added transition from SelectionFrame to MainFrame (11:46AM)
 *  - Added Instance Objects of the PlayerStats container class (11:47AM)
 *  - Added playerMap and enemyMap into the MainFrame (11:56AM)
 * (Taking a break until Religion class...)
 *  - Currently workng on the map generation (2:07PM)
 *  - HOLEEEY HELLL THE RANDOM SHIP GENERATION ALMOST WORKS??? HUHH (5:20PM)
 *  - finally working almost perfectly but I think ships keep overlapping for some reason so gotta fix that (the only problem left) (5:26PM)
 *         The 2 main problems
 *              - sometimes ships generate on top of each other, which dosent make any sense since I have a condition to only generate when the required points are empty
 *              - ships are shorter due to trying to generate outside of the array, this problem makes sense to me just tryna figure how to fix both
 *  - well now i fixed the overlapping but for some reason N ship likes to generate more than 5 segments? (6:18PM)
 *  - fixed boat mitosis, the only problem left are boats extending outside the array (6:37PM)
 *  - although very, VERY inefficient, the ship generator finally works perfectly!!! (8:02PM)
 *  BREAK
 *  - both the players maps and the enemy maps now display onto the selection frame and mainframe(10:47PM)
 * 
 * (Day 2: May 24, 2025)
 *  - Can now attack and take down ship segments, but havent added the part where the entire boat gets taken down yet (10:39AM)
 *  - added a move history file, players can see the past moves during the game, and can tell if their move is a hit or miss (11:08AM)
 *  - added ammo system (11:41AM)
 *  - number of ships and ammo now vary depending on map size (11:44PM)
 *  - Added tracker for how many times player fired weapon,how many times player missed, how many times player hit (11:52AM)
 *  - Did Title Screen visual (12:44PM)
 *  - Added enemyAI (1:50PM)
 *  - added background from opening screen to selection screen and rearranged elements around mainFrame (3:10PM)
 *  - program now checks if game ended after each turn (3:42PM)
 *  - no longer using a JTextArea for the map anymore, now its a grid and looks way better (4:26PM)
 *  - added endingScreen script (4:41PM)
 *  - player and enemy stats now display on ending screen (5:39PM)
 *  - When any part of the ship is hit, the rest of the ship sinks, its been done! (6:19PM)
 * 
 * And with that, I finished all the requirements (level 3 and level4++), so technically, I could submit it now, but just like last time, im adding more garbage.
 * 
 * (Day 3: May 25, 2025)
 *  - created the gameRules script to store global variables (11:03AM)
 *  - created fadeIn/out transition between frames (11:59AM)
 *  - Making the UI look better (creates some of the button and label visuals) (3:06PM)
 *  - made the map look better: the boats and empty spaces are actually pictures now instead of characters! (3:55PM)
 *  - ok so theres an image scaling problem for the grid and I have no Idea how to go about fixing it so ill fix it later (4:54PM)
 *  - yeah... pretty much this entire day was dedicated to designing UI elements and rearranging the components in each frame (8:08PM - end of day)
 * 
 * (Day 4: May 26, 2025)
 *  - Started adding functionality to various buttons in the SelectionFrame (12:43AM)
 *  - Started working on MainFrame UI (8:22AM)
 *  - Fixed Grid image scaling issues (10:45AM)
 *  - Making program more bullet proof (11:35AM)
 * 
 *  Things to add:
 *      - Choice between AI or PVP
 *      - Heavy rework to ending screen (display both resulting maps and add a quit btn and animation)
 *      - rework win conditions (If player 1 took down more ships than player 2, player 1 wins, if both took down even amount of ships, its a draw)
 *      - add better visuals to MainFrame and ending frame
 *      - transition between turns (think fire emblem)
 *      - attack animations (think Fire emblem GBA series)
 *      - metaprogression (add ranked points for fun)
 *      - Main thing to do is to clean up the code (So much redundant garbage)
 *  Enemy AI Plan:
 *      - easy difficulty has the AI completely random point generation (already implemented)
 *      - medium difficulty (hardest one to implement) has random point generation, but when the point is a ship, the AI goes into the searching state
 *          - when in the searching state, the ai will look for other possible segments that are connected to that key point, and will loop x times. (x depends on boat length)
 *      - Hard difficulty will have the AI search for the ship chars (using linear search), this one is impossible to beat.
 * 
 *  Theres a lot of time still left on this assignment, so after that, I could add sounds and music, then playtest it a bunch
 * 
 *  (Day 5: may 27, 2025)
 *      - added choice between single segment destruction or full ship destruction (12:16AM)
 *      - added animation transition between player and enemy turns (1:47AM)
 *      - added the script TransitionAnim, the frame now moves (9:39AM)
 *      - FInally fixed the problem where the program would crash everytime the TransitionAnim is re-instantiated (11:25AM)
 */
