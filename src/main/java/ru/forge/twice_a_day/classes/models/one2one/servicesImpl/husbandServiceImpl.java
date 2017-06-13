package ru.forge.twice_a_day.classes.models.one2one.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.forge.twice_a_day.classes.models.one2one.model.Husband;
import ru.forge.twice_a_day.classes.models.one2one.repository.HusbandRepository;
import ru.forge.twice_a_day.classes.models.one2one.services.HusbandService;

import java.util.List;

@Service("husbandService")
@Repository
@Transactional
public class husbandServiceImpl implements HusbandService {
    @Autowired
    HusbandRepository husbandRepository;
    public List<Husband> listAll() {
        return husbandRepository.findAll();
    }
}
