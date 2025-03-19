import java.util.Scanner;

/* Nigel Garcia
 * March 6 2025
 * ChristmasTree
 * outputs a christmas tree with x height (height is determined by the user)
 */

public class ChristmasTree {
    public static void main(String[] args) throws Exception 
    {
        /* Initializing variables with user input (height)
         * calls upon the function "makeTree" is height is between 3 and 20
         * try catch to prevent error (also i like them :33)
         */
        try
        {
            Scanner scanner = new Scanner(System.in);
            String space = "";
            String visual = "*";
            System.out.println("Enter christmas tree height (must be between 3-20): ");
            int height = Integer.parseInt(scanner.nextLine());
            if (height >= 3 && height <= 20) makeTree(height, space, visual);    
            scanner.close();
        }
        catch(Exception e)
        {
            System.out.println("Only numbers!!!");
        }
    }
    public static void makeTree(int height, String space, String visual)
    {
        /* Creates an array to manage tree height and triangle shape
         * space variable to create the triangle shape (x amount of spaces at the start (depends on height) then removes 1 spaces each loop to create the triangle shape)
         * adds space + visual (the asterisk symbol) for triangle shape
         * each loop the visual string has two extra asterisks added so that the triangle shape is also applied to the right side instead of only the left(and fills triangle in)
         * stemSpaces variable in order to center the stem that goes at the bottom of the triangle (same idea as what I did with the space variable)
         * fRow variable takes the number of chars in the bottom triangle row (its for stemSpaces variable so that it knows how many spaces to add for the stem)
         * Made tree stem scale with the fRow value (count value)
         * count value is used in a 2D array (so that its actually easier to print the stem) 
         * stem height scales with user inputted height (divided by 3)
         * Gets rid of x amount of spaces from the stemSpaces variable (so that the stem is actually centered (done with nested ifs))
         * afterwards, the entire 2D array is filled with the asterisk symbol (using nested for loops) and the printTree function is called
         */
        String[] treeSize = new String[height];
        for (int i = 0; i < height; i++)
        {
            space = space + " ";
        }
        for (int i = 0; i < height; i++)
        {
            treeSize[i] = space + visual;
            space = space.replaceFirst(" ", "");
            visual = visual + "**";
        }
        String stemSpaces = " ";
        int count = 0;
        int fRow = treeSize[height - 1].toCharArray().length - 1;

        if (3 <= fRow && fRow < 13) count = 1;
        else if (13 <= fRow && fRow < 31) count = 3;
        else if (31 <= fRow && fRow < 40) count = 5;


        char[][] sSpaces = new char[height / 3][count];
        for (int i = height; i < fRow; i++)
        {
            stemSpaces = stemSpaces + " ";
        }
        if (count > 1)
        {
            stemSpaces = stemSpaces.replaceFirst(" ", "");
            if (count > 3)
            {
                stemSpaces = stemSpaces.replaceFirst(" ", "");
            }
        }
        for (int i = 0; i < height / 3; i++)
        {
            for (int z = 0; z < count; z++)
            {
                sSpaces[i][z] = '*';
            }
        }
        printTree(treeSize, stemSpaces, height, sSpaces);
    }
    public static void printTree(String[] tree, String stem, int height, char[][] sSpaces)
    {
        /* uses for loops to print the arrays (since the shape is stored in the arrays) 
         * for the stem printing I had the each row of the 2D array be added to the stemSpaces variable (now called stem) so that the stem is actually centered
        */
        for (int i = 0; i < height; i++)
        {
            System.out.println(tree[i]);
        }
        for (int i = 0; i < height / 3; i++)
        {
            String s = new String(sSpaces[i]);
            System.out.println(stem + s);
        }
    }
}
