/* Nigel Garcia
 * May 25 2025
 * GameRules
 * just a bunch of global variables to help manage game settings
 */

public class GameRules {
    public static AIDifficulty difficulty;
    public static AttackType atkType;
    public static boolean enemyMapVisible = false;
    public enum AIDifficulty
    {
        Easy,
        medium,
        impossible,
        pvp
    }
    public enum AttackType
    {
        singleSegment,
        fullShip
    }
}
