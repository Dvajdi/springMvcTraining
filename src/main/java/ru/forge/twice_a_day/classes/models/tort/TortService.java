package ru.forge.twice_a_day.classes.models.tort;

import java.util.List;

/**
 * Created by Twice on 12.06.2017.
 */
public interface TortService {
  Tort findById(Long id);
  List<Tort>findAllTorts();
  Tort save(Tort tort);
  void deleteTort(Tort tort);

}
