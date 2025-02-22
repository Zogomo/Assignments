public class App {
    public static void main(String[] args) 
    {
        //Defining a new instance of each class and subclass
        Animal myAnimal = new Animal(5, "Female", "Mammal", true);
        Fish myFish = new Fish(0.6f, 2, "Male", "Fish", true);
        Zebra myZebra = new Zebra(false, 9, "Female", "Mammal", false);

        //Calling public methods
        myAnimal.isMammal();
        myAnimal.mate();
        myZebra.run();
    }
}
