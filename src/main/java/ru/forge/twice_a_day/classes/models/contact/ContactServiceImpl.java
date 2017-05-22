package ru.forge.twice_a_day.classes.models.contact;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Transactional(readOnly = true)
    public List<Contact> findAllContacts() {
        return Lists.newArrayList(contactRepository.findAll());
    }



}
