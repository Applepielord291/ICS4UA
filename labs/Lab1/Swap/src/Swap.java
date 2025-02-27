//Nigel Garcia
//Feb 24 2025
//Swap
//Swaps 2 numbers

public class Swap {
    public static void main(String[] args) throws Exception 
    {
        int num1 = 8;
        int num2 = 10;
        System.out.println("og num1: " + num1); 
        System.out.println("og num2: " + num2);
        swap(num1, num2);
    }
    public static void swap(int num1, int num2)
    {
        int temp1 = num1;
        int temp2 = num2;
        num1 = temp2; num2 = temp1;
        System.out.println("new num1: " + num1); 
        System.out.println("new num2: " + num2);
    }
}
