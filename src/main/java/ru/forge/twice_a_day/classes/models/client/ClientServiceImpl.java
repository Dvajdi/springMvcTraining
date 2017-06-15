package ru.forge.twice_a_day.classes.models.client;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("clientService")
@Transactional
@Repository
public class ClientServiceImpl implements ClientService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id) {
        return clientRepository.findOne(id);
    }

    public List<Client> findAll() {
        return Lists.newArrayList(clientRepository.findAll());
    }

    public Client save(Client client) {
        if(client.getId()==null){
            em.persist(client);
        }else{
            em.merge(client);
        }
        return client;
    }

    public void delete(Client client) {
        Client mergeClient = em.merge(client);
        em.remove(mergeClient);
    }
}
