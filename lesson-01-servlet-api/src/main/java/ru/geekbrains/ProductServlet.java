package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
       productRepository = (ProductRepository)getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Product> products = productRepository.findAll();

       resp.getWriter().println("<table border=\"1\">");
       resp.getWriter().println("<caption><h1>Products list</h1></caption>");
            for(Product s : products){
                resp.getWriter().println("<tr><td>" + s.getId() + "</td><td>" + s.getName() + "</td><td>" + s.getCost() + "</td></tr>");

            }

       resp.getWriter().println("</table>");
    }
}
