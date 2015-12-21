function validateHorseRaceEdit(form) {
	if(!validateForm(form, [{
		id: "newRank",
		message: "Поле Место заполнено",
		checker: checkNotEmpty
	}, {
		id: "newTime",
		message: "Поле Время финиша не заполнено",
		checker: checkNotEmpty
	}, {
		id: "newTimeSeconds",
		message: "Поле Время финиша(сек) не заполнено",
		checker: checkNotEmpty
	}
	])) {
		return false;
	}
	return true;
}
