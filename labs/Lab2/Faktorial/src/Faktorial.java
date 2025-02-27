/*  Nigel Garcia
    Feb 25 2025
    Faktorial
    outputs the factorial of a user-inputted number */

public class Faktorial {
    public static void main(String[] args) throws Exception 
    {
        int numberFactorial = 3;
        int result = 1;
        System.out.println(factorial(numberFactorial, result) + " is the factorial of " + numberFactorial);
    }
    public static int factorial(int inputNum, int res) //find a way to add all results, the factorial works though
    {
        //int[] t = new int[inputNum];
        if (res == 1)
        {
            for (int y = inputNum - 1; y > 0; y--)
            {
                inputNum *= y;
                System.out.println(inputNum);
            }
        }
        return inputNum;
    }
}
