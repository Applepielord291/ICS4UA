import java.util.Scanner;

/* Nigel Garcia
 * May 2 2025
 * fibonacci
 * outputs the nth number of the fibonnaci sequencce
 */

public class fibonacci {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int res = scn.nextInt();
        System.out.println(fibo(res, res));
        scn.close();
    }
    public static int fibo(int input, int ogInput)
    {
        if ((ogInput -  1) > 0)
        {
            return fibo(input + (ogInput - 1), ogInput - 1);
        }
        else
        {
            return input;
        }
    }
}
