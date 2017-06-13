package ru.forge.twice_a_day.classes.models.one2many;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.forge.twice_a_day.classes.models.one2many.model.Company;
import ru.forge.twice_a_day.classes.models.one2many.model.Product;
import ru.forge.twice_a_day.classes.models.one2many.services.CompanyService;
import ru.forge.twice_a_day.classes.models.one2many.services.ProductService;

import java.util.List;


public class GoOneToMany {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/spring-data.xml");
        ctx.refresh();

        CompanyService companyService = ctx.getBean("companyService", CompanyService.class);
        List<Company> companies = companyService.listAll();
        for(Company company:companies){
            System.out.println(company);
        }

        companyService.save(new Company("Конторка"));

        ProductService productService = ctx.getBean("productService",ProductService.class);

        Product prod = new Product();
        prod.setName("РЫБА");
        prod.setCompany(companies.get(companies.size()-1));
        productService.save(prod);


        List<Product> products = productService.listAll();
        for(Product product:products){
            System.out.println(product);
        }
    }
}
