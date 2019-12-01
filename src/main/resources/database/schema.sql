DROP TABLE IF EXISTS "developer";

CREATE TABLE IF NOT EXISTS "developer"
(
    id     SERIAL PRIMARY KEY,
    login  varchar(100),
    active varchar(1) default 'T'
);
