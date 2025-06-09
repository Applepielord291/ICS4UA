/* 
 * May 25 2025
 * GameRules
 * just a bunch of global variables to help manage game settings
 */

public class GameRules {
    public static AIDifficulty difficulty;
    public static AttackType atkType;
    public static boolean enemyMapVisible = false;
    public static boolean playerCanAttack = true;  
    //manages AI difficulty settings
    public enum AIDifficulty
    {
        Easy,
        impossible,
        pvp
    }
    //manages attack type settings
    public enum AttackType
    {
        singleSegment,
        fullShip
    }
    //resets values so that program isnt screwed up when user goes back to selection after playing a game
    public static void resetValues()
    {
        enemyMapVisible = false;
        playerCanAttack = true;
    }
}
