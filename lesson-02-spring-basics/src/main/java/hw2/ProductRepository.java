package hw2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

  public  ProductRepository(){
        productMap.put(1L, new Product(1L,"молоко", 20)) ;
        productMap.put(2L, new Product(2L,"сып", 20)) ;
        productMap.put(3L, new Product(3L,"яйца", 20)) ;
        productMap.put(4L, new Product(4L,"зефир", 20)) ;
        productMap.put(5L, new Product(5L,"колбаса", 20)) ;
    }

    private final AtomicLong identity = new AtomicLong(0);

    public List<Product> findAll() {

       return new ArrayList<>(productMap.values());

    }

    public Product findById(long id){
        return productMap.get(id);
    }


//    static  {
//        productMap.put(1L, new Product(1L,"молоко", 20)) ;
//        productMap.put(2L, new Product(2L,"молоко", 20)) ;
//        productMap.put(3L, new Product(3L,"молоко", 20)) ;
//        productMap.put(4L, new Product(4L,"молоко", 20)) ;
//        productMap.put(5L, new Product(5L,"молоко", 20)) ;
//
//    }

    public void save(Product product) {
        if (product.getId() == null) {
            long id = identity.incrementAndGet();
            product.setId(id);
        }
        productMap.put(product.getId(), product);

    }
//
//    public void delete(long id) {
//        productMap.remove(id);
//    }


}
