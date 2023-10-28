package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Office;

import java.util.List;

// 4) EntityRelationship : บอกความสัมพันธ์ของตาราง Office กับ Employee

public class TestEntityRelationship {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("classic-models");
        EntityManager em = emf.createEntityManager();
        List<Office> officeList = em.createNamedQuery("OFFICE.FIND_ALL").getResultList();
        for (Office office : officeList) { // Office ที่ 1 มีพนักงานกี่คน
            System.out.printf("(%-2s) %-25s %-15s %-12s\n",
                    office.getOfficeCode(), office.getAddressLine1(),
                    office.getCity(), office.getCountry());
            System.out.println("-------------------------------------------------");
            for (Employee employee : office.getEmployeeList()) { // มีพนักงานกี่คนใน Office นั้น
                System.out.printf("%12d %-10s %-12s %-20s\n",
                        employee.getId(), employee.getFirstName(),
                        employee.getLastName(), employee.getJobTitle());
            }
            System.out.println("\n");
        }
        em.close(); // ทำงานเสร็จสั่งปิด
    }
}


