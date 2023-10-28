package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.Semester;

import java.io.IOException;

@WebServlet(name = "CourseRegisterHistoryServlet", value = "/course-registered-history")
public class CourseRegisterHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); //ส่ง Parameter false -> ถ้าไม่เคยลงทะเบียนมาก่อนก็ไม่ต้องสร้าง session ใหม่ให้ต้องให้เขากลับไปลงทะเบียนมาก่อน
        if (session == null || session.getAttribute("courseRegistered") == null) {
            request.setAttribute("message", "ไม่มีข้อมูล การลงทะเบียน ขอให้ลงทะเบียนก่อน");
//        } else {
//            request.setAttribute("semester", Semester.getAllSemesterText()); //ให้แสดงชื่อภาค/ปีการศึกษา
            // ข้อมูล semester สามารถเอาไปใส่ใน Applicatiopn scope ได้เพราะข้อมูลเหมือนกัน
            // สร้าง Application scope แล้วไม่ต้องสร้างอีกเพราะมันแชร์กันทั้งแอป (อยู่ใน CourseListServlet)
        }
        getServletContext().getRequestDispatcher("/user_registered.jsp").forward(request,response);
        // แต่ถ้าลงทะเบียนแล้วก็ให้ forward ไปที่ user_registered.jsp เพื่อแสดงผลบน browser
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
