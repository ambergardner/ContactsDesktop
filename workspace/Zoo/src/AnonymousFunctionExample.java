/**
 * Created by amber on 2/21/17.
 */
public class AnonymousFunctionExample  {
    public static void main(String[] args) {
        //run code from a separate method
        sayHello();

        // run code from anonymous class
        Runnable r = new Runnable() {
            @Override
            public void run() { System.out.println("Hello from Anoymous class with override!");}
        };
        r.run();

        //run code from a lambda
        Runnable r2 = () -> {System.out.println("Hello from a lambda!"); };
        r2.run();

    }
    private static void sayHello() { System.out.println("Hello from a method!");}
}


