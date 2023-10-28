package sit.int202.simple.simple.entities;

import lombok.*;

// สร้าง Model เพื่อเก็บข้อมูลรายวิชา
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Subject {
    private String id;
    private String title;
    private double credit;
}
