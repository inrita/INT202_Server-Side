package sit.int202.simple.simple;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet (name = "EvalGradeServlet", value = "/grade")
// name จะตั้งชื่ออะไรก็ได้, value เอาไว้เรียก servlet เรียกด้วย URL ตัวนี้ /grade
public class EvalGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String score = request.getParameter("score");
        int scoreValue = Integer.valueOf(score);
        String grade = "F";
        String color = "darkblue";
        if (scoreValue >= 80) {
            grade = "A";
        } else if (scoreValue >= 70) {
            grade = "B";
        } else if (scoreValue >= 60) {
            grade = "C";
        } else {
            color = "red";
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Simple Calculate Grade Servlet:: </h1><br>");
        out.println("Your score is = " + score + "<br>");
        out.println("Your grade is <h3 style = 'color :" + color + "'> "+ grade +" </h3><br>");
        out.println("Favorite Subject : <br>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }

}
