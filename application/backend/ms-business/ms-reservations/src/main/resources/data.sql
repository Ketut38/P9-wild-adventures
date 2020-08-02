INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (1, 1, '2020-01-23', TRUE, 300);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (2, 2, '2020-01-23', TRUE, 250);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (3, 3, '2020-01-23', FALSE, 150);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (4, 1, '2020-01-23', TRUE, 200);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (5, 3, '2020-01-23', TRUE, 50);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (6, 2, '2020-01-23', TRUE, 100);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (7, 1, '2020-01-23', TRUE, 100);

INSERT INTO order_session(order_id, session_id) VALUES (1,1);
INSERT INTO order_session(order_id, session_id) VALUES (1,2);
INSERT INTO order_session(order_id, session_id) VALUES (1,3);
INSERT INTO order_session(order_id, session_id) VALUES (2,4);
INSERT INTO order_session(order_id, session_id) VALUES (2,5);
INSERT INTO order_session(order_id, session_id) VALUES (3,6);
INSERT INTO order_session(order_id, session_id) VALUES (3,7);



