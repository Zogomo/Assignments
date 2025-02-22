public class Fish extends Animal
{
    private final float sizeInFeet;

    Fish(float sizeInFeet, int age, String gender, String type, Boolean hasMate)
    {
        super(age, gender, type, hasMate);
        this.sizeInFeet = sizeInFeet;
    }

    //Method that prints whether the fish can eat, of course it can eat.
    private void canEat()
    {
        System.out.println("Yes, the fish can eat.");
    }
}
