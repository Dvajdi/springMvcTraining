package ru.forge.twice_a_day.classes.models.one2one;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.forge.twice_a_day.classes.models.one2one.model.Husband;
import ru.forge.twice_a_day.classes.models.one2one.model.Wife;
import ru.forge.twice_a_day.classes.models.one2one.services.HusbandService;
import ru.forge.twice_a_day.classes.models.one2one.services.WifeService;

import java.util.List;


public class Go {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/spring-data.xml");
        ctx.refresh();

        WifeService wifeService = ctx.getBean("wifeService", WifeService.class);
        List<Wife> wifes = wifeService.listAll();
        for(Wife wife:wifes){
            System.out.println(wife);
        }

        HusbandService husbandService = ctx.getBean("husbandService",HusbandService.class);
        List<Husband> husbands = husbandService.listAll();

        for(Husband husband:husbands){
            System.out.println(husband);
        }
    }
}
