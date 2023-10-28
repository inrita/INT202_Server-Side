package sit.int202.simple.simple;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
// name จะตั้งชื่ออะไรก็ได้
// value เอาไว้เรียก servlet เรียกด้วย URL ตัวนี้ /hello-servlet

public class HelloServlet extends HttpServlet {
    private String message;
    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        String browser = request.getHeader("User-Agent");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1><br>");
        out.println(("Your browser is " + browser));
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
