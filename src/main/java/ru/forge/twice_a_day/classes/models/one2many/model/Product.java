package ru.forge.twice_a_day.classes.models.one2many.model;

import javax.persistence.*;

import org.json.JSONObject;

import java.io.Serializable;

@Entity
@Table(name="product")
public class Product implements Serializable{
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    public Product(){
    }
    
    public Product(String name){
    	this.name = name;
    }
    
    public Product(String name, Company company){
    	this.name = name;
    	this.company = company;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // products
    public void setCompany(Company company){
    	this.company = company;
    }
    
    public Company getCompany(){
    	return this.company;
    }
    
    public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONObject companyObj = new JSONObject();
        companyObj.put("name", this.company.getName());
        jsonInfo.put("company", companyObj);
        
        info = jsonInfo.toString();
        return info;
    }
}
