package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // เพื้อให้พิมข้อมูลออกมาให้

@Entity
@Table(name = "employees")
@NamedQueries(
        @NamedQuery(name = "EMPLOYEE.FINDALL", query = "select e from Employee e")
)

public class Employee {
    @Id // มี employeeNumber -> id เป็น PK
    @Column (name = "employeeNumber", nullable = false) // เปลี่ยนชื่อ attribute
    private Integer id;
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
}


