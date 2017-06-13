package ru.forge.twice_a_day.classes.models.one2many.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.forge.twice_a_day.classes.models.one2many.model.Company;


public interface CompanyRepository extends JpaRepository<Company, Long>{
}