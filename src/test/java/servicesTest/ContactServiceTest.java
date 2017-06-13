package servicesTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import ru.forge.twice_a_day.classes.models.contact.Contact;
import ru.forge.twice_a_day.classes.models.contact.ContactService;
import ru.forge.twice_a_day.classes.models.tort.Tort;
import ru.forge.twice_a_day.classes.models.tort.TortService;
import ru.forge.twice_a_day.classes.myUtils.ContextUtils;
import ru.forge.twice_a_day.classes.myUtils.PrintUtils;


import java.util.List;

public class ContactServiceTest {

    @Test
    public void checkCreateContactService(){
        ContactService contactService = ContextUtils.getContext().getBean("contactService",ContactService.class);
        List<Contact> contacts = contactService.findAllContacts();
        PrintUtils.listEntities(contacts);
        Assert.assertTrue(contacts.size()!=0);
    }

    @Test
    public void contactSaveTest(){
        ContactService contactService = ContextUtils.getContext().getBean("contactService",ContactService.class);
        List<Contact> contacts = contactService.findAllContacts();
        int contactsQuantity = contacts.size();

        Contact contact = new Contact();
        contact.setFirstName("Pavel");
        contact.setLastName("MMMMM");
        contactService.save(contact);
        Assert.assertTrue(contactsQuantity<contactService.findAllContacts().size());
    }

    @Test
    public void deleteContactTest(){
        ContactService contactService = ContextUtils.getContext().getBean("contactService",ContactService.class);
        List<Contact> contacts = contactService.findAllContacts();
        int contactsQuantity = contacts.size();

        Contact contact = contacts.get(contactsQuantity-1);
        contactService.delete(contact);

        Assert.assertTrue(contactsQuantity-contactService.findAllContacts().size()==1);
    }






}
