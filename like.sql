-- selects any drink of type alcohol provided it was spell correctly when entered.
-- E.G. would not find any alcoholic drinks that were entered as "alcholic" or etc.
SELECT * FROM chez_moose.drinks
WHERE drink_type LIKE "alcohol";

-- Selects any of the drinks that are decently in stock
SELECT * FROM chez_moose.drinks
WHERE number_of_units > 12;

-- Selects anything starting with "m"
SELECT * FROM chez_moose.drinks
WHERE drink_name LIKE "m%";

-- Queries any drink that ends with "l"
SELECT * FROM chez_moose.drinks
WHERE drink_type LIKE "%l";

-- Queries any drink that includes "IPA" in the title
SELECT * FROM chez_moose.drinks
WHERE drink_name LIKE "%IPA%"