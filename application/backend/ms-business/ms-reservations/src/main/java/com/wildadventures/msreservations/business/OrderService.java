package com.wildadventures.msreservations.business;

import com.wildadventures.msreservations.consumer.OrderRepository;
import com.wildadventures.msreservations.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Order findById(Integer id) {
        return  orderRepository.findById(id).get();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Integer orderToUpdateId, Order order) {
        Order orderToUpdate = orderRepository.findById(orderToUpdateId).get();
        if(orderToUpdate != null){
            orderToUpdate.setUserId(order.getUserId());
            orderToUpdate.setSessionId(order.getSessionId());
            orderToUpdate.setDate(order.getDate());
            orderToUpdate.setStatus(order.getStatus());
            return orderRepository.save(orderToUpdate);
        }
        return null;
    }

    public List<Order> findByUser(Integer userId){
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders;
    }

}
