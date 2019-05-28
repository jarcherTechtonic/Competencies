DROP DATABASE IF EXISTS chez_moose;
-- CREATE SCHEMA chez_moose;
USE chez_moose;

CREATE TABLE IF NOT EXISTS meals (
  meal_id      SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  meal_name    VARCHAR(40) NOT NULL,
  date_added   DATETIME NOT NULL,
  meal_price   SMALLINT NOT NULL,
  last_updated TIMESTAMP 
               DEFAULT CURRENT_TIMESTAMP ON UPDATE
               CURRENT_TIMESTAMP,
  PRIMARY KEY (meal_id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS sales (
  sale_id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  breakfast_profit INT NOT NULL,
  lunch_profit     INT NOT NULL,
  dinner_profit    INT NOT NULL,
  misc_profit      INT NOT NULL,
  net_profit       INT NOT NULL, 
  sale_date        DATETIME NOT NULL,
  last_updated     TIMESTAMP 
                   DEFAULT CURRENT_TIMESTAMP ON UPDATE
                   CURRENT_TIMESTAMP,
  PRIMARY KEY (sale_id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS expenses (
  expense_id        SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  cleaning_supplies INT NOT NULL,
  cooking_tools     INT NOT NULL,
  ingredients       INT NOT NULL,
  drinks            INT NOT NULL,
  silverware        INT NOT NULL,
  last_updated      TIMESTAMP 
                    DEFAULT CURRENT_TIMESTAMP ON UPDATE
                    CURRENT_TIMESTAMP,
  PRIMARY KEY (expense_id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS inventory (
  item_id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  item_type        VARCHAR(20),
  item_name        VARCHAR(40) NOT NULL,
  expires          DATE NOT NULL,
  number_of_units  INT,
  last_updated     TIMESTAMP 
                   DEFAULT CURRENT_TIMESTAMP ON UPDATE
                   CURRENT_TIMESTAMP,
  PRIMARY KEY (item_id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;