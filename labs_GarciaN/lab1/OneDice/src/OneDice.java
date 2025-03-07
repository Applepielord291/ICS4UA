import java.util.Scanner;
//Nigel Garcia
//february 20 2025
//OneDice
//generates a random number between 1 - 6

public class OneDice {
    public static void main(String[] args) throws Exception 
    {
        roll();
    }
    public static void roll()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rolled a " + Math.round(1 + Math.random() * 5) + ". Roll again? (Y/N)");
        String res = scanner.nextLine();
        if (res.toUpperCase().equals("Y")) roll(); else if (res.toUpperCase().equals("N")) scanner.close();
    }
}
