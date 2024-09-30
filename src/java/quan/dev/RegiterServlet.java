/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package quan.dev;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import quan.dev.data.dao.DatabaseDao;
import quan.dev.data.dao.UserDao;
import quan.dev.data.model.User;


//@WebServlet(name = "AboutServlet", urlPatterns = {"/AboutServlet"})
public class RegiterServlet extends BaseServlet {

   
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        request.getRequestDispatcher("register.jsp").include(request,response);
        
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email= request.getParameter("email");
           String password= request.getParameter("password");
           
           UserDao userDao=DatabaseDao.getInstance().getUserDao();
           User user = userDao.find(email);
           
           if (user != null){
               session.setAttribute("error","Email existed");
               request.getRequestDispatcher("register.jsp").forward(request, response);
           }else {
               user = new User (email,password,"user");
               userDao.insert(user);
               response.sendRedirect("LoginServlet");
                       
           }
        
    }

  

   
}
