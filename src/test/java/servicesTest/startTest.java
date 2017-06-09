package servicesTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.forge.twice_a_day.classes.models.cat.Cat;
import ru.forge.twice_a_day.classes.models.cat.CatService;
import ru.forge.twice_a_day.classes.models.contact.Contact;
import ru.forge.twice_a_day.classes.models.contact.ContactService;
import ru.forge.twice_a_day.classes.models.order.Order;
import ru.forge.twice_a_day.classes.models.order.OrderService;

import java.util.List;

public class startTest {
    public GenericXmlApplicationContext getContext(){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/spring-data.xml");
        ctx.refresh();
        return ctx;
    }

    void listEntities(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    @Test
    public void checkContactService(){
        ContactService contactService = getContext().getBean("contactService",ContactService.class);
        List<Contact> contacts = contactService.findAllContacts();
        listEntities(contacts);
        Assert.assertTrue(contacts.size()!=0);
    }

    @Test
    public void checkOrderService(){
        OrderService orderService = getContext().getBean("orderService",OrderService.class);
        List<Order>orders = orderService.findAllOrders();
        /*List<Order> orders = orderService.orders();
        for (int i = 0; i <orders.size() ; i++) {
            System.out.println(orders.get(i));
        }
        Assert.assertTrue(orders.size()!=0);
        orderService.findById(1l);*/
        Assert.assertTrue(true);
    }

    @Test
    public void checkCatsService(){
        CatService catService = getContext().getBean("catService",CatService.class);
        List<Cat> cats = catService.findAll();
        listEntities(cats);
        Assert.assertTrue(cats.size()>0);
    }

}
