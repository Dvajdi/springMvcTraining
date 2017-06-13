package ru.forge.twice_a_day.classes.models.tort_order;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.forge.twice_a_day.classes.models.tort.TortRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("tortOrderService")
@Transactional
@Repository
public class TortOrderServiceImpl implements TortOrderService{
    @Autowired
    TortOrderRepository tortOrderRepository;

    @PersistenceContext
    EntityManager em;

    @Transactional(readOnly = true)
    public TortOrder findById(Long id) {
        return tortOrderRepository.findOne(id);
    }
    @Transactional(readOnly = true)
    public List<TortOrder> findAll() {
        return Lists.newArrayList(tortOrderRepository.findAll());
    }

    public TortOrder save(TortOrder tortOrder) {
        if(tortOrder.getId()==null){
            em.persist(tortOrder);
        }else{
            em.merge(tortOrder);
        }
        return tortOrder;
    }

    public void delete(TortOrder tortOrder) {
        TortOrder tortOrderMerge = em.merge(tortOrder);
        em.remove(tortOrderMerge);
    }
}
