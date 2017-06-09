package ru.forge.twice_a_day.classes.models.order;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrders() {
        return Lists.newArrayList(orderRepository.findAll());
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }


    public Order findById(Long id) {
        return orderRepository.findOne(id);
    }


    public void printMessage(){
        System.out.println("it's work");
    }
}
