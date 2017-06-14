package servicesTest;

import org.junit.Assert;

import org.junit.Test;
import ru.forge.twice_a_day.classes.models.client.Client;
import ru.forge.twice_a_day.classes.models.client.ClientService;
import ru.forge.twice_a_day.classes.myUtils.ContextUtils;
import ru.forge.twice_a_day.classes.myUtils.PrintUtils;

import java.util.List;


public class ClientServiceTest {
    @Test
    public void findAllTest(){
        ClientService clientService = ContextUtils.getContext().getBean("clientService",ClientService.class);
        List<Client> clients = clientService.findAll();
        PrintUtils.listEntities(clients);
        Assert.assertTrue(clients.size()!=0);
    }


}
