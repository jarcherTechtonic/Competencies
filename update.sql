-- For this scenario, imagine that we've incorrectly entered something.
INSERT INTO chez_moose.meals (meal_id, meal_name, date_added, meal_price) 
VALUES ("9", "over-priced meal", "2021-02-22", "299.99");

-- Looks like an extra 9 got entered in on the price of this meal--it probably doesn't cost 300 bucks...
-- Let's edit/update it!
UPDATE chez_moose.meals
SET meal_name = "correctly-priced meal", meal_price = "29.99"
WHERE meal_id = 9;