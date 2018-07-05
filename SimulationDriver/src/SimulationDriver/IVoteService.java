package SimulationDriver;

import java.util.LinkedHashMap;
import java.util.Map;

public class IVoteService {
    private Student[] studentList;
    private Question question;  // has answer attached to it
    
    public IVoteService(Student[] x, Question y) {
        studentList = x;
        question = y;
        //  match student answers with question answers
        //  get questions from map
        for(Student s : studentList)
            for(Map.Entry<String, Boolean> m : question.getCorrectAnswerList().entrySet())
                s.addAnswer(m.getKey(), false);
    }
    public Student[] getStudentList() {
        return studentList;
    }
    public void sendAnswer(String studentID, String answer) {
        // student map matches question map w/layout
        if(question.isMultipleAnswer() && 
            question.getCorrectAnswerList() != null &&
            question.getCorrectAnswerList().containsKey(answer)) {
            for(Student s : studentList) {
                if(s.getID().equals(studentID))
                    s.addAnswer(answer, true);
            }
        }
        else {
            for(Map.Entry<String, Boolean> m : question.getCorrectAnswerList().entrySet())
                for(Student s : studentList)
                    if(s.getID().equals(studentID) && question.getCorrectAnswerList().containsKey(answer)) {
                        resetAnswer(s.getStudentAnswers());
                        s.addAnswer(answer, true);
                    }
        }
    }
    // resets answer list booleans back to false
    public void resetAnswer(LinkedHashMap<String, Boolean> answerMap) {
        for(Map.Entry<String, Boolean> m : answerMap.entrySet()) {
            if(m.getValue()) {
                answerMap.put(m.getKey(), false);
                return;
            }
        }
    }
    public void getAnswers() {
        LinkedHashMap<String, Integer> ac = new LinkedHashMap<String, Integer>();
        // initialize to keep the order of map
        for(Map.Entry<String, Boolean> m : question.getCorrectAnswerList().entrySet()) {
            ac.put(m.getKey(), 0);
        }
        for(Student s: studentList) {
            for(Map.Entry<String, Boolean> m : s.getStudentAnswers().entrySet()) {
                //  its already in then increment count
                if(ac.containsKey(m.getKey()) && s.getStudentAnswers().get(m.getKey()))
                    ac.put(m.getKey(), ac.get(m.getKey())+1) ;
            }
        }
        for(Map.Entry<String, Integer> m : ac.entrySet()) 
            System.out.println(m.getKey() + " : " + m.getValue());
    }
}
