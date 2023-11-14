CREATE TABLE IF NOT EXISTS clients (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    f_name VARCHAR(50) NOT NULL ,
    l_name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS account(
  account_number VARCHAR(20) PRIMARY KEY ,
    client_id INT NOT NULL ,
    name VARCHAR(50) NOT NULL,
  is_saving_acc BOOLEAN NOT NULL ,
  balance DECIMAL(8,2) ,
  CONSTRAINT fk_account FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE IF NOT EXISTS transactions(
    trans_id VARCHAR(10) PRIMARY KEY ,
    amount DECIMAL(8,2) NOT NULL ,
    sender_acc_no VARCHAR(20) NOT NULL ,
    receiver_acc_no VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts_transactions(
    account_number VARCHAR(20),
    trans_id VARCHAR(10),
    CONSTRAINT pk_1 PRIMARY KEY (account_number,trans_id),
    CONSTRAINT fk_1 FOREIGN KEY (account_number) REFERENCES account(account_number) ,
    CONSTRAINT fk_2 FOREIGN KEY (trans_id) REFERENCES transactions(trans_id)
);
