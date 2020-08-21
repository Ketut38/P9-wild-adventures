
CREATE TABLE public.image (
                id INTEGER NOT NULL,
                description VARCHAR(150) NOT NULL,
                url VARCHAR(500) NOT NULL,
                CONSTRAINT image_pk PRIMARY KEY (id)
);


CREATE TABLE public.address (
                id VARCHAR NOT NULL,
                street_number VARCHAR(20) NOT NULL,
                street_name VARCHAR(50) NOT NULL,
                postal_code VARCHAR(10) NOT NULL,
                city VARCHAR(100) NOT NULL,
                CONSTRAINT address_pk PRIMARY KEY (id)
);


CREATE TABLE public.category (
                id INTEGER NOT NULL,
                title VARCHAR(50) NOT NULL,
                description VARCHAR(1000) NOT NULL,
                image_id INTEGER NOT NULL,
                CONSTRAINT category_pk PRIMARY KEY (id)
);


CREATE TABLE public.adventure (
                id INTEGER NOT NULL,
                title VARCHAR(50) NOT NULL,
                description VARCHAR(1000) NOT NULL,
                location VARCHAR(150) NOT NULL,
                status VARCHAR(20) NOT NULL,
                image_id INTEGER NOT NULL,
                CONSTRAINT adventure_pk PRIMARY KEY (id)
);


CREATE TABLE public.category_adventure (
                id INTEGER NOT NULL,
                adventure_id INTEGER NOT NULL,
                category_id INTEGER NOT NULL,
                CONSTRAINT category_adventure_pk PRIMARY KEY (id)
);


CREATE TABLE public.session (
                id INTEGER NOT NULL,
                start_date TIMESTAMP NOT NULL,
                end_date TIMESTAMP NOT NULL,
                price NUMERIC NOT NULL,
                image_id INTEGER NOT NULL,
                adventure_id INTEGER NOT NULL,
                CONSTRAINT session_pk PRIMARY KEY (id)
);


CREATE TABLE public.useraccount (
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


CREATE TABLE public.comments (
                id INTEGER NOT NULL,
                useraccount_id INTEGER NOT NULL,
                adventure_id INTEGER NOT NULL,
                content VARCHAR(500) NOT NULL,
                created_on TIMESTAMP NOT NULL,
                updated_on TIMESTAMP NOT NULL,
                CONSTRAINT comments_pk PRIMARY KEY (id)
);


CREATE TABLE public.order (
                id INTEGER NOT NULL,
                date TIMESTAMP NOT NULL,
                status VARCHAR(50) NOT NULL,
                useraccount_id INTEGER NOT NULL,
                CONSTRAINT order_pk PRIMARY KEY (id)
);


CREATE TABLE public.order_session (
                id INTEGER NOT NULL,
                order_id INTEGER NOT NULL,
                session_id INTEGER NOT NULL,
                CONSTRAINT order_session_pk PRIMARY KEY (id)
);


ALTER TABLE public.useraccount ADD CONSTRAINT image_useraccount_fk
FOREIGN KEY (image_id)
REFERENCES public.image (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.session ADD CONSTRAINT image_session_fk
FOREIGN KEY (image_id)
REFERENCES public.image (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.category ADD CONSTRAINT image_category_fk
FOREIGN KEY (image_id)
REFERENCES public.image (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.adventure ADD CONSTRAINT image_adventure_fk
FOREIGN KEY (image_id)
REFERENCES public.image (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.useraccount ADD CONSTRAINT address_useraccount_fk
FOREIGN KEY (address_id)
REFERENCES public.address (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.category_adventure ADD CONSTRAINT category_category_adventure_fk
FOREIGN KEY (category_id)
REFERENCES public.category (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.session ADD CONSTRAINT adventure_session_fk
FOREIGN KEY (adventure_id)
REFERENCES public.adventure (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.category_adventure ADD CONSTRAINT adventure_category_adventure_fk
FOREIGN KEY (adventure_id)
REFERENCES public.adventure (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comments ADD CONSTRAINT adventure_comments_fk
FOREIGN KEY (adventure_id)
REFERENCES public.adventure (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.order_session ADD CONSTRAINT session_order_session_fk
FOREIGN KEY (session_id)
REFERENCES public.session (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.order ADD CONSTRAINT useraccount_order_fk
FOREIGN KEY (useraccount_id)
REFERENCES public.useraccount (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comments ADD CONSTRAINT useraccount_comments_fk
FOREIGN KEY (useraccount_id)
REFERENCES public.useraccount (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.order_session ADD CONSTRAINT order_order_session_fk
FOREIGN KEY (order_id)
REFERENCES public.order (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
