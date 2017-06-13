package ru.forge.twice_a_day.classes.models.one2one.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.forge.twice_a_day.classes.models.one2one.model.Wife;
import ru.forge.twice_a_day.classes.models.one2one.repository.WifeRepository;
import ru.forge.twice_a_day.classes.models.one2one.services.WifeService;

import java.util.List;

@Service("wifeService")
@Transactional
@Repository
public class WifeServiceImpl implements WifeService{
    @Autowired
    WifeRepository wifeRepository;

    public List<Wife> listAll() {
        return wifeRepository.findAll();
    }
}
