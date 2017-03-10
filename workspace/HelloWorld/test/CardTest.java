import org.junit.Test;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by amber on 2/16/17.
 */
public class CardTest {
    @Test
    public void whenFlippedFromFaceUpThenFaceDown(){
        // assemble
        Card card = new Card(3, "Hearts");
        card.setFaceUp();
        assertTrue(card.isFaceUp);

    }

    @Test
    public void noCardCanBeOutsideRangeOfRank(){
        //rank is only 1-13
    }
}
