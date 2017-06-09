package ru.forge.twice_a_day.classes.models.contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ContactService {
    List<Contact> findAllContacts();
    Contact findById(Long id);
    Contact save(Contact contact);
    Page<Contact> findAllByPage(Pageable pageable);

}
