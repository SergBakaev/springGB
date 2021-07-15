package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Product;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductDao {



    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

//        em.getTransaction().begin();
//
//        List.of(
//                new Product(null, "Молоко", 18),
//                new Product(null, "Хлеб", 24),
//                new Product(null, "Сыр", 57)
//        ).forEach(em::persist);
//
//        em.getTransaction().commit();

//        1 Product (Product findById(Long id)
            em.find(Product.class,4L );

//        2 List"Product" findAll()
            List<Product> products = em.createQuery("select u from Product u", Product.class)
                    .getResultList();
        System.out.println(products);

//        3 void deleteById(Long id)
            em.getTransaction().begin();
//            em.createQuery("delete Product u where id = 2");
            Product product= em.find(Product.class, 1L);
            em.remove(product);
            em.getTransaction().commit();



//       4  Product saveOrUpdate(Product product))
            em.getTransaction().begin();
            em.createQuery("update Product set price = 25 where id = 1")
                    .executeUpdate();
            em.createQuery("update  Product set title = 'Яйца' where  id = 2")
                    .executeUpdate();
            em.getTransaction().commit();






        em.close();

}

}
