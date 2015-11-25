/*for store password using SHA-256*/
INSERT INTO `users` (`login`, `firstName`, `lastName`, `password`, `roleID`, `email`, `phone`, `cash_amount`) VALUES
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


