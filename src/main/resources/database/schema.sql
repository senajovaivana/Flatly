DROP TABLE IF EXISTS "developer";
DROP TABLE IF EXISTS "payment_method_of_room";
DROP TABLE IF EXISTS "payment_method";
DROP TABLE IF EXISTS "booking";
DROP TABLE IF EXISTS "room_image";
DROP TABLE IF EXISTS "room";
DROP TABLE IF EXISTS "users";

CREATE TABLE IF NOT EXISTS "developer"
(
    id     SERIAL PRIMARY KEY,
    login  varchar(100),
    active varchar(1) default 'T'
);

CREATE TABLE IF NOT EXISTS "users"
(
    id SERIAL PRIMARY KEY,
    login  varchar(40),
    password varchar(80),
    first_name  varchar(40),
    last_name varchar(40),
    security_token varchar(200)
);

CREATE TABLE IF NOT EXISTS "payment_method"
(
    id SERIAL PRIMARY KEY,
    name_of_method varchar(40)
);

CREATE TABLE IF NOT EXISTS "room"
(
    id BIGSERIAL PRIMARY KEY,
    owner_of_room integer,
    name_of_room varchar(200),
    start_date date,
    end_date date default null,
    active char(1) default 'T',
    description varchar(2000),
    city varchar(50),
    street varchar(50),
    number_of_street varchar(50),
    zip_code varchar(10),
    country varchar(50),
    price integer,
    check_in_from time,
    check_in_to time,
    check_out time,
    limit_of_quests integer,
    FOREIGN KEY (owner_of_room) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS "payment_method_of_room"
(
    id_room integer,
    id_payment_method integer,
    PRIMARY KEY(id_room, id_payment_method),
    FOREIGN KEY (id_room) REFERENCES room(id),
    FOREIGN KEY (id_payment_method) REFERENCES payment_method(id)
);

CREATE TABLE IF NOT EXISTS "booking"
(
    id SERIAL PRIMARY KEY,
    owner_of_booking varchar(40),
    start_date date,
    end_date date,
    item_type varchar(1) default 'F',
    item_id integer,
    active varchar(1) default 'T',
    FOREIGN KEY (item_id) REFERENCES room(id)
);

CREATE TABLE IF NOT EXISTS "room_image"
(
    id SERIAL PRIMARY KEY,
    id_room integer,
    content bytea,
    FOREIGN KEY (id_room) REFERENCES room(id)
);

