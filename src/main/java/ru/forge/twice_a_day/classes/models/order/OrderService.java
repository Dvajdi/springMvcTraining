package ru.forge.twice_a_day.classes.models.order;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderService {
    List<Order> orders();
    Order save(Order order);
    Order findById(Long id);
    void printMessage();

}
