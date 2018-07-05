package SimulationDriver;

import java.util.LinkedHashMap;

class Question {
    private Boolean multipleAnswer; 
    private String questionPrompt;
    private LinkedHashMap<String, Boolean> answerList;  // used a map in case I wanted to make it check for if a user entered a correct answer
    
    public Question(LinkedHashMap<String, Boolean> answers, String question, Boolean answerType) {
        answerList = answers;
        questionPrompt = question;
        multipleAnswer = answerType;
    }
    public Question(String question) {
        questionPrompt = question;
    }
    public Boolean isMultipleAnswer() {
        return multipleAnswer;
    }
    public void setAnswerType(Boolean x) {
        multipleAnswer = x;
    }
    public String getQuestion() {
        return questionPrompt;
    }
    public void setQuestion(String x) {
        questionPrompt = x;
    }
    public LinkedHashMap<String, Boolean> getCorrectAnswerList() {
        return answerList;
    }
    public void addAnswer(String x, Boolean y) {
        if(answerList == null)
            answerList = new LinkedHashMap<String, Boolean>();
        answerList.put(x, y);
    }
}

