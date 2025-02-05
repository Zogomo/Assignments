import java.util.Scanner;

public class App 
{
    public static void main(String args[]) 
    {
        //Holds the first and second units entered by the user.
        String unitInStr;
        String unitOutStr;
        Unit unitInEnu = Unit.INVALID;
        Unit unitOutEnu = Unit.INVALID;

        String quantInStr = "0";
        double quantIn = 0.0;
        double quantOut = 0.0;
  
        Scanner scan = new Scanner(System.in);

        System.out.println("This App supports weight conversions using kg, lb, g, mg, and oz. For valid units enter 'Help'");
        System.out.println("If at any point you want to stop the program, enter 'Exit' or 'Quit'.");

        Boolean loopStatus = false;

        //The main loop asking and processing the conversions.
        do
        {
            

            System.out.println("Please enter the units you are converting from.");
            System.out.println("For example, kilograms or kg");
            unitInStr = scan.next();
            
            Boolean unitInStatus = false;

            //Maps the user input to the corresponding enumeration.
            //Sub Loop checking for proper input.
            do
            {
                
                if (unitInStr.equalsIgnoreCase("kg") || unitInStr.equalsIgnoreCase("kilograms") ) 
                {
                    unitInEnu = Unit.KILOGRAMS;
                    unitInStatus = true;    //Sets value to exit loop.
                }
                else if(unitInStr.equalsIgnoreCase("lb") || unitInStr.equalsIgnoreCase("pounds"))
                {
                    unitInEnu = Unit.POUNDS;
                    unitInStatus = true;
                }
                else if(unitInStr.equalsIgnoreCase("g")|| unitInStr.equalsIgnoreCase("grams"))
                {
                    unitInEnu = Unit.GRAMS;
                    unitInStatus = true;
                }
                else if(unitInStr.equalsIgnoreCase("mg") || unitInStr.equalsIgnoreCase("milligrams"))
                {
                    unitInEnu = Unit.MILLIGRAMS;
                    unitInStatus = true;
                }
                else if(unitInStr.equalsIgnoreCase("oz")  || unitInStr.equalsIgnoreCase("ounces"))
                {
                    unitInEnu = Unit.OUNCES;
                    unitInStatus = true;
                }
                else if(unitInStr.equalsIgnoreCase("help"))
                {
                    System.out.println("Valid Units are: Kilograms, Grams, Milligrams, Pounds, and Ounces.");
                    unitInStr = scan.next();
                }
                else if(unitInStr.equalsIgnoreCase("exit")|| unitInStr.equalsIgnoreCase("quit") || unitInStr.equalsIgnoreCase("0"))
                {
                    System.exit(0);
                }
                else //For invalid input.
                {
                    System.out.println("Invalid Input, try entering again."); 
                    unitInStr = scan.next();                
                }
            } while(unitInStatus == false);

            System.out.println("Please enter the units you are converting to.");
            unitOutStr = scan.next();
            
            Boolean unitOutStatus = false;
            //Maps the user input to the corresponding enumeration. Or exits the program.
            do 
            {
                
                if (unitOutStr.equalsIgnoreCase("kg") || unitOutStr.equalsIgnoreCase("kilograms")) 
                {
                    unitOutEnu = Unit.KILOGRAMS;
                    unitOutStatus = true;
                }
                else if(unitOutStr.equalsIgnoreCase("lb") || unitOutStr.equalsIgnoreCase("pounds"))
                {
                    unitOutEnu = Unit.POUNDS;
                    unitOutStatus = true;
                }
                else if(unitOutStr.equalsIgnoreCase("g") || unitOutStr.equalsIgnoreCase("grams"))
                {
                    unitOutEnu = Unit.GRAMS;
                    unitOutStatus = true;
                }
                else if(unitOutStr.equalsIgnoreCase("mg") || unitOutStr.equalsIgnoreCase("milligrams"))
                {
                    unitOutEnu = Unit.MILLIGRAMS;
                    unitOutStatus = true;
                }
                else if(unitOutStr.equalsIgnoreCase("oz") || unitOutStr.equalsIgnoreCase("ounces"))
                {
                    unitOutEnu = Unit.OUNCES;
                    unitOutStatus = true;
                }
                else if(unitOutStr.equalsIgnoreCase("help"))
                {
                    System.out.println("Valid Units are: Kilograms, Grams, Milligrams, Pounds, and Ounces.");
                }
                else if(unitOutStr.equalsIgnoreCase("exit") || unitOutStr.equalsIgnoreCase("quit") || unitOutStr.equalsIgnoreCase("0"))
                {
                    System.exit(0);
                }
                else //For invalid input
                {
                    System.out.println("Invalid Input, try entering again"); 
                    unitOutStr = scan.next(); 
                }
            } while (unitOutStatus == false);

            System.out.println("Please enter the quantity of the units you are converting from.");
            quantInStr = scan.next();

            Boolean quantInLoopStatus = false;
            do 
            {
                
                if (quantInStr.equalsIgnoreCase("quit") || quantInStr.equalsIgnoreCase("exit") || quantInStr.equalsIgnoreCase("0")) 
                {
                    System.exit(0);
                } 
                else 
                {
                    try 
                    {
                        quantIn = Double.parseDouble(quantInStr);
                        quantOut = weightConv(quantIn, unitInEnu, unitOutEnu);
                        quantInLoopStatus = true;

                    } catch (Exception e) 
                    {
                        System.out.println("Invalid Input, try entering again.");
                        quantInStr = scan.next();
                    }    
                }
            } while (quantInLoopStatus = false);

            //Checks if there's an unforeseen error resulting in a 0 output, if not, prints out the results
            //and asks if the user would like to continue using the program.
            if (quantOut == 0)
            {
                System.out.println("Error, please start again");
            } 
            else
            {
                System.out.println(Double.toString(quantIn) + " " + unitInStr + " " + "=" + Double.toString(quantOut) + " " + unitOutStr);
                System.out.println("If you want to continue enter 'Continue', if not enter 'Quit'.");
                String loop = scan.next();

                if(loop.equalsIgnoreCase("continue"))
                {
                    loopStatus = true; 
                } 
                else
                {
                    System.exit(0);
                }
            }
        } while (loopStatus == true);
        //if for some reason the loop is exited, will close the program
        scan.close();
        System.exit(0);
    }

    //Enumeration of units for ease of use
    public enum Unit
    {
        KILOGRAMS, //Weight units
        POUNDS, 
        GRAMS, 
        MILLIGRAMS, 
        OUNCES,
        INVALID
    }

    //This Method handles converting the given quantity into the appropriate units based on user input.
    private static double weightConv(double quantIn, Unit unitInEnu, Unit unitOutEnu)
    {
        Double quantOut = 0.0;
        switch (unitInEnu)
        {
            case KILOGRAMS:              
                switch (unitOutEnu) 
                {
                    case GRAMS:                      
                        quantOut = quantIn * 1000.0;
                        break;
                    case MILLIGRAMS:         
                        quantOut = quantIn * 1000000.0;
                        break;
                    case POUNDS:                  
                        quantOut = quantIn * 2.20462;
                        break;
                    case OUNCES:                       
                        quantOut = quantIn * 35.274;
                        break;
                    case KILOGRAMS:
                        quantOut = quantIn;
                        break;
                    default:
                        quantOut = 0.0;
                        break;
                }
                break;
            case GRAMS:
                switch (unitOutEnu) 
                {
                    case KILOGRAMS:                    
                        quantOut = quantIn * 0.001;
                        break;
                    case MILLIGRAMS:                     
                        quantOut = quantIn * 1000.0;
                        break;
                    case POUNDS:                       
                        quantOut = quantIn * 0.00220462;
                        break;
                    case OUNCES:                       
                        quantOut = quantIn * 0.035274;
                        break;
                    case GRAMS:
                        quantOut = quantIn;
                        break;
                    default:
                        quantOut = 0.0;
                        break;
                }
                break;
            case MILLIGRAMS:
                switch (unitOutEnu) 
                {
                    case KILOGRAMS:                       
                        quantOut = quantIn * 0.000001;
                        break;
                    case GRAMS:                       
                        quantOut = quantIn * 0.001;                    
                        break;
                    case POUNDS:                        
                        quantOut = quantIn * 0.00000220462; 
                        break;
                    case OUNCES:                
                        quantOut = quantIn * 0.000035274;
                        break;
                    case MILLIGRAMS:
                        quantOut = quantIn;
                        break;
                    default:
                        quantOut = 0.0;
                        break;
                }
                break;
            case POUNDS:
                switch (unitOutEnu) 
                {
                    case GRAMS:
                        quantOut = quantIn * 453.592;
                        break;
                    case MILLIGRAMS:
                        quantOut = quantIn * 453592.0;
                        break;
                    case KILOGRAMS:
                        quantOut = quantIn * 0.453592; 
                        break;
                    case OUNCES:
                        quantOut = quantIn * 16.0;
                        break;
                    case POUNDS:
                        quantOut = quantIn;
                        break;
                    default:
                        quantOut = 0.0;
                        break;
                }
                break;
            case OUNCES:
                switch (unitOutEnu) 
                {
                    case KILOGRAMS:
                        quantOut = quantIn / 35.274;
                        break;
                    case GRAMS:
                        quantOut = quantIn * 28.3495;
                        break;
                    case MILLIGRAMS:
                        quantOut = quantIn * 28349.5;
                        break;
                    case POUNDS:
                        quantOut = quantIn / 16.0;
                        break;
                    case OUNCES:
                        quantOut = quantIn;
                            break;
                    default:                      
                        quantOut = 0.0;
                        break;
                }
                break;
            default:
                quantOut = 0.0;
                break;
        }
        return quantOut;
    }
}