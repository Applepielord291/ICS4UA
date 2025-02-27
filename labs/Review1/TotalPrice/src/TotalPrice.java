import java.util.Scanner;

//Nigel Garcia
//February 5 2025
//File that outputs a final price when given quantity and price

public class TotalPrice {
    public static void main(String[] args)
    {
        float tax = 1.13f;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter price: ");
        float price = Float.parseFloat(scanner.nextLine());

        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Total price of your purchase is $" + quantity * (price * tax));
        scanner.close();
    }
}
