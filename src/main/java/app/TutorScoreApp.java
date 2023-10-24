package app;

import static java.lang.String.format;

import model.Option;
import model.Question;
import model.Tutor;
import service.TutorService;
import service.TutorServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TutorScoreApp {

    public static void main(String[] args) {
        //Create Tutor
        Tutor tutor = new Tutor(1, "Tutor1");
        //Load Questionnaire
        List<Question> questionnaire = getQuestionnaire();
        //Tutor selects options from Questionnaire
        Map<String, Set<Integer>> selectedOptionsByQuestion = new HashMap<>();
        for (Question question : questionnaire) {
            List<Option> options = question.getOptions();
            if (question.isMultiChoice()) {
                //Tutor selects option 1 and option 4 for first question
                selectedOptionsByQuestion.put(question.getQuestionId(), Set.of(options.get(0).getOptionId(), options.get(3).getOptionId()));
            } else {
                //Tutor selects option 3  for second question
                selectedOptionsByQuestion.put(question.getQuestionId(), Set.of(options.get(2).getOptionId()));
            }
        }
        TutorService tutorService = new TutorServiceImpl();
        int tutorScore = tutorService.calculateTutorScore(questionnaire, selectedOptionsByQuestion);
        tutor.setTutorScore(tutorScore);
        System.out.println(format("Tutor Score with tutorId %s is %s", tutor.getTutorId(), tutor.getTutorScore()));

    }

    /**
     * Loads immutable Questionnaire.This should preferably be coming from a static file in resources and loaded
     * into memory at Application startup.
     *
     * @return
     */
    private static List<Question> getQuestionnaire() {
        Question question1 = new Question("ques1", "What kind of tutoring experience do you have?");
        question1.setOptions(List.of(new Option(1, "Online Tutoring", 1),
                                     new Option(2, "Home schooling", 1),
                                     new Option(3, "After school club", 1),
                                     new Option(4, "None", 0)));
        question1.setMultiChoice(true);
        Question question2 = new Question("ques2", "How much overall tutoring experience you have?");
        question2.setOptions(List.of(new Option(1, "0-1", 0),
                                     new Option(2, "1-2", 1),
                                     new Option(3, "3 or more", 2),
                                     new Option(4, "None", 0)));
        question2.setMultiChoice(false);
        return List.of(question1, question2);

    }
}
