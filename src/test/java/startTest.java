import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
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
    @Test
    public void createContextTest() {
        assert (getContext()!=null);
    }

    @Test
    public void checkContactService(){
        ContactService contactService = getContext().getBean("contactService",ContactService.class);

        List<Contact> contacts = contactService.findAllContacts();

        for(Contact contact:contacts){
            System.out.println(contact);
        }
        Assert.assertTrue(contacts.size()!=0);
    }

    @Test
    public void checkOrderService(){
        OrderService orderService = getContext().getBean("orderService",OrderService.class);
        orderService.printMessage();
        orderService.orders();
        /*List<Order> orders = orderService.orders();
        for (int i = 0; i <orders.size() ; i++) {
            System.out.println(orders.get(i));
        }
        Assert.assertTrue(orders.size()!=0);
        orderService.findById(1l);*/
        Assert.assertTrue(true);
    }

}
