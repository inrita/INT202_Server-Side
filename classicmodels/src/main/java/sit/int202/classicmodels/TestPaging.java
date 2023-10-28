package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Employee;

import java.util.List;
import java.util.Scanner;

// 3) การทำ Paging คือการ select ข้อมูลมาทีละช่วงๆ

public class TestPaging {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("classic-models");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EMPLOYEE.FINDALL");
        int start = 0; // เริ่มที่ 0 (record แรกที่ 0)
        int pageSize = 5; // ดึงมาทีละ 5 รายการ
        query.setMaxResults(pageSize); // จำนวน record ที่มากที่สุดที่เราจะดึงมา
        while (true) {
            query.setFirstResult(start);
            List<Employee> employees = query.getResultList(); // ได้ข้อมูลทั้งหมดมาเป็น list
            if (employees.isEmpty()) {
                break; // ถ้าดึงข้อมูลมาหมดแล้วให้ทำการ break
            }
            // แต่ถ้ายังดึงข้อมูลมาไม่หมดก็ให้ทำต่อตามนี้
            start = start + pageSize; // 4 + 5 = 9, 9 + 5 = 14, ..... จนครบข้อมูลในตาราง
            displayEmployees(employees);
            System.out.print("Press x then ENTER to view next page ...");
            new Scanner(System.in).nextLine();
        }
        em.close();
    }

    private  static void displayEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.printf("%12d %-10s %-12s %-20s\n",
                    employee.getId(), employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle());
        }
        System.out.println("------------------------");
    }
}



