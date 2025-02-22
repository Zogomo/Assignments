public class Animal
{
    int age = 0;
    String gender;
    String type;
    boolean hasMate;

    Animal(int age, String gender, String type, boolean hasMate)
    {
        this.age = age;
        this.gender = gender;
        this.type = type;
        this.hasMate = hasMate;
    }

    //Public method that prints whether an instance is a mammal.
    public void isMammal()
    {
        if (type.equalsIgnoreCase("Mammal")) 
        {
            System.out.println("This is a mammal.");
        } else 
        {
            System.out.println("This is not a mammal.");
        }   
    }

    //Public method that prints whether an instance has a mate.
    public void mate() 
    {
        if (hasMate) 
        {
            System.out.println("This animal has a mate.");
        } 
        else 
        {
            System.out.println("This animal does not have a mate.");
        }
    }
}
