package Questions;

import java.util.ArrayList;
import java.util.HashMap;


class QandA {
    String questions;
    Object answer;

    public QandA(String questions, Object answer) {
        this.questions = questions;
        this.answer = answer;
    }
}

public class Questions {
    ArrayList<QandA> questionsAndAnswers = new ArrayList<>();

    public Questions() {
        questionsAndAnswers.add(new QandA("If you weighed 16.5 on the moon how much would you weigh here on Earth?", "100"));
        questionsAndAnswers.add(new QandA("What color is the plnet Saturn?", "pale yellow"));
        questionsAndAnswers.add(new QandA("How much does a McDonald's burger cost in Japan?", "$0.45"));
    }

    public String getNext() {
        String ques = questionsAndAnswers.get(getRandom()).question;
        return ques;
    }

    public int getRandom() {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public void promptUser(String question) {
        System.out.println(question);
    }
}
}