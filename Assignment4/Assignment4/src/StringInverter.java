import java.util.Scanner;

public class StringInverter {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String stringIn;
        String stringOut;
        
        
        System.out.println("Please enter the string you want reversed.");
        stringIn = scan.next();

        //Converts the string given into a char array so it can be easily inverted.
        char[] charArrayIn = stringIn.toCharArray();

        int start = 0;
        int end = charArrayIn.length - 1;

        //Swaps the place of the start and end while moving to the center.
        while (start < end)
        {
            char hold = charArrayIn[start];
            charArrayIn[start] = charArrayIn[end];
            charArrayIn[end] = hold;

            //Increments the indeces towards the middle.
            start++;
            end--;
        }

        System.out.println("Reversed String:");
        //Converts the character array into a new string
        stringOut = new String(charArrayIn);
        System.out.println(stringOut);
        scan.close();
    }
}
