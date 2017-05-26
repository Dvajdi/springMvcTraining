package ru.forge.twice_a_day.classes.models.contact;

import java.util.List;


public interface ContactService {
    List<Contact> findAllContacts();
    Contact findById(Long id);
    void save(Contact contact);
}
