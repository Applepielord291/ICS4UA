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
        int value = 5;
        Scanner scanner = new Scanner(System.in);
        System.out.println("start program? (Y/N)");
        String res = scanner.nextLine();
        if (res.toUpperCase().equals("Y") && value > 0) loop = true;
        else if (value <= 0) System.out.println("Please use a number greater than 0");
        while (loop)
        {
            System.out.println(radius(5)); System.out.println(radius(value));
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
    public static double area(float radius) 
    {
        System.out.println("area:");
        return Math.PI * Math.pow(radius, 2);
    }
}
