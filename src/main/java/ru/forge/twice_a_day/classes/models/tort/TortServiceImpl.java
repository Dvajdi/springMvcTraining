package ru.forge.twice_a_day.classes.models.tort;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("tortService")
@Transactional
@Repository
public class TortServiceImpl implements TortService {
  @Autowired
  TortRepository tortRepository;

  @PersistenceContext
  private EntityManager em;

  @Transactional(readOnly=true)
  public Tort findById(Long id) {
    return tortRepository.findOne(id);
  }

  @Transactional(readOnly = true)
  public List<Tort> findAllTorts() {
    return Lists.newArrayList(tortRepository.findAll());
  }

  public Tort save(Tort tort) {
    if(tort.getId() == null){
      em.persist(tort);
    }else{
      em.merge(tort);
    }
    return null;
  }

  public void deleteTort(Tort tort) {
    Tort mergeTort = em.merge(tort);
    em.remove(mergeTort);
  }
}
