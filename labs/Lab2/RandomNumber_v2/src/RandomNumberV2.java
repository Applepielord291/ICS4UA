/*  Nigel Garcia
    Feb 25 2025
    RandomNumber_v2
    Generates a random number between 1-Desired high number */

public class RandomNumberV2 {
    public static void main(String[] args) throws Exception 
    {
        int high = 6;
        System.out.println(randNumber(high));
    }
    public static int randNumber(int high)
    {
        double x = 1 + Math.random() * high;
        return (int)x;
    }
}
