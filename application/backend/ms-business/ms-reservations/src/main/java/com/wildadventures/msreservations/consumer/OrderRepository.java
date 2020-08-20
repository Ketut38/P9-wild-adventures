package com.wildadventures.msreservations.consumer;

import java.util.Date;
import java.util.List;

import com.wildadventures.msreservations.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    List<Order> findByDate(Date date);

    List<Order> findByUserId(String  userId);
}
