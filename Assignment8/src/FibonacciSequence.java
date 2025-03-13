public class FibonacciSequence {
    public static void main(String[] args) throws Exception 
    {
        int firstArg = 0;
        //Checks if an entered argument is an integer, returns an error if not.
        if (args.length > 0) 
        {
            try 
            {
                firstArg = Integer.parseInt(args[0]);

                //Checks if the arggument is negative, if it is returns an error message.
                if (firstArg < 0) 
                {
                    System.err.println("Argument " + args[0] + " must be a non-negative integer.");
                System.exit(1);
                }
            } 
            catch (NumberFormatException e) 
            {
                System.err.println("Argument " + args[0] + " must be an integer.");
                System.exit(1);
            }
        } 
        else 
        {
            System.err.println("An argument must be entered");
            System.exit(1);
        }
        long fibFin = Fibonacci(firstArg);
        System.out.println(fibFin);
    }

    //This method calculates the Fibonacci Sequence
    public static long Fibonacci(int firstArg)
    {
        //Variables that are used to hold the nth, n-1, and n-2 values for computing the Fibonacci Sequence.
        //n-1 is initialized to 1 in order to allow for the program to return anything other than 0.
        long fibN = 0;
        long fibN1 = 1;
        long fibN2 = 0;
       
        if (firstArg < 2 )
        {
            fibN = firstArg;
        }
        else if (firstArg >= 2)
        {
            for (int fib = 0; fib < firstArg - 1; fib++)
            {
                
                fibN = fibN1 + fibN2;
                fibN2 = fibN1;
                fibN1 = fibN;
            }
        }
        return fibN;
    }
}