//Nigel Garcia
//Feb 24 2025
//DiceRoll
//rolls a dice x amount of times

public class DiceRoll {
    public static void main(String[] args) throws Exception 
    {
        rollDice(5); //number of times to roll
    }
    public static void rollDice(double numRoll)
    {
        for (int x = 0; x < numRoll; x++)
        {
            System.out.println("roll" + x + " is: " + Math.floor(1 + Math.random() * 5));
        }
    }
}
