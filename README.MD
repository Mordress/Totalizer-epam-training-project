﻿﻿Вариант 16.	Система Скачки. Клиент делает Ставки разных видов на Забеги.
Букмекер устанавливает уровень выигрыша. Администратор фиксирует результаты Забегов.

Система "Тотализатор".
Пользователи системы:
- Администратор.
- Букмекер.
- Пользователь.

Администратор.
Логин: administrator
Пароль: administrator
	Администратор создает новые забеги на определенное число и время, указывая длину забега. 
Он не может создать забег на дату, которая уже в прошлом. Для состоявшихся забегов администратор фиксирует
результаты - место лошади в забеге и время её финиша. Также он может редактировать результаты состоявшихся забегов
(при необходимости), а также удалять еще не состоявшиеся забеги.

Букмекер.
Логин: bookmaker
Пароль: bookmaker
	Букмекер обрабатывает ставки на те забеги которые завершились, и результаты которых зафиксировал администратор.
Букмекер устанавливает уровень выигрыша и определяет победила ли ставка.

Пользователь:
Логин: user
Пароль: user

Пользователь может просматривать историю своих ставок, а также активные ставки в данный момент. Может создавать новую ставку
посредством попытки угадать какой по счету определенная лошадь придет в конкретном забеге. У пользователя есть баланс в USD.
В данный момент все новые пользователи начинают с 1000$ на счету. Пользователь может отменить(удалить) свою ставку на забег, если забег еще
не состоялся.

Все пользователи (включая букмекера и администратора) могут просматривать список доступных лошадей
с их характеристиками, изменять пароль от своей учетной записи в личном кабинете(профиле).
Любой желающий может зарегистироваться в качестве обычного пользователя и попытать счастья в ставках.

На данный момент набор лошадей статичен - 10 штук. Все 10 участвуют во всех забегах.