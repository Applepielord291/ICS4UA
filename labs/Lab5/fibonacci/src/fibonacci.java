import java.util.Scanner;

/* Nigel Garcia
 * May 2 2025
 * fibonacci
 * outputs the nth number of the fibonnaci sequencce
 * program not finished yet
 */

public class fibonacci {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int res = scn.nextInt();
        System.out.println(fibo(res, res - 1));
        scn.close();
    }
    public static int fibo(int input, int ogInput)
    {
        if ((ogInput) > 0)
        {
            return fibo((input - ogInput), ogInput - 1);
        }
        else
        {
            return input;
        }
    }
}
