package servicesTest;

import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import ru.forge.twice_a_day.classes.models.sampels.one2many.model.Company;
import ru.forge.twice_a_day.classes.models.sampels.one2many.services.CompanyService;
import ru.forge.twice_a_day.classes.myUtils.ContextUtils;
import ru.forge.twice_a_day.classes.myUtils.PrintUtils;

import java.util.List;


public class CompanyServiceTest implements BaseServiceTest{

    @Override
    @Test
    public void listTest() {
        ApplicationContext ctx = ContextUtils.getContext();
        CompanyService companyService = ctx.getBean("companyService",CompanyService.class);
        List<Company> companies = companyService.listAll();
        PrintUtils.listEntities(companies);

    }

    @Override
    @Test
    public void saveTest() {
        ApplicationContext ctx = ContextUtils.getContext();
        CompanyService companyService = ctx.getBean("companyService",CompanyService.class);

        List<Company> companies = companyService.listAll();
        int companyQuantity = companies.size();

        Company company = new Company("Магазин");
        companyService.save(company);

        Assert.assertTrue(companyQuantity<companyService.listAll().size());
    }

    @Override
    @Test
    public void deleteTest() {
        ApplicationContext ctx = ContextUtils.getContext();
        CompanyService companyService = ctx.getBean("companyService",CompanyService.class);
        List<Company> companies = companyService.listAll();
        int companyQuantity = companies.size();
        PrintUtils.listEntities(companies);
        Company company = companies.get(companies.size()-1);
        companyService.delete(company);
        PrintUtils.listEntities(companyService.listAll());
        Assert.assertTrue(companyQuantity>companyService.listAll().size());
    }
}
