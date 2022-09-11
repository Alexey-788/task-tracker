CREATE TABLE card(
    id BIGINT PRIMARY KEY NOT NULL,
    card_group_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,

    CONSTRAINT fk_card_to_card_group
        FOREIGN KEY (card_group_id)
        REFERENCES card_group(id)
);

CREATE SEQUENCE card_id_seq;