package ru.forge.twice_a_day.classes.models.contact;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends PagingAndSortingRepository<Contact,Long> {

}
