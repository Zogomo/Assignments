public class Zebra extends Animal
{
    public final boolean isWild;

    Zebra(boolean isWild, int age, String gender, String type, boolean hasMate)
    {
        super(age, gender, type, hasMate);
        this.isWild = isWild;
    }

    public void run()
    {
        System.out.println("The zebra runs");
    }
}
