import org.springframework.context.support.GenericXmlApplicationContext;
import ru.forge.twice_a_day.classes.models.contact.Contact;
import ru.forge.twice_a_day.classes.models.contact.ContactService;

import java.util.List;


public class startTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/spring-data.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("contactService",ContactService.class);

        List<Contact> contacts = contactService.findAllContacts();
        for (int i = 0; i <contacts.size() ; i++) {
            System.out.println(contacts.get(i));
        }
    }

}
