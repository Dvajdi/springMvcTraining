package ru.forge.twice_a_day.classes.models.one2many.servicesImpl;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.forge.twice_a_day.classes.models.one2many.model.Product;
import ru.forge.twice_a_day.classes.models.one2many.repository.ProductRepository;
import ru.forge.twice_a_day.classes.models.one2many.services.ProductService;

import java.util.List;

@Service("productService")
@Transactional
@Repository
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> listAll() {
        return Lists.newArrayList(productRepository.findAll());
    }
}
