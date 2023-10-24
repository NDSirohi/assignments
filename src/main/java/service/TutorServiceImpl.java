package service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import model.Option;
import model.Question;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TutorServiceImpl implements TutorService {

    /**
     * Calculates score for the tutor from the selected options for the given questionnaire
     *
     * @param questionnaire
     * @param selectedOptionsByQuestion
     * @return
     */
    @Override
    public int calculateTutorScore(List<Question> questionnaire, Map<String, Set<Integer>> selectedOptionsByQuestion) {
        int score = 0;
        if (isNull(selectedOptionsByQuestion) || selectedOptionsByQuestion.isEmpty()) {
            throw new IllegalArgumentException("No question answered in the questionnaire");
        }
        for (Question question : questionnaire) {
            Set<Integer> selectedOptions = selectedOptionsByQuestion.get(question.getQuestionId());
            //Assumption all questions are mandatory
            if (nonNull(selectedOptions) && !selectedOptions.isEmpty()) {
                if (!question.isMultiChoice() && selectedOptions.size() > 1) {
                    throw new IllegalArgumentException("Multiple options selected for single choice question");
                }
                score = score + question.getOptions().stream().filter(option -> selectedOptions.contains(option.getOptionId())).mapToInt(Option::getOptionScore)
                                        .sum();
            } else {
                throw new IllegalArgumentException("All the Questions are Mandatory");
            }
        }
        return score;
    }

}
