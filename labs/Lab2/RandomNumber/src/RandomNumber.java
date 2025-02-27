/*  Nigel Garcia
    Feb 25 2025
    RandomNumber
    Generates a random number between 1-6 */

public class RandomNumber {
    public static void main(String[] args) throws Exception 
    {
        System.out.println(randNumber());
    }
    public static int randNumber()
    {
        double x = 1 + Math.random() * 5;
        return (int)x;
    }
}
