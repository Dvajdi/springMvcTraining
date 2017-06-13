package ru.forge.twice_a_day.classes.models.one2many.servicesImpl;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.forge.twice_a_day.classes.models.one2many.model.Product;
import ru.forge.twice_a_day.classes.models.one2many.repository.ProductRepository;
import ru.forge.twice_a_day.classes.models.one2many.services.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("productService")
@Transactional
@Repository
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @PersistenceContext
    EntityManager em;


    @Override
    public List<Product> listAll() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product save(Product product) {
        if(product.getId()==null){
            em.persist(product);
        }else{
            em.merge(product);
        }
        return product;
    }
}
