package hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
@Scope("prototype")
public class Cart {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    public void delete(long id) {
        productMap.remove(id);
    }

    public void add(Product product) {

        productMap.put(product.getId(), product);

    }
    public List<Product> findAll() {

        return new ArrayList<>(productMap.values());

    }
}
