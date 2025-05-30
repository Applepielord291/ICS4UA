/* Nigel Garcia
 * May 25 2025
 * GameRules
 * just a bunch of global variables to help manage game settings
 */

public class GameRules {
    public static AIDifficulty difficulty;
    public static AttackType atkType;
    public static CurrentFrame currF;
    public static boolean enemyMapVisible = false;
    public static boolean playerCanAttack = true;
    public enum AIDifficulty
    {
        Easy,
        impossible,
        pvp
    }
    public enum AttackType
    {
        singleSegment,
        fullShip
    }
    public enum CurrentFrame
    {
        endScreen,
        selectionScreen,
        mainScreen
    }
    public static void resetValues()
    {
        enemyMapVisible = false;
        playerCanAttack = true;
    }
}
