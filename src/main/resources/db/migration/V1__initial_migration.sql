CREATE TABLE user (
   id BINARY(16) NOT NULL UNIQUE,
   password_hash VARCHAR(64),
   ussd_pin_hash VARCHAR(64),
   first_name VARCHAR(64),
   last_name VARCHAR(64),
   email VARCHAR(30) UNIQUE,
   phone_number VARCHAR(15) UNIQUE,
   image_url VARCHAR(256),
   activated BIT NOT NULL,
   password_reset_date DATETIME,
   user_status VARCHAR(15) NOT NULL,
   created_by VARCHAR(255),
   creation_date DATETIME,
   last_modified_by VARCHAR(255),
   last_modified_date DATETIME,

   PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE authority (
    id BINARY(16) NOT NULL UNIQUE,
    authority_name VARCHAR(64),
    created_by VARCHAR(255),
    creation_date DATETIME,
    last_modified_by VARCHAR(255),
    last_modified_date DATETIME,

    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE user_authority (
   user_id BINARY(16) NOT NULL,
   authority_id BINARY(16) NOT NULL,

   PRIMARY KEY(user_id, authority_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE currency (
   `id` BINARY(16) NOT NULL UNIQUE,
   `name` VARCHAR(64) NOT NULL,
   `symbol` VARCHAR(30) NOT NULL UNIQUE,
   `enabled` BIT NOT NULL,
   `supported` BIT NOT NULL,
   created_by VARCHAR(255),
   creation_date DATETIME,
   last_modified_by VARCHAR(255),
   last_modified_date DATETIME,

    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE transaction (
  id BINARY(16) NOT NULL UNIQUE,
  amount DECIMAL(64) NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  `currency_id` BINARY(16) NOT NULL,
  `reference` VARCHAR(64),
  `status` VARCHAR(30) NOT NULL,
  `paid` BIT NOT NULL,
  created_by VARCHAR(255),
  creation_date DATETIME,
  last_modified_by VARCHAR(255),
  last_modified_date DATETIME,

  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE wallet_asset (
  id BINARY(16) NOT NULL UNIQUE,
  `available_balance` DECIMAL(64) NOT NULL,
  `reserved_balance` VARCHAR(30) NOT NULL,
  `locked` BIT NOT NULL,
  `currency_id` BINARY(16) NOT NULL,
  `user_id` BINARY(16) NOT NULL,
  created_by VARCHAR(255),
  creation_date DATETIME,
  last_modified_by VARCHAR(255),
  last_modified_date DATETIME,

  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;