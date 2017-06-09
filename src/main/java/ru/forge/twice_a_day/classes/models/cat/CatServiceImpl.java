package ru.forge.twice_a_day.classes.models.cat;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("catService")
@Transactional
@Repository
public class CatServiceImpl implements CatService {

    @Autowired
    private CatRepository catRepository;

    @Transactional(readOnly = true)
    public List<Cat> findAll() {
        return Lists.newArrayList(catRepository.findAll());
    }
}
