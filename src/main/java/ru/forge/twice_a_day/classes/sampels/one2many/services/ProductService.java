package ru.forge.twice_a_day.classes.sampels.one2many.services;


import ru.forge.twice_a_day.classes.sampels.one2many.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAll();
    Product findById(Long id);
    Product save(Product product);
    void delete(Product product);



}
