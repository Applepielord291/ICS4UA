import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        String res = scn.nextLine();
        System.out.println(reverseString(res));
        scn.close();
    }
    public static String reverseString(String accept)
    {
        if (accept.length() > 0) 
        {
            return reverseString(accept.substring(1) + accept.charAt(0));
        }
        else 
        {
            return "";
        }
    }
}
