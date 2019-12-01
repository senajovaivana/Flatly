--without "spring.datasource.data" below in application.properties data need to be put to import.sql or data.sql or data-dev.sql ...
--spring.datasource.data=classpath:/database/data/populate.sql

INSERT INTO "developer" (id, login, active)
VALUES (-777, 'I should not be in DB', 'F');