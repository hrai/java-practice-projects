
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HelloWorldServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>Hello World</title></head>");
        out.println("<body><h1> Hello World</h1></body>");
        out.println("</html>");
    }
}
