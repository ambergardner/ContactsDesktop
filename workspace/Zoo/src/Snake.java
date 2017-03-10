/**
 * Created by amber on 2/7/17.
 */
public class Snake extends Reptile{

    public Snake(){
        this.name = "Snake";

    }

    @Override
    public void makeSound() {
        System.out.println("Hssss!");
    }
}
