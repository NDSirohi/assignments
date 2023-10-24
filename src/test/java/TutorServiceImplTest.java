import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.Option;
import model.Question;
import service.TutorService;
import service.TutorServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TutorServiceImplTest {

    private TutorService tutorService;

    @BeforeEach
    void init() {
        tutorService = new TutorServiceImpl();
    }

    @Test
    void test_calculateScore_success() {
        Map<String, Set<Integer>> selectedOptionsByQuestion = Map.of("ques1", Set.of(1, 2), "ques2", Set.of(3));
        assertEquals(4, tutorService.calculateTutorScore(getQuestionnaire(), selectedOptionsByQuestion));
    }

    @Test
    void test_calculateScore_whenSelectedOptionsNull_failure() {
        assertThrows(IllegalArgumentException.class, () -> tutorService.calculateTutorScore(getQuestionnaire(), null),
                     "No question answered in the questionnaire");
    }

    @Test
    void test_calculateScore_whenSelectedOptionsEmpty_failure() {
        assertThrows(IllegalArgumentException.class, () -> tutorService.calculateTutorScore(getQuestionnaire(), Map.of()),
                     "No question answered in the questionnaire");
    }

    @Test
    void test_calculateScore_whenAnyQuestionUnanswered_failure() {
        Map<String, Set<Integer>> selectedOptionsByQuestion = Map.of("ques1", Set.of(1, 2), "ques2", Set.of());
        assertThrows(IllegalArgumentException.class, () -> tutorService.calculateTutorScore(getQuestionnaire(), selectedOptionsByQuestion),
                     "All the Questions are Mandatory");
    }

    @Test
    void test_calculateScore_whenSingleChoiceQuestionInvalid_failure() {
        Map<String, Set<Integer>> selectedOptionsByQuestion = Map.of("ques1", Set.of(1, 2), "ques2", Set.of(1, 2));
        assertThrows(IllegalArgumentException.class, () -> tutorService.calculateTutorScore(getQuestionnaire(), selectedOptionsByQuestion),
                     "Multiple options selected for single choice question");
    }

    private List<Question> getQuestionnaire() {
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
