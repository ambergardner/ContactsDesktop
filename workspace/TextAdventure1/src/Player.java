import java.util.Scanner;

public class Player extends {
    String weapon;
    String location;
    List<String> items = new ArrayList<>();


    public Player(String name){
        this.health = 20;
        this.damage = 20;

    }

    public void findItem(String item) {
        System.out.printf("You found a %s! pick it up?[y/n]"));
                String answer = Game.scanner.nextLine());
        if (answer.equalIgnoreCase("y")) {
            items.add(item);
            System.out.println("You picked up an item!");
        }
    }

    public void chooseName() {
        System.out.println("What is your name?");
        name = Game.scanner.nextLine();
        System.out.println("Welcome, " + name);
    }

    public void chooseWeapon() throws Exception {
        System.out.println("Choose your weapon [sword/mace]");
        weapon = Game.scanner.nextLine();

        if (weapon.equalsIgnoreCase("sword")) {
            System.out.println("A sword is a fine choice!");
        } else if (weapon.equalsIgnoreCase("mace")) {
            System.out.println("A mace is a fine choice!");
        } else {
            throw new Exception("Invalid weapon.");
        }
    }

    public void chooseLocation() throws Exception {
        System.out.println("Choose your location [forest/tunnel]");
        location = Game.scanner.nextLine();

        if (location.equalsIgnoreCase("forest")) {
            System.out.println("Entering forest...");
        } else if (location.equalsIgnoreCase("tunnel")) {
            System.out.println("Entering tunnel...");
        } else {
            throw new Exception("Invalid location.");
        }
    }
}
