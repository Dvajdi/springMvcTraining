package ru.forge.twice_a_day.classes.models.one2many.servicesImpl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.forge.twice_a_day.classes.models.one2many.model.Company;
import ru.forge.twice_a_day.classes.models.one2many.repository.CompanyRepository;
import ru.forge.twice_a_day.classes.models.one2many.services.CompanyService;

import java.util.List;

@Service("companyService")
@Transactional
@Repository
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> listAll() {
        return Lists.newArrayList(companyRepository.findAll());
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findOne(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
