public class BubbleSort  <T extends Comparable<? super T>>{
    @SuppressWarnings("unchecked")
    public static <T> void bubbleSort(T[] array)
    {
        int length = array.length;
        for (int index = 0; index < length - 1; index++)
        {
            for (int index2 = 0; index2 < length - index - 1; index2++)
            {
                if (((Comparable<? super T>) array[index2]).compareTo(array[index2 + 1]) > 0) 
                {
                    // swap temp and arr[i]
                    T temp = array[index2];
                    array[index2] = array[index2 + 1];
                    array[index2 + 1] = temp;
                }
            }
        }        
    }
}
