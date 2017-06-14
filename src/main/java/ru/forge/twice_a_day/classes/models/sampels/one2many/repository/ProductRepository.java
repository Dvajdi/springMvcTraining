package ru.forge.twice_a_day.classes.models.sampels.one2many.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.forge.twice_a_day.classes.models.sampels.one2many.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}