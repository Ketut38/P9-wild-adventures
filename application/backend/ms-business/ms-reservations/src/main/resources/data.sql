INSERT INTO orders(id, user_id, order_date, is_paid) VALUES (1, 1, '2020-01-23', TRUE);
INSERT INTO orders(id, user_id, order_date, is_paid) VALUES (2, 2, '2020-01-23', TRUE);
INSERT INTO orders(id, user_id, order_date, is_paid) VALUES (3, 3, '2020-01-23', FALSE);
INSERT INTO orders(id, user_id, order_date, is_paid) VALUES (4, 1, '2020-01-23', TRUE);
INSERT INTO orders(id, user_id, order_date, is_paid) VALUES (5, 3, '2020-01-23', TRUE);
INSERT INTO orders(id, user_id, order_date, is_paid) VALUES (6, 2, '2020-01-23', TRUE);
INSERT INTO orders(id, user_id, order_date, is_paid) VALUES (7, 1, '2020-01-23', TRUE);

INSERT INTO order_session(order_id, session_id) VALUES (1,1);
INSERT INTO order_session(order_id, session_id) VALUES (1,2);
INSERT INTO order_session(order_id, session_id) VALUES (1,3);
INSERT INTO order_session(order_id, session_id) VALUES (2,4);
INSERT INTO order_session(order_id, session_id) VALUES (2,5);
INSERT INTO order_session(order_id, session_id) VALUES (3,6);
INSERT INTO order_session(order_id, session_id) VALUES (3,7);



