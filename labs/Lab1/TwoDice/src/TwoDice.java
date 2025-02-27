import java.util.Scanner;

//Nigel Garcia
//Feb 20 2025
//TwoDice
//Generates 2 dice and adds both values

public class TwoDice {
    public static void main(String[] args) throws Exception 
    {
        roll();
    }
    public static void roll()
    {
        Scanner scanner = new Scanner(System.in);
        long num1 = Math.round(1 + Math.random() * 5); long num2 = Math.round(1 + Math.random() * 5); long num3 = num1 + num2;
        System.out.println("Rolled a " + num1 + " and a " + num2 + ". Your total is: " + num3 + ". Roll again? (Y/N)");
        String res = scanner.nextLine();
        if (res.toUpperCase().equals("Y")) roll(); else if (res.toUpperCase().equals("N")) scanner.close();
    }
}
