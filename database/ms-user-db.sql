CREATE SCHEMA wauser;


CREATE SEQUENCE wauser.image_id_seq;
CREATE TABLE wauser.image (
                id INTEGER NOT NULL DEFAULT nextval('wauser.image_id_seq'),
                description VARCHAR(150) NOT NULL,
                url VARCHAR(500) NOT NULL,
                CONSTRAINT image_pk PRIMARY KEY (id)
);
ALTER SEQUENCE wauser.image_id_seq OWNED BY wauser.image.id;



CREATE SEQUENCE wauser.address_id_seq;
CREATE TABLE wauser.address (
                id VARCHAR NOT NULL,
                street_number VARCHAR(20) NOT NULL,
                street_name VARCHAR(50) NOT NULL,
                postal_code VARCHAR(10) NOT NULL,
                city VARCHAR(100) NOT NULL,
                CONSTRAINT address_pk PRIMARY KEY (id)
);
ALTER SEQUENCE wauser.address_id_seq OWNED BY wauser.address.id;

CREATE SEQUENCE wauser.useraccount_id_seq;
CREATE TABLE wauser.useraccount (
                id INTEGER NOT NULL,
                username VARCHAR(50) NOT NULL,
                first_name VARCHAR(50) NOT NULL,
                last_name VARCHAR(50) NOT NULL,
                gender VARCHAR(10) NOT NULL,
                email VARCHAR(50) NOT NULL,
                password VARCHAR(50) NOT NULL,
                phone VARCHAR(20) NOT NULL,
                created_on TIMESTAMP NOT NULL,
                updated_on TIMESTAMP NOT NULL,
                active BOOLEAN NOT NULL,
                image_id INTEGER NOT NULL,
                address_id VARCHAR NOT NULL,
                CONSTRAINT useraccount_pk PRIMARY KEY (id)
);
ALTER SEQUENCE wauser.useraccount_id_seq OWNED BY wauser.useraccount.id;

ALTER TABLE wauser.useraccount ADD CONSTRAINT image_useraccount_fk
FOREIGN KEY (image_id)
REFERENCES wauser.image (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE wauser.useraccount ADD CONSTRAINT address_useraccount_fk
FOREIGN KEY (address_id)
REFERENCES wauser.address (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;