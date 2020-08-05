INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (101, 1, '2020-01-23', TRUE, 300);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (102, 2, '2020-01-23', TRUE, 250);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (103, 3, '2020-01-23', FALSE, 150);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (104, 1, '2020-01-23', TRUE, 200);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (105, 3, '2020-01-23', TRUE, 50);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (106, 2, '2020-01-23', TRUE, 100);
INSERT INTO orders(id, user_id, order_date, is_paid, amount) VALUES (107, 1, '2020-01-23', TRUE, 100);

INSERT INTO order_session(order_id, session_id) VALUES (101,1);
INSERT INTO order_session(order_id, session_id) VALUES (101,2);
INSERT INTO order_session(order_id, session_id) VALUES (101,3);
INSERT INTO order_session(order_id, session_id) VALUES (102,4);
INSERT INTO order_session(order_id, session_id) VALUES (102,5);
INSERT INTO order_session(order_id, session_id) VALUES (103,6);
INSERT INTO order_session(order_id, session_id) VALUES (103,7);