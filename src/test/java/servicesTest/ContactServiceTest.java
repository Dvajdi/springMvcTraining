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
    public void checkContactService(){
        ContactService contactService = ContextUtils.getContext().getBean("contactService",ContactService.class);
        List<Contact> contacts = contactService.findAllContacts();
        PrintUtils.listEntities(contacts);
        Assert.assertTrue(contacts.size()!=0);
    }






}
