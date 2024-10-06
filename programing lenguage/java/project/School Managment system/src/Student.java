import java.util.ArrayList;
import java.util.HashMap;

public class Student {

    private String _name;
    private int _age;
    private int _id;
    private ArrayList<String> _lesson;
    private HashMap<String,HashMap<String,Integer>> _lessonScore;

    public Student(String name, int age, int id) {
        this._name = name;
        this._age = age;
        this._id = id;
    }

    public void addLesson(String lesson) {
        if (_lesson == null) {
            _lesson = new ArrayList<>();
        }
        _lesson.add(lesson);
    }
}
