package sit.int202;

import java.util.*;

public class ProblemOne {
    public static void main(String[] args) {
//        Student s1= new Student(1090, "Inrita", 4.00);
//        Student s2= new Student(1090, "Inrita", 4.00);
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//        System.out.println(s1.equals(s2));
            // >> False เพราะ method จะ true or false มันขึ้นอยู่กับเรา implement ข้อมูล
            // >> True เพราะ สอง object นี้ HashCode มันเท่ากันแล้ว เนื่องจาก attribute มันเหมือนกันแสดงว่าต้องเป็น object เดียวกัน

        // HashSet
        // When we have 100 students
        Set<Student> studentSet = new HashSet<>(125, 0.75f);
        // default capacity 16, Load Factor 0.75 = 75%
        // มีข้อมูลได้ไม่เกิน 75% เลยต้องสร้างที่เก็บข้อมูลเผื่อไว้
        //Set<Student> studentSet = new HashSet<>(200, 0.5f); // ใส่่ข้อมูลได้แค่ 100 เพราะอีก 100 เผื่อเอาไว้
        //เอาข้อมูลของ Student ใส่ลงไปใน HashSet
        studentSet.add(new Student(10001, "Somsri", 3.25));
        studentSet.add(new Student(10002, "Somsak", 3.00));
        studentSet.add(new Student(10009, "Somchai", 3.26));
        studentSet.add(new Student(10007, "Somsiri", 3.25));
        studentSet.add(new Student(10037, "Sirisopaphan", 3.25));
        for (Student s : studentSet) {
            System.out.println(s+ " -> " + s.hashCode());
        }
        // หัวใจของ Set คือ ข้อมูลห้ามซ้ำ

        // ReHashing
//        Set<Integer> set = new HashSet<>(16, 0.5f);
//        for (int i = 0: i < 8; i++) {
//        }

        // TreeSet : link ข้อมูลได้เรื่อยๆ ไม่มีขนาดหรือข้อจำกัด
        Set<Student> studentSet2 = new TreeSet<>();
        studentSet2.add(new Student(10001, "Somsri", 3.25));
        studentSet2.add(new Student(10002, "Somsak", 3.00));
        studentSet2.add(new Student(10009, "Somchai", 3.26));
        studentSet2.add(new Student(10007, "Somsiri", 3.25));
        studentSet2.add(new Student(10037, "Sirisopaphan", 3.25));

        List<Student> tmp = studentSet.stream().sorted().toList();
        // แปลง studentSet เป็น stream() เพราะจะได้ Byte และแปลงเป็น sorted() แปลงเป็น toList()
        //Collections.sort(tmp);
        System.out.println("------------");
        for (Student s : tmp) {
            System.out.println(s);
        }

        System.out.println("---- Sort by Gpax Desc ----");
        List<Student> studentsSorted = studentSet2.stream().sorted(Student.SORT_BY_GPAX).toList();
        for (Student s : studentsSorted) {
            System.out.println(s+ " " +s.hashCode());
        }

        System.out.println("---- Sort by Name Desc ----");
        studentsSorted = studentSet2.stream().sorted(Student.SORT_BY_NAME).toList();
        for (Student s : studentsSorted) {
            System.out.println(s);
        }
    }
}
