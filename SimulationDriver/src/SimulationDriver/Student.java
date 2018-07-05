package SimulationDriver;
import java.util.LinkedHashMap;

public class Student {
    private String uniqueID;
    private LinkedHashMap<String, Boolean> studentAnswers; // right = true, wrong = false
    
    public Student(String id) {
        uniqueID = id;
    }
    public String getUniqueID() {
        return uniqueID;
    }
    public void setUniqueID(String x) {
        uniqueID = x;
    }
    public String getID() {
        return uniqueID;
    }
    public void setID(String x) {
        uniqueID = x;
    }
    public LinkedHashMap<String, Boolean> getStudentAnswers() {
        return studentAnswers;
    }
    public void addAnswer(String x, Boolean y) {
        if(studentAnswers == null)
            studentAnswers = new LinkedHashMap<String, Boolean>();
        studentAnswers.put(x, y);
    }
}
