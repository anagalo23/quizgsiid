package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Cette partie n'est pas utilisée dans ce tp
 *
 */
public  class Questions {

	
	
    private final String question;

    private final String correctAnswer;

    private final List<String> incorrectAnswers;

    public Questions(final String question, final String correctAnswer, 
                final List<String> incorrectAnswers) {
        // TODO: empty strings/nulls checks
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = new ArrayList<String>(incorrectAnswers);
    }

    public List<String> getPossibleAnswers() {
        final List<String> result = new ArrayList<String>();
        result.addAll(incorrectAnswers);
        result.add(correctAnswer);

        Collections.shuffle(result);
        return result;
    }
    
    public boolean isCorrectAnswer(final String answer) {
        if (answer.equals(correctAnswer)) {
            return true;
        }
        return false;
    }

    public String getQuestion() {
        return question;
    }
}