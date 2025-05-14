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
        System.out.println(fibo(0, 1, res, 0, 0));
        scn.close();
    }
    public static int fibo(int num1, int num2, int limit, int timesRun, int sum)
    {
        if (timesRun < limit)
        {
            sum = num1 + num2;
            return fibo(num2, sum, limit, timesRun+1, sum);
        }
        else return sum;
    }
}
