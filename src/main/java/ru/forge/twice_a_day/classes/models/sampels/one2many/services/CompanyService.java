package ru.forge.twice_a_day.classes.models.sampels.one2many.services;


import ru.forge.twice_a_day.classes.models.sampels.one2many.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> listAll();
    Company findById(Long id);
    Company save(Company company);
    void delete(Company company);
}
