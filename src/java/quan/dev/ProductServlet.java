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
import quan.dev.data.dao.ProductDao;
import quan.dev.data.model.Product;
import quan.dev.util.Constants;

//@WebServlet(name = "AboutServlet", urlPatterns = {"/AboutServlet"})
public class ProductServlet extends BaseServlet {

   
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId= Integer.parseInt( request.getParameter("productId"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product =productDao.find(productId);
         List<Product> newsProductList = productDao.news(Constants.NUMBER_LIMIT);
         request.setAttribute("newsProductList", newsProductList);
   
        request.setAttribute("product", product);
       
        
        request.getRequestDispatcher("product.jsp").include(request,response);
        
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
