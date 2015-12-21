function validateCreateRace(form) {
	if(!validateForm(form, [{
		id: "date",
		message: "Поле Дата и время не заполнено",
		checker: checkNotEmpty
	}, {
		id: "distance",
		message: "Поле Длина дистанции не заполнено",
		checker: checkNotEmpty
	}
	])) {
		return false;
	}
	return true;
}
