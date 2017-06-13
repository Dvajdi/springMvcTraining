package ru.forge.twice_a_day.classes.models.one2many;
/*

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.jpa.one2many.model.Company;
import com.javasampleapproach.jpa.one2many.model.Product;
import com.javasampleapproach.jpa.one2many.repository.CompanyRepository;
import com.javasampleapproach.jpa.one2many.repository.ProductRepository;


@SpringBootApplication
public class SpringJpaOneToManyRelationshipApplication implements CommandLineRunner{
    
    @Autowired
    CompanyRepository companyRepository;
     
    @Autowired
    ProductRepository productRepository;
 
    public static void main(String[] args) {
    	SpringApplication.run(SpringJpaOneToManyRelationshipApplication.class, args);
    }
 
    
    @Override
    public void run(String... arg0) throws Exception {
    	clearData();
    	saveData();
    	showData();
    }
    
    @Transactional
    private void clearData(){
    	companyRepository.deleteAll();
        productRepository.deleteAll();
    }
    
    @Transactional
    private void saveData(){
    	Product iphone7 = new Product("Iphone 7");
        Product iPadPro = new Product("IPadPro");
        
        Product galaxyJ7 = new Product("GalaxyJ7");
        Product galaxyTabA = new Product("GalaxyTabA");
         
        Company apple = new Company("Apple");
        Company samsung = new Company("Samsung");
        
        // set company for products
        iphone7.setCompany(apple);
        iPadPro.setCompany(apple);
        
        galaxyJ7.setCompany(samsung);
        galaxyTabA.setCompany(samsung);
        
        // save companies
        companyRepository.save(apple);
        companyRepository.save(samsung);
         
        // save products
        productRepository.save(iphone7);
        productRepository.save(iPadPro);
        
        productRepository.save(galaxyJ7);
        productRepository.save(galaxyTabA);
    }
    
    @Transactional
    private void showData(){
    	// get All data
    	List<Company> companyLst = companyRepository.findAll();
        List<Product> productLst = productRepository.findAll();
         
        System.out.println("===================Product List:==================");
        productLst.forEach(System.out::println);
         
        System.out.println("===================Company List:==================");
        companyLst.forEach(System.out::println);
    }
    
}*/
