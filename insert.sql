-- INSERT STATEMENTS for the drinks table
INSERT INTO chez_moose.drinks (drink_id, drink_type, drink_name, expires, number_of_units) 
VALUES ("1", "alcohol", "Mooses IPA", "2021-09-30", "30");

INSERT INTO chez_moose.drinks (drink_id, drink_type, drink_name, expires, number_of_units) 
VALUES ("2", "juice", "OJ", "2021-09-30", "12");

INSERT INTO chez_moose.drinks (drink_id, drink_type, drink_name, expires, number_of_units) 
VALUES ("3", "dairy", "Milk", "2019-06-30", "10");

INSERT INTO chez_moose.drinks (drink_id, drink_type, drink_name, expires, number_of_units) 
VALUES ("4", "alcohol", "Wine", "2022-11-22", "40");

-- INSERT STATEMENTS for the inventory table 
INSERT INTO chez_moose.inventory (item_id, item_type, item_name, expires, number_of_units) 
VALUES ("1", "drink", "Mooses IPA", "2020-06-06", "30");

INSERT INTO chez_moose.inventory (item_id, item_type, item_name, expires, number_of_units) 
VALUES ("2", "juice", "OJ", "2021-09-30", "12");

INSERT INTO chez_moose.inventory (item_id, item_type, item_name, expires, number_of_units) 
VALUES ("3", "dairy", "Milk", "2019-06-30", "10");

INSERT INTO chez_moose.inventory (item_id, item_type, item_name, expires, number_of_units) 
VALUES ("4", "alcohol", "Wine", "2022-11-22");

-- INSERT STATEMENTS for the meals table
INSERT INTO chez_moose.meals (meal_id, meal_name, date_added, meal_price) 
VALUES ("5", "burger n fries", "1999-12-30", "15.99");

INSERT INTO chez_moose.meals (meal_id, meal_name, date_added, meal_price) 
VALUES ("6", "steak n shake", "2004-12-12", "22.81");

INSERT INTO chez_moose.meals (meal_id, meal_name, date_added, meal_price) 
VALUES ("7", "chicken wings", "2001-06-06", "17.24");

INSERT INTO chez_moose.meals (meal_id, meal_name, date_added, meal_price) 
VALUES ("8", "big ol sammiche", "2012-02-24", "25.99");


