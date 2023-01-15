CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT primary key,
    username varchar(25),
    password varchar(15),
    first_name varchar(30),
    last_name varchar(30),
    created_by varchar(25),
    created_date timestamp,
    last_modified_by varchar(25),
    last_modified_date timestamp
);

CREATE TABLE IF NOT EXISTS authorities (
    authority_id BIGINT primary key,
    name varchar(50)
);

CREATE TABLE IF NOT EXISTS users_authorities (
    user_id BIGINT,
    authority_id BIGINT ,
    CONSTRAINT fk_users_authorities FOREIGN KEY (user_id)
                               REFERENCES authorities(authority_id),
    CONSTRAINT pk_users_authorities PRIMARY KEY (user_id, authority_id)
);

CREATE SEQUENCE IF NOT EXISTS user_id_sequence
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START WITH 1;

CREATE SEQUENCE IF NOT EXISTS authority_id_sequence
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START WITH 1;

CREATE SEQUENCE IF NOT EXISTS users_authorities_id_sequence
    INCREMENT BY 1
    MINVALUE 1
    NO MAXVALUE
    START WITH 1;
