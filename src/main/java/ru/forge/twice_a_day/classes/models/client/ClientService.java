package ru.forge.twice_a_day.classes.models.client;

import java.util.List;

/**
 * Created by twice on 14.06.17.
 */
public interface ClientService {
    Client findById(Long id);
    List<Client> findAll();
    Client save(Client client);
    void delete(Client client);
}
