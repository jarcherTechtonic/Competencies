-- returns everything in the inventory table by the ascending number of units
SELECT * FROM chez_moose.inventory
ORDER BY number_of_units;

-- explicity returns everything in the inventory table by the ascending number of units
SELECT * FROM chez_moose.inventory
ORDER BY number_of_units ASC;

-- returns everything in the inventory table by the descending number of units
SELECT * FROM chez_moose.inventory
ORDER BY number_of_units DESC;

-- imagine if there were thousands of entries and you only wanted to see the top ten
-- one could "LIMIT" the query to only show the first 10 results
SELECT * FROM chez_moose.inventory
ORDER BY item_id
LIMIT 10;