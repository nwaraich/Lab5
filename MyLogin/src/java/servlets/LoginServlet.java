
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

public class LoginServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String Logout = request.getParameter("logout");
        
 
        // logout redirect to login page
        if (Logout != null){
            
            
            //invalidates session
            session.invalidate();
            
            
            //setting successful logout message
            String Message = "You have Successfully logged out";
            request.setAttribute("message", Message);
            
            //returning to login page
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        

        // load JSP
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
     
        String username = request.getParameter("u_username");
        String password = request.getParameter("p_password");
        
        if (username == null || username.equals("") || password.equals("") || password == null) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            
            //setting return message
            String Message = "Enter a username and password";
            request.setAttribute("message",Message);
    
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           
        }
            
        
        AccountService aser = new AccountService();
        
        if (aser.login(username,password) != null ){
            session.setAttribute("username",username);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            String message = "Authenication Failed! Please enter correct login information";
            request.setAttribute("message", message);
        }
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }
}
