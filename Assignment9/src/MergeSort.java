public class MergeSort {
    public static void mergeSort(int[] inputArray)
    {
        int inputLength = inputArray.length;
        if (inputLength < 2) 
        {
            return;
        }
       
        int midIndex = inputLength / 2;
        int[] leftArr = new int[midIndex];
        int[] rightArr = new int[inputLength - midIndex];

        for (int leftIndex = 0; leftIndex < midIndex; leftIndex++)
        {
            leftArr[leftIndex] = inputArray[leftIndex];
        }

        for (int rightIndex = midIndex; rightIndex < inputLength; rightIndex++) 
        {
            rightArr[rightIndex - midIndex] = inputArray[rightIndex];
        }
               
        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(inputArray, leftArr, rightArr);
    }

    private static void merge (int[] inputArray, int[] leftArr, int[] rightArr)
    {
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize)  
        {
            if (leftArr[i] <= rightArr[j]) 
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
