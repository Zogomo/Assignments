import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class MergeSorter {
    public static void main(String[] args) throws Exception 
    {
        int firstArg = 0;
        if (args.length > 0) 
        {
            try 
            {
                firstArg = Integer.parseInt(args[0]);

                //Checks if the arggument is negative, if it is returns an error message.
                if (firstArg < 1) 
                {
                    System.err.println("Argument " + args[0] + " must be a positive integer.");
                System.exit(1);
                }
            } 
            catch (NumberFormatException e) 
            {
                System.err.println("Argument " + args[0] + " must be an integer.");
                System.exit(1);
            }

            int[] randArr = new int[firstArg];
            int[] sortedArr = new int[firstArg];
            randArr = createRandomArray(firstArg);

            System.out.println("Enter the name of the file you want the randomized array in.");

            Scanner scan = new Scanner(System.in);
            String randArrFileName = scan.next();
            writeArrayToFile(randArr, randArrFileName);

            sortedArr = randArr;

            MergeSort.mergeSort(sortedArr);
            

            System.out.println("Enter the name of the file you want the sorted array in.");
            String sortedArrFileName = scan.next();
            writeArrayToFile(sortedArr, sortedArrFileName);

            System.out.println("The array has been sorted.");
            scan.close();
        }
        else
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the file name of the array you want sorted.");
            String fileName = scan.nextLine();
            int[] arr = readFileToArray(fileName);
            
            System.out.println("Enter the name of the file you want the sorted array in.");
            String sortedArrFileName = scan.next();

            MergeSort.mergeSort(arr);
            writeArrayToFile(arr, sortedArrFileName);

            System.out.println("Your array has been sorted.");
            scan.close();
        }
    }

    public static int[] createRandomArray(int arrayLength)
    {
        Random random = new Random();       
        int[] randArr = new int[arrayLength];

        for(int i = 0; i < arrayLength; i++)
        {
            randArr[i] = random.nextInt(101);
        }

        return randArr;
    }

    public static void writeArrayToFile(int[] array, String fileName) throws FileNotFoundException
    {
        PrintWriter outputFile = new PrintWriter(fileName);
        for (int index = 0; index < array.length; index++)
        {
            outputFile.println(array[index]);
        }
        outputFile.close();
    }

    public static int[] readFileToArray(String fileName) throws FileNotFoundException
    {
        //String line = "";
        Scanner scanFile = null;
        int[] array;
        int lineCount = 0;
        int lineValue = 0;

        try {
            scanFile = new Scanner(new File(fileName));

            while(scanFile.hasNextLine())
            {
                scanFile.nextLine();
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanFile.close();

        array = new int[lineCount];

        Scanner scanValue = new Scanner(new File(fileName));
        for (int line = 0; line < lineCount; line++)
        {
            lineValue = scanValue.nextInt();
            array[line] = lineValue;
        }
        scanValue.close();
        return array;
    }
}
