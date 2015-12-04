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
#insert roles
INSERT INTO `role` (`name`) VALUES ('user');
INSERT INTO `role` (`name`) VALUES ('bookmaker');
INSERT INTO `role` (`name`) VALUES ('administrator');
#insert races
INSERT INTO `race` (`date`, `distance`) VALUES ('2015-11-22-10-00-00', 2400);
INSERT INTO `race` (`date`, `distance`) VALUES ('2015-11-24-16-30-00', 4400);
INSERT INTO `race` (`date`, `distance`) VALUES ('2015-12-30-08-00-00', 3500);
#insert horse_races
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 1, 1, '00:05:30');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 2, 3, '00:05:46');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 3, 2, '00:05:44');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 4, 5, '00:06:01');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 5, 4, '00:05:50');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 6, 8, '00:06:34');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 7, 6, '00:06:03');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 8, 7, '00:06:32');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 9, 9, '00:06:35');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (1, 10, 10, '00:06:40');

INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 1, 7, '00:10:45');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 2, 4, '00:10:34');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 3, 5, '00:10:35');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 4, 6, '00:10:40');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 5, 10, '00:11:10');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 6, 2, '00:10:32');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 7, 3, '00:10:33');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 8, 8, '00:10:47');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 9, 9, '00:11:00');
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (2, 10, 1, '00:10:30');

INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 1, NULL , NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 2, NULL , NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 3, NULL , NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 4, NULL , NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 5, NULL , NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 6, NULL , NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 7, NULL , NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 8, NULL , NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 9, NULL , NULL );
INSERT INTO `horse_race` (`race_ID`, `horse_ID`, `result_rank`, `result_time`) VALUES (3, 10, NULL , NULL );
#insert users
#for store password using SHA-256
INSERT INTO `users` (`login`, `first_name`, `last_name`, `password`, `role_ID`, `email`, `phone`, `cash_amount`) VALUES
  ('administrator',
   'Andrew',
   'Bownell',
   '4194D1706ED1F408D5E02D672777019F4D5385C766A8C6CA8ACBA3167D36A7B9',
   3,
   'andrew.bownell@gmail.com',
   '8(029)111-22-33',
   NULL),

  ('bookmaker',
   'Oleg',
   'Tur',
   'A8977290E24F481DC6291CEE29C9041254F041427B31D07484C563035F35251C',
   2,
   'oleg.tur@gmail.com',
   '8(029)252-62-27',
   NULL),

  ('alex1985',
   'Alex',
   'Angel',
   '6C8FE625B2F67E1565BA9830372C62887918F43ACE76C6EAF764EA2EE02A0B8C',
   1,
   'alex.angel@gmail.com',
   '8(029)555-66-77',
   1000),

  ('sophia22',
   'Sophia',
   'Brown',
   'EC26534EBDD2BB0C8CE521F861930A8F9994FDB2560F4E824EC9898C067170ED',
   1,
   'sophia.brown@gmail.com',
   '8(029)432-23-17',
   2200);

#insert bets
INSERT INTO `bet` (`horse_race_ID`,
                   `result_rank`,
                   `result_time`,
                   `bet_amount`,
                   `win_amount`,
                   `is_winner`,
                   `user_ID`,
                   `created_date`)
VALUES
  (21, 3, NULL, 100.00, NULL, NULL, 3, DEFAULT),
  (23, NULL, '00:07:10', 50.00, NULL, NULL, 3, DEFAULT),
  (3, 2, NULL, 10.00, 20.00, TRUE, 4, '2015-01-09 15:30:00');


