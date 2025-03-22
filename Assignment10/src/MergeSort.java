import java.util.Arrays;

public class MergeSort <T extends Comparable<? super T>> 
{
    public static <T> void mergeSort(T[] inputArray)
    {
        int inputLength = inputArray.length;
        if (inputLength < 2) 
        {
            return;
        }
       
        int midIndex = inputLength / 2;
        T[] leftArr = Arrays.copyOfRange(inputArray, 0, midIndex);
        T[] rightArr = Arrays.copyOfRange(inputArray, midIndex, inputLength);
                
        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(inputArray, leftArr, rightArr);
    }

    @SuppressWarnings("unchecked")
    private static <T> void merge (T[] inputArray, T[] leftArr, T[] rightArr)
            {
                int leftSize = leftArr.length;
                int rightSize = rightArr.length;
        
                int i = 0, j = 0, k = 0;
        
                while(i < leftSize && j < rightSize)  
                {
                    if (((Comparable<? super T>) leftArr[i]).compareTo(rightArr[j]) <= 0) 
                    {
                        inputArray[k] = leftArr[i];
                        i++;
                    }
                    else
                    {
                        inputArray[k] = rightArr[j];
                        j++;
                    }
                    k++;
                }
        
                while (i < leftSize)
                {
                    inputArray[k] = leftArr[i];
                    i++;
                    k++;
                }
                while (j < rightSize)
                {
                    inputArray[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
