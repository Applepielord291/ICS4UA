/*  Nigel Garcia
    Feb 25 2025
    RandomNumber_v3
    Generates a random number between 1-Desired high number and increments by value step */

public class RandomNumberV3 {
    public static void main(String[] args) throws Exception 
    {
        int min = 0;
        int max = 100;
        int step = 5;
        System.out.println(randNumber(min, max, step));
    }
    public static int randNumber(int min, int max, int step)
    {
        double x = min + Math.random() * max;
        for (int y = 0; y < 3; y++)
        {
            x += step;
            System.out.print(Math.floor(x) + " ");
        }
        System.out.println(' ');
        return (int)x;
    }
}
