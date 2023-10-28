package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.CourseRegistered;
import sit.int202.register.models.CourseRepository;
import sit.int202.register.models.Semester;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CourseListServlet", value = "/course_list")
public class CourseListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ทำ Application scope เป็น object ของ ServletContext ถ้าอยากได้ ServletContext ก็ต้อง getServletContext()
        ServletContext sc = getServletContext();
        if (sc.getAttribute("semesters") == null) { // ตอนแรกอยู่ใน request scope แต่ตอนนี้เปลี่ยนเป็น Application scope -> ไม่เคยมีมาก่อน
            sc.setAttribute("semesters", Semester.getAllSemesterText()); // อ้างด้วย sc เก็บใน ServletContext
            // servlet ตัวไหนเข้ามาก็เห็นหมดแชร์กันทั้งแอป เพราะเป็น Application scope
        }
        getServletContext().getRequestDispatcher("/course_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        request.setCharacterEncoding("UTF-8");
        if (parameterMap.get("semester") == null) {
            doGet(request,response);
            return;
        }
        int semester = Integer.valueOf(parameterMap.get("semester")[0]);
//      request.setAttribute("semesters", Semester.getAllSemesterText()); สร้าง Application scope ที่ด้านบนแล้วไม่ต้องสร้างอีกเพราะมันแชร์กันทั้งแอป
        request.setAttribute("selectedSemester", semester);
        request.setAttribute("subjects", CourseRepository.getSubjects(semester));
        if(request.getSession(false) != null && request.getSession(false).getAttribute("courseRegistered") != null) {
            request.setAttribute("semesterRegistered",
                    ((CourseRegistered) request.getSession()
                            .getAttribute("courseRegistered"))
                            .getRegisteredCourseMap(semester));
        }
        getServletContext().getRequestDispatcher("/course_list.jsp").forward(request,response);
    }
}
