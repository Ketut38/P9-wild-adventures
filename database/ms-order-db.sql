CREATE SCHEMA waorder;

CREATE SEQUENCE waorder.orders_id_seq;

CREATE TABLE waorder.orders (
                id INTEGER NOT NULL DEFAULT nextval('waorder.orders_id_seq'),
                date TIMESTAMP NOT NULL,
                status VARCHAR(50) NOT NULL,
                useraccount_id INTEGER NOT NULL,
                CONSTRAINT order_pk PRIMARY KEY (id)
);


CREATE TABLE waorder.order_session (
                order_id INTEGER NOT NULL,
                session_id INTEGER NOT NULL,
                CONSTRAINT order_session_pk PRIMARY KEY (order_id, session_id)
);

ALTER TABLE waorder.order_session ADD CONSTRAINT order_order_session_fk
FOREIGN KEY (order_id)
REFERENCES waorder.orders (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
