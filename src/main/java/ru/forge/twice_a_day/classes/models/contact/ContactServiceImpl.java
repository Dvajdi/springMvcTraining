package ru.forge.twice_a_day.classes.models.contact;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Contact> findAllContacts() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    public Contact save(Contact contact) {
        if(contact.getId()==null){
            em.persist(contact);
        }else{
            em.merge(contact);
        }
        return contact;
    }

    public void delete(Contact contact) {
        Contact contactMerge = em.merge(contact);
        em.remove(contactMerge);
    }


    @Transactional(readOnly = true)
    public Page<Contact> findAllByPage(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }




}
