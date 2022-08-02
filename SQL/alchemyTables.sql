DROP TABLE alchemist_recipe;
DROP TABLE alchemist_ingredients; 
DROP table ingredient_types;
DROP TABLE alchemist_inventory ;
DROP TABLE alchemist_users;
DROP TABLE alchemist_class;

CREATE TABLE alchemist_class(
	class_id serial PRIMARY KEY,
	class_name varchar(10) NOT NULL
);

CREATE TABLE ingredient_types(
	type_id serial PRIMARY KEY,
	type_name varchar(10) NOT NULL 
);

CREATE TABLE alchemist_users(
	user_id serial PRIMARY KEY,
	username varchar(10) NOT NULL,
	user_password varchar(10) NOT NULL,
	user_classFK int REFERENCES "alchemist_class"(class_id)
);

CREATE TABLE alchemist_ingredients(
	ingredient_id serial PRIMARY KEY,
	ingredient_name varchar(10) NOT NULL,
	type_id int REFERENCES ingredient_types(type_id)
);

CREATE TABLE alchemist_recipe(
	recipe_id serial PRIMARY KEY,
	recipe_name varchar(10) NOT NULL,
	ingredient1FK int REFERENCES alchemist_ingredients(ingredient_id),
	ingredient2FK int REFERENCES alchemist_ingredients(ingredient_id),
	recipe_value int NOT NULL
);
ALTER TABLE alchemist_recipe
ADD CONSTRAINT ingredient_list UNIQUE (ingredient1FK,ingredient2FK);

CREATE TABLE alchemist_inventory(
	inventory_id serial PRIMARY KEY,
	user_idFK int REFERENCES alchemist_users(user_id),
	user_gold int DEFAULT 500,
	item1 varchar(10)
);

