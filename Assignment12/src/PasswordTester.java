import java.util.Scanner;

public class PasswordTester 
{
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Please enter your potential password.");

        Scanner scan = new Scanner(System.in);
        String password = scan.next();
        scan.close();

        
        char[] passArr = password.toCharArray();

        boolean lcStatus = false;
        boolean ucStatus = false;
        boolean numStatus = false;
        boolean specialStatus = false;
        
        //Checks what requirements the password meets
        int finalStatus = getFinalStatus(password, passArr, lcStatus, ucStatus, numStatus, specialStatus);

        //Checks if the password has the proper length and enough of the requirements.
        if (passArr.length > 7 && passArr.length < 17)
        {
            if (finalStatus > 2)
            {
                System.out.println("Your password is acceptable.");
                System.exit(0);
            }
            else
            {
                System.out.println("Your password is not acceptable.");
            }
        }
        else
        {
            System.out.println("Your password is too short.");
        }
    }

    //Checks what requirements the password meets
    public static int getFinalStatus(String password, char[] passArr, boolean lcStatus, boolean ucStatus, boolean numStatus, boolean specialStatus)
    {
        String checkSpecArr = "~!@#$%^&*()-=+_";

        for (int index = 0; index < passArr.length; index++)
        {
            if (Character.isUpperCase(passArr[index]) == true) 
            {
                ucStatus = true;
            } 
            else if (Character.isLowerCase(passArr[index]) == true)
            {
                lcStatus = true;
            }
            else if (Character.isDigit(passArr[index]) == true)
            {
                numStatus = true;
            }
            else if (checkSpecArr.contains(password.subSequence(index, index)))
            {
                specialStatus = true;
            }
        }

        int finalStatus = 0;
        if (lcStatus == true)
        {
            finalStatus++;
        }

        if (ucStatus == true)
        {
            finalStatus++;
        }

        if (numStatus == true)
        {
            finalStatus++;
        }

        if (specialStatus == true)
        {
            finalStatus++;
        }

        return finalStatus;
    }
}
