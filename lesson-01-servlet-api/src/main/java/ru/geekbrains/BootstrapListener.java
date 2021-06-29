package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        ProductRepository productRepository = new ProductRepository();
        productRepository.save(new Product( 1L,"Product 1", 10));
        productRepository.save(new Product( 2L,"Product 2", 20));
        productRepository.save(new Product( 3L,"Product 3", 50));
        productRepository.save(new Product( 4L,"Product 4", 100));
        productRepository.save(new Product( 5L,"Product 5", 5));
        productRepository.save(new Product( 6L,"Product 6",75));
        productRepository.save(new Product( 7L,"Product 7",68));
        productRepository.save(new Product( 8L,"Product 8",90));
        productRepository.save(new Product( 9L,"Product 9",54));
        productRepository.save(new Product( 10L,"Product 10", 23));

        sc.setAttribute("productRepository", productRepository);
    }
}
