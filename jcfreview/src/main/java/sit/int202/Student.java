package sit.int202;

import lombok.*;

import java.util.Comparator;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@EqualsAndHashCode(exclude = {"gpax"}) // เอาแค่ id, name มาเทียบกันไม่เอา gpax

// ProblemOne
public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double gpax;

    // เรียงลำดับตาม GPAX จากมากไปน้อย ถ้า GPAX เท่ากันให้เรียงตามขื่อ
    public static final Comparator<Student> SORT_BY_GPAX = new Comparator<Student>() {
        @Override
        // ตรงนี้เป็น Anonymous inner class  เป็นคลาสที่ไม่มีชื่อ แต่ implement มาจาก Comparator
        // อ้างเก็บไว้ใน SORT_BY_GPAX
        public int compare(Student o1, Student o2) {
            if (o1.getGpax() < o2.getGpax()) {
                return 1;
            } else if (o1.getGpax() > o2.getGpax()) {
                return -1;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }
    }; // ได้ object มาเก็บไว้อยู่ในตัวแปร

    public static final Comparator<Student> SORT_BY_NAME = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };


    // HashCode and Equals ต้องทำทั้งคู่
    // Object เท่ากัน HashCode ก็ต้องเท่ากัน
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(gpax, student.gpax) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gpax);
    }

    @Override
    public int compareTo(Student o) {
        return this.getId() - o.getId();
        // ถ้า this.getId() มันน้อยกว่าตัว object o ที่ส่งมาจะ return เป็นลบ | มากกว่า return เป็นบวก | เท่ากัน return เป็นศูนย์
        // Object ที่จะใส่เข้าไปใน Tree ได้ต้องทำ Comparable
    }
}
