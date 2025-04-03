//Nigel Garcia
//submission

enum stateMachine {
    idle,
    phase1,
    phase2,
    phase3,
    phase4,
    phase5
}

class stats {
    public int enemyType = 2;
    public int health = 1000;
    public float attackDamage = 13.5f;
    public float moveSpeed = 8.5f;
    public boolean isAlive = true;
    public int attackCooldown = 3;
    public boolean hasAttacked = false;
}

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("");
    }
}
