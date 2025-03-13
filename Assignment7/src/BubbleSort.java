public class BubbleSort 
{
    public static void bubbleSort(int[] array)
    {
        int length = array.length;
        for (int index = 0; index < length - 1; index++)
        {
            for (int index2 = 0; index2 < length - index - 1; index2++)
            {
                if (array[index2] > array[index2 + 1]) 
                {
                    // swap temp and arr[i]
                    int temp = array[index2];
                    array[index2] = array[index2 + 1];
                    array[index2 + 1] = temp;
                }
            }
        }        
    }
}
