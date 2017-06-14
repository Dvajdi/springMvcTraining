package ru.forge.twice_a_day.classes.sampels.one2one.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.forge.twice_a_day.classes.sampels.one2one.model.Husband;

public interface HusbandRepository extends JpaRepository<Husband, Integer> {
}