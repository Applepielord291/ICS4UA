import java.util.Scanner;

/* Nigel Garcia
 * March 6 2025
 * Pizza slices
 * determines number of pizza slices and leftovers given the number of boxes and people input */

public class PizzaSlices {
    public static void main(String[] args) throws Exception 
    {
        /* Initializing variables using user input (scanner)
         * calls upon the function "calculate" (takes the ppl and boxes variable), which calculates number of leftovers and slices for each person
         * Try catch to prevent errors (if user decides to input not numberss)
         */
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many people?");             
            double ppl = Integer.parseInt(scanner.nextLine());      
            System.out.println("How many pizza boxes?");
            double boxes = Integer.parseInt(scanner.nextLine());
            calculate(ppl, boxes);
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println("Only numbers allowed!!! ");
        }
        
    }
    public static void calculate(double ppl, double boxes)
    {
        /* Creates 2 new variables: leftOver and pizzaSlices which will hold information for slice number and leftovers
         * calculates slice numbers (multiplies by 8), calculates the result (div slices by people), then checks if there are leftovers (slices that each person has is equal to actual slices?)
         * calls upon the function "output" (takes the result and leftOver variable) to finish off the program.
         */
        double leftOver = 0;
        double pizzaSlices = boxes * 8;
        double result = Math.round(pizzaSlices / ppl); 
        if (result * ppl != pizzaSlices) leftOver = Math.abs(pizzaSlices % ppl);
        output(result, leftOver);
    }
    public static void output(double result, double left) 
    {
        /* Tells the user the number of slices each person will get and number of leftovers. */
        System.out.println("Each person will get " + (int)result + " slice(s) and there will be " + (int)left + " leftover(s)");
    }
}
