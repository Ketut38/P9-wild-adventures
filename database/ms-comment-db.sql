CREATE SCHEMA wacomment;

CREATE SEQUENCE wacomment.comment_id_seq;

CREATE TABLE wacomment.comment (
                id INTEGER NOT NULL DEFAULT nextval('wacomment.comment_id_seq'),
                useraccount_id INTEGER NOT NULL,
                adventure_id INTEGER NOT NULL,
                content VARCHAR(500) NOT NULL,
                created_on TIMESTAMP NOT NULL,
                updated_on TIMESTAMP NOT NULL,
                CONSTRAINT comments_pk PRIMARY KEY (id)
);
ALTER SEQUENCE wacomment.comment_id_seq OWNED BY wacomment.comment.id;

ALTER TABLE wacomment.comments ADD CONSTRAINT useraccount_comments_fk
FOREIGN KEY (useraccount_id)
REFERENCES wacomment.useraccount (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE wacomment.comments ADD CONSTRAINT adventure_comments_fk
FOREIGN KEY (adventure_id)
REFERENCES wacomment.adventure (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;