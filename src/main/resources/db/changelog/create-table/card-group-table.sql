CREATE TABLE card_group(
    id BIGINT PRIMARY KEY NOT NULL,
    board_id BIGINT NOT NULL,
    title VARCHAR(255),

    CONSTRAINT fk_card_group_to_board
        FOREIGN KEY (board_id)
        REFERENCES board(id)
);

CREATE SEQUENCE card_group_id_seq;