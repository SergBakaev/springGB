package ru.geekbrains.persist;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Product {

    private Long id;

    @NotBlank
    private String productName;

    @Min(value = 1)
    private Integer cost;

    public Product() {
    }

    public Product(String productName, Integer cost) {
        this.productName = productName;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
