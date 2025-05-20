import java.util.Scanner;

public class EmployeePortal {
    public static void main(String[] args) throws Exception {
        String[] names = {"gore", "bore", "das", "sad", "xp", "wdjia", "dawiu", "yikes", "nice", "owid"};
        Scanner scn = new Scanner(System.in);
        System.out.println("Search for a name: ");
        String res = scn.nextLine();
        String[] sortedNames = Quick(names, 0, names.length-1);
        System.out.println("Done");
        for (int i = 0; i < sortedNames.length; i++)
        {
            System.out.print(sortedNames[i] + " ");
        }
        BinarySearch(sortedNames, 0, 0, names.length-1, res);
        scn.close();
        /*int[] age = new int[15];
        int[] salary = new int[15];
        Scanner scn = new Scanner(System.in);
        String userRes = scn.nextLine();*/
    }
    public static String[] Quick(String[] names, int lowLim, int highLim)
    {
        int i = lowLim; int j = highLim; String h;
        String x = names[(lowLim + highLim) / 2];
        do
        {
            System.out.println("i: " + i);
            System.out.println("highLim: " + highLim);
            System.out.println("j: " + j);
            System.out.println("lowim: " + lowLim);
            while (names[i].charAt(0) < x.charAt(0)) i++;
            while (names[i].charAt(0) > x.charAt(0)) j--;
            if (i <= j)
            {
                h = names[i]; 
                names[i] = names[j]; 
                names[j] = h;
                i++; j--;
            }
        } while (i <= j);

        if (lowLim < j) Quick(names, lowLim, j);
        if (i < highLim) Quick(names, i, highLim);
        return names;
    }
    public static void BinarySearch(String[] names, int first, int mid, int last, String res)
    {
        while (first <= last) 
        {
            if ((names[mid].charAt(0) == res.charAt(0)) && (names[mid].length() == res.length()) && names[mid].equals(res))
            {
                System.out.println("found");
            }
            else if (names[mid].charAt(0) > res.charAt(0)) last = mid-1; //eliminate right half
            else if (names[mid].charAt(0) < res.charAt(0)) first = mid+1; //eliminate left half
            mid = first + (last - first)/2;
        }
    }
}
    
