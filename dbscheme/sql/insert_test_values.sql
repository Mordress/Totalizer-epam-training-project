USE racing;
# insert breeds
INSERT INTO `breed` (`name`) VALUES ('Орловский рысак');
INSERT INTO `breed` (`name`) VALUES ('Французский рысак');
INSERT INTO `breed` (`name`) VALUES ('Американский рысак');
INSERT INTO `breed` (`name`) VALUES ('Русский рысак');
#insert horses
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Черная молния', 1, 452, 4);
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Адский жеребец', 2, 467, 5);
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Красный дракон', 3, 422, 4);
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Посейдон', 4, 563, 6);
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Зевс', 2, 485, 5);
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Свифти', 3, 512, 6);
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Большой пони', 4, 601, 7);
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Дживс', 1, 468, 5);
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Хантер', 3, 493, 4);
INSERT INTO `horse` (`name`, `breed_ID`, `weight`, `age`) VALUES ('Зератул', 4, 410, 3);

#insert races
INSERT INTO `race` (`date`, `distance`) VALUES ('2015-11-22-10-00-00', 2400);
INSERT INTO `race` (`date`, `distance`) VALUES ('2015-11-24-16-30-00', 4400);
INSERT INTO `race` (`date`, `distance`) VALUES ('2015-12-30-08-00-00', 3500);
INSERT INTO `race` (`date`, `distance`) VALUES ('2015-12-12-15-45-00', 8800);
#insert horse_races
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 1, 1, '2015-11-22-10-10-10');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 2, 3, '2015-11-22-10-10-30');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 3, 2, '2015-11-22-10-10-20');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 4, 5, '2015-11-22-10-10-50');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 5, 4, '2015-11-22-10-10-40');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 6, 8, '2015-11-22-10-11-20');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 7, 6, '2015-11-22-10-11-00');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 8, 7, '2015-11-22-10-11-10');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 9, 9, '2015-11-22-10-11-30');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 10, 10, '2015-11-22-10-11-40');

INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 1, 7, '2015-11-24-16-46-00');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 2, 4, '2015-11-24-16-45-30');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 3, 5, '2015-11-24-16-45-40');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 4, 6, '2015-11-24-16-45-50');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 5, 10, '2015-11-24-16-46-30');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 6, 2, '2015-11-24-16-45-10');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 7, 3, '2015-11-24-16-45-20');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 8, 8, '2015-11-24-16-46-10');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 9, 9, '2015-11-24-16-46-20');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 10, 1, '2015-11-24-16-45-00');

INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 1, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 2, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 3, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 4, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 5, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 6, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 7, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 8, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 9, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 10, 0, NULL );

INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 1, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 2, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 3, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 4, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 5, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 6, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 7, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 8, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 9, 0, NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (4, 10, 0, NULL );
#insert users
#for store password using SHA-256
INSERT INTO `users` (`login`, `first_name`, `last_name`, `password`, `role`, `email`, `cash_amount`) VALUES
  ('administrator',
   'Andrew',
   'Bownell',
   '4194D1706ED1F408D5E02D672777019F4D5385C766A8C6CA8ACBA3167D36A7B9',
   2,
   'andrew.bownell@gmail.com',
   NULL),

  ('bookmaker',
   'Oleg',
   'Tur',
   'A8977290E24F481DC6291CEE29C9041254F041427B31D07484C563035F35251C',
   1,
   'oleg.tur@gmail.com',
   NULL),

  ('alex1985',
   'Андрей',
   'Некрасов',
   '6C8FE625B2F67E1565BA9830372C62887918F43ACE76C6EAF764EA2EE02A0B8C',
   0,
   'alex.angel@gmail.com',
   1000),

  ('sophia22',
   'Sophia',
   'Brown',
   'EC26534EBDD2BB0C8CE521F861930A8F9994FDB2560F4E824EC9898C067170ED',
   0,
   'sophia.brown@gmail.com',
   2200);

#insert bets
INSERT INTO `bet` (`horse_race_ID`,
                   `result_rank`,
                   `bet_amount`,
                   `win_amount`,
                   `is_winner`,
                   `user_ID`,
                   `created_date`)
VALUES
  (21, 3, 100.00, NULL, NULL, 3, DEFAULT),
  (23, NULL, 50.00, NULL, NULL, 3, DEFAULT),
  (3, 2, 10.00, 20.00, TRUE, 4, '2015-01-09 15:30:00');


