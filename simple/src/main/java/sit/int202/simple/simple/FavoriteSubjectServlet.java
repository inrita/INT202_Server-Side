package sit.int202.simple.simple;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

//ให้สร้าง servlet ที่รับ request จากที่ user ส่งมาได้ (ในที่นี้คือของ favorite_subject)

@WebServlet (name = "FavoriteSubjectServlet", value = "/favoriteSubject")
// name จะตั้งชื่ออะไรก็ได้, value เอาไว้เรียก servlet เรียกด้วย URL ตัวนี้ /favoriteSubject
public class FavoriteSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }


    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String[] favoriteSubject = request.getParameterValues("favorite_subject");

        PrintWriter out = response.getWriter();
        // การแปลง Servlet code
        out.println("<html><body>");
        out.println("<h1>Your Favorite Subject:: </h1><br>");
        out.println("Student Id = " + id + "<br>");
        out.println("Student Name = " + name + "<br>");
        out.println("Favorite Subject : <br>");
        for (String subject : favoriteSubject) {
            out.println(" &nbsp; &nbsp; - " + subject + "<br>");
        }

        // getParameter แบบ method Map
        Map<String, String[]> param = request.getParameterMap();
        out.println("<hr>");
        out.println("<h1>Request Parameter from Map:: </h1><br>");
        out.println("Student Id = " + param.get("id")[0] + "<br>");
        out.println("Student Name = " + param.get("name")[0] + "<br>");
        out.println("Your Favorite Subject:: <br>");
        for (String subject : param.get("favorite_subject")) {
            out.println(" &nbsp; &nbsp; - " + subject + "<br>");
        }
        out.println("</body></html>");
    }
}
