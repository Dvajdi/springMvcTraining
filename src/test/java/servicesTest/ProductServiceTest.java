package servicesTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.forge.twice_a_day.classes.models.sampels.one2many.model.Product;
import ru.forge.twice_a_day.classes.models.sampels.one2many.services.ProductService;
import ru.forge.twice_a_day.classes.myUtils.ContextUtils;
import ru.forge.twice_a_day.classes.myUtils.PrintUtils;

import java.util.List;


public class ProductServiceTest implements BaseServiceTest {


    @Override
    @Test
    public void listTest() {
        ProductService productService =
                (ProductService) ContextUtils.getService("productService");
        PrintUtils.listEntities(productService.listAll());

    }

    @Override
    @Test
    public void saveTest() {
        ProductService productService =
                (ProductService) ContextUtils.getService("productService");

        int productsQuantity = productService.listAll().size();
        Product product = new Product("Что-то");
        productService.save(product);
        Assert.assertTrue(productsQuantity<productService.listAll().size());
        PrintUtils.listEntities(productService.listAll());
    }

    @Override
    @Test
    public void deleteTest() {
        ProductService productService =
                (ProductService) ContextUtils.getService("productService");
        List<Product> products = productService.listAll();
        int productsQuantity = products.size();
        Product product = products.get(productsQuantity-1);
        productService.delete(product);
        Assert.assertTrue(productsQuantity>productService.listAll().size());
    }
}
