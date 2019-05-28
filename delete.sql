-- Let's say that we enter in some unwanted data by mistake
INSERT INTO chez_moose.drinks (drink_id, drink_type, drink_name, expires, number_of_units) 
VALUES ("10", "alcohol", "Not our Restaurant's IPA", "2009-03-01", "30");

-- Since that's not our restaurant's beer, let's delete it from our table!
DELETE FROM chez_moose.drinks
WHERE drink_id = "10";