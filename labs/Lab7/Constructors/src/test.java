import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        Main main = new Main('x');
        Scanner scanner = new Scanner(System.in);
        System.out.println("Testing something, enter string: ");
        String res = scanner.nextLine();
        if (res!=null)
        {
            System.out.println(main.GetSetMain(res));
        }
        System.out.println("enter int: ");
        int numRes = scanner.nextInt();
        System.out.println(main.GetSet(numRes));
        scanner.close();
    }
}
