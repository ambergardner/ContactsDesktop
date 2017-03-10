/**
 * Created by amber on 2/7/17.
 */
public class Animal {
    String name;
    String category;

    public void makeSound(){
        System.out.println("Animal sound!");

    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.name = "testing toString()";
        System.out.println(animal.toString());
    }
}
