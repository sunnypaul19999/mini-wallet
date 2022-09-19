drop database if exists mini_wallet;

create database if not exists mini_wallet;

use mini_wallet;

CREATE TABLE IF NOT EXISTS mini_wallet_user (
    user_id BIGINT,
    username VARCHAR(255),
    password VARCHAR(80),
    jwt_token TEXT,
    CONSTRAINT pk_user_id PRIMARY KEY (user_id)
);
 
CREATE TABLE IF NOT EXISTS wallet (
    wallet_id BIGINT,
    wallet_timestamp DATETIME(6),
    available_balance BIGINT,
    user_id BIGINT,
    CONSTRAINT pk_wallet_id PRIMARY KEY (wallet_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id)
        REFERENCES mini_wallet_user (user_id),
    CONSTRAINT un_user_id UNIQUE KEY (user_id)
);
 
CREATE TABLE IF NOT EXISTS wallet_transaction_history (
    wallet_transaction_id BIGINT,
    wallet_transaction_timestamp DATETIME(6),
    wallet_transaction_action VARCHAR(255),
    fk_wallet_id BIGINT,
    CONSTRAINT pk_wallet_transaction_id PRIMARY KEY (wallet_transaction_id),
    CONSTRAINT fk_wallet_id FOREIGN KEY (fk_wallet_id)
        REFERENCES wallet (wallet_id)
);
 