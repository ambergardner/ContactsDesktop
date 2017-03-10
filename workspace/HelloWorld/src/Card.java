/**
 * Created by amber on 2/16/17.
 */
public class Card {
    private int rank;
    private String suit;
    private int orientation;  //1 is face up, 2 is face down


    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;


    }

    public void setFaceUp() {
        this.orientation = 1;

    }
}
