package com.wildadventures.msreservations.consumer;

import com.wildadventures.msreservations.model.OrderSession;
import com.wildadventures.msreservations.model.OrderSessionKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSessionRepository extends JpaRepository<OrderSession, OrderSessionKey> {
}
