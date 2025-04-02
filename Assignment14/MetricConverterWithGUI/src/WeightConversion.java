public class WeightConversion 
{
    public static double weightConv(double quantIn, String unitIn, String unitOut)
    {
        Double quantOut = 0.0;
        switch (unitIn)
        {
            case "Kilograms":              
                switch (unitOut) 
                {
                    case "Grams":                      
                        quantOut = quantIn * 1000.0;
                        break;
                    case "Milligrams":         
                        quantOut = quantIn * 1000000.0;
                        break;
                    case "Pounds":                  
                        quantOut = quantIn * 2.20462;
                        break;
                    case "Ounces":                       
                        quantOut = quantIn * 35.274;
                        break;
                    case "Kilograms":
                        quantOut = quantIn;
                        break;
                    default:
                        quantOut = 0.0;
                        break;
                }
                break;
            case "Grams":
                switch (unitOut) 
                {
                    case "Kilograms":                    
                        quantOut = quantIn * 0.001;
                        break;
                    case "Milligrams":                     
                        quantOut = quantIn * 1000.0;
                        break;
                    case "Pounds":                       
                        quantOut = quantIn * 0.00220462;
                        break;
                    case "Ounces":                       
                        quantOut = quantIn * 0.035274;
                        break;
                    case "Grams":
                        quantOut = quantIn;
                        break;
                    default:
                        quantOut = 0.0;
                        break;
                }
                break;
            case "Milligrams":
                switch (unitOut) 
                {
                    case "Kilograms":                       
                        quantOut = quantIn * 0.000001;
                        break;
                    case "Grams":                       
                        quantOut = quantIn * 0.001;                    
                        break;
                    case "Pounds":                        
                        quantOut = quantIn * 0.00000220462; 
                        break;
                    case "Ounces":                
                        quantOut = quantIn * 0.000035274;
                        break;
                    case "Milligrams":
                        quantOut = quantIn;
                        break;
                    default:
                        quantOut = 0.0;
                        break;
                }
                break;
            case "Pounds":
                switch (unitOut) 
                {
                    case "Grams":
                        quantOut = quantIn * 453.592;
                        break;
                    case "Milligrams":
                        quantOut = quantIn * 453592.0;
                        break;
                    case "Kilograms":
                        quantOut = quantIn * 0.453592; 
                        break;
                    case "Ounces":
                        quantOut = quantIn * 16.0;
                        break;
                    case "Pounds":
                        quantOut = quantIn;
                        break;
                    default:
                        quantOut = 0.0;
                        break;
                }
                break;
            case "Ounces":
                switch (unitOut) 
                {
                    case "Kilograms":
                        quantOut = quantIn / 35.274;
                        break;
                    case "Grams":
                        quantOut = quantIn * 28.3495;
                        break;
                    case "Milligrams":
                        quantOut = quantIn * 28349.5;
                        break;
                    case "Pounds":
                        quantOut = quantIn / 16.0;
                        break;
                    case "Ounces":
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
