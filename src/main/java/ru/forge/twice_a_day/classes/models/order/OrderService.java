package ru.forge.twice_a_day.classes.models.order;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface OrderService {
    List<Order> findAllOrders();


}
