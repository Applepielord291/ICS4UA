/* 
 * May 23 2025
 * PlayerStats
 * Container class for each player
 */

public class PlayerStats 
{
    public int ammoCount; 
    public char[][] map; //map that displays ships and where the enemy has attacked
    public char[][] hiddenMap; //map that DOES NOT display ships but displays where the enemy has attacked (only used when user disable enemy map visibility)
    public int timesFired;
    public int timesMissed;
}
