INSERT INTO `bet` (`horse_race_ID`,
                   `result_rank`,
                   `result_time`,
                   `bet_amount`,
                   `win_amount`,
                   `is_winner`,
                   `userID`,
                   `createdDate`)
VALUES
  (21, 3, NULL, 100.00, NULL, NULL, 3, DEFAULT),
  (23, NULL, '00:07:10', 50.00, NULL, NULL, 3, DEFAULT),
  (3, 2, NULL, 10.00, 20.00, TRUE, 4, '2015-01-09 15:30:00');
