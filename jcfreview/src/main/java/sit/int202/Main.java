package sit.int202;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1090, "Inrita", 4.00);
        System.out.println(student.getName());
        System.out.println(student);
        String[] s = {"Inrita", "Warittinan"};
        for (String x : s) {
            System.out.println(x);
        }
    }
}
