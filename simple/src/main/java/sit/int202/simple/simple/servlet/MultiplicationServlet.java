package sit.int202.simple.simple.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Controller

@WebServlet(name = "MultiplicationServlet", value = "/MultiplicationServlet")
public class MultiplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param =  request.getParameter("number");
        if (param == null || ! isNumber(param)) {
            request.setAttribute("message", "Invalid Parameter or No parameter !!!"); // JSP นำ message ไปแสดงเมื่อเป็น false
        }
        request.getRequestDispatcher("/multiplication_table.jsp").forward(request,response);
    }

    // check ตัวเลขที่ส่งมาทีละตัวว่าใช้ตัวเลขมั้ยถ้าใช่ -> isNumber (check ทีละตัว)
    private boolean isNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if(! Character.isDigit((number.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}