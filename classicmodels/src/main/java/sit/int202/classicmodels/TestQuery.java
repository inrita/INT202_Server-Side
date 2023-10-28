package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Office;

import java.util.List;
import java.util.Scanner;

// 2) Creating Queries มี EntityManager เพื่อสร้างตัว Query ขึ้นมาทำตามเงื่อนไขที่เราต้องการจะหา

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("classic-models");
        EntityManager em = emf.createEntityManager();
//        Query query2 = em.createNamedQuery("OFFICE.FIND_ALL");
        Query query = em.createNamedQuery("OFFICE.FIND_BY_COUNTRY");
        System.out.print("Find office by country start with: ");
        String country = new Scanner(System.in).next();
        query.setParameter("countryParam", country+"%"); // country ขึ้นต้นด้วย

        List<Office> offices = query.getResultList(); // ได้ข้อมูลทั้งหมดมาเป็น list
        for (Office office : offices) {
            System.out.printf("(%-2s) %-25s %-15s %-12s\n", // - คือชิดซ้าย
                office.getOfficeCode(), office.getAddressLine1(),
                office.getCity(), office.getCountry());
        }

        System.out.println("-----------------------");

        List<Employee> employees = em.createNamedQuery("EMPLOYEE.FINDALL").getResultList(); // ได้ข้อมูลทั้งหมดมาเป็น list
        for (Employee employee : employees) {
            System.out.printf("%12d %-10s %-12s %-20s\n",
                    employee.getId(), employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle());
        }
        em.close();
    }
}


