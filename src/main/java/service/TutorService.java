package service;

import model.Question;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TutorService {

    int calculateTutorScore(List<Question> questionnaire,Map<String, Set<Integer>> selectedOptionsByQuestion);
}
