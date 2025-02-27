import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*  Nigel Garcia
    Feb 25 2025
    Funktions
    Outputs largest number, greatest common divisor, if its divisible, if its prime, it letter is part of alphabet */

public class Funktions {
    public static void main(String[] args) throws Exception 
    {
        int num1 = 12;
        int num2 = 14;
        String s = "d";
        System.out.println(largest(num1, num2));
        System.out.println(greatCommDiv(num1, num2));
        System.out.println(isDivisible(num1, num2));
        System.out.println(isPrime(num1));
        System.out.println(Letter(s));
    }
    public static double largest(double num1, double num2)
    {
        if (num1 > num2) return num1;
        else if (num2 > num1) return num2;
        return 0;
    }
    public static int greatCommDiv(int num1, int num2)
    {
        if (num1 > num2)
        {
            for (int x = 1; x < num1; x++)
            {
                if (num1 % x == 0 && num2 % x == 0)
                {
                    return x;
                }
            }
        }
        else if (num2 > num1)
        {
            for (int x = 1; x < num2; x++)
            {
                if (num1 % x == 0 && num2 % x == 0)
                {
                    return x;
                }
            }
        }
        
        return 0;
    }
    public static boolean isDivisible(int num1, int num2)
    {
        if (num1 % num2 == 0) return true;
        return false;
    }
    public static boolean isPrime(int num1)
    {
        for (int x = 1; x < num1; x++)
        {
            if (num1 % x == 1 && x != 1 || x != num1)
            {
                return true;
            } 
        }
        return false;
    }
    public static boolean Letter(String x)
    {
        Pattern pat = Pattern.compile("abcdefghijklmnopqrstuvwxyz", Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(x);
        if (mat.find()) return true;
        else return false;
    }
}
