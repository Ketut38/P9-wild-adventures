CREATE SCHEMA wacategory;

CREATE SEQUENCE wacategory.image_id_seq;
CREATE TABLE wacategory.image (
                id INTEGER NOT NULL DEFAULT nextval('wacategory.image_id_seq'),
                description VARCHAR(150) NOT NULL,
                url VARCHAR(500) NOT NULL,
                CONSTRAINT image_pk PRIMARY KEY (id)
);
ALTER SEQUENCE wacategory.image_id_seq OWNED BY wacategory.image.id;


CREATE SEQUENCE wacategory.category_id_seq;
CREATE TABLE wacategory.category (
                id INTEGER NOT NULL,
                title VARCHAR(50) NOT NULL,
                description VARCHAR(1000) NOT NULL,
                image_id INTEGER NOT NULL,
                CONSTRAINT category_pk PRIMARY KEY (id)
);
ALTER SEQUENCE wacategory.category_id_seq OWNED BY wacategory.category.id;

CREATE TABLE wacategory.category_adventure (
                category_id INTEGER NOT NULL,
                adventure_id INTEGER NOT NULL,
                CONSTRAINT category_adventure_pk PRIMARY KEY (category_id, adventure_id)
);

ALTER TABLE wacategory.category ADD CONSTRAINT image_category_fk
FOREIGN KEY (image_id)
REFERENCES wacategory.image (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


ALTER TABLE wacategory.category_adventure ADD CONSTRAINT category_category_adventure_fk
FOREIGN KEY (category_id)
REFERENCES wacategory.category (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;