
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sky
 */
public class HomeServlet extends HttpServlet {

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // creating a session object
        HttpSession session = request.getSession();
        
        //creat an attribute in the session object
        session.setAttribute("sessionAttribute", "this is an attribute in the request object");
        
        //creating an attribute in request - loading welcome message
        request.setAttribute("requestAttribute","Welcome to the home page" );
        
        
        if (session.getAttribute("username") == null ) {
            response.sendRedirect("login");
            return;
        }
        
  
        //loading home.jsp
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        return;
    }

 
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
}
