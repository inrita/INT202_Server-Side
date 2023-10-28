package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Office;

// 1) JPA ทดลองคำสั่ง EntityManager API operations
public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("classic-models");
        //System.out.println(emf);
        EntityManager em = emf.createEntityManager();
        //System.out.println(em);
        Office office = em.find(Office.class, "8");
        Employee emp = em.find(Employee.class, 1002);

        if (! emp.getFirstName().equalsIgnoreCase("somchai")) {
            em.getTransaction().begin();
            emp.setFirstName("Somchai");
            em.persist(emp); // save object ลงไปในฐานข้อมูลใหม่ (update)
            em.getTransaction().commit();
        }
        System.out.println(emp);

        if (office != null) {
            System.out.printf("%s %s %s\n", office.getCity(), office.getCountry(), office.getPostalCode()); // หาเจอให้ปริ้นตามข้อมูลนี้ออกมา
        } else {
            System.out.println("Office code does not exist !!!"); // หาไม่เจอปริ้น message นี้
        }

//      วิธธีการอัพเดทข้อมูลในตารางใหม่ เช่น เปลี่ยนชื่อ
//        Office newOffice = new Office();
//        newOffice.setOfficeCode("9"); // เพิ่มเบอร์ 9 เข้ามา
//        newOffice.setAddressLine1(office.getAddressLine1()); // copy ของเดิมมาใส่ใน object ใหม่
//        newOffice.setAddressLine2(office.getAddressLine2()); // copy ของเดิมมาใส่ใน object ใหม่
//        newOffice.setCity("Bangmod"); // เพิ่ม Bangmod เข้ามา
//        newOffice.setCountry("Thailand"); // เพิ่ม Thailand เข้ามา
//        newOffice.setPhone(office.getPhone()); // copy ของเดิมมาใส่ใน object ใหม่
//        newOffice.setPostalCode(office.getPostalCode()); // copy ของเดิมมาใส่ใน object ใหม่
//        newOffice.setState(office.getState()); // copy ของเดิมมาใส่ใน object ใหม่
//        newOffice.setTerritory(office.getTerritory()); // copy ของเดิมมาใส่ใน object ใหม่
//        newOffice.setAddressLine1(office.getAddressLine1());
//        office = em.find(Office.class, "8"); // หา officeCode = 8 มาหน่อยสิ
//        if (office != null) {
//            em.getTransaction().begin(); // เริ่ม
//            em.persist(newOffice); // save object ใหม่ที่สร้างขึ้นมาลงในฐานข้อมูล จะ object ใหม่หรือเก่าก็ใช้คำสั่งนี้เหมือนกัน
//            em.remove(office); // ลบข้อมูลที่สร้างขึ้นมาใหม่ แต่ต้องไปอ้างจากตาราง database เดิม
//            em.getTransaction().commit(); // commit
//        }
        em.close();
    }
}
