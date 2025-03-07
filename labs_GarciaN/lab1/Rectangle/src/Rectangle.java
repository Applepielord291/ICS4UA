
/*  Nigel Garcia
    Date started: Feb 24 2025
    Program name: Rectangle
    Purpose: outputs a rectangle given the width, height, and char visual    */

public class Rectangle {
    public static void main(String[] args) throws Exception 
    {
        //shape properties
        char c = 'x';
        int width = 6;
        int height = 5;

        RectanglePrint(c, width, height);
        HollowRectangle(c, width, height);
    }

    //creates a normal rectangle
    public static void RectanglePrint(char c, int width, int height)
    {
        //creates 2D array for the shape
        char[][] shape = new char[width][height];
        for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                shape[y][x] = c;
            }
        }
        for (int x = 0; x < width; x++)
        {
            System.out.println(shape[x]); //print hollow shape
        }
        System.out.println(' ');
    }
    //creates hollow rectangle
    public static void HollowRectangle(char c, int width, int height)
    {
        char[][] shape = new char[width][height];
        for (int x = 0; x < height; x++)
        {
            for (int y = 0; y < width; y++)
            {
                if (x == 0 || x == height - 1)
                {
                    shape[y][x] = c;
                }
                else
                {
                    shape[y][x] = ' ';
                }
                if (y == 0 || y == width - 1)
                {
                    shape[y][x] = c;
                }
                
            }
        }
        for (int x = 0; x < width; x++)
        {
            System.out.println(shape[x]); //print hollow shape
        }
    }
}
