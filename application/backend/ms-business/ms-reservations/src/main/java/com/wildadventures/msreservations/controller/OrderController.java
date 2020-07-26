package com.wildadventures.msreservations.controller;

import com.wildadventures.msreservations.business.OrderService;
import com.wildadventures.msreservations.consumer.OrderSessionRepository;
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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MsOrderProxy msOrderProxy;

    @Autowired
    private OrderSessionRepository orderSessionRepository;

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Récupère toutes les commandes enregistrées

    @GetMapping()
    public List<Order> getAllOrders(){
        log.info("Début méthode : getAllOrders()");
        List<Order> orders = orderService.findAll();
        if(orders == null || orders.isEmpty()) {
            throw  new OrderNotFoundException("Aucune commande enregistrée");
        }
        return orders;
    }

    //Récupère toutes les commandes d'un utlisateur

    @GetMapping(value = "/user/{userId}")
    public List<Order> getAllOrdersByUser(@PathVariable Integer userId){
        log.info("Début méthode : getAllOrdersByUser()");
        List<Order> orders = orderService.findByUser(userId);
        if(orders == null || orders.isEmpty()) {
            throw  new OrderNotFoundException("Aucune commande enregistrée pour cet utilisateur " + +userId);
        }
        return orders;
    }

    // Récupère une commande en fonction de son id

    @GetMapping(value = "/{orderId}")
    public Order getOrder(@PathVariable Integer orderId){
        log.info("Début méthode : getOrder()");
        Optional<Order> order = orderService.findById(orderId);
        if(!order.isPresent()) {
            throw new OrderNotFoundException("La commande d'id : "+ orderId + "n'existe pas");
        }
        return order.get();
    }


    @PostMapping(value = "/save")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        log.info("Début méthode : createOrder()");
        if(order == null) {
            log.error("La commande fournie est nulle");
            throw new OrderValidationException("La commande fournie est nulle");
        }
        /*if(order.getId()!=null){
            log.error("La commande fournie est déjà  à l'état persistant");
            throw new OrderValidationException("La commande fournie existe déjà");
        }*/
        if(order.getOrderSessions()!=null && order.getOrderSessions().size()==0) {
            log.error("La commande fournie n'est reliée à aucune session d'aventure");
            throw new OrderValidationException(("La commande fournie n'est reliée à aucune session d'aventure"));
        }
        //Vérification que l'utilisateur fournie existe
        if(order.getUserId()==null) {
            log.error("L'utilisateur lié à la commande n'existe pas");
            throw new OrderValidationException(("L'utilisateur lié à la commande n'existe pas"));
        }

        log.info("Création de la commande");

        Order addedOrder = orderService.addOrder(order);

        if (addedOrder == null)
            return ResponseEntity.noContent().build();

        final Integer orderId = order.getId();

        if(!order.getOrderSessions().isEmpty()){

            //Si les sessions existent on sauvegarde les liens entre la commande et les sessions
            log.info("Enregistrement des sessions liés à la commande");
            order.getOrderSessions().iterator().forEachRemaining(orderSession -> {
                orderSession.setOrderId(orderId);
                orderSessionRepository.save(orderSession);
            });
        }

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        log.info("Début méthode : updateOrder()");
        if(order == null) {
            log.error("La commande fournie est nulle");
            throw new OrderValidationException("La commande fournie est nulle");
        }
        if(order.getId()==null || !orderService.findById(order.getId()).isPresent()) {
            log.error("La commande fournie n' a pas encore été enregistrée");
            throw new OrderValidationException("La commande fournie n' a pas encore été enregistrée");
        }
        log.info("Mise à jour de la commande");
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
            orderService.deleteOrderById(orderId);
        }
        return new ResponseEntity<>("La commande d'id " + orderId + " a bien été supprimé", HttpStatus.GONE);
    }
}
