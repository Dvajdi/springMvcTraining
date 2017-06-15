package servicesTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.forge.twice_a_day.classes.models.tort.Tort;
import ru.forge.twice_a_day.classes.models.tort.TortService;
import ru.forge.twice_a_day.classes.myUtils.ContextUtils;
import ru.forge.twice_a_day.classes.myUtils.PrintUtils;

import java.util.List;


public class TortServiceTest {


  @Test
  public void checkTortService(){
    TortService tortService = ContextUtils.getContext().getBean("tortService",TortService.class);
    List<Tort> torts = tortService.findAllTorts();
    PrintUtils.listEntities(torts);
    Assert.assertTrue(torts.size()!=0);
  }

  @Test
  public void checkSaveTortService(){
    TortService tortService = ContextUtils.getContext().getBean("tortService",TortService.class);
    int tortQuantity = tortService.findAllTorts().size();

    Tort tort = new Tort();
    tort.setName("Апельсиновый");
    tort.setDescription("Рекомендуем");
    tortService.save(tort);
    Assert.assertTrue(tortService.findAllTorts().size()-tortQuantity==1);
  }

  @Test
  public void  checkDeleteTortService(){
    TortService tortService = ContextUtils.getContext().getBean("tortService",TortService.class);
    List<Tort> torts = tortService.findAllTorts();
    int tortQuantity = torts.size();
    Tort tort = torts.get(tortQuantity-1);

    tortService.deleteTort(tort);

    Assert.assertTrue(tortQuantity-tortService.findAllTorts().size()==1);
  }


}
