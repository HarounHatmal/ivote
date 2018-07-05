package SimulationDriver;

public class SimulationDriver {

    public static void main(String[] args) {
        System.out.println("IVote Service");
        System.out.println("Multiple Choice Question Option");
        String question = "Who is the best WWE wrestler?";
        // multiple choice question 
        IVoteService i = new IVoteService(createStudentArray(), createQuestion(true));
        String one = "1. Kane";
        String two = "2. Undertaker";
        String three = "3. Stone Cold";
        String four = "4. Randy Orton";
        
        i.sendAnswer("Jake", one);
        i.sendAnswer("Kyle", one);
        i.sendAnswer("Kyle", one);
        i.sendAnswer("Jake", two);
        i.sendAnswer("Kyle", three);
        i.sendAnswer("Kyle", four);
        i.sendAnswer("Khloe", four);
        i.sendAnswer("Vince", four);
        i.sendAnswer("Khloe", one);
        i.sendAnswer("Vince", three);
        i.getAnswers();
        
        System.out.println("Single Choice Question Option");
        i = new IVoteService(createStudentArray(), createQuestion(false));      
        i.sendAnswer("Jake", one);
        i.sendAnswer("Kyle", one);
        i.sendAnswer("Kyle", one);
        i.sendAnswer("Jake", two);
        i.sendAnswer("Kyle", three);
        i.sendAnswer("Kyle", four);
        i.sendAnswer("Khloe", four);
        i.sendAnswer("Vince", four);
        i.sendAnswer("Khloe", one);
        i.sendAnswer("Vince", three);
        i.sendAnswer("Vince", four);
        i.getAnswers();
    }
    //  create array size 5 with random IDs
    public static Student[] createStudentArray() {
        Student arr[] = new Student[5];
        arr[0] = new Student("Jake");
        arr[1] = new Student("Kyle");
        arr[2] = new Student("Vince");
        arr[3] = new Student("Khloe");
        arr[4] = new Student("Dennis");
        
        return arr;
    }
    //  true = multiple choice, false = single choice
    public static Question createQuestion(Boolean multipleChoice) {
        String question = "Who is the best WWE wrestler?";
        Question q = new Question(question);
        q.setAnswerType(multipleChoice);
        if(multipleChoice) {
            q.addAnswer("1. Kane", true);
            q.addAnswer("2. Undertaker", true);
            q.addAnswer("3. Stone Cold", true);
            q.addAnswer("4. Randy Orton", true);
        }
        else {
            q.addAnswer("1. Kane", true);
            q.addAnswer("2. Undertaker", true);
            q.addAnswer("3. Stone Cold", true);
            q.addAnswer("4. Randy Orton", true);
        }
        
        return q;
    }
    
    
}
