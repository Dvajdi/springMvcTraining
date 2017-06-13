package ru.forge.twice_a_day.classes.models.tort_order;


import java.util.List;

public interface TortOrderService {
    TortOrder findById(Long id);
    List<TortOrder> findAll();
    TortOrder save(TortOrder tortOrder);
    void delete(TortOrder tortOrder);
}
