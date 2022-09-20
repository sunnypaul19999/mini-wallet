drop database if exists mini_wallet;

create database if not exists mini_wallet;

use mini_wallet;

CREATE TABLE IF NOT EXISTS mini_wallet_user (
    user_id BIGINT AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(80) NOT NULL,
    mini_wallet_user_timestamp DATETIME(6),
    jwt_token TEXT,
    CONSTRAINT mini_wallet_user_pk_user_id PRIMARY KEY (user_id),
    CONSTRAINT mini_wallet_user_un_username UNIQUE KEY (username)
);
 
CREATE TABLE IF NOT EXISTS wallet (
    wallet_id BIGINT AUTO_INCREMENT,
    wallet_timestamp DATETIME(6),
    available_balance BIGINT NOT NULL,
    user_id BIGINT,
    CONSTRAINT wallet_pk_wallet_id PRIMARY KEY (wallet_id),
    CONSTRAINT wallet_fk_user_id FOREIGN KEY (user_id)
        REFERENCES mini_wallet_user (user_id),
    CONSTRAINT wallet_un_user_id UNIQUE KEY (user_id),
    CONSTRAINT wallet_ck_available_balance CHECK (available_balance >= 0)
);
 
CREATE TABLE IF NOT EXISTS wallet_transaction_history (
    wallet_transaction_id BIGINT AUTO_INCREMENT,
    wallet_transaction_timestamp DATETIME(6),
    wallet_transaction_action VARCHAR(255) NOT NULL,
    wallet_id BIGINT,
    CONSTRAINT wallet_transaction_history_pk_wallet_transaction_id PRIMARY KEY (wallet_transaction_id),
    CONSTRAINT wallet_transaction_history_fk_wallet_id FOREIGN KEY (wallet_id)
        REFERENCES wallet (wallet_id)
);

CREATE TABLE wallet_minium_balance (
    wallet_minimum_balance_id BIGINT AUTO_INCREMENT,
    minimum_balance BIGINT NOT NULL,
    wallet_id BIGINT,
    CONSTRAINT wallet_minium_balance_pk_wallet_minimum_balance_id PRIMARY KEY (wallet_minimum_balance_id),
    CONSTRAINT wallet_minium_balance_fk_wallet_id FOREIGN KEY (wallet_id)
        REFERENCES wallet (wallet_id),
    CONSTRAINT wallet_minium_balance_un_wallet_id UNIQUE KEY (wallet_id),
    CONSTRAINT wallet_minium_balance_ck_minimum_balance CHECK (minimum_balance >= 0)
);

CREATE TABLE wallet_transaction_action (
    tranaction_action_id BIGINT AUTO_INCREMENT,
    transaction_action VARCHAR(255) NOT NULL,
    CONSTRAINT wallet_transaction_action_pk_tranaction_action_id PRIMARY KEY (tranaction_action_id),
    CONSTRAINT wallet_transaction_action_un_transaction_action UNIQUE KEY (transaction_action)
);
 