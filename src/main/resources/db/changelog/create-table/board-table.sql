CREATE TABLE board(
    id BIGINT PRIMARY KEY NOT NULL,
    user_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    favorite BOOLEAN NOT NULL,
    creation_date TIMESTAMP NOT NULL,

    CONSTRAINT fk_board_to_user
        FOREIGN KEY(user_id)
        REFERENCES usr(id)
);

CREATE SEQUENCE board_id_seq;