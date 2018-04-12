DROP SCHEMA IF EXISTS sbt_demo;
CREATE SCHEMA IF NOT EXISTS sbt_demo DEFAULT CHARACTER SET utf8;

DROP TABLE sbt_demo.films;

CREATE TABLE sbt_demo.films(
   id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(100) NOT NULL,
  producer         VARCHAR(100) NOT NULL
);

insert into sbt_demo.films (name, producer) values ('Propala gramota','Boris Ivchenko'),('The Flight','Vladimir Naumov, Aleksandr Alov');
SELECT * FROM sbt_demo.films;