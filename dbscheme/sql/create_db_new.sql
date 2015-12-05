DROP DATABASE  IF EXISTS racing;
CREATE DATABASE IF NOT EXISTS racing CHARACTER SET UTF8;
USE racing;
CREATE TABLE bet
(
	bet_ID               INTEGER AUTO_INCREMENT,
	horse_race_ID        INTEGER NOT NULL,
	result_rank          TINYINT NULL,
	result_time          TIME NULL,
	bet_amount           DECIMAL(10,2) NOT NULL,
	win_amount           DECIMAL(10,2) NULL,
	is_winner            BOOLEAN NULL,
	user_ID              INTEGER NOT NULL,
	created_date         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY PK_bet(bet_ID)
);


CREATE INDEX XIF1_bet_horse_race_ID ON bet
(
	horse_race_ID
);



CREATE INDEX XIF2_bet_user_ID ON bet
(
	user_ID
);



CREATE TABLE breed
(
	breed_ID             TINYINT AUTO_INCREMENT,
	name           			 VARCHAR(50) UNIQUE NOT NULL,
PRIMARY KEY PK_breed(breed_ID)
);


CREATE TABLE horse
(
	horse_ID             INTEGER AUTO_INCREMENT,
	name                 VARCHAR(30) NOT NULL UNIQUE,
	breed_ID             TINYINT NOT NULL,
	weight               SMALLINT UNSIGNED NOT NULL,
	age                  TINYINT UNSIGNED NOT NULL,
PRIMARY KEY PK_horse(horse_ID)
);


CREATE INDEX XIF1_horse_breed_ID ON horse
(
	breed_ID
);



CREATE TABLE horse_race
(
	horse_race_ID        INTEGER AUTO_INCREMENT,
	race_ID              INTEGER NOT NULL,
	horse_ID             INTEGER NOT NULL,
	result_rank          TINYINT NULL,
	result_time          TIME NULL,
PRIMARY KEY PK_horse_race(horse_race_ID)
);
 



CREATE UNIQUE INDEX UIX_horse_race_race_ID_horse_ID ON horse_race
(
	race_ID,
	horse_ID
);



CREATE INDEX XIF1_horse_race_horse_ID ON horse_race
(
	horse_ID
);

CREATE TABLE race
(
	race_ID              INTEGER AUTO_INCREMENT,
	date            		 TIMESTAMP NOT NULL,
	distance             INTEGER UNSIGNED NOT NULL,
PRIMARY KEY PK_race(race_ID)
);

CREATE TABLE users
(
	user_ID              INTEGER AUTO_INCREMENT,
	login                CHAR(30) UNIQUE NOT NULL,
	first_name           VARCHAR(30) NOT NULL,
	last_name            VARCHAR(30) NOT NULL,
	password             VARCHAR(255) NOT NULL,
	role                 TINYINT NOT NULL DEFAULT 1,
	email                VARCHAR(30) NOT NULL,
	phone                VARCHAR(15) NOT NULL,
	cash_amount          DECIMAL(10,2) NULL,
PRIMARY KEY PK_users(user_ID)
);
 


CREATE UNIQUE INDEX UIX_user_login ON users
(
	login
);

ALTER TABLE bet
ADD FOREIGN KEY FK_horse_race_to_bet (horse_race_ID) REFERENCES horse_race (horse_race_ID) ON UPDATE CASCADE
	ON DELETE RESTRICT;



ALTER TABLE bet
ADD FOREIGN KEY FK_users_to_bet (user_ID) REFERENCES users (user_ID) ON UPDATE CASCADE ON DELETE RESTRICT;



ALTER TABLE horse
ADD FOREIGN KEY FK_breed_to_horse (breed_ID) REFERENCES breed (breed_ID) ON UPDATE CASCADE ON DELETE RESTRICT;



ALTER TABLE horse_race
ADD FOREIGN KEY FK_horse_to_horse_race (horse_ID) REFERENCES horse (horse_ID) ON UPDATE CASCADE ON DELETE RESTRICT;



ALTER TABLE horse_race
ADD FOREIGN KEY FK_race_to_horse_race (race_ID) REFERENCES race (race_ID) ON UPDATE CASCADE ON DELETE RESTRICT;
