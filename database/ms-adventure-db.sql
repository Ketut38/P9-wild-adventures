CREATE SCHEMA waadventure;

CREATE SEQUENCE waadventure.image_id_seq;
CREATE TABLE waadventure.image (
                id INTEGER NOT NULL DEFAULT nextval('waadventure.image_id_seq'),
                description VARCHAR(150) NOT NULL,
                url VARCHAR(500) NOT NULL,
                CONSTRAINT image_pk PRIMARY KEY (id)
);
ALTER SEQUENCE waadventure.image_id_seq OWNED BY waadventure.image.id;


CREATE SEQUENCE waadventure.adventure_id_seq;
CREATE TABLE waadventure.adventure (
                id INTEGER NOT NULL DEFAULT nextval('waadventure.adventure_id_seq'),
                title VARCHAR(50) NOT NULL,
                description VARCHAR(1000) NOT NULL,
                location VARCHAR(150) NOT NULL,
                status VARCHAR(20) NOT NULL,
                image_id INTEGER NOT NULL,
                CONSTRAINT adventure_pk PRIMARY KEY (id)
);
ALTER SEQUENCE waadventure.adventure_id_seq OWNED BY waadventure.adventure.id;


CREATE SEQUENCE waadventure.session_id_seq;
CREATE TABLE waadventure.session (
                id INTEGER NOT NULL DEFAULT nextval('waadventure.session_id_seq'),
                start_date TIMESTAMP NOT NULL,
                end_date TIMESTAMP NOT NULL,
                price NUMERIC NOT NULL,
                image_id INTEGER NOT NULL,
                adventure_id INTEGER NOT NULL,
                CONSTRAINT session_pk PRIMARY KEY (id)
);
ALTER SEQUENCE waadventure.session_id_seq OWNED BY waadventure.session.id;

ALTER TABLE waadventure.adventure ADD CONSTRAINT image_adventure_fk
FOREIGN KEY (image_id)
REFERENCES waadventure.image (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE waadventure.session ADD CONSTRAINT adventure_session_fk
FOREIGN KEY (adventure_id)
REFERENCES waadventure.adventure (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;