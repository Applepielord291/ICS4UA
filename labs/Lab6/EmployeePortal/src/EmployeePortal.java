import java.util.Scanner;

/* Nigel Garcia
 * May 20 2025
 * EmployeePortal
 * get employee data from a list
 */

public class EmployeePortal {
    public static void main(String[] args) throws Exception {
        String[] names = {"gore", "bore", "das", "sad", "xp", "wdjia", "dawiu", "yikes", "nice", "owid"};
        int[] age = new int[names.length];
        int[] salary = new int[names.length];
        for (int i = 0; i < age.length; i++)
        {
            age[i] = (int)Math.round(Math.random() * 75) + 25;
        }
        for (int i = 0; i < salary.length; i++)
        {
            salary[i] = (int)Math.round(Math.random() * 100000) + 50000;
        }
        Scanner scn = new Scanner(System.in);
        System.out.println("Search for a name: ");
        String res = scn.nextLine();

        String[] sortedNames = Shell(names, 0, names.length-1);
        int position = BinarySearch(names, 0, 0, names.length-1, res);
        if (position != -1) System.out.println("Name: " + sortedNames[position] + "\nAge: " + age[position] + "\nSalary: $" + salary[position]);
        else System.out.println("Name not found on list.");
        scn.close();
    }
    public static String[] Shell(String[] names, int lowLim, int highLim) 
    {
        for (int gap = names.length/2; gap > 0; gap /= 2) 
        {
            for (int i = gap; i < names.length; i++) 
            {
                String temp = names[i];
                int j;
                for (j = i; j >= gap && names[j - gap].charAt(0) > temp.charAt(0); j -= gap) 
                { 
                    names[j] = names[j - gap];
                }
                names[j] = temp; 
            }
        }
        return names;
    }
    public static int BinarySearch(String[] names, int first, int mid, int last, String res) //sometimes this function runs forever
    {
        while (first <= last) 
        {
            if ((names[mid].charAt(0) == res.charAt(0)) && (names[mid].length() == res.length()) && names[mid].equals(res))
            {
                return mid;
            }
            else if (names[mid].charAt(0) >= res.charAt(0)) 
            {
                last = mid-1; //eliminate right half
            }
            else if (names[mid].charAt(0) < res.charAt(0)) 
            {
                first = mid+1; //eliminate left half
            }
            mid = first + (last - first)/2;
        }
        return -1;
    }
}
    
