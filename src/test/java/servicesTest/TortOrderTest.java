package servicesTest;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import ru.forge.twice_a_day.classes.models.contact.Contact;
import ru.forge.twice_a_day.classes.models.contact.ContactService;
import ru.forge.twice_a_day.classes.models.tort_order.TortOrder;
import ru.forge.twice_a_day.classes.models.tort_order.TortOrderService;
import ru.forge.twice_a_day.classes.myUtils.ContextUtils;
import ru.forge.twice_a_day.classes.myUtils.PrintUtils;

import java.util.List;


public class TortOrderTest {
    @Test
    public void checkCreateTortOrderService(){
        TortOrderService tortOrderService =
                (TortOrderService) ContextUtils.getService("tortOrderService");
        List<TortOrder> orders = tortOrderService.findAll();
        System.out.println(orders.get(0));
        //PrintUtils.listEntities(orders);
        //Assert.assertTrue(orders.size()!=0);
    }

    @Test
    public void contactSaveTest(){
        TortOrderService tortOrderService = ContextUtils.getContext().getBean("tortOrderService",TortOrderService.class);
        List<TortOrder> orders = tortOrderService.findAll();
        int ordersQuantity = orders.size();

        TortOrder tortOrder = new TortOrder();
        tortOrder.setOps("ghghgh");

        tortOrderService.save(tortOrder);
        Assert.assertTrue(ordersQuantity<tortOrderService.findAll().size());
    }

    @Test
    public void deleteTortTest(){
        TortOrderService tortOrderService = ContextUtils.getContext().getBean("tortOrderService",TortOrderService.class);
        List<TortOrder> orders = tortOrderService.findAll();
        int ordersQuantity = orders.size();

        PrintUtils.listEntities(orders);
        TortOrder tortOrder = orders.get(ordersQuantity-1);

        System.out.println(tortOrder);
        tortOrderService.delete(tortOrder);


        Assert.assertTrue(ordersQuantity-tortOrderService.findAll().size()==1);
    }

}
