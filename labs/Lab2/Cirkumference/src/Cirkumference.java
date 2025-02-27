import java.util.Scanner;
/*  Nigel Garcia
    Feb 25 2025
    Cirkumference
    outputs info on a circle given the radius */

    /* REMEMBER TO ADD A LOOPING SYSTEM */

public class Cirkumference {
    public static void main(String[] args) throws Exception 
    {
        boolean loop = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("start program? (Y/N)");
        String res = scanner.nextLine();
        if (res.toUpperCase().equals("Y"))
        {
            loop = true;
        }
        while (loop)
        {
            System.out.println(radius(5)); System.out.println(radius(5));
            System.out.println("Continue? (Y/N)");
            String exit = scanner.nextLine();
            if (exit.toUpperCase().equals("N"))
            {
                loop = false;
            }
        }
        scanner.close();
    }
    public static double radius(float radius)
    {
        System.out.println("radius:");
        return radius * Math.PI * 2;
    }
    public static double area(float radius) //no negative radius
    {
        System.out.println("area:");
        return Math.PI * Math.pow(radius, 2);
    }
}
