import java.util.Scanner;

public class CountVowel {
    public static void main(String[] args) throws Exception 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a phrase and outputs vowel count: ");
        String res = scn.nextLine();
        char[] chars = new char[res.length()];
        chars = res.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == 'a') scn.close();
        }
        scn.close();
    }
}
