DROP DATABASE  IF EXISTS horse_racing;
CREATE DATABASE IF NOT EXISTS horse_racing CHARACTER SET UTF8;
USE horse_racing;
CREATE TABLE bet
(
	betID                INTEGER AUTO_INCREMENT,
	horse_race_ID        INTEGER NOT NULL,
	result_rank          TINYINT NULL,
	result_time          TIME NULL,
	bet_amount           DECIMAL(10,2) NOT NULL,
	win_amount           DECIMAL(10,2) NULL,
	is_winner            boolean NULL,
	userID               INTEGER NOT NULL,
	createdDate          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY PK_bet(betID)
);


CREATE INDEX XIF1_bet_horse_race_ID ON bet
(
	horse_race_ID
);



CREATE INDEX XIF2_bet_userID ON bet
(
	userID
);



CREATE TABLE breed
(
	breedID              TINYINT AUTO_INCREMENT,
	breed_name           VARCHAR(50) NOT NULL,
PRIMARY KEY PK_breed(breedID)
);


CREATE TABLE horse
(
	horseID              INTEGER AUTO_INCREMENT,
	name                 VARCHAR(30) NOT NULL,
	breedID              TINYINT NOT NULL,
	weight               SMALLINT NOT NULL,
	age                  TINYINT NOT NULL,
PRIMARY KEY PK_horse(horseID)
);


CREATE INDEX XIF1_horse_breedID ON horse
(
	breedID
);



CREATE TABLE horse_race
(
	horse_race_ID        INTEGER AUTO_INCREMENT,
	raceID               INTEGER NOT NULL,
	horseID              INTEGER NOT NULL,
	result_rank          TINYINT NULL,
	result_time          TIME NULL,
PRIMARY KEY PK_horse_race(horse_race_ID)
);
 



CREATE UNIQUE INDEX UIX_horse_race_raceID_horseID ON horse_race
(
	raceID,
	horseID
);



CREATE INDEX XIF1_horse_race_horseID ON horse_race
(
	horseID
);


/*
CREATE INDEX XIF2_horse_race_raceID ON horse_race
(
	raceID
);
*/


CREATE TABLE race
(
	raceID               INTEGER AUTO_INCREMENT,
	race_date            DATETIME NOT NULL,
	distance             INTEGER NOT NULL,
PRIMARY KEY PK_race(raceID)
);
 



CREATE TABLE role
(
	roleID               TINYINT AUTO_INCREMENT,
	role_name            VARCHAR(20) NOT NULL,
PRIMARY KEY PK_role (roleID)
);
 

CREATE TABLE users
(
	userID               INTEGER AUTO_INCREMENT,
	login                CHAR(30) UNIQUE NOT NULL,
	firstName            VARCHAR(30) NOT NULL,
	lastName             VARCHAR(30) NOT NULL,
	password             VARCHAR(255) NOT NULL,
	roleID               TINYINT NOT NULL,
	email                VARCHAR(30) NOT NULL,
	phone                VARCHAR(15) NOT NULL,
	cash_amount          DECIMAL(10,2) NULL,
PRIMARY KEY PK_users(userID)
);
 


CREATE UNIQUE INDEX UIX_user_login ON users
(
	login
);



CREATE INDEX XIF1_users_roleID ON users
(
	roleID
);



ALTER TABLE bet
ADD FOREIGN KEY FK_horse_race_to_bet (horse_race_ID) REFERENCES horse_race (horse_race_ID);



ALTER TABLE bet
ADD FOREIGN KEY FK_users_to_bet (userID) REFERENCES users (userID);



ALTER TABLE horse
ADD FOREIGN KEY FK_breed_to_horse (breedID) REFERENCES breed (breedID);



ALTER TABLE horse_race
ADD FOREIGN KEY FK_horse_to_horse_race (horseID) REFERENCES horse (horseID);



ALTER TABLE horse_race
ADD FOREIGN KEY FK_race_to_horse_race (raceID) REFERENCES race (raceID);



ALTER TABLE users
ADD FOREIGN KEY FK_role_to_users (roleID) REFERENCES role (roleID);


