package sit.int202.simple.simple.repositories;

import sit.int202.simple.simple.entities.Subject;

import java.util.ArrayList;
import java.util.List;

// สร้าง Model เพื่อเก็บ object ที่แสดงรายชื่อหลายๆวิชา
public class SubjectRepository {
    private static List<Subject> subjects;

    public static List<Subject> findAll() {
        return subjects;
    }

    public SubjectRepository() {
        subjects = new ArrayList<>(20);
        subjects.add(new Subject("INT 103", "Advanced Programming", 3));
        subjects.add(new Subject("INT 104", "User Experience Desing", 3));
        subjects.add(new Subject("INT 105", "Basic SQL", 3));
        subjects.add(new Subject("INT 107", "Computing Platforms Technology", 3));
        subjects.add(new Subject("INT 200", "Data Structures and Algorithms",1));
        subjects.add(new Subject("GEN 121", "Learning and Problem Solving Skills", 3));
        subjects.add(new Subject("INT 100", "IT Fundamentals", 3));
        subjects.add(new Subject("INT 207", "Network I", 3));
    }
}
