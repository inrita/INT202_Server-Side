package sit.int202.simple.simple.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.simple.simple.entities.Subject;
import sit.int202.simple.simple.repositories.SubjectRepository;

import java.io.IOException;
import java.util.List;

// สร้าง controller โดยการใช้ Servlet

@WebServlet(name = "SubjectListServlet", value = "/SubjectList")
public class SubjectListServlet extends HttpServlet {
        private long startTime;
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                List<Subject> subjects = new SubjectRepository().findAll();
                // new SubjectRepository() -> new object ที่ทำการสร้างไว้ใน SubjectRepository
                // .findAll(); -> return มาเป็น list แล้วเก็บไว้ใน subjects

                request.setAttribute("subjects", subjects);
                // request.setAttribute -> คือ data ต่างๆ ที่เราอยากจะใส่ใน request ต่อไปให้ JSP

                request.getRequestDispatcher("/subjects_listing.jsp").forward(request, response);
                // request.getRequestDispatcher -> object ที่ใช้ในการส่งข้อมูลข้าม page ไปแสดงผลยัง JSP
                // forward(request, response); -> ต้องส่งไปทั้ง request เพราะ มีของแชร์ร่วมกับ JSP ด้วย
                //                                          response เพราะ JSP ใช้ response ในการเขียน
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        public void destroy() {
                System.out.println("This servlet life time is" +
                        (System.currentTimeMillis() - startTime) + " milliseconds");
        }

        @Override
        public void init() throws ServletException {
                startTime = System.currentTimeMillis();
                // จำเวลา ณ ตอนที่มันเกิดเอาไว้
                // 1000ms = 1s
        }
}