package ru.forge.twice_a_day.classes.models.one2many.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.forge.twice_a_day.classes.models.one2many.model.Product;

import java.util.List;
import java.util.Set;


public interface ProductRepository extends JpaRepository<Product, Long>{

}