import java.util.Scanner;

/* Nigel Garcia
 * March 6 2025
 * NumeratorDenominator
 * Outputs a simplified fraction given a numerator and denominator value */

class fraction 
{
    public long num;
    public long den;
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
        result(f.num, f.den);
        scanner.close();
    }
    public static void result(long num, long den)
    {
        long gcd = simplify(num, den);
        System.out.println((num / gcd) + " / " + (den / gcd));
    }
    public static long simplify(long num, long den) 
    {
        if (den == 0) return num;
        else return simplify(den, num % den);
    }
}
