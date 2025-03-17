import java.util.Scanner;

/* Nigel Garcia
 * March 6 2025
 * NumeratorDenominator
 * Outputs a simplified fraction given a numerator and denominator value */

class fraction 
{
    public double num;
    public double den;
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
        System.out.println(simplify(f.num, f.den));
        scanner.close();
    }
    public static double simplify(double num, double den)
    {
        double r = num / den;
        return r;
    }
}
