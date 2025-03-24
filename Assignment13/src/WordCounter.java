import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class WordCounter {

    public static void main(String[] args) throws Exception 
    {
        System.out.println("Enter the name of the file.");

        Scanner scan = new Scanner(System.in);

        String fileName = scan.next();
        wordCount[] finalCountArray;

        finalCountArray = readFileToArray(fileName);

        //Loop to print out the words and word counts
        for(int index = 0; index < finalCountArray.length; index++)
        {
            if (finalCountArray[index].wordCount == 1)
            {
                System.out.println(finalCountArray[index].word + " appears " + finalCountArray[index].wordCount + " time.");
            }
            else
            {
                System.out.println(finalCountArray[index].word + " appears " + finalCountArray[index].wordCount + " times.");
            }
        }
        scan.close();
    }

    //Reads the file given and turns it into the desired array.
    public static wordCount[] readFileToArray(String fileName) throws FileNotFoundException
    {
        wordCount[] wordCountArray;
        int lineCount = 0;
        String line = "";
        
        //Tries to scan the file and if successful gives the line count for initializing the array.
        try {
            Scanner scanFile = new Scanner(new File(fileName));

            while(scanFile.hasNextLine())
            {
                scanFile.nextLine();
                lineCount++;
            }
            scanFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        wordCountArray = new wordCount[lineCount];

        Scanner scanString = new Scanner(new File(fileName));
        int lastWordIndex = -1;

        //Scans each line of the file, adding to the array if new while incrementing the word count for each repeat.
        for (int index = 0; index < lineCount; index++)
        {
            line = scanString.nextLine().toLowerCase().trim();

            //If the line is empty, skips the line.
            if(line.length() < 1)
            {
                break;
            }

            //Starts the array.
            if (lastWordIndex < 0)
            {
                lastWordIndex++;
                wordCountArray[lastWordIndex] = new wordCount(line);
            }
            else //If the word is found, increments the word count of the corresponding index.
            {
                boolean found = false;
                for(int innerIndex = 0; innerIndex <= lastWordIndex; innerIndex++)
                {
                    if (line.compareToIgnoreCase(wordCountArray[innerIndex].word) == 0)
                    {
                        wordCountArray[innerIndex].wordCount++;
                        found = true;
                        break;
                    }  
                }
                if (found == false)//Checks if the word found is already in the array, if not adds it to the next index.
                {
                    lastWordIndex++;
                    wordCountArray[lastWordIndex] = new wordCount(line);
                }
            }
        }

        //transfers the wordCountArray to a new array that is initialized for only the amount of spots used.
        wordCount[] finishedArray = Arrays.copyOfRange(wordCountArray, 0, lastWordIndex);

        scanString.close();
        return finishedArray;
    }
}
