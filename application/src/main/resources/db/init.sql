DROP SCHEMA IF EXISTS sbt_demo;
CREATE SCHEMA IF NOT EXISTS sbt_demo DEFAULT CHARACTER SET utf8;

DROP TABLE sbt_demo.films;

CREATE TABLE sbt_demo.films(
   id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(100) NOT NULL,
  director         VARCHAR(100) NOT NULL
);

insert into sbt_demo.films (name, director)
values
      ('The Lord of the Rings: The Fellowship of the Ring','Peter_Jackson'),
      ('The Lord of the Rings: The Two Towers','Peter_Jackson'),
      ('The Lord of the Rings: The Return of the King','Peter_Jackson'),
      ('The Hobbit: An Unexpected Journey','Peter_Jackson'),
      ('The Hobbit: The Desolation of Smaug','Peter_Jackson'),
      ('The Hobbit: The Battle of the Five Armies','Peter_Jackson');

SELECT * FROM sbt_demo.films;