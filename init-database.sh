#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER docker;

    CREATE TABLE meal(
        id int not null,
        meal_ingredient_id int not null,
        "name" varchar(100) not null,
        per_portion_calories int not null,
        category varchar(10) not null,
        image_directory varchar(400) not null,
        recipe text not null,
        proteins float not null,
        carbohydrates float not null,
        fats float not null,
        PRIMARY KEY(id)
    );

    INSERT INTO meal(id, meal_ingredient_id, name, per_portion_calories, category, image_directory, recipe, proteins, carbohydrates, fats)
    VALUES (1, 1, 'carbonara', 500, 'dinner', '/dupa.img', 'dasdfawefasdf', 10, 2, 3),
           (2, 2, 'alfredo', 600, 'lunch', '/dupa1.img', 'qwerqwerqwer', 3, 4, 1);

    CREATE TABLE ingredient(
        id int not null,
        meal_ingredient_id int not null,
        measure varchar(40) not null,
        "name" varchar(70) not null,
        PRIMARY KEY(id)
    );

    INSERT INTO ingredient(id, meal_ingredient_id, measure, name)
    VALUES (1, 1, 'liter', 'milk'),
           (2, 2, 'kg', 'chicken'),
           (3, 1, 'g', 'garlic');

    CREATE TABLE meal_ingredient(
        id int not null,
        meal_id int not null,
        ingredient_id int not null,
        amount float not null,
        PRIMARY KEY(id)
    );

    INSERT INTO meal_ingredient(id, meal_id, ingredient_id, amount)
    VALUES (1, 1, 1, 24),
           (2, 2, 2, 50);

    CREATE TABLE "user"(
        login varchar(150) not null,
        password varchar(150) not null,
        PRIMARY KEY(login)
    );

    INSERT INTO "user"(login, password)
    VALUES ('stefan', 'Duparomana#');
EOSQL