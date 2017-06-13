package ru.forge.twice_a_day.classes.models.one2one.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="husband")
public class Husband implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToOne(mappedBy = "husband")
	private Wife wife;
	
	public Husband(){}
	
	public Husband(String name){
		this.name = name;
	}
	
	public Husband(int id, String name, Wife wife){
		this.id = id;
		this.name = name;
		this.wife = wife;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setWife(Wife wife){
		this.wife = wife;
	}
	
	public Wife getWife(){
		return this.wife;
	}
	
	public String toString(){
		String info = String.format("Husband: name = %s has a wife with name = %s", this.name, this.wife.getName());
		return info;
	}
}
