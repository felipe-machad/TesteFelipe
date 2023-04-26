package verifica.java;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "verifica", urlPatterns = {"/verifica.java"})
public class verifica extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String user= request.getParameter("user");
        String pass= request.getParameter("pass");
        
        String userDb = "teste@gmail.com";
        String passDb = "teste";
        
        if (user.equals(userDb) && pass.equals(passDb)) {
            request.setAttribute("userName", user);
            request.getRequestDispatcher("home.jsp").forward(request, response);

        } else{
            PrintWriter out = response.getWriter();
            out.print(
                    "<script>"
                    +"alert('Acesso negado');"
                    +"window.location.replace('index.html');"
                    +"</script>"
            );
        }
        
        
        try (PrintWriter out = response.getWriter()) {
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet verifica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet verifica at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
