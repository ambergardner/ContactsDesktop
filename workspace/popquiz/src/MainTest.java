import Questions.Questions;

import static org.junit.Assert.*;

/**
 * Created by amber on 2/20/17.
 */
public class MainTest {

    public void selectRandomQuesion(){
        Questions questions = new Questions();

        String q = questions.getNext();
        System.out.println(q);
        assertTrue( q.startsWith("If you"))
                || q.startsWith("What color")
                || q.startsWith("How much"));

        Object answer = questions.promptUser(q);


    }
        @Test
        public void checkUserAnswersCorrectly(){

        }


}