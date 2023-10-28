package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import jdk.jfr.Relational;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
@Table (name = "Offices")
@NamedQueries(
        {
        @NamedQuery(name = "OFFICE.FIND_ALL", query = "select o from Office o"),
        @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY",
                query = "select o from Office o where o.country like :countryParam") // ใส่ : เพื่อบอกให้รู้ว่าเป็น parameter
        }
)

public class Office {
    @Id // มี officeCode เป็น PK
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    @Column (name = "phone") // ชื่อมันตรงกันจะเขียนหรือไม่เขียนก็ได้
    private String phone;
    private String territory;

    // annotation บอกความสัมพันธ์ของ Office กับ Employee
    @OneToMany (mappedBy = "officeCode") // FK
    private List<Employee> employeeList; // class Office มี employee อยู่ข้างใน
                                         // 1 Office มีหลาย employee เก็บเป็น list
}


