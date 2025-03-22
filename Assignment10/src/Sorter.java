import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Sorter<T extends Comparable<T> > 
{
    public static void main(String[] args) throws Exception 
    {
        int arrayLength = 20;

        //Creates a random Integer array for testing.
        Integer[] intArr = new Integer[arrayLength];
        intArr = createRandomArray(arrayLength);


        System.out.println("Randomized integer array:");
        for (int index = 0; index < arrayLength; index++)
        {
            System.out.println(intArr[index]);
        }
        Integer[] bSIntArr = intArr;
        Integer[] mSIntArr = intArr;

        //Merge sort.
        MergeSort.mergeSort(mSIntArr);

        System.out.println("Merge sorted integer array:");
        for (int index = 0; index < arrayLength; index++)
        {
            System.out.println(mSIntArr[index]);
        }

        //Bubble sort.
        BubbleSort.bubbleSort(bSIntArr);

        System.out.println("Bubble sorted character array");        
        for (int index = 0; index < arrayLength; index++)
        {
            System.out.println(bSIntArr[index]);
        }


        Character[] charArr = new Character[arrayLength];
        charArr = createRandomCharArray(arrayLength);
        System.out.println("Randomized character array");        
        for (int index = 0; index < arrayLength; index++)
        {
            System.out.println(charArr[index]);
        }

        Character[] mSCharArr = charArr;
        Character[] bSCharArr = charArr;

        MergeSort.mergeSort(mSCharArr);

        System.out.println("Merge sorted character array");        
        for (int index = 0; index < arrayLength; index++)
        {
            System.out.println(mSCharArr[index]);
        }

        BubbleSort.bubbleSort(bSCharArr);

        System.out.println("Bubble sorted character array");        
        for (int index = 0; index < arrayLength; index++)
        {
            System.out.println(bSCharArr[index]);
        }
    }

    public static Integer[] createRandomArray(int arrayLength)
    {
        Random random = new Random();       
        Integer[] randArr = new Integer[arrayLength];

        for(int i = 0; i < arrayLength; i++)
        {
            randArr[i] = random.nextInt(101);
        }

        return randArr;
    }

    public static Character[] createRandomCharArray(int arrayLength)
    {
        Random random = new Random();       
        Character[] randArr = new Character[arrayLength];

        for(int i = 0; i < arrayLength; i++)
        {
            randArr[i] = (char)(random.nextInt(26)+ 'a');
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
