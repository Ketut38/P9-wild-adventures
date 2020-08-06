package com.wildadventures.msreservations.business;

import com.wildadventures.msreservations.consumer.OrderRepository;
import com.wildadventures.msreservations.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Integer id) {
        return  orderRepository.findById(id);
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrderById(Integer orderId){
        orderRepository.deleteById(orderId);
    }

    public List<Order> findByUser(Integer userId){
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders;
    }

}
