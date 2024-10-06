import java.util.ArrayList;

public class  Lesson {

    private String _lessonName;
    private String _lessonCode;
    private ArrayList<Student> _students;
    private ArrayList<String> _exams;

    public Lesson(String lessonName, String lessonCode, ArrayList<Student> students) {
        _lessonName = lessonName;
        _lessonCode = lessonCode;
        _students = students;
        _exams = new ArrayList<String>();
    }
}
