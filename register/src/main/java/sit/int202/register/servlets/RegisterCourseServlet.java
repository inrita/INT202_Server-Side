package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.CourseRegistered;
import sit.int202.register.models.CourseRepository;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "RegisterCourseServlet", value = "/register")
public class RegisterCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // เขียนใน doPost เพราะ ใน course_list.jsp (view) เป็น method post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        int semester = Integer.valueOf(parameterMap.get("semester")[0]);

        HttpSession session = request.getSession(); //ส่ง Parameter ว่าง = True -> ถ้าไม่มี session มันจะ new seesion ใหม่ให้
        // submit form ครั้งแรกต้องสร้าง session ใหม่ให้เรา (ตะกร้าเปล่า) -> แต่ครั้งต่อมาไม่ต้องใช้ session อันเก่า
        CourseRegistered courseRegistered = (CourseRegistered) session.getAttribute("courseRegistered"); // ไปดึงข้อมูล session.getAttribute("courseRegistered") มาใส่ในตะกร้า
        if(courseRegistered == null) { // seesion พึ่งเกิดเลยได้ null
            courseRegistered = new CourseRegistered(); // สร้าง object -> courseRegistered เพื่อเก็บข้อมูล
            session.setAttribute("courseRegistered", courseRegistered); // เอาข้อมูล (Model) ใส่ตะกร้าเอาไว้
        } else {
            courseRegistered.removeAllRegisteredCourse(semester);
            // remove ของเก่า return การลงทะเบียนใหม่แทน
        }

        // ไป loop เพื่อจะได้รายชื่อวิชาทั้งหมดขึ้นมา get ทีละ value -> array
        for(String subjectId : parameterMap.get("registeredSubjects")) {
            courseRegistered.registerSubject(semester, CourseRepository.getSubject(semester,subjectId));
        }
        System.out.println(courseRegistered.getHistory()); // สั่งปริ้นดูข้อมูลที่ลงทะเบียนรายวิชาไว้ (เก็บเป็น Map)
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
