import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException
    {
        int[][] matrix1;
        int[][] matrix2;
        int[][] matrix3;

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the path to your first  file.");
        String inputFile1Path = scan.next();

        matrix1 = FileToMatrix(inputFile1Path);

        System.out.println("Please enter the path to your second file.");
        String inputFile2Path = scan.next();

        scan.close();

        matrix2 = FileToMatrix(inputFile2Path);


        matrix3 = MatrixMult(matrix1, matrix2);

        MatrixToFile(matrix3);
    }

    public static int[][] FileToMatrix(String filePath) 
    {
        String line = "";
        Scanner scanFile;
       
        int lineIndex = 0;
      

        int rows = FindMatrixRows(filePath);
        int cols = FindMatrixCols(filePath);
        int[][] matrix;

        matrix = new int[rows][cols];
        try {
            scanFile = new Scanner(new File(filePath));

            while(scanFile.hasNextLine())
            {
                line = scanFile.nextLine();
                String lineArrString[] = line.split(", ");
                
                //Parses 
                for (int index = 0; index < lineArrString.length; index++)
                {
                    int parsed = Integer.parseInt(lineArrString[index]);
                    matrix[lineIndex][index] = parsed;
                }               

                lineIndex++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matrix;
    }

    //This method multiplies two given matrices if they are of compatible dimensions.
    public static int[][] MatrixMult(int[][] matrix1, int[][] matrix2)
    {
        int rows1 = matrix1.length;
        int rows2 = matrix2.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] matrixOut;

        matrixOut = new int[rows1][cols2];

        //Checks for proper dimensions.
        if (cols1 != rows2) 
        {
            throw new IllegalArgumentException("Matrices cannot be multiplied due to incompatible dimensions");   
        }

        for (int row = 0; row < rows1; row++) 
        {
            for (int col = 0; col < cols2; col++)
            {
                for (int k = 0; k < cols1; k++)
                {
                    matrixOut[row][col] += matrix1[row][k] * matrix2[k][col];
                }
            }
        }
        return matrixOut;
    }

    //This method is used to write a given matrix into a text file.
    public static void MatrixToFile(int[][] matrixIn) throws FileNotFoundException
    {
        PrintWriter outputFile = new PrintWriter("matrix3.txt");

        //Separates loops based on the row number
        for(int lineIndex = 0; lineIndex < matrixIn.length; lineIndex++)
        {
            //Starts a new line after each loop until the last
            if (lineIndex!= matrixIn.length - 1) 
            {
                for(int index = 0; index < matrixIn[0].length; index++)
                {
                    //Prints the value held in the matrix location, separated by commas.
                    if (index != matrixIn[0].length - 1)
                    {
                        outputFile.print(matrixIn[lineIndex][index] + ", ");
                    } 
                    else
                    {
                        outputFile.print(matrixIn[lineIndex][index]);
                    }

                }
                outputFile.println("");
            } 
            else 
            {
                    for(int index = 0; index < matrixIn[0].length; index++)
                {
                    if (index != matrixIn[0].length - 1)
                    {
                        outputFile.print(matrixIn[lineIndex][index] + ", ");
                    } 
                    else
                    {
                        outputFile.print(matrixIn[lineIndex][index]);
                    }
                }               
            }
            
        }
        outputFile.close();
    }


    //This method isused to find the number of rows in a given file
    public static int FindMatrixRows(String filePath)
    {
        int rowCount = 0;
        try 
        {
            //Scans each line while incrementing the row count until no lines are left.
            Scanner scanFile = new Scanner(new File(filePath));   
            while(scanFile.hasNextLine())
            {
                scanFile.nextLine();
                rowCount ++;
            }
            scanFile.close();
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        return rowCount;
    }

    //This method is used to find the number of columns in a given file
    //assuming that each line contains the same number of columns.
    public static int FindMatrixCols(String filePath)
    {
        String line = "";
        int matrixCols = 0;

        //Scans the first line of the text file then splits it based on commas.
        //returns the length of the array made by splitting the string.
        try {
            Scanner scanFile = new Scanner(new File(filePath));

            line = scanFile.nextLine();
            String lineArrString[] = line.split(",");

            matrixCols = lineArrString.length;
            scanFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matrixCols;
    }
}