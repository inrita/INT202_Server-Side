/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int202.register.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Khaitong Lim
 */
public class CourseRegistered {
    private Map<Integer, List<Subject>> registeredSubjects = new HashMap<>();

    public void registerSubject(int semester, Subject subject) {
        if (registeredSubjects.get(semester)==null) {
            registeredSubjects.put(semester, new ArrayList<>());
        }
        registeredSubjects.get(semester).add(subject);
    }
    public void removeAllRegisteredCourse(int semester) {
        registeredSubjects.remove(semester);
    }
    //  เอาไว้ลบทิ้งเป็นเทอมๆ
    public void removeAllRegisteredCourse() {
        registeredSubjects.clear();
    }
    //  เอาไว้ลบทิ้งทั้ง Map เลยเพราะไม่ได้ใส่ parameter ระบุ
    public List<Subject> getRegisteredCourse(int semester) {
        return registeredSubjects.get(semester);
    }
    // โชว์ข้อมูลเป็นเทอมๆ ที่ลงทะเบียนไว้
    public Map<Integer, List<Subject>> getHistory() {
        return registeredSubjects;
    }
    // โชว์ข้อมูลทั้ง Map เลยว่าลงทะเบียนข้อมูลอะไรไปบ้าง

    public Map<String, String> getRegisteredCourseMap(int semester) {
        Map<String, String> tmp = new HashMap<>();
        registeredSubjects.get(semester).forEach(s -> tmp.put(s.getSubjectId(), "checked"));
        return tmp;
    }
    // เพิ่ม method นี้ขึ้นมาเพื่อตรวจสอบว่าเราได้เช็คเลือกรายวิชานี้ไปแล้ว
}
