/**
 * Created by amber on 2/7/17.
 */
public class Character {
    String name;
    int health;
    int damage;

    public void battle(Character enemy) {
        System.out.printf("%s appears!\n", enemy.name);

        //while both are alive
        while (bothPlayersAlive(enemy)) {
            inflictDamage(this, enemy);
            inflictDamage(enemy, this);
            showHealthStatus(enemy, this);
        }


        //if someones health is zero
        showWhenDead(this);
        showWhenDead(enemy);

       private void showWhenDead(Character player){
        String message = "%s has died./n";
        if (player.health <= 0){
            System.out.printf(message, this.name);
    }

        }
        private void inflictDamage(Character fromPlayer, Character toPlayer){
            toPlayer.health = toPlayer.health - fromPlayer.damage;
    }
    }
            private boolean bothPlayersAlive(Character player2){
                return health > 0 && player2.health > 0;
            }


           private void showHealthStatus (Character player1, Character player2){
            System.out.printf("%s's health: %d/n",  player1.name,  player1.health);
            System.out.printf("%s's health: %d/n", player2.name, player2.health);
    }

    }

