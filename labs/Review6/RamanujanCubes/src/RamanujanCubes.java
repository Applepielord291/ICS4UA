import java.util.Scanner;

//Nigel garcia
//February 6 2025
//outputs number of integers that have the ramanujan cubes property given a range 
//I give up on this haha, (edit: im so stupid for the past 2 weeks trying to use a recursion to cycle between the test numbers and constantly getting stack overflows when i coulda just used a for loop)
public class RamanujanCubes {
    public static void main(String[] args) throws Exception 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input minumum number");
        int minNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Input maximum number");
        int maxNumber = Integer.parseInt(scanner.nextLine());

        //value to check ramanujana cubes
        int testNumbers = minNumber;
        int correct = 0;

        calc(minNumber, maxNumber, correct, testNumbers);
        scanner.close();
    }
   public static int calc(int min, int max, int correct, int test)
   {
    if (test == max)
    {
        System.out.println("There are " + correct + " numbers between " + min + " and " + max + " whose cubes are ramanujan cubes");
        return correct;
    }
    else
    {
        for (int x = 0; x < 999; x++)
        {
            for (int y = 0; y < 999; y++)
            {
                for (int z = 0; z < 999; z++)
                {
                    if (x != y && x != z && y != z)
                    {
                        if (Math.pow(test, 3) == Math.pow(x, 3) + Math.pow(y, 3) + Math.pow(z, 3))
                        {
                            return calc(min, max, correct+1, test+1);
                        }
                    }
                }
            }
        }
        return calc(min, max, correct, test+1);
    }
   }
}
