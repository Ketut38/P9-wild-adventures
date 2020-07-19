package com.wildadventures.msreservations.controller;

import com.wildadventures.msreservations.bean.AdventureBean;
import com.wildadventures.msreservations.business.OrderService;
import com.wildadventures.msreservations.controller.exceptions.OrderNotFoundException;
import com.wildadventures.msreservations.controller.exceptions.OrderValidationException;
import com.wildadventures.msreservations.model.Order;
import com.wildadventures.msreservations.proxy.MsOrderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MsOrderProxy msOrderProxy;

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

    @GetMapping(value = "/all-adventures")
    public List<AdventureBean> findAllAdventures(){
        log.info("Récupération de la liste des commandes");
        List<AdventureBean> adventureBeans = msOrderProxy.getAllAventures();
        if(adventureBeans.isEmpty()){
            throw new OrderNotFoundException("Nothing to show");
        }
        return adventureBeans;

    }

    @GetMapping(value = "/{id}")
    public Order findById(@PathVariable Integer id) throws Exception {
        Optional<Order> orderOptional = orderService.findById(id);
        if(!orderOptional.isPresent()) throw new OrderNotFoundException("La commande avec l'id " + id + " est INTROUVABLE");

        return orderOptional.get();
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
    public ResponseEntity<Order> updateOrder(@RequestBody Order orderDetails, @PathVariable Integer id) {

        Order order = null;
        Optional<Order> orderOptional = orderService.findById(id);
        if(!orderOptional.isPresent()){
            throw new OrderNotFoundException("L'aventure avec l'id, " + id + " est INTROUVABLE");
        }
        order = orderOptional.get();
        if(order.getId() == null){
            throw new OrderValidationException("La commande fournie est nulle");
        }
        order.setUserId(orderDetails.getUserId());
        order.setSessionId(orderDetails.getSessionId());
        order.setDate(orderDetails.getDate());
        order.setIsPaid(orderDetails.getIsPaid());

        return new ResponseEntity<>(orderService.addOrder(order),HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId){
        log.info("Début méthode : deleteOrder()");
        Optional<Order> orderToDelete = orderService.findById(orderId);
        if(!orderToDelete.isPresent()) {
            log.error("La commande fournie n'existe pas");
            throw new OrderNotFoundException("La commande fournie n'existe pas");
        }
        else {
            log.info("Suppression de la commande d'id : "+orderId);
            orderService.deleteOrderById(orderId);
        }
        return new ResponseEntity<>("La commande d'id " + orderId + " a bien été supprimé", HttpStatus.GONE);
    }


    @RequestMapping(value = "/{userId}/orders", method = RequestMethod.GET)
    public List<Order> findByUser(@PathVariable Integer userId) throws Exception {
        List<Order> orders = orderService.findByUser(userId);
        if (orders.isEmpty()){
            throw new OrderNotFoundException("Il n'existe aucune commande avec l'id : " + userId);
        }
        return orders;
    }
}
