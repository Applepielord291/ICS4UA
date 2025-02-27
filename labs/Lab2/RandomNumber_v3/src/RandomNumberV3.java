/*  Nigel Garcia
    Feb 25 2025
    RandomNumber_v3
    Generates a random number between 1-Desired high number and increments by value step */

public class RandomNumberV3 {
    public static void main(String[] args) throws Exception 
    {
        int min = 10;
        int max = 25;
        int step = 5;
        System.out.println(randNumber(min, max, step));
        System.out.println("");
    }
    public static int randNumber(int min, int max, int step)
    {
        double x = min + Math.random() * max;
        double[] z = new double[3];
        for (int y = 0; y < 3; y++)
        {
            x += step;
            z[y] = x;
            System.out.print(Math.floor(x) + " ");
        }
        System.out.println(' ');
        double q = Math.random() * 3;
        return (int)z[(int)q];
    }
}
