/**
 * Created by amber on 2/7/17.
 */
public class Dog extends Mammal {

    public Dog(){
        this.name = "Dog";
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}
