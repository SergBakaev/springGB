package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private final DaoProduct daoProduct;


    public Service(DaoProduct daoProduct) {
        this.daoProduct = daoProduct;

    }


    private void fillDBProducts(int numbers) {
        List<Product> productList = new ArrayList<>();
        int i = 1;
        while(i <= numbers) {
            productList.add(new Product());
            productList.get(i - 1).setTitle("product_" + i);
            int i1 = i * 10 + i;
            productList.get(i - 1).setPrice(new BigDecimal(i1));
            i++;
        }
    }

}
