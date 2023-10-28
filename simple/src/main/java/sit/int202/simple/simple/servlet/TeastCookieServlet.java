package sit.int202.simple.simple.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TeastCookieServlet", value = "/test_cookie")
public class TeastCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ถ้าจะทำ cookie ในหน้า test_cookie.jsp ต้องมาทำใน doGet
        // ใช้ for loop หา bgColor ทีละตัว และแสดงผลส่งไปที่หน้า test_cookie.jsp
        Cookie[] cookies = request.getCookies();
        for (Cookie ck : cookies) {
            if(ck.getName().equalsIgnoreCase("bg_cookie")) {
                request.setAttribute("bgColor", ck.getValue());
            }
        }
        request.getRequestDispatcher("/test_cookie.jsp").forward(request, response);
        // บนฝั่ง client เขียนอยู่บน form ไม่ต้องใส่ / เพราะต้องอ้างอิง URL เดิม forword
        // ส่วนฝั่ง server ต้องใส่ / เพื่อ reference server ที่ Application เรา
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // จะดึงตัว bgColor มาเก็บไว้ใน method doPost เพราะเป็น form
        String bgColor = request.getParameter("bg");
        Cookie ck = new Cookie("bg_cookie", bgColor); //สร้าง cookie (value คือ bgColor)
        ck.setMaxAge(8*24*60*60); // เซตอายุให้มัน (วัน*ชม*นาที*วินาที)
        response.addCookie(ck); // ถ้าอยากให้ browser เก็บต้อง add ไปบน response
        request.setAttribute("bgColor", bgColor);
        request.getRequestDispatcher("/test_cookie.jsp").forward(request,response);
        // ดึงตัว bgColor มาเก็บไว้แล้วส่งกลับให้ jsp
    }
}