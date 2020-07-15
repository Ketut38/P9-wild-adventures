package com.wildadventures.msreservations.controller;

import com.wildadventures.msreservations.business.OrderService;
import com.wildadventures.msreservations.controller.exceptions.OrderNotFoundException;
import com.wildadventures.msreservations.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

   @GetMapping()
    public List<Order> findAll(){
        log.info("Récupération de la liste des commandes");
        return orderService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Order findById(@PathVariable Integer id) throws Exception {
        Order order = orderService.findById(id);
        if(order==null) throw new OrderNotFoundException("La commande avec l'id " + id + " est INTROUVABLE");

        return order;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Void> saveOrder(@RequestBody Order order) {
        Order addedOrder = orderService.addOrder(order);

        if (addedOrder == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedOrder.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping (value = "/update/{id}")
    public Order updateOrder(@RequestBody Order orderDetails, @PathVariable Integer id) {

        Order order = orderService.findById(id);
        order.setUserId(orderDetails.getUserId());
        order.setSessionId(orderDetails.getSessionId());
        order.setDate(orderDetails.getDate());
        order.setStatus(orderDetails.getStatus());

        return orderService.addOrder(order);
    }

    @RequestMapping(value = "/{userId}/orders", method = RequestMethod.GET)
    public List<Order> findByUser(@PathVariable Integer userId) throws Exception {
        List<Order> orders = orderService.findByUser(userId);
        if (orders.isEmpty()){
            throw new Exception("Il n'existe aucune commande avec l'id : " + userId);
        }
        return orders;
    }
}
