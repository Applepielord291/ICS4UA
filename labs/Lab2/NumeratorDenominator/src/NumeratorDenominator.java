import java.util.Scanner;

/* Nigel Garcia
 * March 6 2025
 * NumeratorDenominator
 * Outputs a simplified fraction given a numerator and denominator value */

class fraction 
{
    public int num;
    public int den;
}

public class NumeratorDenominator {
    public static void main(String[] args) throws Exception 
    {
        fraction f = new fraction();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter numerator");
        f.num = Integer.parseInt(scanner.nextLine());
        System.out.println("enter denominator");
        f.den = Integer.parseInt(scanner.nextLine());
        int test = 1;
        System.out.println(simplify(f.num, f.den, test));
        scanner.close();
    }
    public static int simplify(int num, int den, int test)
    {
        if (num % test == 0 && den % test == 0)
        {

        }
        return 0;
    }
}
