CREATE TABLE clients (
    id VARCHAR(10) PRIMARY KEY ,
    f_name VARCHAR(50) NOT NULL ,
    l_name VARCHAR(50) NOT NULL ,
);

CREATE TABLE account (
  account_number VARCHAR(20) PRIMARY KEY ,
  is_saving_acc BOOLEAN NOT NULL ,
  balance DECIMAL(8,2) DEFAULT 0.00,
  client_id VARCHAR(10) NOT NULL ,
  CONSTRAINT fk_account FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE transactions(
    trans_id VARCHAR(10) PRIMARY KEY ,
    amount DECIMAL(8,2) NOT NULL ,
    sender_acc_no VARCHAR(20) NOT NULL ,
    receiver_acc_no VARCHAR(20) NOT NULL ,
);

CREATE TABLE accounts_transactions(
    account_number VARCHAR(20),
    trans_id VARCHAR(10),
    CONSTRAINT pk_1 PRIMARY KEY (account_number,trans_id),
    CONSTRAINT fk_1 FOREIGN KEY (account_number) REFERENCES account(account_number) ,
    CONSTRAINT fk_2 FOREIGN KEY (trans_id) REFERENCES transactions(trans_id)
);
