/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package quan.dev;

import quan.dev.data.dao.CategoryDao;
import quan.dev.data.dao.Database;
import quan.dev.data.dao.DatabaseDao;
import quan.dev.data.dao.ProductDao;
import quan.dev.data.model.Category;
import quan.dev.data.model.Product;
import quan.dev.util.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ASUS
 */

public class HomeServlet extends BaseServlet {

  //trang cotroller
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        //nhung sp noi bat va lam viec voi san pham
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> hotProductList = productDao.hot(Constants.NUMBER_LIMIT);
        List<Product> newsProductList = productDao.news(Constants.NUMBER_LIMIT);
        request.setAttribute("hotProductList", hotProductList);
        request.setAttribute("newsProductList", newsProductList);
        request.getRequestDispatcher("home.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    

}
